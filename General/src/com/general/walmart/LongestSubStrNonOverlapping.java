package com.general.walmart;

public class LongestSubStrNonOverlapping {

	/**
	 * ref : https://www.geeksforgeeks.org/longest-repeating-and-non-overlapping-substring/
	 * DP: O(n^2)
	 * @param str
	 * @return
	 */
	public static String longestRepeatedSubString(String str)
	{
	    int n = str.length();
	    int dpArr[][]=new int[n+1][n+1];
	 
	    String outputStr=""; 
	    int outputLength  = 0;
	 
	    int i, index = 0;
	    for (i=1; i<=n; i++)
	    {
	        for (int j=i+1; j<=n; j++)
	        {
	            if (str.charAt(i-1) == str.charAt(j-1) &&  dpArr[i-1][j-1] < (j - i)){
	                dpArr[i][j] = dpArr[i-1][j-1] + 1;
	                if (dpArr[i][j] > outputLength){
	                    outputLength = dpArr[i][j];
	                    index = Math.max(i, index);
	                }
	            }
	            else
	                dpArr[i][j] = 0;
	        }
	    }
	    System.out.println("res_length:"+outputLength);
	    if (outputLength > 0)
	        for (i = index - outputLength + 1; i <= index; i++)
	            outputStr+=(str.charAt(i-1));
	 
	    System.out.println("res:"+outputStr);
	    return outputStr;
	}
	
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		longestRepeatedSubString(str);
	}
}
