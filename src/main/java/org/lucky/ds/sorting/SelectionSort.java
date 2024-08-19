package org.lucky.ds.sorting;

public class SelectionSort {

    /*
        Search through an array and keep track of minimum value during
        each iteration. At the end of each iteration, We swap variables

        Quadratic time O(n^2)
        small dataset = okay
        large dataset = Bad
     */

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        System.out.println("input");
        for(int i : arr)
            System.out.print(i);
        System.out.println();

        selectionSort(arr);

        System.out.println("output");
        for(int i : arr)
            System.out.print(i);
    }

    private static void selectionSort(int[] arr) {
        int step_counter=0;
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[min] > arr[j])
                    min=j;
                step_counter++;
            }
            //variable swapping
            int tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }
        System.out.println("Total step needed: "+step_counter);
    }
}
