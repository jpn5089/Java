//*********************************************************************************************************************
//                                                     JP Nicola
//                                                      CPMA 535
//                                           Tic Tac Toe Game - Protocol/Board Portion 
//
// Portions of code acquired from http://codereview.stackexchange.com/questions/95876/simple-tic-tac-toe-game as I am 
// still not completely comfortable in Java. I am not sure my character type choices were the best for a client/server 
// purpose.
//*********************************************************************************************************************

import java.io.*;
import java.net.*;
import java.util.Arrays;

class TicTacToeBoard {  
  
  char[][] table = new char[3][3];
  
  public void createBoard() {
    //int value = 1; 
    for (int i = 0; i < 3; i++) {
      for (int p = 0; p < 3; p++) {
        table[i][p] = ' ';
        //value = value + 1;                
      }
    }
  }
  
  //Strings to display display at any given time 
  public String displayBoard() {    
    
    String value = " ";
    
    value = "  0  " + table[0][0] + " | " + table[0][1] + " | " + table[0][2];
    value = value + "\t     --+---+--";
    value = value + "\t  1  " + table[1][0] + " | " + table[1][1] + " | " + table[1][2];
    value = value + "\t     --+---+--";
    value = value + "\t  2  " + table[2][0] + " | " + table[2][1] + " | " + table[2][2];
    value = value + "\t     0   1   2 \t";
    
    return value; 
  }
  
  // Make sure move can be made
  public boolean isMoveIllegal(int row, int column) {
    // out of bounds
    if ((row > 2 || column > 2) || (row < 0 || column < 0)) {
      System.out.println("That space is outside the dimensions of the board. Please try again (row then column with no space).");
      return true;
      // already taken
    } else if (table[row][column] == 'X' || table[row][column] == 'O') {
      System.out.println("That space has already been filled. Please try again (row then column with no space).");
      return true;
    }
    return false;
  }
  
  //Add either and X or O for current player 
  public String changeBoard(char player, int row, int column) {
    table[row][column] = player;  
    return displayBoard();
  }  
  
  // I hardcoded the possible winning sequences 
  public boolean checkIfWinner() {
    if (table[0][0] == table[1][0] && table[1][0] == table[2][0] && (table[0][0] == 'X' || table[0][0] == 'O')) {
      return true;
    } else if (table[0][1] == table[1][1] && table[1][1] == table[2][1] && (table[0][1] == 'X' || table[0][1] == 'O')) {
      return true;
    } else if (table[0][2] == table[1][2] && table[1][2] == table[2][2] && (table[0][2] == 'X' || table[0][2] == 'O')) {
      return true;
    } else if (table[0][0] == table[0][1] && table[0][1] == table[0][2] && (table[0][0] == 'X' || table[0][0] == 'O')) {
      return true;
    } else if (table[1][0] == table[1][1] && table[1][1] == table[1][2] && (table[1][0] == 'X' || table[1][0] == 'O')) {
      return true;
    } else if (table[2][0] == table[2][1] && table[2][1] == table[2][2] && (table[2][0] == 'X' || table[2][0] == 'O')) {
      return true;
    } else if (table[0][0] == table[1][1] && table[1][1] == table[2][2] && (table[0][0] == 'X' || table[0][0] == 'O')) {
      return true;
    } else if (table[2][0] == table[1][1] && table[1][1] == table[0][2] && (table[2][0] == 'X' || table[2][0] == 'O')) {
      return true;
    } else {
      return false;
    }
  }
  
  // As long as there is an open space, there won't be a tie
  public boolean checkIfTie() {
    for (int i = 0; i < 3; i++) {
      for (int p = 0; p < 3; p++) {
        if (table[i][p] == ' ') {
          return false;
        }
      }
    }    
    return true;
  }
  
  //rotate between player X and player O
  public char changePlayer(char player) {
    char newTurn='e';
    if (player == 'O')
      newTurn='X';
    if (player == 'X')
      newTurn='O';
    return newTurn;
  }
}


