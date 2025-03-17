package org.example;

public class MaximumXOR {

    int xorWithOutOperator(int x, int y, int maxBits) {

        // Initialize result
        int res = 0;

        // Assuming 32-bit Integer
        for (int i = maxBits; i >= 0; i--) {

            // Find current bits in x and y
            int b1 = ((x & (1 << i)) == 0) ? 0 : 1;
            int b2 = ((y & (1 << i)) == 0) ? 0 : 1;

            // If both are 1 then 0 else xor is same as OR
            int xoredBit = ((b1 & b2) != 0) ? 0 : (b1 | b2);

            // Update result
            res <<= 1;
            res |= xoredBit;
        }
        return res;
    }

    //k<2 power of maxBits
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int maxK = (int) Math.pow(2, maximumBit);
        int max = 0;
        int[] result = new int[nums.length];
        for (int n = nums.length; n > 0; n--) {
            int xor = nums[0];
            for (int i = 1; i < n; i++) {
                xor = xor ^ nums[i];
                if (max < nums[i]) max = nums[i];
            }
            for (int i = 0; i < maxK; i++) {
                if ((xor ^ i) == max) result[nums.length - n] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] xors = new MaximumXOR().getMaximumXor(new int[]{0, 1, 1, 3}, 2);
        for (int xor : xors) {
            System.out.println(xor);
        }
        xors = new MaximumXOR().getMaximumXor(new int[]{2, 3, 4, 7}, 3);
        for (int xor : xors) {
            System.out.println(xor);
        }
        xors = new MaximumXOR().getMaximumXor(new int[]{0}, 1);
        for (int xor : xors) {
            System.out.println(xor);
        }

    }
}
