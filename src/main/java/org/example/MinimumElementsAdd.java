package org.example;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/*Minimum Elements to Add to Form a Given Sum
You are given an integer array nums and two integers limit and goal. The array nums has an interesting property that abs(nums[i]) <= limit.
Return the minimum number of elements you need to add to make the sum of the array equal to goal. The array must maintain its property that abs(nums[i]) <= limit.

Note that abs(x) equals x if x >= 0, and -x otherwise.

Example 1:

Input: nums = [1,-1,1], limit = 3, goal = -4
Output: 2
Explanation: You can add -2 and -3, then the sum of the array will be 1 - 1 + 1 - 2 - 3 = -4.
Example 2:

Input: nums = [1,-10,9,1], limit = 100, goal = 0
Output: 1
 */
public class MinimumElementsAdd {

    public static void main(String[] args) {
        long millis = System.currentTimeMillis() % 1000;

        System.out.println(new MinimumElementsAdd().minElements(new int[]{1, -1, 1}, 3, -4));
        System.out.println(new MinimumElementsAdd().minElements(new int[]{1, -10, 9, 1}, 100, 0));
        System.out.println(new MinimumElementsAdd().minElements(new int[]{2, 2, 2, 5, 1, -2}, 5, 126614243));
        System.out.println(new MinimumElementsAdd().minElements(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 3, 1000000000));
        int[] in = new int[100000];
        for (int i = 0; i < 100000; i++) {
            in[i] = 1000000;
        }
        System.out.println(new MinimumElementsAdd().minElements(in, 1000000, -1000000000));
        //101000
        System.out.println(System.currentTimeMillis() % 1000 - millis);
    }

    // My Solution
    public int minElements1(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long req = Math.abs(goal - sum);
        int count = 0;
        if (req > 0) {
            count += req / limit;
            if (req % limit == 0) req = 0;
            else req -= ((long) count * limit);
        }
        if (req > 0 && req < limit) return ++count;
        return count;
    }

    //Accepted Solution
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long req = Math.abs(goal - sum);
        return (int)(req / limit) + ((req % limit) == 0 ? 0 : 1);
    }


}
