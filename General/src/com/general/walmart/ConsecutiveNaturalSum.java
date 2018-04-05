package com.general.walmart;

public class ConsecutiveNaturalSum {
	
	/**
	 * ref:https://www.geeksforgeeks.org/print-possible-sums-consecutive-numbers-sum-n/
	 * O(n)
	 * @param N
	 */
	static void printConsecutiveNaturalSum(int N)
	{
	    int startIndex = 1, endIndex = 1;
	    int sum = 1;
	    int noOfWays=0;
	    while (startIndex <= N/2)
	    {
	        if (sum < N)
	        {
	            endIndex += 1;
	            sum += endIndex;
	        }
	        else if (sum > N)
	        {
	            sum -= startIndex;
	            startIndex += 1;
	        }
	        else if (sum == N)
	        {	
	        	noOfWays++;
	            for (int i = startIndex; i <= endIndex; ++i)
	                System.out.print(" "+i);
	 
	            System.out.println();
	            sum -= startIndex;
	            startIndex += 1;
	        }
	    }
	    System.out.println("noOfWays:"+noOfWays);
	}
	public static void main(String[] args) {
		printConsecutiveNaturalSum(15);
	}
}
