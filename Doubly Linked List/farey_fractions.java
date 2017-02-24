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
    
    Fraction f1 = new Fraction(0,1); // create new objects by calling constructor
    Fraction f2 = new Fraction(1,1); 
    insertAtHead(f2);
    insertAtHead(f1);    
    
    for (int i = 1; i < n; i++) { // check for farey level 
      int len = dllLength();
      for (int j = 1; j < len; j++) { //check for how long list is
        int den_sum = tail.info.den + tail.prev.info.den; // add numerators and denominators from both fracs
        int num_sum = tail.info.num + tail.prev.info.num;       
        Fraction f3 = new Fraction(num_sum, den_sum); // create new fraction
        Fraction f4 = deleteFromTail(); 
        
        if (den_sum < n+1) { //check if denominator (c+d) is less than or equal to n           
          insertAtHead(f4); //start organizing output list from last to beginining
          insertAtHead(f3); //put in new fraction      
        }        
        else {
          insertAtHead(f4); //still put last fraction to front 
        }
      }
      Fraction f5 = deleteFromTail(); //delete last fraction (0/1)
      insertAtHead(f5); //move to front 
    }
    System.out.println("This is your Farey List: ");
    print();
    return this;
  }
}

// DLL = head or tail
// DLLNode = info, next, or prev
// Fraction = num or den
