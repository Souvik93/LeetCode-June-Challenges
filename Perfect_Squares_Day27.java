/*


Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

*/

class Solution {
    public int numSquares(int n) {
        
        int dp[] = new int[n+1];
        
        for(int i=1;i<dp.length;i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        
        return dp[n];
        
      /*  n = 4
            
            i = 1'
            
            1 - 1*1 = 0+1 = 1;
          2 = 2 - 1*1 = 1+1;
        3 = 3 -1*1 = 2 + 1 = 3
            
            i = 4
            
            j=1;
        
            4-1*1 = 2 = 2+1 = 3
                
            j*j<=4;
        
        j=2 ; 4-2*2 = 0 = 0+1 = 1 =mi(1,3) = 1*/
            
    
        
    }
}
