package org.example;

import java.util.ArrayList;

public class CountSubArrays {
    // Count Subarrays Where Max Element Appears at Least K Times
    /*You are given an integer array nums and a positive integer k.

        Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

        A subarray is a contiguous sequence of elements within an array.

        Example 1:

        Input: nums = [1,3,2,3,3], k = 2
        Output: 6
        Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
        Example 2:

        Input: nums = [1,4,2,1], k = 3
        Output: 0
        Explanation: No subarray contains the element 4 at least 3 times.
     */
    public static void main(String[] args) {
        System.out.println(new CountSubArrays().countSubarrays(new int[]{1, 5, 6, 4, 3, 6, 2, 4, 6, 3, 6}, 3));
        System.out.println(new CountSubArrays().countSubarrays(new int[]{1,3,2,3,3}, 2));
        System.out.println(new CountSubArrays().countSubarrays(new int[]{1,4,2,1}, 3));
    }

    public long countSubarrays(int[] nums, int k) {
        int count = 0;
        int maxCount = 1;
        int max = nums[0];
        ArrayList<Integer> maxElementIndex = new ArrayList<>(nums.length / 2);
        maxElementIndex.add(0, 0);
        for(int i=1; i< nums.length; i++){
            if(nums[i] > max) {
                maxCount = 1;
                max = nums[i];
                maxElementIndex = new ArrayList<>();
                maxElementIndex.add(0, i);
            } else if (nums[i] == max) {
                maxCount++;
                maxElementIndex.add(maxCount - 1, i);
            }
        }
        if (k < maxElementIndex.size()) {
            /*int innerIndex = k;
            for (int i = 0; i < maxElementIndex.get(maxElementIndex.size() - k); i++){

                for (int j = nums.length; j >= maxElementIndex.get(innerIndex - 1); j--){
                    count++;
                }
                innerIndex++;
            }*/
            int sliderStartIndex = 0;
            int sliderEndIndex = k - 1;
            int sliderStart = maxElementIndex.get(sliderStartIndex);
            int sliderEnd = maxElementIndex.get(sliderEndIndex);
            for (int i = 0; i <= maxElementIndex.get(maxElementIndex.size() - k); i++){
                for (int j = nums.length; j >= sliderEnd; j--){
                    count++;
                }
                if (sliderEndIndex + 1 == maxElementIndex.size()) break;
                if (i == sliderStart){
                    sliderStart = maxElementIndex.get(++sliderStartIndex);
                    sliderEnd = maxElementIndex.get(++sliderEndIndex);
                }
            }
        }

        return count;
    }
}
