import java.util.*;

class TicTacToeBoard
{

    private char [] [] arrayOfSpace = new char [3] [3]; // create array
    boolean xGoesNow = true;

    public TicTacToeBoard () // constructor for 2D array of blank space
    {
        for (int row = 0; row <= arrayOfSpace.length - 1; row++)
        {
            for (int column = 0; column <= arrayOfSpace[row].length - 1; column++)
            {
                arrayOfSpace[row][column] = ' ';
            }
        }
    }

    public String toString() // convert to String
    {
        char [] visible = {'|', arrayOfSpace[0][0], ' ', arrayOfSpace[0][1], ' ', arrayOfSpace[0][2], '|', '\n',
                            '|', arrayOfSpace[1][0], ' ', arrayOfSpace[1][1], ' ', arrayOfSpace[1][2], '|','\n',
                            '|', arrayOfSpace[2][0], ' ', arrayOfSpace[2][1], ' ', arrayOfSpace[2][2], '|'};
        String returnBoard = new String (visible);
        return returnBoard;
    }

    public boolean isFree(int x, int y) // legal move in open place?
    {
        boolean placeIsAvail = true;

        if (arrayOfSpace[x - 1][y - 1] != ' ')
        {
            placeIsAvail = false;
        }
        return placeIsAvail;
    }

    public void playersChangeTurn() // switches between players
    {
        xGoesNow = !xGoesNow;
    }

    public boolean getXGoes() // stores who is playing
    {
        return xGoesNow;
    }

    public void updateTheBoard (int x, int y) // checks which mark to put, places mark in designated index of array
    {
        char marked = ' ';
        char [] updatedRow = new char [3];

        if (xGoesNow == true)
        {
            marked = 'X';
        }
        else
        {
            marked = 'O';
        }

        arrayOfSpace[x - 1][y - 1] = marked;
    }

    public boolean XWinCheck() // checks for XXX in any consecutive arrangement
    {
        boolean weHaveAXWinner = false;

        if (arrayOfSpace[0][0] == 'X' && arrayOfSpace[0][1] == 'X' && arrayOfSpace[0][2] == 'X')
        {
            weHaveAXWinner = true;
        }
        else if (arrayOfSpace[1][0] == 'X' && arrayOfSpace[1][1] == 'X' && arrayOfSpace[1][2] == 'X')
        {
            weHaveAXWinner = true;
        }
        else if (arrayOfSpace[2][0] == 'X' && arrayOfSpace[2][1] == 'X' && arrayOfSpace[2][2] == 'X')
        {
            weHaveAXWinner = true;
        }
        else if (arrayOfSpace[0][0] == 'X' && arrayOfSpace[1][0] == 'X' && arrayOfSpace[2][0] == 'X')
        {
            weHaveAXWinner = true;
        }
        else if (arrayOfSpace[0][1] == 'X' && arrayOfSpace[1][1] == 'X' && arrayOfSpace[2][1] == 'X')
        {
            weHaveAXWinner = true;
        }
        else if (arrayOfSpace[0][2] == 'X' && arrayOfSpace[1][2] == 'X' && arrayOfSpace[2][2] == 'X')
        {
            weHaveAXWinner = true;
        }
        else if (arrayOfSpace[0][0] == 'X' && arrayOfSpace[1][1] == 'X' && arrayOfSpace[2][2] == 'X')
        {
            weHaveAXWinner = true;
        }
        else if (arrayOfSpace[0][2] == 'X' && arrayOfSpace[1][1] == 'X' && arrayOfSpace[2][0] == 'X')
        {
            weHaveAXWinner = true;
        }
        return weHaveAXWinner;
    }


       public boolean OWinCheck() // checks for O in consecutive order
       {
           boolean weHaveAOWinner = false;

           if (arrayOfSpace[0][0] == 'O' && arrayOfSpace[0][1] == 'O' && arrayOfSpace[0][2] == 'O')
            {
                weHaveAOWinner = true;
            }
            else if (arrayOfSpace[1][0] == 'O' && arrayOfSpace[1][1] == 'O' && arrayOfSpace[1][2] == 'O')
            {
                weHaveAOWinner = true;
            }
            else if (arrayOfSpace[2][0] == 'O' && arrayOfSpace[2][1] == 'O' && arrayOfSpace[2][2] == 'O')
            {
                weHaveAOWinner = true;
            }
            else if (arrayOfSpace[0][0] == 'O' && arrayOfSpace[1][0] == 'O' && arrayOfSpace[2][0] == 'O')
            {
                weHaveAOWinner = true;
            }
            else if (arrayOfSpace[0][1] == 'O' && arrayOfSpace[1][1] == 'O' && arrayOfSpace[2][1] == 'O')
            {
                weHaveAOWinner = true;
            }
            else if (arrayOfSpace[0][2] == 'O' && arrayOfSpace[1][2] == 'O' && arrayOfSpace[2][2] == 'O')
            {
                weHaveAOWinner = true;
            }
            else if (arrayOfSpace[0][0] == 'O' && arrayOfSpace[1][1] == 'O' && arrayOfSpace[2][2] == 'O')
            {
                weHaveAOWinner = true;
            }
            else if (arrayOfSpace[0][2] == 'O' && arrayOfSpace[1][1] == 'O' && arrayOfSpace[2][0] == 'O')
            {
                weHaveAOWinner = true;
            }
            return weHaveAOWinner;
       }

    }




