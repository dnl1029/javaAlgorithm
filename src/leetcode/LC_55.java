package leetcode;

import java.io.IOException;

public class LC_55 {

    /**
     * You are given an integer array nums. You are initially positioned at the array's first index,
     * and each element in the array represents your maximum jump length at that position.
     *
     * Return true if you can reach the last index, or false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     *
     * Input: nums = [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
     * which makes it impossible to reach the last index.
     */

    public boolean canJump(int[] nums) {
        boolean res = false;

        int index = 0;

        if(nums.length==1) return true;

        for(int i=0; i<nums.length; i++) {
            if(nums[0]==0) break;
            if(i!=0 && index<i) break;
            if(index>=nums.length-1) {
                res = true;
                break;
            }
            index = Math.max(index,i+nums[i]);
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        LC_55 main = new LC_55();

        int[] nums = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        int[] nums3= {1,0,1,0};

        System.out.println(main.canJump(nums3));
    }
}