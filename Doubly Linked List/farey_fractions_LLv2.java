//*********************************************************************************************************************
//                                                   JP Nicola
//                                                   Program #4
//                                                  due 9/27/2016
//               This program uses the Java Linked List class to create Farey Fractions. The user enters 
//                    a Farey levels and this insertion and deletion the list is extended as needed.           
//*********************************************************************************************************************


import java.util.LinkedList;
import java.util.Scanner;

class Farey_LinkedList {
  
  public static void main(String[] args) {
    
    int n; 
    System.out.println("Enter Farey level:");
    Scanner input = new Scanner(System.in);
    n = input.nextInt();  
    Farey_LL linkList = new Farey_LL();    
    linkList.fareyMath(n); //dont need to dll. in Farey class
    for (int i = 0; i < linkList.size(); i++) {
      System.out.print(linkList.get(i).toString() + " ");
    }
  }
}

class Farey_LL extends LinkedList<Fraction> {
  
  public LinkedList<Fraction> fareyMath(int n) {
    
    Fraction f1 = new Fraction(0,1); // set constructors
    Fraction f2 = new Fraction(1,1); 
    add(0,f2);
    add(0,f1);
    
    for (int i = 1; i < n; i++) { // check for farey level
      int len = size();
      //System.out.println("At farey level " + i + " len = " + len);
      for (int j = 0; j < len; j++) { //check for how long list is
        int den_sum = get(j).den + get(j+1).den; // add numerators and denominators from both fracs
        //System.out.println("den = " + den_sum + " at j= " + j);
        int num_sum = get(j).num + get(j+1).num;
        //System.out.println("num = " + num_sum + " at j= " + j);
        Fraction f3 = new Fraction(num_sum, den_sum); // create new fraction
        
        if (den_sum < n+1) //check if denominator (c+d) is less than or equal to n           
          add(j+1,f3); //put in new fraction
        //j = j + 1;
      }
    }
    return this;
  }
}
