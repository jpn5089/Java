//*********************************************************************************************************************
//                                                   JP Nicola
//                                                   Program #4
//                                                  due 9/27/2016
//                  This program uses doubly linked lists to create Farey Fractions. The user enters 
//                    a Farey levels and this insertion and deletion the list is extended as needed.           
//*********************************************************************************************************************

import java.util.Scanner;
import java.util.LinkedList;

class test {
  
  public static void main(String[] args) {    
    int n; 
    System.out.println("Enter Farey level:");
    Scanner input = new Scanner(System.in);
    n = input.nextInt();  
    Farey dll = new Farey();    
    dll.fareyMath(n); //dont need to dll. in Farey class
    dll.dllLength();
    int l = dll.dllLength();
    for (int i = 0; i < l + 1; i++) {
      System.out.print(dll.deleteFromTail().toString() + " ");
    }
  }
}

class Farey extends DLL<Fraction> {
  
  public int dllLength() { //create method to check length of list
    int length = 0;
    for (DLLNode<Fraction> i = head; i != null; i = i.next) {
      length = length + 1;      
    }
    return length;
  }  
  public DLL<Fraction> fareyMath(int n) { //what do inputs need to be to execute method
    
    Fraction f1 = new Fraction(0,1); // set constructors
    Fraction f2 = new Fraction(1,1); 
    insertAtHead(f2);
    insertAtHead(f1);
    
    for (int i = 1; i < n + 1; i++) { // check for farey level
      /* n = dllLength();          */      
      for (int j = 1; j < dllLength() + 1; j++) { //check for how long list is
        int den_sum = tail.info.den + tail.prev.info.den; // add numerators and denominators from both fracs
        //System.out.println(den_sum);
        int num_sum = tail.info.num + tail.prev.info.num;
        //System.out.println(num_sum);
        Fraction f3 = deleteFromTail(); //get the first two fractions that need compared
        //System.out.println(f3);
        Fraction f4 = deleteFromTail();
        //System.out.println(f4);
        Fraction f5 = new Fraction(num_sum, den_sum); // create new fraction
        //System.out.println(f5);
        System.out.println(dllLength() + "len");
        
        if (den_sum < n+1) { //check if denominator (c+d) is less than or equal to n           
          insertAtHead(f3); //start organizing output list from last to beginining
          insertAtHead(f5); 
          System.out.println(f3 + " f3b");
          System.out.println(f4 + " f4b");
          System.out.println(f5 + " f5b");
          f3 = f4; // shift fractions by one place to prepare for next comparison
          System.out.println(f3 + " f3");
          System.out.println(f4 + " f4");
          System.out.println(f5 + " f5");
          f4 = deleteFromTail(); 
          System.out.println(f4 + " df4");
        } else {
          insertAtHead(f4);
          f3 = f4;
        }             
      }
      //insertAtHead(f1);
      insertAtHead(f2);//add first fraction back to beginning of list 
    }
    return this;
  }
}

// DLL = head or tail
// DLLNode = info, next, or prev
// Fraction = num or den
