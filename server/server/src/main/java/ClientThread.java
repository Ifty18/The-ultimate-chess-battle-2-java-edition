import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

class ClientThread extends Thread {

    private Socket socket1 = null ;
    private Socket socket2 = null ;

    public ClientThread (Socket socket1, Socket socket2) throws SocketException {
        this.socket1 = socket1 ; // the communication way between the client1 and the server
        this.socket2 = socket2 ; // the communication way between the client2 and the server
        socket1.setSoTimeout(120*1000); // the socket closes if the first client doesn't make any move in 120 seconds
        socket2.setSoTimeout(120*1000); // the socket closes if the second client doesn't make any move in 120 seconds
    }

    public void run () {
        try {
            // writing to the first client that he is the first player
            PrintWriter out1 = new PrintWriter(socket1.getOutputStream());
            out1.println("200");
            out1.flush();

            // writing to the second client that he is the second player
            PrintWriter out2 = new PrintWriter(socket2.getOutputStream());
            out2.println("400");
            out2.flush();

            while ( true ) { // the server constantly waits for commands from the clients

                BufferedReader in1 = new BufferedReader(new InputStreamReader(socket1.getInputStream())); // waiting in blocking state for the first client's move
                String request1 = in1.readLine(); // stores the message sent by the first client
                String arr1[] = request1.split(" "); // splitting the message sent by the first client

                if ( arr1[0].equals("201") ) { // if the first player won with that move
                    out1.println("201");
                    out1.flush();
                    out2.println("401");
                    out2.flush();
                    break;
                }

                // if we get past the first break, we continue normally with sending the response to the second client
                out2.println(request1);
                out2.flush();

                // after sending the response, we enter in a blocking reading state again waiting for the second player's move
                BufferedReader in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream())); // waiting in blocking state for the first client's move
                String request2 = in2.readLine(); // stores the message sent by the second client
                String arr2[] = request2.split(" "); // splitting the message sent by the second client

                if ( arr2[0].equals("201") ) { // if the second player won with that move
                    out1.println("401");
                    out1.flush();
                    out2.println("201");
                    out2.flush();
                    break;
                }

                // if we get past the second break, we continue normally with sending the response to the first client
                out1.println(request2);
                out1.flush();

            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally { // here the server closes the communication with the client
            try {
                socket1.close(); // rip socket1
                socket2.close(); // rip socket2
            } catch (IOException e) { System.err.println (e); }
        }
    }
}