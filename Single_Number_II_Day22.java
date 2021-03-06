/*

Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99

*/

class Solution {
    public int singleNumber(int[] nums) {
        
        int p =0 ;
        int q= 0;
        int r;
        for(int num : nums) {
            r = num;
            p = q & (p^r);
            q = p | (q^r);
        }
         return q;
        
    }
}

