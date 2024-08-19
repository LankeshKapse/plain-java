package org.lucky.ds.searching;

public class IterpolationSearch {

    public static void main(String[] args) {
        int[] arr = new int[100_0];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int target = 623;
        System.out.println("target: "+target);

        int index = interPolationSearch(arr, target);
        String message = index != -1 ? "Element found at index: " + index : "Element not found";
        System.out.println(message);
    }

    private static int interPolationSearch(int[] arr, int target) {
        int index=-1;
        int low=0;
        int high = arr.length-1;
        int step_counter=0;
        while (target >= arr[low] && target <= arr[high] && low <= high){
            step_counter++;

            int prob = low + (high-low) * (target - arr[low]) / (arr[high] - arr[low]);

            System.out.println("Guess index: "+prob);
            if(arr[prob] == target){
                index = prob;
                break;
            }
            if(target < arr[prob])
                high = prob-1;

            if(target > arr[prob])
                low = prob+1;

        }
        System.out.println("Step required: "+step_counter);
        return index;
    }
}
