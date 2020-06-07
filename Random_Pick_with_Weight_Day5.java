/*

Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.

*/

/* Solution In Java */
class Solution {
    
    private int wa[];
    private int sum;

    public Solution(int[] w) {
        
        sum = 0;
        wa = new int[w.length];
        for(int i=0;i<w.length;++i) {
            sum = w[i]+sum;
            wa[i]=sum;
        }
        
    }
    
    public int pickIndex() {
        int rand = (int) (Math.random()*sum);
        return binarySearch(rand+1);
    }
    
    private int binarySearch(int num) {
        int l = 0;
        int r=wa.length-1;
        while(l<r) {
            int mid =l+(r-l)/2;
            if(wa[mid]<num) {
                l=mid+1;
            } else {
                r= mid;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
