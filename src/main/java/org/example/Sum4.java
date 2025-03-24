package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {

    /*
    Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
    0 <= a, b, c, d < n
    a, b, c, and d are distinct.
    nums[a] + nums[b] + nums[c] + nums[d] == target
    You may return the answer in any order.

    Example 1:
    Input: nums = [1,0,-1,0,-2,2], target = 0
    Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

    Example 2:
    Input: nums = [2,2,2,2,2], target = 8
    Output: [[2,2,2,2]]
    */
    public static void main(String[] args) {
        new Sum4().fourSum(new int[]{1,0,-1,0,-2,2}, 0);
        new Sum4().fourSum(new int[]{2,2,2,2,2}, 8);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // if nums.length is less the 4 then return that list itself
        Arrays.sort(nums);

        int a,b,c,d=0;

        return new ArrayList<>();
    }
}
