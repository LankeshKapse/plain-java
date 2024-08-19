package org.lucky.ds.searching;


public class BinarySearch {

    public static void main(String[] args) {
        /*
        Binary search is another searching algorithm whose time complexity is O(log n)
        it works on only sorted array. First it will find mid of a collection and compare
        with target element if mid is lower that target then it discard the left array and
        try to search right array using same technique util it found the target value.
        It is better than linear search because its splitting array in half so search area also become small.
         */

//        int[] arr = {0,1,2,3,4,5,6,7,8,9};
//        int target =9;

        int[] arr = new int[100_000_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int target = arr[arr.length - 1];

        int index = binarySearch(arr, target);
        String message = index != -1 ? "Element found at index: " + index : "Element not found";
        System.out.println(message);
    }

    private static int binarySearch(int[] arr, int target) {
        int low=0;
        int high = arr.length;
        int step_counter=0;
        int index = -1;
        while (low<=high){
            int mid = low + (high-low) / 2;
            int value = arr[mid];
            if(value < target){
                low = mid+1;
            }else {
                if(value > target){
                    high = mid-1;
                }else {
                    index= mid;
                    break;
                }
            }
            step_counter++;
        }
        System.out.println("Step required: "+step_counter);
        return index;
    }
}
