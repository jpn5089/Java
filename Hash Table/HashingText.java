import java.io.*;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;

class HashingText {
  
  public static void main(String[] args) {
    
    System.out.println("Enter file with '.txt' extension included: ");
    Scanner input = new Scanner(System.in);
    //  String file = input.next(); 
    Integer lineNumber = 0;
    Hashing hashTable = new Hashing();
    
    try{
      FileReader in = new FileReader("hashing.txt");
      BufferedReader br = new BufferedReader(in);    
      
      String s = "";
      char c;
      String line;
      String finishedWord;
      while ((line = br.readLine()) != null) {
        lineNumber = lineNumber + 1; //designated line number
        String[] words = line.split(" "); //split each line into its separate words
        for (int i = 0; i < words.length; i++) {
          Word pair = new Word(words[i], lineNumber); //create objects of class word to insert into hash table
          hashTable.insert(pair);
        }
      }
    }
    catch(IOException E){}
    
    //make temporary array
    int tempLength = 0;
    int hashLength = hashTable.tsize; 
    for (int i = 0; i < hashLength; i++){ //find apporpriate length for final array (number of non-null positions in orignal Hash Table)
      if (hashTable.table[i] != null) {
        tempLength++;
      }
    }
    int finalLength = 0;
    Word[] finalTable = new Word[tempLength]; //create final output array of class Word that is correct length (tempLength)
    int hashFinalLength = finalTable.length;
    for (int j = 0; j < hashLength; j++) { // loop to fill final array with Word objects 
      if (hashTable.table[j] != null) {
        finalTable[finalLength] = hashTable.table[j]; //assign values from orignal hash table to correct position in fimal array 
        finalLength++;
      }
    }
    Arrays.sort(finalTable); //sort 
    System.out.println(Arrays.toString(finalTable)); //print
  }
}

