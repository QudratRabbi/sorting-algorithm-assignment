/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortingComparison;

//import java.util.*;

// 
// Qudrat E Rabbi
// CIS 3501
// Fall 2019
// Prof John P Baugh  
// Assignment Three
//

public class Cis_3501_assignemt_three {

    
    public static void main(String[] args) {
        
        int[] array_250 = new int[250]; // Creating array to populate
        int[] array_500 = new int[500];
        int[] array_750 = new int[750];
        int[] array_1000 = new int[1000];
        int[] array_2500 = new int[2500]; 
        int[] array_20 = new int[20]; // for report 
       
        
        
        //int[] test = {10,9,8,7,6,5,4,3,2,1,0}; // used to check functionality of sorting
            
        
       runTimeComparison(array_250); // Running the sorting algorithms and return a comparison between the two
       runTimeComparison(array_500); // For each array
       runTimeComparison(array_750);
       runTimeComparison(array_1000);
       runTimeComparison(array_2500); 
       runTimeComparison(array_20);
        
        
       System.out.println("250 : " + fillerTime(array_250) );
       System.out.println("500 : " + fillerTime(array_500) );
       System.out.println("750 : " + fillerTime(array_750));
       System.out.println("1000 : " + fillerTime(array_1000));
       System.out.println("2500 : " + fillerTime(array_2500));     
          
       
       System.out.println("THE END.");        
       
    } 
    
    
    //pre-condition: Array is passed to the function 
    //post-condition: Function calls two different methods to copare the running time between two sorting algorithm
    
    public static void runTimeComparison(int[] array){
        System.out.println("Both Sorting functions utilize array filling and the runtime consists of 5 rounds of sorting and filling.");
        System.out.println("Running on array of length : " + array.length);
        System.out.println("Insertion Sorting time is   : " + insertRunTime(array) + " nano-seconds. "); // call on insertRunTime which returns running time of insertion sort on the given array
        System.out.println("Quick Sorting time  is      : " + quickRunTime(array)  + " nano-seconds. "); // call on quickRunTime which returns running time of quick sort on the given array 
        System.out.println("==========================================================================================================");
    }
    
    // Pre-condition : Called by runTimeComparison to perform insertion on a given array
    // Post-Condition: Returns running time of 5 rounds of insertion sorting and filling
    public static long insertRunTime(int [] array){ 
        
        long start = System.nanoTime();
        insertionFive(array);
        long end = System.nanoTime();
        return end - start;
    }
    
    // Pre-condition : Called by runTimeComparison to perform quick Sort on a given array
    // Post-Condition: Returns running time of 5 rounds of quick sorting and filling
    public static long quickRunTime(int [] array){
        
        long start = System.nanoTime();
        quickFive(array);
        long end = System.nanoTime();
        return end - start;
    }   
    // Pre-condition : Array passed from inserRunTime function
    // Post-Condition: Fills array and performs insertion sort 5 times 
    
    public static void insertionFive(int [] array){
        for (int i = 0; i < 5; i++){
        array = SortingMethod.array_fill(array);        // newly randomized array, common operation in both sorting                                                           
        SortingMethod.insertionSort(array);             // Therefor has similar effect on running time 
        }
    }
    
    // Pre-condition : Array passed from inserRunTime function
    // Post-Condition: Fills array and performs quick sort 5 times 
    
    public static void quickFive(int[] array){
        for (int i = 0; i < 5; i++){
        array = SortingMethod.array_fill(array);         // newly randomized array, common operation in both sorting 
                                                         // Therefor has similar effect on running time 
        SortingMethod.quickSort(array, 0, array.length-1); // quicksort with starting and ending index
        }
        
    }
    // Pre-Condition : Array passed in
    // Post-Condition : Returns how long it takes for the program to fill the array with random numbers
    
    public static long fillerTime(int [] array){
        long start = System.nanoTime();
        for(int i = 0 ; i < 5 ; i ++){
        SortingMethod.array_fill(array);
        }
        long end = System.nanoTime();
        return end - start;
    }
    
}
