package org.lucky.ds.searching;

public class LinearSearch {

    public static void main(String[] args) {
//        int[] arr = {1,3,2,5,4,7,6,9,8};
//        int target = 9;

        int[] arr = new int[100_000_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int target = arr[arr.length - 1];
        /*
          Linear search is search throw collection from start to end
          and compare each element with target element if it's found it will return index of
          that element otherwise it will return -1
          It has time complexity is O(n)
         */

        int index = linearSearch(arr, target);
        String message = index != -1 ? "Element found at index: " + index : "Element not found";
        System.out.println(message);
    }

    private static int linearSearch(int[] arr, int target){
        int step_counter=0;
        int index = -1;
        for(int i=0; i < arr.length; i++){
            if(arr[i] == target){
                index =i;
                break;
            }
            step_counter++;
        }
        System.out.println("Step required: "+step_counter);
        return index;
    }
}
