package org.lucky.ds.sorting;

public class InsertionSort {

    /*
        After comparing elements to the left sift elements to the right
        to make room to insert a value

        Quadratic time o(n^2)
        Small dataset = decent
        Large dataset = BAD

        Less step than bubble sort
        Best case is O(n) comared to selection Sort O(n^2)
     */

    public static void main(String[] args) {
//        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        int arr[] = new int[100];
        int pointer=0;
        for (int i = arr.length-1; i >= 0; i--) {
            arr[pointer] = i;
            pointer++;
        }
        System.out.println("input");
        for(int i : arr)
            System.out.print(i+",");
        System.out.println();

        int step_counter= insertionSort(arr);

        System.out.println("output");
        for(int i : arr)
            System.out.print(i+",");

        System.out.println();
        System.out.println("Total step needed: "+step_counter);
    }

    private static int insertionSort(int[] arr) {
        int step_counter=0;

        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            while (j>=0 && arr[j] > tmp){
                arr[j+1] = arr[j];
                j--;
                step_counter++;
            }
            arr[j+1] = tmp;
        }

        return step_counter;
    }
}
