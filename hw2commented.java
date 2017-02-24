//*********************************************************************************************************************
//                                                   JP Nicola
//                                                   Program #2
//                                                  due 9/8/2016
//                  This program takes two arrays holding any combination of integers 0-10 and performs
//                                 various methods to edit and compare the array(s).
//*********************************************************************************************************************

import java.util.Scanner;
import java.util.Arrays;

class TestIntergerSet {
  public static void main(String[] args) {
    int n;
    System.out.println("Enter the number of integers in your first set: ");
    Scanner input = new Scanner(System.in);
    n = input.nextInt();
    int[] set1 = new int[n]; //creating integer array to hold user input
    boolean[] init_array = new boolean[11];    
    System.out.println("Enter those integers between 0 and 10: ");
    for (int t = 0 ; t < n ; t ++) { //allow user to enter the number of integers they chose
      set1[t] = input.nextInt();
    }
    System.out.println("Enter the number of integers in your second set: ");
    int n2;
    n2 = input.nextInt();
    int[] set2 = new int[n2];
    System.out.println("Enter those integers between 0 and 10: ");
    for (int t = 0 ; t < n2 ; t ++) {
      set2[t] = input.nextInt();
    }
    IntegerSet int_set1 = new IntegerSet(set1); //creating variable of type integer type to hold booleans 
    IntegerSet int_set2 = new IntegerSet(set2);
    System.out.println(Arrays.toString(set1)); 
    System.out.println(Arrays.toString(set2));
    /*System.out.println("Enter an integer between 0 and 10 to insert to your first set: ");
    int i;
    i = input.nextInt();    
    int_set1.insertElement(i);
    System.out.println(int_set1.toString());
    System.out.println("Enter an integer between 0 and 10 to delete from your first set: ");
    int d;
    d = input.nextInt();
    int_set1.deleteElement(d);
    System.out.println(int_set1.toString());*/
    System.out.println("The union of the two sets");
    System.out.println(int_set1.union(int_set2).toString());
    System.out.println("The intersection of the two sets");
    System.out.println(int_set1.intersection(int_set2).toString());
    System.out.println("Are the two sets equal?");
    System.out.println(int_set1.equals(int_set2));
  }
}

class IntegerSet {
  boolean[] initial_array; //Field
  
  public IntegerSet() {
    initial_array = new boolean[11]; //Constructor  
  }
  
  public IntegerSet(int[] set1) { // type and variable as parameters
    initial_array = new boolean[11]; 
    for (int i = 0; i < set1.length; i++) { //create boolean array from user input integer array
      initial_array[set1[i]] = true;
    }    
  }
  public IntegerSet union(IntegerSet a1) { 
    IntegerSet a2 = new IntegerSet(); //create new array for output placeholder
    
    for(int i = 0; i < initial_array.length; i++)  { 
      if(initial_array[i] || a1.initial_array[i] == true ){ //use || to find values in BOTH arrays
        a2.insertElement(i);
      }
    }
    return a2;
  }   
  
  public IntegerSet intersection(IntegerSet a1) { 
    IntegerSet a2 = new IntegerSet();
    
    for(int i = 0; i < initial_array.length; i++)  {
      if(initial_array[i] && a1.initial_array[i] == true ){ // use && to find values in BOTH arrays
        a2.insertElement(i);
      }
    }
    return a2;
  }   
  
  public void insertElement(int i){ //take integer from user and add to array by setting to true in boolean array
    initial_array[i]  = true;
  }
  public void deleteElement(int i){ //take integer from user and remove from array by setting to false in boolean array
    initial_array[i]  = false;
  }
  public String toString() {
    String s = ""; 
    boolean b = true; 
    for(int i = 0; i < initial_array.length; i++) {
      if(initial_array[i] == true) { 
        s = s + i + " "; //for any trues in boolean array, add the corresponding integer value plus a space to s 
        b = false; //so program doesn't reach 2nd if statement and would print value for empty set
      }
    }
    if(b == true){ //if all i's are false
      s = "---";
    }
    return s;
  }
  public boolean equals(Object a1) {
    boolean a2 = true;
    IntegerSet a3 = (IntegerSet) a1; //since equals is of type Object, we need to set to type IntegerSet        
    for(int i = 0; i < initial_array.length; i++) {
      a2 = a2 && (initial_array[i] == a3.initial_array[i]); //look if two booleans are equal and then if that equals a2 using && 
    }
    return a2;
  }
}


