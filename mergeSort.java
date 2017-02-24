//*********************************************************************************************************************
//                                                     JP Nicola
//                                                     Program #8
//                                                   due 11/17/2016
//                  This program is supposed to utilize the natural order of an array by taking "runs" of 
//                     of ordered numbers and then merging those "runs" into a totally ordering array.
//*********************************************************************************************************************

import java.util.Scanner;

class MergeSort {
  
  public static void merge(int[] array, int left, int split, int right) {
    
    int[] tempArray = new int[array.length]; 
    int i = 0;
    int j = 0;
    
    for (int k = 0; k < (right - left) + 1; k++) { //check to make sure index pointers are still in range in two subarrays
      if ((i < split && j < right && array[i] <= array[j]) || (i < split && j >= right)) { //if pointer is out of range in second subarray
        tempArray[k] = array[i]; //insert value from first subarray index to new ordered array, tempArray
        i++;      
      } else {
        tempArray[k] = array[j]; //else insert value from second subarray index
        j++;
      }
      array = tempArray;
    }
  }  
  
  public static void naturalSort(int[] array, int left, int right) {
    
    if((right - left) < 2) //base case
      return;
    
    int split = 0;
    
    //find index of split
    for (int i = 0; i < array.length; i++) { 
      if (array[left] < array[left + 1]) {
        left++;
      } else {
        split = i;
      }
    }
    
    //double check if last two index spots are ordered or not
    if (array.length == 2 && array[left] <= array[right]) 
      return; 
    
    // recursive calls to sort and merge
    naturalSort(array, split, right);
    merge(array, left, split, right);
  }
  
  public static void main(String[] args) {
    
    int n;
    System.out.println("Enter the number of integers in the array: ");
    Scanner input = new Scanner(System.in);
    n = input.nextInt();
    int[] a = new int[n]; //creating integer array to hold user input    
    System.out.println("Enter numbers to fill the array: ");
    for (int k = 0 ; k < n ; k++) { //allow user to enter the number of integers they chose
      a[k] = input.nextInt();
    }
    naturalSort(a, 0, a.length - 1);
  }
}