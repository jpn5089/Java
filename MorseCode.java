//*********************************************************************************************************************
//                                                      JP Nicola
//                                                      Program #6
//                                                     due 10/20/2016
//             This program converts text encoded as Morse Code to English text through the use of an insert                
//          to create the tree and a search method to find the letters corresponding to each piece of Morse Code.            
//*********************************************************************************************************************


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class MorseCode extends BST<Character> {
  
  String[] code = {".-", "-...","-.-.","-..",".","..-.","--.","....","..",".---",
    "-.-",".-..","--","-.","---",".--.","--.-",".-.", "...","-","..-","...-",".--","-..-","-.--","--.."};
  
  Character[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T',
    'U','V','W','X','Y','Z'};
  
  public MorseCode(){ //tree constructor
    
    if (root == null) {
      root = new BSTNode<Character>('+');  
    }
    for(int i = 0; i < letters.length; i++) {
      insert(letters[i]);
    }
  }
  
  public static void main(String[] args) {
    
    System.out.println("Enter file with '.txt' extension included: ");
    Scanner input = new Scanner(System.in);
    String message = input.next();   
    
    try { //fileinputstream reader
      FileInputStream file = new FileInputStream("morsecode.txt");
      MorseCode alphabet = new MorseCode();
      String s = "";
      char c;
      while(file.available() > 0) { //as long as there are still characters to read    
        c = (char) file.read(); //save character to compare in if statements 
        s = s + c;        
        if (c == ' ') {
          System.out.print(alphabet.search(s.trim()));
          s = "";
          c = (char) file.read();
          if (c == ' ') { //check for two spaces in a row
            System.out.print(" ");
          } else {
            s = s + c;
          }
        } 
      }
        System.out.print(alphabet.search(s.trim()));
    }
    catch(IOException e){}            
  }
  
  public void insert(Character t) {
    
    int index = t - 'A'; //get index of all letters for 0-25 by subtracting ascii code
    String mc = code[index];    
    BSTNode<Character> p = root;
    
    for(int j = 0; j < mc.length(); j++) {
      Character mcpiece = mc.charAt(j); //check individual characters to see if you should go left or right
      if (mcpiece == '-') {
        if (p.left != null) 
          p = p.left; 
        else { 
          p.left = new BSTNode<Character>(); //create new node if p.left is null
          p = p.left; //reset p
        }
      }      
      if (mcpiece == '.') {
        if (p.right != null)
          p = p.right;
        else {
          p.right = new BSTNode<Character>(); //create new node if p.right is null
          p = p.right; // reset p 
        }
      }
    }
    p.el = t; //populate node with parameter t
  }
  
  public Character search(String t) {
    
    BSTNode<Character> p = root;
    
    for(int k = 0; k < t.length(); k++) {
      Character tpiece = t.charAt(k); // look at just one character at a time     
      if (tpiece == '-') { //if character is "-", go left
        p = p.left;
      } else {
        p = p.right; // if not, go right
      }
    }
    return p.el; //return if found
  }
}
