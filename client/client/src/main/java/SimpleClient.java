import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleClient {

    public static Integer myTurn = 0;
    public static Integer oldCell = -1;
    public static Integer newCell = -1;
    public static int playerNumber = 0;
    public static int kingStillAlive = 1;

    public static void main (String[] args) throws IOException, InterruptedException {

        int gameStarted = 0;
        int iWon = 0;

        Scanner scanner = new Scanner(System.in);
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port

        System.out.println("waiting for an opponent...");
        try (
                Socket socket = new Socket(serverAddress, PORT); // the communication gate between the client and the server
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())) ) {
            
            while (true) { // the client constantly sends and waits for messages to and from the server

                // reading the server's message
                if ( myTurn == 0 ) { // if it s not this client's turn, we will enter the reading mode
                    String response = in.readLine();
                    String arr[] = response.split(" "); // transforming the response into an array, each element containing a word (the separator being the space character). It will be later used for taking only the first word from the server's response.
                    if ( gameStarted == 0 ) {
                        System.out.println("The game has begun !!!");
                        gameStarted = 1;
                    }
                    if ( arr[0].equals("200") ) { // if we are the first player
                        DrawTable.initWindow();
                        playerNumber = 1;
                    } else if ( arr[0].equals("400") ) { // if we are the second player
                        DrawTable.initWindow();
                        playerNumber = 2;
                        String response1 = in.readLine();
                        String arr1[] = response1.split(" ");
                        oldCell = Integer.parseInt(arr1[0]);
                        newCell = Integer.parseInt(arr1[1]);

                        GameLogic.swapCells(oldCell, newCell);

                        DrawTable.draw();
                    } else if ( arr[0].equals("201") ) {
                        System.out.println("You won !!!");
                        socket.close();
                        break;
                    } else if ( arr[0].equals("401") ) {
                        System.out.println("You lost !!!");
                        socket.close();
                        break;
                    } else { // means we are not at the beginning of the game
                        oldCell = Integer.parseInt(arr[0]);
                        newCell = Integer.parseInt(arr[1]);

                        //TODO swap cells
                        GameLogic.swapCells(oldCell, newCell);

                        DrawTable.draw();
                    }
                    myTurn = 1;
                    oldCell = -1;
                    newCell = -1;
                }

                TimeUnit.MILLISECONDS.sleep(500); // the while refresh rate is 0.5 seconds

                if ( oldCell != -1 && newCell == -1 ) {
                    DrawTable.draw(); // updating the table
                }

                if ( oldCell != -1 && newCell != -1 ) { // if our client made a move
                    myTurn = 0;
                    GameLogic.swapCells(oldCell, newCell); // putting the piece from the first cell in the second cell

                    if ( kingStillAlive == 0 ) { // checking if the king was not captured
                        iWon = 1;
                        out.println("201");
                        DrawTable.draw();
                    }

                    String request = oldCell + " " + newCell; // preparing the request for the server
                    out.println(request); // sending the move to the other client
                    DrawTable.draw(); // updating the table
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } finally {
        scanner.close();
        DrawTable.frame.setVisible(false);
        if ( iWon == 1 ) {
            System.out.println("You won !!!");
        }
        System.exit(0);
        }
    }
}