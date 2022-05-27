public class GameLogic {

    public static void checkValidMoves ( Integer cellNumber, Integer pieceNumber) {
        if (pieceNumber == 1)
        { // white pawn
            if ((cellNumber >= 49) && (cellNumber <= 56))
            { //in case it is the first move
                if ((Squares.pieceNumber[cellNumber - 8] == -1))
                { // no enemy in the first cell
                    Squares.validMove[cellNumber - 8] = 1;
                    if ((Squares.pieceNumber[cellNumber - 16] == -1))
                    { // no enemy piece even 2 cells in front
                        Squares.validMove[cellNumber - 16] = 1;
                    }
                }
                if ((Squares.pieceNumber[cellNumber - 7] >= 7) && (Squares.pieceNumber[cellNumber - 7] <= 12))
                {
                    Squares.validMove[cellNumber - 7] = 1;
                }
                if ((Squares.pieceNumber[cellNumber - 9] >= 7) && (Squares.pieceNumber[cellNumber - 9] <= 12))
                {
                    Squares.validMove[cellNumber - 9] = 1;
                }
            }
            else
            { //normal case
                if (Squares.pieceNumber[cellNumber - 8] == -1)
                { //if there is no piece in front of the pawn
                    Squares.validMove[cellNumber - 8] = 1;
                }
                if ((Squares.pieceNumber[cellNumber - 7] >= 7) && (Squares.pieceNumber[cellNumber - 7] <= 12))
                { //if there is a piece in the top right corner
                    Squares.validMove[cellNumber - 7] = 1;
                }
                if ((Squares.pieceNumber[cellNumber - 9] >= 7) && (Squares.pieceNumber[cellNumber - 9] <= 12))
                { //if there is a piece in the top left corner
                    Squares.validMove[cellNumber - 9] = 1;
                }
            }
        }
        else if (pieceNumber == 7)
        { // black pawn
            if ((cellNumber >= 9) && (cellNumber <= 16))
            { //in case it is the first move
                if ((Squares.pieceNumber[cellNumber + 8] == -1))
                { // no enemy in the first cell
                    Squares.validMove[cellNumber + 8] = 1;
                    if ((Squares.pieceNumber[cellNumber + 16] == -1))
                    { // no enemy piece even 2 cells in front
                        Squares.validMove[cellNumber + 16] = 1;
                    }
                }
                if ((Squares.pieceNumber[cellNumber + 7] >= 1) && (Squares.pieceNumber[cellNumber + 7] <= 6))
                {
                    Squares.validMove[cellNumber + 7] = 1;
                }
                if ((Squares.pieceNumber[cellNumber + 9] >= 1) && (Squares.pieceNumber[cellNumber + 9] <= 6))
                {
                    Squares.validMove[cellNumber + 9] = 1;
                }
            }
            else
            { //normal case
                if (Squares.pieceNumber[cellNumber + 8] == -1)
                { //if there is no piece in front of the pawn
                    Squares.validMove[cellNumber + 8] = 1;
                }
                if ((Squares.pieceNumber[cellNumber + 7] >= 1) && (Squares.pieceNumber[cellNumber + 7] <= 6))
                { //if there is a piece in the top right corner
                    Squares.validMove[cellNumber + 7] = 1;
                }
                if ((Squares.pieceNumber[cellNumber + 9] >= 1) && (Squares.pieceNumber[cellNumber + 9] <= 6))
                { //if there is a piece in the top left corner
                    Squares.validMove[cellNumber + 9] = 1;
                }
            }
        }
        else if (pieceNumber == 2)
        { // white rook
            int aux = cellNumber;

            while ((aux >= 9) && ((Squares.pieceNumber[aux - 8] == -1) || (Squares.pieceNumber[aux - 8] >= 7) && (Squares.pieceNumber[aux - 8] <= 12)))
            { //creating the path if the rook goes up the table
                Squares.validMove[aux - 8] = 1;
                if ((Squares.pieceNumber[aux - 8] >= 7) && (Squares.pieceNumber[aux - 8] <= 12))
                { //if we have an enemy piece in the way
                    break;
                }
                aux = aux - 8;
            }

            aux = cellNumber; //resetting the value of aux to the initial position

            while ((aux <= 56) && ((Squares.pieceNumber[aux + 8] == -1) || (Squares.pieceNumber[aux + 8] >= 7) && (Squares.pieceNumber[aux + 8] <= 12)))
            { //creating the path if the rook goes down the table
                Squares.validMove[aux + 8] = 1;
                if ((Squares.pieceNumber[aux + 8] >= 7) && (Squares.pieceNumber[aux + 8] <= 12))
                { //if we have an enemy piece in the way
                    break;
                }
                aux = aux + 8;
            }

            aux = cellNumber; //resetting the value of aux to the initial position

            while ((aux % 8 > 0) && ((Squares.pieceNumber[aux + 1] == -1) || (Squares.pieceNumber[aux + 1] >= 7) && (Squares.pieceNumber[aux + 1] <= 12)))
            { //creating the path if the rook goes right
                Squares.validMove[aux + 1] = 1;
                if ((Squares.pieceNumber[aux + 1] >= 7) && (Squares.pieceNumber[aux + 1] <= 12))
                { //if we have an enemy piece in the way
                    break;
                }
                aux = aux + 1;
            }

            aux = cellNumber; //resetting the value of aux to the initial position

            while (((aux % 8 > 1) || (aux % 8 == 0)) && ((Squares.pieceNumber[aux - 1] == -1) || (Squares.pieceNumber[aux - 1] >= 7) && (Squares.pieceNumber[aux - 1] <= 12)))
            { //creating the path if the rook goes left
                Squares.validMove[aux - 1] = 1;
                if ((Squares.pieceNumber[aux - 1] >= 7) && (Squares.pieceNumber[aux - 1] <= 12))
                { //if we have an enemy piece in the way
                    break;
                }
                aux = aux - 1;
            }
        }
        else if (pieceNumber == 8)
        { // black rook
            int aux = cellNumber;

            while ((aux >= 9) && ((Squares.pieceNumber[aux - 8] == -1) || (Squares.pieceNumber[aux - 8] >= 1) && (Squares.pieceNumber[aux - 8] <= 6)))
            { //creating the path if the rook goes up the table
                Squares.validMove[aux - 8] = 1;
                if ((Squares.pieceNumber[aux - 8] >= 1) && (Squares.pieceNumber[aux - 8] <= 6))
                { //if we have an enemy piece in the way
                    break;
                }
                aux = aux - 8;
            }

            aux = cellNumber; //resetting the value of aux to the initial position

            while ((aux <= 56) && ((Squares.pieceNumber[aux + 8] == -1) || (Squares.pieceNumber[aux + 8] >= 1) && (Squares.pieceNumber[aux + 8] <= 6)))
            { //creating the path if the rook goes down the table
                Squares.validMove[aux + 8] = 1;
                if ((Squares.pieceNumber[aux + 8] >= 1) && (Squares.pieceNumber[aux + 8] <= 6))
                { //if we have an enemy piece in the way
                    break;
                }
                aux = aux + 8;
            }

            aux = cellNumber; //resetting the value of aux to the initial position

            while ((aux % 8 > 0) && ((Squares.pieceNumber[aux + 1] == -1) || (Squares.pieceNumber[aux + 1] >= 1) && (Squares.pieceNumber[aux + 1] <= 6)))
            { //creating the path if the rook goes right
                Squares.validMove[aux + 1] = 1;
                if ((Squares.pieceNumber[aux + 1] >= 1) && (Squares.pieceNumber[aux + 1] <= 6))
                { //if we have an enemy piece in the way
                    break;
                }
                aux = aux + 1;
            }

            aux = cellNumber; //resetting the value of aux to the initial position

            while (((aux % 8 > 1) || (aux % 8 == 0)) && ((Squares.pieceNumber[aux - 1] == -1) || (Squares.pieceNumber[aux - 1] >= 1) && (Squares.pieceNumber[aux - 1] <= 6)))
            { //creating the path if the rook goes left
                Squares.validMove[aux - 1] = 1;
                if ((Squares.pieceNumber[aux - 1] >= 1) && (Squares.pieceNumber[aux - 1] <= 6))
                { //if we have an enemy piece in the way
                    break;
                }
                aux = aux - 1;
            }
        }
        else if (pieceNumber == 3)
        { // white bishop
            int aux2 = cellNumber;

            while (((aux2 >= 9) && (aux2 % 8 != 0)) && ((Squares.pieceNumber[aux2 - 7] == -1) || ((Squares.pieceNumber[aux2 - 7] >= 7) && (Squares.pieceNumber[aux2 - 7] <= 12))))
            { //creating the path if the bishop goes right up
                Squares.validMove[aux2 - 7] = 1;
                if ((Squares.pieceNumber[aux2 - 7] >= 7) && (Squares.pieceNumber[aux2 - 7] <= 12))
                { //if we have an enemy piece in the way
                    break;
                }
                aux2 = aux2 - 7;
            }

            aux2 = cellNumber;

            while (((aux2 >= 9) && (aux2 % 8 != 1)) && ((Squares.pieceNumber[aux2 - 9] == -1) || ((Squares.pieceNumber[aux2 - 9] >= 7) && (Squares.pieceNumber[aux2 - 9] <= 12))))
            { //creating the path if the bishop goes left up
                Squares.validMove[aux2 - 9] = 1;
                if ((Squares.pieceNumber[aux2 - 9] >= 7) && (Squares.pieceNumber[aux2 - 9] <= 12))
                { //if we have an enemy piece in the way
                    break;
                }
                aux2 = aux2 - 9;
            }

            aux2 = cellNumber;

            while (((aux2 <= 56) && (aux2 % 8 != 1)) && ((Squares.pieceNumber[aux2 + 7] == -1) || ((Squares.pieceNumber[aux2 + 7] >= 7) && (Squares.pieceNumber[aux2 + 7] <= 12))))
            { //creating the path if the bishop goes left down
                Squares.validMove[aux2 + 7] = 1;
                if ((Squares.pieceNumber[aux2 + 7] >= 7) && (Squares.pieceNumber[aux2 + 7] <= 12))
                { //if we have an enemy piece in the way
                    break;
                }
                aux2 = aux2 + 7;
            }

            aux2 = cellNumber;

            while (((aux2 <= 56) && (aux2 % 8 != 0)) && ((Squares.pieceNumber[aux2 + 9] == -1) || ((Squares.pieceNumber[aux2 + 9] >= 7) && (Squares.pieceNumber[aux2 + 9] <= 12))))
            { //creating the path if the bishop goes right down
                Squares.validMove[aux2 + 9] = 1;
                if ((Squares.pieceNumber[aux2 + 9] >= 7) && (Squares.pieceNumber[aux2 + 9] <= 12))
                { //if we have an enemy piece in the way
                    break;
                }
                aux2 = aux2 + 9;
            }
        }
        else if (pieceNumber == 9)
        { // black bishop
            int aux3 = cellNumber;

            while (((aux3 >= 9) && (aux3 % 8 != 0)) && ((Squares.pieceNumber[aux3 - 7] == -1) || ((Squares.pieceNumber[aux3 - 7] >= 1) && (Squares.pieceNumber[aux3 - 7] <= 6))))
            { //creating the path if the bishop goes right up
                Squares.validMove[aux3 - 7] = 1;
                if ((Squares.pieceNumber[aux3 - 7] >= 1) && (Squares.pieceNumber[aux3 - 7] <= 6))
                { //if we have an enemy piece in the way
                    break;
                }
                aux3 = aux3 - 7;
            }

            aux3 = cellNumber;

            while (((aux3 >= 9) && (aux3 % 8 != 1)) && ((Squares.pieceNumber[aux3 - 9] == -1) || ((Squares.pieceNumber[aux3 - 9] >= 1) && (Squares.pieceNumber[aux3 - 9] <= 6))))
            { //creating the path if the bishop goes left up
                Squares.validMove[aux3 - 9] = 1;
                if ((Squares.pieceNumber[aux3 - 9] >= 1) && (Squares.pieceNumber[aux3 - 9] <= 6))
                { //if we have an enemy piece in the way
                    break;
                }
                aux3 = aux3 - 9;
            }

            aux3 = cellNumber;

            while (((aux3 <= 56) && (aux3 % 8 != 1)) && ((Squares.pieceNumber[aux3 + 7] == -1) || ((Squares.pieceNumber[aux3 + 7] >= 1) && (Squares.pieceNumber[aux3 + 7] <= 6))))
            { //creating the path if the bishop goes left down
                Squares.validMove[aux3 + 7] = 1;
                if ((Squares.pieceNumber[aux3 + 7] >= 1) && (Squares.pieceNumber[aux3 + 7] <= 6))
                { //if we have an enemy piece in the way
                    break;
                }
                aux3 = aux3 + 7;
            }

            aux3 = cellNumber;

            while (((aux3 <= 56) && (aux3 % 8 != 0)) && ((Squares.pieceNumber[aux3 + 9] == -1) || ((Squares.pieceNumber[aux3 + 9] >= 1) && (Squares.pieceNumber[aux3 + 9] <= 6))))
            { //creating the path if the bishop goes right down
                Squares.validMove[aux3 + 9] = 1;
                if ((Squares.pieceNumber[aux3 + 9] >= 1) && (Squares.pieceNumber[aux3 + 9] <= 6))
                { //if we have an enemy piece in the way
                    break;
                }
                aux3 = aux3 + 9;
            }
        }
        else if (pieceNumber == 5)
        { // white queen
            int aux4 = cellNumber;

            while (((aux4 >= 9) && (aux4 % 8 != 0)) && ((Squares.pieceNumber[aux4 - 7] == -1) || ((Squares.pieceNumber[aux4 - 7] >= 7) && (Squares.pieceNumber[aux4 - 7] <= 12))))
            { //creating the path if the queen goes right up
                Squares.validMove[aux4 - 7] = 1;
                if ((Squares.pieceNumber[aux4 - 7] >= 7) && (Squares.pieceNumber[aux4 - 7] <= 12))
                { //if we have an enemy piece in the way
                    break;
                }
                aux4 = aux4 - 7;
            }

            aux4 = cellNumber;

            while (((aux4 >= 9) && (aux4 % 8 != 1)) && ((Squares.pieceNumber[aux4 - 9] == -1) || ((Squares.pieceNumber[aux4 - 9] >= 7) && (Squares.pieceNumber[aux4 - 9] <= 12))))
            { //creating the path if the queen goes left up
                Squares.validMove[aux4 - 9] = 1;
                if ((Squares.pieceNumber[aux4 - 9] >= 7) && (Squares.pieceNumber[aux4 - 9] <= 12))
                { //if we have an enemy piece in the way
                    break;
                }
                aux4 = aux4 - 9;
            }

            aux4 = cellNumber;

            while (((aux4 <= 56) && (aux4 % 8 != 1)) && ((Squares.pieceNumber[aux4 + 7] == -1) || ((Squares.pieceNumber[aux4 + 7] >= 7) && (Squares.pieceNumber[aux4 + 7] <= 12))))
            { //creating the path if the queen goes left down
                Squares.validMove[aux4 + 7] = 1;
                if ((Squares.pieceNumber[aux4 + 7] >= 7) && (Squares.pieceNumber[aux4 + 7] <= 12))
                { //if we have an enemy piece in the way
                    break;
                }
                aux4 = aux4 + 7;
            }

            aux4 = cellNumber;

            while (((aux4 <= 56) && (aux4 % 8 != 0)) && ((Squares.pieceNumber[aux4 + 9] == -1) || ((Squares.pieceNumber[aux4 + 9] >= 7) && (Squares.pieceNumber[aux4 + 9] <= 12))))
            { //creating the path if the queen goes right down
                Squares.validMove[aux4 + 9] = 1;
                if ((Squares.pieceNumber[aux4 + 9] >= 7) && (Squares.pieceNumber[aux4 + 9] <= 12))
                { //if we have an enemy piece in the way
                    break;
                }
                aux4 = aux4 + 9;
            }

            aux4 = cellNumber;

            while ((aux4 >= 9) && ((Squares.pieceNumber[aux4 - 8] == -1) || (Squares.pieceNumber[aux4 - 8] >= 7) && (Squares.pieceNumber[aux4 - 8] <= 12)))
            { //creating the path if the queen goes up the table
                Squares.validMove[aux4 - 8] = 1;
                if ((Squares.pieceNumber[aux4 - 8] >= 7) && (Squares.pieceNumber[aux4 - 8] <= 12))
                { //if we have an enemy piece in the way
                    break;
                }
                aux4 = aux4 - 8;
            }

            aux4 = cellNumber; //resetting the value of aux to the initial position

            while ((aux4 <= 56) && ((Squares.pieceNumber[aux4 + 8] == -1) || (Squares.pieceNumber[aux4 + 8] >= 7) && (Squares.pieceNumber[aux4 + 8] <= 12)))
            { //creating the path if the queen goes down the table
                Squares.validMove[aux4 + 8] = 1;
                if ((Squares.pieceNumber[aux4 + 8] >= 7) && (Squares.pieceNumber[aux4 + 8] <= 12))
                { //if we have an enemy piece in the way
                    break;
                }
                aux4 = aux4 + 8;
            }

            aux4 = cellNumber; //resetting the value of aux to the initial position

            while ((aux4 % 8 > 0) && ((Squares.pieceNumber[aux4 + 1] == -1) || (Squares.pieceNumber[aux4 + 1] >= 7) && (Squares.pieceNumber[aux4 + 1] <= 12)))
            { //creating the path if the queen goes right
                Squares.validMove[aux4 + 1] = 1;
                if ((Squares.pieceNumber[aux4 + 1] >= 7) && (Squares.pieceNumber[aux4 + 1] <= 12))
                { //if we have an enemy piece in the way
                    break;
                }
                aux4 = aux4 + 1;
            }

            aux4 = cellNumber; //resetting the value of aux to the initial position

            while (((aux4 % 8 > 1) || (aux4 % 8 == 0)) && ((Squares.pieceNumber[aux4 - 1] == -1) || (Squares.pieceNumber[aux4 - 1] >= 7) && (Squares.pieceNumber[aux4 - 1] <= 12)))
            { //creating the path if the queen goes left
                Squares.validMove[aux4 - 1] = 1;
                if ((Squares.pieceNumber[aux4 - 1] >= 7) && (Squares.pieceNumber[aux4 - 1] <= 12))
                { //if we have an enemy piece in the way
                    break;
                }
                aux4 = aux4 - 1;
            }
        }
        else if (pieceNumber == 11)
        { // black queen
            int aux4 = cellNumber;

            while (((aux4 >= 9) && (aux4 % 8 != 0)) && ((Squares.pieceNumber[aux4 - 7] == -1) || ((Squares.pieceNumber[aux4 - 7] >= 1) && (Squares.pieceNumber[aux4 - 7] <= 6))))
            { //creating the path if the queen goes right up
                Squares.validMove[aux4 - 7] = 1;
                if ((Squares.pieceNumber[aux4 - 7] >= 1) && (Squares.pieceNumber[aux4 - 7] <= 6))
                { //if we have an enemy piece in the way
                    break;
                }
                aux4 = aux4 - 7;
            }

            aux4 = cellNumber;

            while (((aux4 >= 9) && (aux4 % 8 != 1)) && ((Squares.pieceNumber[aux4 - 9] == -1) || ((Squares.pieceNumber[aux4 - 9] >= 1) && (Squares.pieceNumber[aux4 - 9] <= 6))))
            { //creating the path if the queen goes left up
                Squares.validMove[aux4 - 9] = 1;
                if ((Squares.pieceNumber[aux4 - 9] >= 1) && (Squares.pieceNumber[aux4 - 9] <= 6))
                { //if we have an enemy piece in the way
                    break;
                }
                aux4 = aux4 - 9;
            }

            aux4 = cellNumber;

            while (((aux4 <= 56) && (aux4 % 8 != 1)) && ((Squares.pieceNumber[aux4 + 7] == -1) || ((Squares.pieceNumber[aux4 + 7] >= 1) && (Squares.pieceNumber[aux4 + 7] <= 6))))
            { //creating the path if the queen goes left down
                Squares.validMove[aux4 + 7] = 1;
                if ((Squares.pieceNumber[aux4 + 7] >= 1) && (Squares.pieceNumber[aux4 + 7] <= 6))
                { //if we have an enemy piece in the way
                    break;
                }
                aux4 = aux4 + 7;
            }

            aux4 = cellNumber;

            while (((aux4 <= 56) && (aux4 % 8 != 0)) && ((Squares.pieceNumber[aux4 + 9] == -1) || ((Squares.pieceNumber[aux4 + 9] >= 1) && (Squares.pieceNumber[aux4 + 9] <= 6))))
            { //creating the path if the queen goes right down
                Squares.validMove[aux4 + 9] = 1;
                if ((Squares.pieceNumber[aux4 + 9] >= 1) && (Squares.pieceNumber[aux4 + 9] <= 6))
                { //if we have an enemy piece in the way
                    break;
                }
                aux4 = aux4 + 9;
            }

            aux4 = cellNumber;

            while ((aux4 >= 9) && ((Squares.pieceNumber[aux4 - 8] == -1) || (Squares.pieceNumber[aux4 - 8] >= 1) && (Squares.pieceNumber[aux4 - 8] <= 6)))
            { //creating the path if the queen goes up the table
                Squares.validMove[aux4 - 8] = 1;
                if ((Squares.pieceNumber[aux4 - 8] >= 1) && (Squares.pieceNumber[aux4 - 8] <= 6))
                { //if we have an enemy piece in the way
                    break;
                }
                aux4 = aux4 - 8;
            }

            aux4 = cellNumber; //resetting the value of aux to the initial position

            while ((aux4 <= 56) && ((Squares.pieceNumber[aux4 + 8] == -1) || (Squares.pieceNumber[aux4 + 8] >= 1) && (Squares.pieceNumber[aux4 + 8] <= 6)))
            { //creating the path if the queen goes down the table
                Squares.validMove[aux4 + 8] = 1;
                if ((Squares.pieceNumber[aux4 + 8] >= 1) && (Squares.pieceNumber[aux4 + 8] <= 6))
                { //if we have an enemy piece in the way
                    break;
                }
                aux4 = aux4 + 8;
            }

            aux4 = cellNumber; //resetting the value of aux to the initial position

            while ((aux4 % 8 > 0) && ((Squares.pieceNumber[aux4 + 1] == -1) || (Squares.pieceNumber[aux4 + 1] >= 1) && (Squares.pieceNumber[aux4 + 1] <= 6)))
            { //creating the path if the queen goes right
                Squares.validMove[aux4 + 1] = 1;
                if ((Squares.pieceNumber[aux4 + 1] >= 1) && (Squares.pieceNumber[aux4 + 1] <= 6))
                { //if we have an enemy piece in the way
                    break;
                }
                aux4 = aux4 + 1;
            }

            aux4 = cellNumber; //resetting the value of aux to the initial position

            while (((aux4 % 8 > 1) || (aux4 % 8 == 0)) && ((Squares.pieceNumber[aux4 - 1] == -1) || (Squares.pieceNumber[aux4 - 1] >= 1) && (Squares.pieceNumber[aux4 - 1] <= 6)))
            { //creating the path if the queen goes left
                Squares.validMove[aux4 - 1] = 1;
                if ((Squares.pieceNumber[aux4 - 1] >= 1) && (Squares.pieceNumber[aux4 - 1] <= 6))
                { //if we have an enemy piece in the way
                    break;
                }
                aux4 = aux4 - 1;
            }
        }
        if (pieceNumber == 6)
        { //white king
            if ((cellNumber > 8) && ((Squares.pieceNumber[cellNumber - 8] == -1) || ((Squares.pieceNumber[cellNumber - 8] >= 7) && (Squares.pieceNumber[cellNumber - 8] <= 12))))
            { //if the king wants to go one square up
                Squares.validMove[cellNumber - 8] = 1;
            }
            if ((cellNumber <= 56) && ((Squares.pieceNumber[cellNumber + 8] == -1) || ((Squares.pieceNumber[cellNumber + 8] >= 7) && (Squares.pieceNumber[cellNumber + 8] <= 12))))
            { //if the king wants to go one square down
                Squares.validMove[cellNumber + 8] = 1;
            }
            if ((cellNumber % 8 != 1) && ((Squares.pieceNumber[cellNumber - 1] == -1) || ((Squares.pieceNumber[cellNumber - 1] >= 7) && (Squares.pieceNumber[cellNumber - 1] <= 12))))
            { //if the king wants to go one square left
                Squares.validMove[cellNumber - 1] = 1;
            }
            if ((cellNumber % 8 != 0) && ((Squares.pieceNumber[cellNumber + 1] == -1) || ((Squares.pieceNumber[cellNumber + 1] >= 7) && (Squares.pieceNumber[cellNumber + 1] <= 12))))
            { //if the king wants to go one square right
                Squares.validMove[cellNumber + 1] = 1;
            }

            if ((cellNumber % 8 != 1) && (cellNumber > 8) && ((Squares.pieceNumber[cellNumber - 9] == -1) || ((Squares.pieceNumber[cellNumber - 9] >= 7) && (Squares.pieceNumber[cellNumber - 9] <= 12))))
            { //if the king wants to go one square up left
                Squares.validMove[cellNumber - 9] = 1;
            }
            if ((cellNumber % 8 != 1) && (cellNumber <= 56) && ((Squares.pieceNumber[cellNumber + 7] == -1) || ((Squares.pieceNumber[cellNumber + 7] >= 7) && (Squares.pieceNumber[cellNumber + 7] <= 12))))
            { //if the king wants to go one square down left
                Squares.validMove[cellNumber + 7] = 1;
            }
            if ((cellNumber > 8) && (cellNumber % 8 != 0) && ((Squares.pieceNumber[cellNumber - 7] == -1) || ((Squares.pieceNumber[cellNumber - 7] >= 7) && (Squares.pieceNumber[cellNumber - 7] <= 12))))
            { //if the king wants to go one square up right
                Squares.validMove[cellNumber - 7] = 1;
            }
            if ((cellNumber <= 56) && (cellNumber % 8 != 0) && ((Squares.pieceNumber[cellNumber + 9] == -1) || ((Squares.pieceNumber[cellNumber + 9] >= 7) && (Squares.pieceNumber[cellNumber + 9] <= 12))))
            { //if the king wants to go one square down right
                Squares.validMove[cellNumber + 9] = 1;
            }
        }
        if (pieceNumber == 12)
        { //black king
            if ((cellNumber > 8) && ((Squares.pieceNumber[cellNumber - 8] == -1) || ((Squares.pieceNumber[cellNumber - 8] >= 1) && (Squares.pieceNumber[cellNumber - 8] <= 6))))
            { //if the king wants to go one square up
                Squares.validMove[cellNumber - 8] = 1;
            }
            if ((cellNumber <= 56) && ((Squares.pieceNumber[cellNumber + 8] == -1) || ((Squares.pieceNumber[cellNumber + 8] >= 1) && (Squares.pieceNumber[cellNumber + 8] <= 6))))
            { //if the king wants to go one square down
                Squares.validMove[cellNumber + 8] = 1;
            }
            if ((cellNumber % 8 != 1) && ((Squares.pieceNumber[cellNumber - 1] == -1) || ((Squares.pieceNumber[cellNumber - 1] >= 1) && (Squares.pieceNumber[cellNumber - 1] <= 6))))
            { //if the king wants to go one square left
                Squares.validMove[cellNumber - 1] = 1;
            }
            if ((cellNumber % 8 != 0) && ((Squares.pieceNumber[cellNumber + 1] == -1) || ((Squares.pieceNumber[cellNumber + 1] >= 1) && (Squares.pieceNumber[cellNumber + 1] <= 6))))
            { //if the king wants to go one square right
                Squares.validMove[cellNumber + 1] = 1;
            }

            if ((cellNumber % 8 != 1) && (cellNumber > 8) && ((Squares.pieceNumber[cellNumber - 9] == -1) || ((Squares.pieceNumber[cellNumber - 9] >= 1) && (Squares.pieceNumber[cellNumber - 9] <= 6))))
            { //if the king wants to go one square up left
                Squares.validMove[cellNumber - 9] = 1;
            }
            if ((cellNumber % 8 != 1) && (cellNumber <= 56) && ((Squares.pieceNumber[cellNumber + 7] == -1) || ((Squares.pieceNumber[cellNumber + 7] >= 1) && (Squares.pieceNumber[cellNumber + 7] <= 6))))
            { //if the king wants to go one square down left
                Squares.validMove[cellNumber + 7] = 1;
            }
            if ((cellNumber > 8) && (cellNumber % 8 != 0) && ((Squares.pieceNumber[cellNumber - 7] == -1) || ((Squares.pieceNumber[cellNumber - 7] >= 1) && (Squares.pieceNumber[cellNumber - 7] <= 6))))
            { //if the king wants to go one square up right
                Squares.validMove[cellNumber - 7] = 1;
            }
            if ((cellNumber <= 56) && (cellNumber % 8 != 0) && ((Squares.pieceNumber[cellNumber + 9] == -1) || ((Squares.pieceNumber[cellNumber + 9] >= 1) && (Squares.pieceNumber[cellNumber + 9] <= 6))))
            { //if the king wants to go one square down right
                Squares.validMove[cellNumber + 9] = 1;
            }
        }
        else if (pieceNumber == 4)
        { // white knight
            if ((cellNumber > 16) && (cellNumber % 8 != 1) && ((Squares.pieceNumber[cellNumber - 17] == -1) || ((Squares.pieceNumber[cellNumber - 17] >= 7) && (Squares.pieceNumber[cellNumber - 17] <= 12))))
            { //the knight goes up - left
                Squares.validMove[cellNumber - 17] = 1;
            }
            if ((cellNumber > 16) && (cellNumber % 8 != 0) && ((Squares.pieceNumber[cellNumber - 15] == -1) || ((Squares.pieceNumber[cellNumber - 15] >= 7) && (Squares.pieceNumber[cellNumber - 15] <= 12))))
            { //the knight goes up - right
                Squares.validMove[cellNumber - 15] = 1;
            }
            if ((cellNumber < 49) && (cellNumber % 8 != 1) && ((Squares.pieceNumber[cellNumber + 15] == -1) || ((Squares.pieceNumber[cellNumber + 15] >= 7) && (Squares.pieceNumber[cellNumber + 15] <= 12))))
            { //the knight goes down - left
                Squares.validMove[cellNumber + 15] = 1;
            }
            if ((cellNumber < 49) && (cellNumber % 8 != 0) && ((Squares.pieceNumber[cellNumber + 17] == -1) || ((Squares.pieceNumber[cellNumber + 17] >= 7) && (Squares.pieceNumber[cellNumber + 17] <= 12))))
            { //the knight goes down - right
                Squares.validMove[cellNumber + 17] = 1;
            }
            if ((cellNumber > 8) && (cellNumber % 8 != 1) && (cellNumber % 8 != 2) && ((Squares.pieceNumber[cellNumber - 10] == -1) || ((Squares.pieceNumber[cellNumber - 10] >= 7) && (Squares.pieceNumber[cellNumber - 10] <= 12))))
            { //the knight goes left - up
                Squares.validMove[cellNumber - 10] = 1;
            }
            if ((cellNumber > 8) && (cellNumber % 8 != 0) && (cellNumber % 8 != 7) && ((Squares.pieceNumber[cellNumber - 6] == -1) || ((Squares.pieceNumber[cellNumber - 6] >= 7) && (Squares.pieceNumber[cellNumber - 6] <= 12))))
            { //the knight goes right - up
                Squares.validMove[cellNumber - 6] = 1;
            }
            if ((cellNumber > 8) && (cellNumber % 8 != 0) && (cellNumber % 8 != 7) && ((Squares.pieceNumber[cellNumber - 6] == -1) || ((Squares.pieceNumber[cellNumber - 6] >= 7) && (Squares.pieceNumber[cellNumber - 6] <= 12))))
            { //the knight goes right - up
                Squares.validMove[cellNumber - 6] = 1;
            }
            if ((cellNumber < 57) && (cellNumber % 8 != 1) && (cellNumber % 8 != 2) && ((Squares.pieceNumber[cellNumber + 6] == -1) || ((Squares.pieceNumber[cellNumber + 6] >= 7) && (Squares.pieceNumber[cellNumber + 6] <= 12))))
            { //the knight goes left - down
                Squares.validMove[cellNumber + 6] = 1;
            }
            if ((cellNumber < 57) && (cellNumber % 8 != 0) && (cellNumber % 8 != 7) && ((Squares.pieceNumber[cellNumber + 10] == -1) || ((Squares.pieceNumber[cellNumber + 10] >= 7) && (Squares.pieceNumber[cellNumber + 10] <= 12))))
            { //the knight goes right - down
                Squares.validMove[cellNumber + 10] = 1;
            }
        }
        else if (pieceNumber == 10)
        { // black knight
            if ((cellNumber > 16) && (cellNumber % 8 != 1) && ((Squares.pieceNumber[cellNumber - 17] == -1) || ((Squares.pieceNumber[cellNumber - 17] >= 1) && (Squares.pieceNumber[cellNumber - 17] <= 6))))
            { //the knight goes up - left
                Squares.validMove[cellNumber - 17] = 1;
            }
            if ((cellNumber > 16) && (cellNumber % 8 != 0) && ((Squares.pieceNumber[cellNumber - 15] == -1) || ((Squares.pieceNumber[cellNumber - 15] >= 1) && (Squares.pieceNumber[cellNumber - 15] <= 6))))
            { //the knight goes up - right
                Squares.validMove[cellNumber - 15] = 1;
            }
            if ((cellNumber < 49) && (cellNumber % 8 != 1) && ((Squares.pieceNumber[cellNumber + 15] == -1) || ((Squares.pieceNumber[cellNumber + 15] >= 1) && (Squares.pieceNumber[cellNumber + 15] <= 6))))
            { //the knight goes down - left
                Squares.validMove[cellNumber + 15] = 1;
            }
            if ((cellNumber < 49) && (cellNumber % 8 != 0) && ((Squares.pieceNumber[cellNumber + 17] == -1) || ((Squares.pieceNumber[cellNumber + 17] >= 1) && (Squares.pieceNumber[cellNumber + 17] <= 6))))
            { //the knight goes down - right
                Squares.validMove[cellNumber + 17] = 1;
            }
            if ((cellNumber > 8) && (cellNumber % 8 != 1) && (cellNumber % 8 != 2) && ((Squares.pieceNumber[cellNumber - 10] == -1) || ((Squares.pieceNumber[cellNumber - 10] >= 1) && (Squares.pieceNumber[cellNumber - 10] <= 6))))
            { //the knight goes left - up
                Squares.validMove[cellNumber - 10] = 1;
            }
            if ((cellNumber > 8) && (cellNumber % 8 != 0) && (cellNumber % 8 != 7) && ((Squares.pieceNumber[cellNumber - 6] == -1) || ((Squares.pieceNumber[cellNumber - 6] >= 1) && (Squares.pieceNumber[cellNumber - 6] <= 6))))
            { //the knight goes right - up
                Squares.validMove[cellNumber - 6] = 1;
            }
            if ((cellNumber > 8) && (cellNumber % 8 != 0) && (cellNumber % 8 != 7) && ((Squares.pieceNumber[cellNumber - 6] == -1) || ((Squares.pieceNumber[cellNumber - 6] >= 1) && (Squares.pieceNumber[cellNumber - 6] <= 6))))
            { //the knight goes right - up
                Squares.validMove[cellNumber - 6] = 1;
            }
            if ((cellNumber < 57) && (cellNumber % 8 != 1) && (cellNumber % 8 != 2) && ((Squares.pieceNumber[cellNumber + 6] == -1) || ((Squares.pieceNumber[cellNumber + 6] >= 1) && (Squares.pieceNumber[cellNumber + 6] <= 6))))
            { //the knight goes left - down
                Squares.validMove[cellNumber + 6] = 1;
            }
            if ((cellNumber < 57) && (cellNumber % 8 != 0) && (cellNumber % 8 != 7) && ((Squares.pieceNumber[cellNumber + 10] == -1) || ((Squares.pieceNumber[cellNumber + 10] >= 1) && (Squares.pieceNumber[cellNumber + 10] <= 6))))
            { //the knight goes right - down
                Squares.validMove[cellNumber + 10] = 1;
            }
        }
    }

    public static void clearValidMoves () {
        for (int i = 1; i < 65; i++)
        {
            Squares.validMove[i] = 0;
        }
    }

    public static void initialiseTable(){
        int i, j, k=1;
        for ( j = 0 ; j < 8 ; j++ ){
            for ( i= 0 ; i < 8 ; i++ ){
                Squares.x[k] = i * 64;
                Squares.y[k] = j * 64;
                Squares.state[k] = 0;
                Squares.validMove[k] = 0;
                if ( (k >= 9) && ( k <= 16 ) ){ //black pawn
                    Squares.pieceNumber[k] = 7;
                } else if ( (k == 1) || (k == 8) ){ // black rook
                    Squares.pieceNumber[k] = 8;
                } else if ( (k == 2) || (k == 7) ){ // black knight
                    Squares.pieceNumber[k] = 10;
                } else if ( (k == 3) || (k == 6) ){ // black bishop
                    Squares.pieceNumber[k] = 9;
                } else if ( k == 4 ){ // black queen
                    Squares.pieceNumber[k] = 11;
                } else if ( k == 5 ){ // black king
                    Squares.pieceNumber[k] = 12;
                } else if ( (k >= 49) && ( k <= 56 ) ){ // white pawn
                    Squares.pieceNumber[k] = 1;
                } else if ( (k == 57) || (k == 64) ){ // white rook
                    Squares.pieceNumber[k] = 2;
                } else if ( (k == 58) || (k == 63) ){ // white knight
                    Squares.pieceNumber[k] = 4;
                } else if ( (k == 59) || (k == 62) ){ // white bishop
                    Squares.pieceNumber[k] = 3;
                } else if ( k == 60 ){ // white queen
                    Squares.pieceNumber[k] = 5;
                } else if ( k == 61 ){ // white king
                    Squares.pieceNumber[k] = 6;
                } else { // empty cells
                    Squares.pieceNumber[k] = -1;
                }
                k++;
            }
        }
    }

    public static void swapCells ( int cell1, int cell2 ) {
        if ( Squares.pieceNumber[cell2] == 12 || Squares.pieceNumber[cell2] == 6 ){ // checking if the king was captured
            SimpleClient.kingStillAlive = 0;
        }
        Squares.pieceNumber[cell2] = Squares.pieceNumber[cell1];
        Squares.pieceNumber[cell1] = -1;
    }

}
