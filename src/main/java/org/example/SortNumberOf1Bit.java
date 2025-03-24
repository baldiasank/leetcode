package org.example;


import java.util.*;

//Sort Integers by The Number of 1 Bits
public class SortNumberOf1Bit {
    public static void main(String[] args) {
        Utility.printArrayValues(new SortNumberOf1Bit().sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}));
        Utility.printArrayValues(new SortNumberOf1Bit().sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1}));
        Utility.printArrayValues(new SortNumberOf1Bit().sortByBits(new int[]{2,3,5,7,11,13,17,19}));
    }

    public int[] sortByBitsMySolution(int[] arr) {
        Map<Integer, Boolean> bitsMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                boolean n1 = computeIfNumberHas1Bit(arr[i], bitsMap);
                for (int j = i; j < arr.length; j++) {
                    boolean n2 = computeIfNumberHas1Bit(arr[j], bitsMap);
                    if (n1 && n2 && arr[i] > arr[j] ||
                            n2 && !n1 ||
                            arr[i] > arr[j]) {
                        n1 = computeIfNumberHas1Bit(arr[j], bitsMap);
                        int tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }
        }
        return arr;
    }

    public Boolean computeIfNumberHas1Bit(int num, Map<Integer, Boolean> map) {
        return map.computeIfAbsent(num, value -> {
            long bits = intToBinary(num);
            return bits == 1;
        });
    }

    public long intToBinary(int num) {
        long bits = 0;
        while (num > 0) {
            bits = (bits * 10) + (num % 2);
            num = num / 2;
        }
        return bits;
    }

    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Comparator<Integer> comparator = new CustomComparator();
        Arrays.sort(nums, comparator);
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }

}

class CustomComparator implements Comparator<Integer> {
    private int findWeight(int num) {
        int mask = 1;
        int weight = 0;

        while (num > 0) {
            if ((num & mask) > 0) {
                weight++;
                num ^= mask;
            }

            mask <<= 1;
        }

        return weight;
    }

    @Override
    public int compare(Integer a, Integer b) {
        if (findWeight(a) == findWeight(b)) {
            return a - b;
        }

        return findWeight(a) - findWeight(b);
    }
}
