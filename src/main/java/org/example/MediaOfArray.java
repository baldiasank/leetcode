package org.example;

public class MediaOfArray {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2,4};
        //System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        sort(nums1);
        sort(nums2);
        int num1Index = 0;
        int num2Index = 0;
        int[] result = new int[nums1.length + nums2.length];
        while (num1Index < nums1.length || num2Index < nums2.length) {
            if(num2Index == nums2.length){
                result[num1Index + num2Index] = nums1[num1Index];
                num1Index++;
                continue;
            } else if (num1Index == nums1.length){
                result[num1Index + num2Index] = nums2[num2Index];
                num2Index++;
                continue;
            }

            if (nums1[num1Index] < nums2[num2Index]) {
                result[num1Index + num2Index] = nums1[num1Index];
                num1Index++;
            } else {
                result[num1Index + num2Index] = nums2[num2Index];
                num2Index++;
            }
        }

        int centerIndex = result.length / 2;
        if (result.length % 2 == 0){
            return (double) (result[centerIndex] + result[centerIndex - 1]) / 2;
        } else {
            return result[centerIndex];
        }
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, result, 0, nums1.length);
        System.arraycopy(nums2, 0, result, nums1.length, nums2.length);
        sort(result);
        int centerIndex = result.length / 2;
        if (result.length % 2 == 0){
            return (double) (result[centerIndex] + result[centerIndex - 1]) / 2;
        } else {
            return result[centerIndex];
        }
    }

    private static void sort(int[] num) {
        for (int i=0; i < num.length; i++) {
            for(int j = i + 1; j < num.length; j++) {
                if (num[i] > num[j]) {
                    int sorted = num[j];
                    num[j] = num[i];
                    num[i] = sorted;
                }
            }
        }
    }
}
