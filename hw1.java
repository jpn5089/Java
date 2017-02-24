//*********************************************************************************************************************
//                                             JP Nicola
//                                             Program #1
//                                            due 9/1/2016
//                    This program computes the factorial for a nonnegative integer and 
//          computes the value of e and e^x where the user enters the number of terms to calculate   
//*********************************************************************************************************************

import java.util.Scanner;

class Factorial  {
  public static void main(String[] args) {
    int n;
    int x;
    int terms;
    System.out.println("Enter a non negative integer: ");
    Scanner kb = new Scanner(System.in);
    n = kb.nextInt();
    // Loop in case user input is a negative number
    while (n < 0) {
      System.out.println("Invalid Number");
      System.out.println("Enter a non negative integer: ");
      n = kb.nextInt();
    }
    long answer = factorial(n);
    System.out.println("The factorial of "+n+" is = "+answer);
    // Part B
    System.out.println("Enter the number of terms to calculate e: ");
    terms = kb.nextInt();    
    double ans = e(n);
    System.out.println("e(for " +terms+" terms) = "+ans);
    // Part C
    System.out.println("Enter the number of terms to calculate e^x: ");
    terms = kb.nextInt();
    System.out.println("Also, enter the value of x to calculate e^x: ");
    x = kb.nextInt();
    double answerex = ex(terms, x);
    System.out.println("e^" + x + "(for " +terms+" terms) = " +answerex);
    
  }  
  //Find factorial by looping through calculation incrementing f by 1 each loop
  public static long factorial(long n) {
    long counter = 1; 
    for (int f = 1 ; f <= n ; f++)
        counter = counter*f; 
    return counter;
  }  
  //e needs to be a double here and so does counter to allow calculation to work
  public static double e(int terms) {
    double counter = 1.0; 
    for (int t = 1 ; t < terms ; t ++)
      counter = counter + (1.0/(double) factorial(t));
    return counter;
  }
  //Utilized the built in power function
  public static double ex(int terms, int x) {
    double counter = 1.0;
    for (int t = 1 ; t < terms ; t ++){
      counter = counter + (Math.pow(x,t)/(double) factorial(t));
    }
    return counter;
  }
}


