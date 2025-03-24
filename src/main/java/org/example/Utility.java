package org.example;

public class Utility {
    public static void printArrayValues(int[] nums){
        System.out.print("[");
        for (int num : nums){
            System.out.print(num+",");
        }
        System.out.println("]");
    }
}
