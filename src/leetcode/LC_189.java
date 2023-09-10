package leetcode;

import java.io.IOException;

public class LC_189 {

    /**
     * 189. Rotate Array
     * Medium
     * 16.1K
     * 1.8K
     * Companies
     * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     * Example 2:
     *
     * Input: nums = [-1,-100,3,99], k = 2
     * Output: [3,99,-1,-100]
     * Explanation:
     * rotate 1 steps to the right: [99,-1,-100,3]
     * rotate 2 steps to the right: [3,99,-1,-100]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * -231 <= nums[i] <= 231 - 1
     * 0 <= k <= 105
     *
     *
     * Follow up:
     *
     * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
     * Could you do it in-place with O(1) extra space?
     */

    public void rotate(int[] nums, int k) {
        int N = nums.length;
        k = k%N;
        if(k!=0) {
            int[] newarr = new int[N+k];
            int index = k;
            for(int i=0; i<N; i++) {
                newarr[index] = nums[i];
                index++;
            }
            //newarr[0] = newarr[nums.length];
            int temp = N+k-1;
            for(int i=k-1; i>=0; i--) {
                newarr[i] = newarr[temp];
                temp--;
            }

            for(int i=0; i<N; i++) {
                nums[i] = newarr[i];
            }
        }

    }

    public static void main(String[] args) throws IOException {
        LC_189 main = new LC_189();

        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        //Output: [5,6,7,1,2,3,4]

        main.rotate(nums,k);
    }
}