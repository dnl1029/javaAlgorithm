package leetcode;

import java.io.IOException;
import java.util.HashMap;

public class LC_169 {

    /**
     * 169. Majority Element
     * Easy
     * 16.8K
     * 487
     * Companies
     * Given an array nums of size n, return the majority element.
     *
     * The majority element is the element that appears more than ⌊n / 2⌋ times.
     * You may assume that the majority element always exists in the array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,2,3]
     * Output: 3
     * Example 2:
     *
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     *
     *
     * Constraints:
     *
     * n == nums.length
     * 1 <= n <= 5 * 104
     * -109 <= nums[i] <= 109
     *
     *
     * Follow-up: Could you solve the problem in linear time and in O(1) space?
     */

    public int majorityElement(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>=(nums.length/2)+1) {
                count = nums[i];
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        LC_169 main = new LC_169();

        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(main.majorityElement(nums));
    }
}