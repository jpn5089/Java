//*********************************************************************************************************************
//                                                      JP Nicola
//                                                      Program #5
//                                                     due 10/6/2016
//   Take a string knowing a selected character and let three methods 1.) see if the character exists in the string 
//      2.) count the number of occurences of that character in the string and 3.) return a new string with all 
//                                      those occurences of the character removed.
//*********************************************************************************************************************

import java.util.Scanner;

class recursionOnStrings {
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a string of characters:");
    String string = input.nextLine();
    
    System.out.println("Search for what character?:");
    char ch = input.next().charAt(0);
    
    Recursive rec = new Recursive();
    
    if (rec.charIndex(ch,string) == -1) {
      System.out.println("Character " + "'" + ch + "'" +  " is not in the string");
    } else {
      System.out.println("Character " + "'" + ch + "'" +  " is in the string");
    }      
    System.out.println(ch + " occurs " + rec.charCount(ch, string) + " time(s) in the string");
    
    System.out.println("New String: " + rec.newString(ch, string));
  }
}

class Recursive {
  
  public int charIndex(char ch, String str) {
    
    if (str == null || str.equals("")) { //base case
      return -1; 
    } else if (ch == str.charAt(0)) {
      return 0; 
    }    
    int subIndex = charIndex(ch, str.substring(1)); 
    if (subIndex == -1) {
      return -1;
    } else {
      return 1 + subIndex; // recursive step
    }    
  }
  
  public int charCount(char ch, String str) {
    if(str == null || str.equals("")) //base case
      return 0;
    
    String subStr = str.substring(1);
    if (str.charAt(0) == ch) {
      return 1 + charCount(ch, subStr); //recursive steps
    } else {      
      return charCount(ch, subStr);
    }    
  }
  
  public String newString(char ch, String str)  {   
    if (str == null || str.equals("")) { //base case
      return str;
    }    
    String firstchar;
    if (str.charAt(0) == ch) { //check if first character is a match
      firstchar = ""; //if so, delete
    } else {
      firstchar = str.substring(0,1); //if not, keep it
    }
    return firstchar + newString(ch, str.substring(1)); //recursive step to return the first character or nothing followed by the rest of the string without the character 'ch'
  }
}