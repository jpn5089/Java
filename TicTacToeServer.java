//*********************************************************************************************************************
//                                                     JP Nicola
//                                                      CPMA 535
//                                           Tic Tac Toe Game - Server Portion 
//*********************************************************************************************************************

import java.util.Arrays;
import java.net.*;
import java.io.*;
import java.lang.*;        

public class TicTacToeServer {
  
  public static void main(String[] args) {
    int row, column;
    char player = 'O';    
    
    if (args.length != 1) {
      System.err.println("Usage: java TicTacToeServer <port number>");
      System.exit(1);
    }
    
    int portNumber = Integer.parseInt(args[0]);
    //Server is opened and allows for the two players (clients) to connect    
    try {
      ServerSocket serverSocket = new ServerSocket(portNumber);
      
      Socket clientXSocket = serverSocket.accept();
      PrintWriter outX = new PrintWriter(clientXSocket.getOutputStream(), true);
      BufferedReader inX = new BufferedReader(new InputStreamReader(clientXSocket.getInputStream()));
      
      Socket clientOSocket = serverSocket.accept();
      PrintWriter outO = new PrintWriter(clientOSocket.getOutputStream(), true);
      BufferedReader inO = new BufferedReader(new InputStreamReader(clientOSocket.getInputStream()));
      
      TicTacToeBoard game = new TicTacToeBoard();
      String inputLine, outputLine, board, bd, newBoard;
      char[] inputChars;
      
      game.createBoard();  
      
      outX.println("Player X: choose your location (row then column with no space)");
      
      //player X starts
      while ((inputLine = inX.readLine()) != null) {
        player = game.changePlayer(player);
        inputChars = inputLine.toCharArray(); //take client input and change to an array of characters 
        row = Character.getNumericValue(inputChars[0]); //convert character to integer
        column = Character.getNumericValue(inputChars[1]); //convert character to integer
        
        if (game.isMoveIllegal(row, column)) {
          outX.println("Illegal move: try again (row then column with no space)");
          inputLine = inX.readLine();
          inputChars = inputLine.toCharArray(); //take client input and change to an array of characters 
          row = Character.getNumericValue(inputChars[0]); 
          column = Character.getNumericValue(inputChars[1]);
          newBoard = game.changeBoard(player, row, column);
          outO.println(newBoard + "\t Player O: make move (row then column with no space)"); //print board with new move to player O
        }
        
        newBoard = game.changeBoard(player, row, column);
        outO.println(newBoard + "\t Player O: make move (row then column with no space)"); //print board to player O

        if (game.checkIfWinner()) {
          outX.println("The winner is " + player + "!");
          outO.println("The winner is " + player + "!");
          break;        
        }

        if (game.checkIfTie()) {
          outX.println("The game is a tie!");
          outO.println("The game is a tie!");
          break;
        }
        
        //outO.println("choose your location (row then column with no space)");
        inputLine = inO.readLine();
        player = game.changePlayer(player);
        inputChars = inputLine.toCharArray(); //take client input and change to an array of characters 
        row = Character.getNumericValue(inputChars[0]); //convert character to integer
        column = Character.getNumericValue(inputChars[1]); //convert character to integer
        
        if (game.isMoveIllegal(row, column)) {
          outO.println("Illegal move: try again (row then column with no space)");
          inputLine = inO.readLine();
          inputChars = inputLine.toCharArray(); //take client input and change to an array of characters 
          row = Character.getNumericValue(inputChars[0]); 
          column = Character.getNumericValue(inputChars[1]);
          newBoard = game.changeBoard(player, row, column);
          outX.println(newBoard + "\t Player X: make move (row then column with no space)"); //print board with new move to player X
        }
        
        newBoard = game.changeBoard(player, row, column);
        outX.println(newBoard + "\t Player X: make move (row then column with no space)"); //print board to player X

        if (game.checkIfWinner()) {
          outX.println("The winner is " + player + "!");
          outO.println("The winner is " + player + "!");
          break;        
        }

        if (game.checkIfTie()) {
          outX.println("The game is a tie!");
          outO.println("The game is a tie!");
          break;
        }
      }
    } catch (IOException e) {
      System.out.println("Exception caught when trying to listen on port "
                           + portNumber + " or listening for a connection");
      System.out.println(e.getMessage());
    }
  }
}
