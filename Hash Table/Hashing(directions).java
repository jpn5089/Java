//*********************************************************************************************************************
//                                                   JP Nicola
//                                                   Program #7
//                                                  due 11/4/2016
//                 This program takes an input of words and uses hashing to say what words occur and the   
//                         line numbers they occur on. This is done through the use of a Word object 
//                       that holds a string and a one node linked list that stores the line numbers.
//*********************************************************************************************************************

import java.io.*;

class Hashing {
  
  static int tsize = 8;
  Word[] table;
  Hashing(){
    table= new Word[tsize];
  }
  
  public int hash(String str) { //find home position
    return str.charAt(0) % tsize;
  }
  
// Collision resolution should be implemented with the linear probing technique. If the home position is free, 
// an object is put there that includes this word and a one-node linked list with the line number of the line on which 
// the word was encountered. If the position is occupied by an object that already includes this word, add the line 
// number to the list of line numbers in this object. If the home position is occupied by an object for another word, 
// use linear probing to find a free cell if the word has been encountered for the first time or a cell with an object 
// that already includes this word. During linear probing, start from the beginning of the hash table when its end 
// has been reached. When all positions in the table are occupied, print a message and continue processing the file.  
  
  public void insert(Word wrd) {
    
    int pos = hash(wrd.word);
    
    if (table[pos] == null) {
      table[pos] = wrd;
      return;
    } else if (table[pos].equals(wrd)) {
      table[pos].lineNumber.add(wrd.lineNumber.element()); 
      return;
    } else {
      for (int i = pos + 1; i != pos; i++) {
        if (table[i] == null) {
          table[i] = wrd;
          // show(table);
          return;
        } else if (table[i].equals(wrd)) {
          table[i].lineNumber.add(wrd.lineNumber.element()); 
           //show(table);
          return;
        } else if (i == tsize - 1) {
          i = -1;
        }
        
      }
      
      System.out.println("No more open positions to insert new word");
      
    }
   
  }
  
  static void show(Object[] o){
    for( Object c:o)
      System.out.println(c+" ");
  }
}


