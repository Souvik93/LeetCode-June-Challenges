/*

Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

 

Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
   Hide Hint #1  
The entire logic for reversing a string is based on using the opposite directional two-pointer approach!
Java

*/

class Solution {
    public void reverseString(char[] s) {
        int j = s.length-1;
        for(int i=0;i<s.length;i++) {
            if(i<j) {
            if(s[i]!=s[j]) {
                swap(i,j,s);
            }
            j--;
        } else {
                 break;
            }
           
        }
        
    }
    
    public void swap(int a, int b,char[] sx) {
        char tempChar = sx[a];
        sx[a]=sx[b];
        sx[b]=tempChar;
    }
}
