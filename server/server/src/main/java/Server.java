import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // This is the port on which the server is listening
    public static final int PORT = 8100;

    // the serverSocket is public static so it can be closed by any client
    public static ServerSocket serverSocket = null ;

    public Server() throws IOException {
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) { // the server is always waiting for new clients to connect
                System.out.println ("Waiting for the first client ...");
                Socket socket1 = serverSocket.accept();

                System.out.println ("Waiting for the second client ...");
                Socket socket2 = serverSocket.accept();

                // Execute the client's request in a new thread
                new ClientThread(socket1, socket2).start();
            }
        } catch (IOException e) {
            System.err. println ("Ooops... " + e);
        } finally {
//            serverSocket.close();
        }
    }
}