package org.lucky.ds.sorting;

public class BubbleSort {

    /*
       Pairs of adjacent elements are compared, and the elements swapped
       If they are not in order.
       Quadratic time O(n^2)
       Small dataset = okay-ish
       large dataset = bad (plz don't use)
     */
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        System.out.println("input");
        for(int i : arr)
            System.out.print(i);
        System.out.println();

        bubbleSort(arr);

        System.out.println("output");
        for(int i : arr)
            System.out.print(i);
    }

    private static void bubbleSort(int[] arr) {
        int step_counter=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] =  arr[j+1];
                    arr[j+1] = tmp;
                }
                step_counter++;
            }
        }
        System.out.println("Total step needed: "+step_counter);
    }
}
