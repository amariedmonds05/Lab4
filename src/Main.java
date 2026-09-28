//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import jdk.dynalink.beans.StaticClass;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Lab Work: Ask the user how many integer numbers to be sorted
        // Declare the array and populate the array
        // Use scanner object and nextInt() to initialize input_size
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many integers will be sorted? ");
        int input_size = scanner.nextInt();

    // declare the array
        int[] input = new int[input_size];


        // take input from the user here using a loop
        for (int i=0; i < input_size; i++) {
            System.out.print ("Enter number " + (i+1) + ": ");
            input[i] = scanner.nextInt();
        }
        // Java array is passes by value or reference???
        int low = 0;
        int high = input.length-1;

        MergeSort(input, low, high);

        //print sorted array
        System.out.println("Sorted array: ");
        for(int i = 0; i<input.length; i++) {
        System.out.print (input[i] + " ");
        }
        scanner.close();
    }

    public static void MergeSort(int [] A, int low, int high){
        if (low < high) {
            // Divide
            int mid = low + (high-low)/2;

            MergeSort(A, low, mid);
            MergeSort(A, mid+1, high);
            Merge(A, low, mid, high);
        }
    }

    public static void Merge(int [] A, int low, int mid, int high) {
    //find size of two subarrays
        int n1 = mid-low+1;
        int n2 = high-mid;

        //temporary arrays
        int[]left = new int[n1];
        int[]right = new int[n2];

        //copy into left array
        for(int i=0; i<n1; i++) {
            left[i] = A[low+i];
        }

        //copy into right array
        for(int j=0; j<n2; j++) {
            right[j] = A[mid+1+j];
        }

        //starting
        int i = 0;
        int j = 0;
        int k = low;

        //compare elements from the two arrays
        while (i<n1 && j<n2) {
            if (left[i] <= right[j]) {
                A[k] = left[i];
                i++;
            }
            else {
                A[k] = right[j];
                j++;
            }
            k++;
        }

        //copy remaining elements from left array
        while(i<n1) {
            A[k] = left[i];
            i++;
            k++;
        }

        //copy remaining elements from right array
        while(j<n2) {
            A[k] = right[j];
            j++;
            k++;
        }

    }


}