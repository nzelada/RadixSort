package radixSort;

/**
 * ************************************************************
 * Purpose/Description:
 * <This program will get elements and see if they are odd or even and sort them if they are even>
 * Author’s Panther ID: 
 * Certification: I hereby certify that this work is my own and none of it is
 * the work of any other person.
 * ************************************************************
 */
import java.util.*;

public class RadixSort {

    /**
     * This is the main method in which it will allow for the program to run. It
     * will also ask the user for to input the elements and how many elements
     * they are wanting to represent. Not only that it will find if the elements
     * are odd or even. If even it will sort them out. If not, it will say it
     * found an odd number.
     *
     * @param args
     */
    public static void main(String[] args) {

        int num; // the number of elements

        Scanner s = new Scanner(System.in); // scanner

        System.out.println("Enter the number of elements you want to sort");

        num = s.nextInt(); // input is assigned to num

        int[] arr = new int[num]; // array size with num

        System.out.println("Enter the elements"); // print

        for (int i = 0; i < num; i++) { // for loop 
            arr[i] = s.nextInt();  // assigns input into the array
        }

        radixsort(arr); // calls the method to sort

        System.out.print("After sorting: "); // after sorting

        for (int i = 0; i < num; i++){  // for loop
            System.out.print(arr[i] + " ");} // prints in sorting
            
      
        System.out.print("\n"); // new line

    }
/**
 * radixsort will get the user's elements and check if they are odd or even. It 
 * will also sort them out and return it to the main to present.
 * @param arr  the array
 */
    public static void radixsort(int[] arr) {

        ArrayList<Integer>[] storage = new ArrayList[10]; // new arraylist of 10

        for (int i = 0; i < storage.length; i++) { // for loop

            storage[i] = new ArrayList<Integer>(); // assigns b integer to arraylist

        }

        boolean f = false; // boolean variable

        int temp = -1, divisor = 1; // int 

        while (!f) { // being true

            f = true;

            for (int i = 0; i < arr.length; i++) { // for loop

                temp = arr[i] / divisor; // divide and assign to temp

                if (temp % 2 != 0) { // if statement of module

                    System.out.println("*** Abort *** At least one key with odd digits");

                    System.exit(0);

                }

                storage[temp % 10].add(arr[i]); // adds to the array

                if (f && temp > 0) { // if less than 0

                    f = false; // its false then

                }

            }

            int a = 0; // starting at 0

            for (int b = 0; b < 10; b = b + 2) { // for loop

                for (Integer i : storage[b]) { // enchanced for loop

                    arr[a++] = i;

                }

                storage[b].clear(); // remove from the arraylist

            }

            divisor *= 10; // next number

        }

    }
}
