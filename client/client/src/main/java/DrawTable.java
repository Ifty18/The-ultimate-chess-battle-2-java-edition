import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawTable {
    public static JFrame frame = new JFrame();
    static BufferedImage blackRook, blackKing, blackQueen, blackBishop, blackKnight, blackPawn, whiteRook, whiteKing, whiteQueen, whiteBishop, whiteKnight, whitePawn;

    private static void importImages() throws IOException {
        blackRook = ImageIO.read(new File("C:\\Ifty\\facultate\\Anul 2 Sem 2\\Programare avansata\\proiect\\client\\client\\assets\\blackRook.png"));
        blackKing = ImageIO.read(new File("C:\\Ifty\\facultate\\Anul 2 Sem 2\\Programare avansata\\proiect\\client\\client\\assets\\blackKing.png"));
        blackQueen = ImageIO.read(new File("C:\\Ifty\\facultate\\Anul 2 Sem 2\\Programare avansata\\proiect\\client\\client\\assets\\blackQueen.png"));
        blackBishop = ImageIO.read(new File("C:\\Ifty\\facultate\\Anul 2 Sem 2\\Programare avansata\\proiect\\client\\client\\assets\\blackBishop.png"));
        blackKnight = ImageIO.read(new File("C:\\Ifty\\facultate\\Anul 2 Sem 2\\Programare avansata\\proiect\\client\\client\\assets\\blackKnight.png"));
        blackPawn = ImageIO.read(new File("C:\\Ifty\\facultate\\Anul 2 Sem 2\\Programare avansata\\proiect\\client\\client\\assets\\blackPawn.png"));
        whiteRook = ImageIO.read(new File("C:\\Ifty\\facultate\\Anul 2 Sem 2\\Programare avansata\\proiect\\client\\client\\assets\\whiteRook.png"));
        whiteKing = ImageIO.read(new File("C:\\Ifty\\facultate\\Anul 2 Sem 2\\Programare avansata\\proiect\\client\\client\\assets\\whiteKing.png"));
        whiteQueen = ImageIO.read(new File("C:\\Ifty\\facultate\\Anul 2 Sem 2\\Programare avansata\\proiect\\client\\client\\assets\\whiteQueen.png"));
        whiteBishop = ImageIO.read(new File("C:\\Ifty\\facultate\\Anul 2 Sem 2\\Programare avansata\\proiect\\client\\client\\assets\\whiteBishop.png"));
        whiteKnight = ImageIO.read(new File("C:\\Ifty\\facultate\\Anul 2 Sem 2\\Programare avansata\\proiect\\client\\client\\assets\\whiteKnight.png"));
        whitePawn = ImageIO.read(new File("C:\\Ifty\\facultate\\Anul 2 Sem 2\\Programare avansata\\proiect\\client\\client\\assets\\whitePawn.png"));
    }


    public static void initWindow () throws IOException {
        frame.setBounds(100, 100, 528, 550); // 512 for frame.setUndecorated(true);
        importImages(); // import the images in the variables
        GameLogic.initialiseTable(); // initialise the squares with values
        frame.add(drawPannel()); // add the table and the pieces to the frame

        frame.setDefaultCloseOperation(3); // the actions that can close the frame
        frame.setVisible(true);
    }

    public static JPanel drawPannel() throws IOException {

         JPanel pn =new JPanel(){
            @Override
            public void paint(Graphics g) {
                boolean white=true;
                for(int y= 0;y<8;y++){
                    for(int x= 0;x<8;x++){
                        if(white){
                            g.setColor(new Color(229, 223, 163));
                        }else{
                            g.setColor(new Color(119, 148, 85));
                        }
                        g.fillRect(x*64, y*64, 64, 64);
                        white=!white;
                    }
                    white=!white;
                }

                // after we drew the chess table, we must draw the pieces as well
                for (int i = 1; i < 65; i++)
                {
                    if (Squares.pieceNumber[i] != -1)
                    {
                        if (Squares.pieceNumber[i] == 1)
                        {
                            g.drawImage(whitePawn, Squares.x[i], Squares.y[i], null);
                        }
                        else if (Squares.pieceNumber[i] == 2)
                        {
                            g.drawImage(whiteRook, Squares.x[i], Squares.y[i], null);
                        }
                        else if (Squares.pieceNumber[i] == 3)
                        {
                            g.drawImage(whiteBishop, Squares.x[i], Squares.y[i], null);
                        }
                        else if (Squares.pieceNumber[i] == 4)
                        {
                            g.drawImage(whiteKnight, Squares.x[i], Squares.y[i], null);
                        }
                        else if (Squares.pieceNumber[i] == 5)
                        {
                            g.drawImage(whiteQueen, Squares.x[i], Squares.y[i], null);
                        }
                        else if (Squares.pieceNumber[i] == 6)
                        {
                            g.drawImage(whiteKing, Squares.x[i], Squares.y[i], null);
                        }
                        else if (Squares.pieceNumber[i] == 7)
                        {
                            g.drawImage(blackPawn, Squares.x[i], Squares.y[i], null);
                        }
                        else if (Squares.pieceNumber[i] == 8)
                        {
                            g.drawImage(blackRook, Squares.x[i], Squares.y[i], null);
                        }
                        else if (Squares.pieceNumber[i] == 9)
                        {
                            g.drawImage(blackBishop, Squares.x[i], Squares.y[i], null);
                        }
                        else if (Squares.pieceNumber[i] == 10)
                        {
                            g.drawImage(blackKnight, Squares.x[i], Squares.y[i], null);
                        }
                        else if (Squares.pieceNumber[i] == 11)
                        {
                            g.drawImage(blackQueen, Squares.x[i], Squares.y[i], null);
                        }
                        else if (Squares.pieceNumber[i] == 12)
                        {
                            g.drawImage(blackKing, Squares.x[i], Squares.y[i], null);
                        }
                    }
                    if (Squares.validMove[i] == 1)
                    {
                        g.setColor(new Color(255, 78, 78));
                        int aux1 = Squares.x[i];
                        int aux2 = Squares.y[i];
                        g.fillRect(aux1, aux2, 64, 64);
//                        DrawRectangle(aux1, aux2, 87, 87, ORANGE);
                    }
                }
            }
         };

        pn.addMouseListener(new MouseAdapter() {// provides empty implementation of all
            // MouseListener`s methods, allowing us to
            // override only those which interests us
            @Override //I override only one method for presentation
            public void mousePressed(MouseEvent e) {
                if ( SimpleClient.myTurn == 1 ) { // if it's our turn to move
                    if ( SimpleClient.oldCell == -1 ) { // if the first cell that's selected
                        int cellNumber =  (e.getX() / 64 + 1) + ((e.getY() / 64) * 8);
                        if ( (SimpleClient.playerNumber == 1 && Squares.pieceNumber[cellNumber] >= 1 && Squares.pieceNumber[cellNumber] <= 6) || (SimpleClient.playerNumber == 2 && Squares.pieceNumber[cellNumber] >= 7 && Squares.pieceNumber[cellNumber] <= 12)  ) { // if the selected piece is ours
                            SimpleClient.oldCell = cellNumber;
                            GameLogic.checkValidMoves( cellNumber, Squares.pieceNumber[cellNumber] );
                        }
                    } else if ( SimpleClient.oldCell != -1 && SimpleClient.newCell == -1 ) { // if the first cell was selected but not the second one
                        int cellNumber =  (e.getX() / 64 + 1) + ((e.getY() / 64) * 8);
                        if ( cellNumber == SimpleClient.oldCell ) { // if the user clicks on the same cell again, we will deselect it
                            SimpleClient.oldCell = -1;
                            GameLogic.clearValidMoves();
                        } else if ( cellNumber != SimpleClient.oldCell ) { // if the user clicks on a different cell than the first one
                            if ( Squares.validMove[cellNumber] == 1 ) { // if the second cell is a valid move
                                SimpleClient.newCell = cellNumber;
                                GameLogic.clearValidMoves(); // after the client made a move, we must clear the table
                            } else if ((SimpleClient.playerNumber == 1 && Squares.pieceNumber[cellNumber] >= 1 && Squares.pieceNumber[cellNumber] <= 6) || (SimpleClient.playerNumber == 2 && Squares.pieceNumber[cellNumber] >= 7 && Squares.pieceNumber[cellNumber] <= 12)) { // if the player selects another piece of his color
                                GameLogic.clearValidMoves();
                                SimpleClient.oldCell = cellNumber;
                                GameLogic.checkValidMoves( cellNumber, Squares.pieceNumber[cellNumber] );
                            }
                        }
                    }
                }
            }
        });

        return pn;
    }

    public static void draw () throws IOException {
        frame.add(drawPannel()); // add the table and the pieces to the frame
        frame.setVisible(true);
    }
}

