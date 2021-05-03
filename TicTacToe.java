import java.util.*;

class TicTacToe
{
    public static void main (String [] args)
    {
        Scanner player = new Scanner (System.in); // accept player names
        System.out.println("Welcome! Tic-Tac-Toe is a two player game. \n Enter player one's name: ");
        String p1 = player.nextLine();
        System.out.println("Enter player two's name: ");
        String p2 = player.nextLine();

        //introduction to rules
        System.out.println("Players take turns marking a square. Only squares not already marked can be picked. ");
        System.out.print("Once a player has marked three squares in a row, he or she wins! If all squares are marked and no three squares are the same, a tied game is declared. ");
        System.out.println("Have Fun!");

        System.out.println("Game board: ");
        TicTacToeBoard theBoard = new TicTacToeBoard(); // creates Board object theBoard
        System.out.println(theBoard.toString()); //calls toString method from class
        Scanner nextMove = new Scanner (System.in);

        int xPlace; //some initializations
        int yPlace;

        boolean p1Winner = false;
        boolean p2Winner = false;

        while (true)  //primary game loop
        {
            System.out.println("It is " + p1 + "'s turn. \n Pick a row between 1 and 3: "); // calls on first player
            xPlace = nextMove.nextInt();
            while (xPlace != 1 && xPlace != 2 && xPlace != 3) // makes sure entry is valid input until it is
            {
                System.out.println("Whoops, that didn't look like a 1, 2, or 3. Please try again. ");
                System.out.println("Pick a row between 1 and 3: ");
                xPlace = nextMove.nextInt();
            }
            System.out.println("Pick a column between 1 and 3: ");
            yPlace = nextMove.nextInt();
            while (yPlace != 1 && yPlace != 2 && yPlace != 3) // same for y axis
            {
                System.out.println("Whoops, that didn't look like a 1, 2, or 3. Please try again. ");
                System.out.println("Pick a column between 1 and 3: ");
                yPlace = nextMove.nextInt();
            }

            while (theBoard.isFree(xPlace, yPlace) == false) // checks if board place is open-- no playing over other players
            {
                if (theBoard.isFree(xPlace, yPlace) == false)
                {
                    System.out.println("That place is already occupied, please pick another place.");
                    System.out.println("Pick a row between 1 and 3: ");
                    xPlace = nextMove.nextInt();
                    System.out.println("Pick a column between 1 and 3: ");
                    yPlace = nextMove.nextInt();
                }
            }
            theBoard.updateTheBoard(xPlace, yPlace); // updates board with new placement
            System.out.println(theBoard.toString()); // prints board -- as string

            if (theBoard.XWinCheck() == true || theBoard.OWinCheck() == true) // has anyone won?
            {
                p1Winner = true;
                System.out.println(p1 + " is the winner, game over.");
                break; // if yes, declare it then break
            }

            theBoard.playersChangeTurn(); // switch to O's from X's
            System.out.println("It is " + p2 + "'s turn. \n Pick a row between 1 and 3: "); // calls second player
            xPlace = nextMove.nextInt();
            while (xPlace != 1 && xPlace != 2 && xPlace != 3) // makes sure valid entry
            {
                    System.out.println("Whoops, that didn't look like a 1, 2, or 3. Please try again. ");
                    System.out.println("Pick a row between 1 and 3: ");
                    xPlace = nextMove.nextInt();
            }
            System.out.println("Pick a column between 1 and 3: ");
            yPlace = nextMove.nextInt();
            while (yPlace != 1 && yPlace != 2 && yPlace != 3) // makes sure valid entry
                {
                    System.out.println("Whoops, that didn't look like a 1, 2, or 3. Please try again. ");
                    System.out.println("Pick a column between 1 and 3: ");
                    yPlace = nextMove.nextInt();
                }

            while (theBoard.isFree(xPlace, yPlace) == false) // checks that place is available
            {
            if (theBoard.isFree(xPlace, yPlace) == false)
                {
                    System.out.println("That place is already occupied, please pick another place.");
                    System.out.println("Pick a row between 1 and 3: ");
                    xPlace = nextMove.nextInt();
                    System.out.println("Pick a column between 1 and 3: ");
                    yPlace = nextMove.nextInt();
                }
            }

            theBoard.updateTheBoard(xPlace, yPlace);
            System.out.println(theBoard.toString()); // prints new board
            theBoard.playersChangeTurn();

            if (theBoard.XWinCheck() == true || theBoard.OWinCheck() == true) // checks if won
            {
                p2Winner = true;
                System.out.println(p2 + " is the winner, game over.");
                break;
            }
        }
    }
}
