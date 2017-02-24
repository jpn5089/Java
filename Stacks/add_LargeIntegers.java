//*********************************************************************************************************************
//                                                   JP Nicola
//                                                   Program #3
//                                                  due 9/15/2016
//                  This program is designed to take two very large integers and produce a sum through the 
//                                         utilization of addition using stacks.
//*********************************************************************************************************************

import java.util.Scanner;
import java.util.Stack;
import java.lang.Character;

class Stack_addition_test {
  public static void main(String[] args) {
    String n1;
    System.out.println("Enter a very large number to be added: ");
    Scanner input = new Scanner(System.in);
    n1 = input.next();
    String n2;
    System.out.println("Enter a second very large number to be added: ");
    n2 = input.next();
    
    Stack<Character> first = new Stack<Character>();
    Stack<Character> second = new Stack<Character>();    
    
    for (int i = 0; i < n1.length(); i++) {
      first.push(n1.charAt(i));      
    }  
    
    for (int i = 0; i < n2.length(); i++) {
      second.push(n2.charAt(i));      
    } 
    
    System.out.println("The sum of your two numbers is " + add(first,second));    
    
  }
  public static String add(Stack<Character> first, Stack<Character> second) {
    Stack<Integer> result = new Stack<Integer>();
    int carry = 0;
    int mod = 0;
    while(first.isEmpty() == false && second.isEmpty() == false) { //make sure stacks are not empty 
      carry = Character.getNumericValue(first.pop()) + Character.getNumericValue(second.pop()) + carry; //take top element from each stack and add
      mod = carry % 10; // find the unit part of sum
      carry = carry/10; // set carry back to zero or one 
      result.push(mod); //send unit part to result stack
    }
    
    //#############################################################################################################//
    // In case the integers aren't equal size. A loop for each case to grab remaining numbers from nonempty stack  //
    //#############################################################################################################//
    
    int sz2 = second.size(); //set size to stay constant
    if (first.isEmpty() == true) {
      for (int i = 0; i < sz2; i++ ) { //if first is empty, go off remaining length of second
        carry = Character.getNumericValue(second.pop()) + carry; //start popping while also bringing along any carry's from the previous calculation
        mod = carry % 10;
        result.push(mod);
        carry = carry/10;
      }
    }
    int sz1 = first.size(); //set size to stay constant
    if (second.isEmpty() == true)  {     
      for (int i = 0; i < sz1; i++ ) { // if second is empty, go off remaining length of first
        carry = Character.getNumericValue(first.pop()) + carry; //start popping while also bringing along any carry's from the previous calculation
        mod = carry % 10; 
        result.push(mod);
        carry = carry/10;
      }      
    }
    
    // If the last two numbers, of even length stacks, added together are >= 10, push that "1" from the tens place
    if (carry != 0) {
      result.push(carry); 
    }
    
    //pop values from result stack to a string to print 
    int sz_result = result.size();
    String out = ""; 
    for (int i = 0; i < sz_result; i++) { 
      out = out + "" + result.pop();
    }
    return out;
  }
}