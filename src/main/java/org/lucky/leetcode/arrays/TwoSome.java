package org.lucky.leetcode.arrays;


import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSome {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            int compliment = target - nums[i];
            if(map.containsKey(compliment)){
                return new int[]{map.get(compliment),i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(ints,new int[]{0,1});
        int[] ints2 = twoSum(new int[]{3,2,4}, 6);
        assertArrayEquals(ints2,new int[]{1,2});
        int[] ints3 = twoSum(new int[]{3,3}, 6);
        assertArrayEquals(ints3,new int[]{0,1});
    }
}
