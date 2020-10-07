/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortingComparison;

/**
 *Qudrat E Rabbi
 *Prof. John Baugh
 *CIS 3501 
 *Assignment three 
 */
public class SortingMethod { 
   
    //pre-condition: recursive quickSort function which takes the array, starting and ending index to perform sort
    //post-condition: Array is sorted
    public static void quickSort(int [] array, int begin, int end){
        if (begin < end){
            
            int part_is_on = partition(array, begin, end);// calls on partition function to create a partision index
            
            quickSort(array, begin, part_is_on - 1); // Recursive sorting of elements before and after 
            quickSort(array, part_is_on + 1, end);
        }
    }      
    
    
    //pre-condition:  Unsorted array with randomized integers
    //post-condition: Sorted array
    
    public static void insertionSort(int[] array){        
        for (int i = 1; i < array.length ; i ++){
            int key = array[i];
            int j = i - 1;
            
            while (j >= 0 && array[j] > key){
                array[j+1] = array[j];
                j = j-1;
            }
            array[j + 1] = key;
        }
            
    }
    
    //pre-condition: Empty array or (sorted in our case) used array passed in
    //post-condition: Fills array or re-fills it with random number ranging from 0 to array length
   public static int [] array_fill(int [] array){       
       
       for(int i =0; i < array.length;i++){
            array[i] = (int)(Math.random()* array.length);
        }
       return array;
   }
    //pre-condition: Array passed in
    //post-condition: Prints the entire array separated by space
   
    public static void print_list(int [] array){
       for(int i = 0; i < array.length;i++){
            System.out.print(" " + array[i]);
        } 
    }
    
    //pre-condition: two arrays are passed in
    //post-condition: checks elements in both array by index, to see if done right
    // for testing purposes only
    
    public static void arrayComparison(int [] array1, int [] array2){
        for(int i = 0; i < array1.length; i++){
            System.out.println("1st: " + array1[i] + "  2nd :" + array2[i]);
        }
    }
    
    //pre-condition: Array with begining and ending partition index is passed in     
    //post-condition: takes last element as pivot to shift numbers larger and smaller accordingly.                  
                        
    
    public static int partition( int[] array, int begin, int end){
        int pivot = array[end];
        
        int i = (begin - 1);// lower index
        
        for(int x = begin; x < end; x++){ 
            
            if(array[x] <= pivot){ // if current element is smaller 
                
                i++;                
                int temp = array[i];
                array[i] = array[x];
                array[x] = temp;                
            }
        }
        int temp = array[i+1];
        array[i+1] = array[end];
        array[end] = temp;
        return i + 1;
    } 
    
    
    //pre-condition: Checks if an array is indeed sorted
    //post-condition: True or false based on result
    // For testing pusposes
    
    public static boolean sortCheck(int [] array){
        for (int i = 0; i < array.length -1 ; i++){
            if(array[i] > array[i+1])
                return false;
        }
        return true;
    }
    
}
