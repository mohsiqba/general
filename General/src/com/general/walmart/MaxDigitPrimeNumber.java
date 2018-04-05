package com.general.walmart;

import java.util.Arrays;

public class MaxDigitPrimeNumber {

	static void genPrimeNumbers(boolean prime[], int n)
	{
	    for (int p = 2; p * p  <= n; p++)
	    {
	        if (prime[p] == false)
	            for (int i = p*2; i <= n; i+=p)
	                prime[i] = true;
	    }
	}
	 
	static int maxDigitInPrimes(int L, int R)
	{
	    boolean prime[]=new boolean[R+1];
	    genPrimeNumbers(prime, R);
	    System.out.println(Arrays.toString(prime));
	    int freq[] = new int[10];
	    for (int i = L; i <= R; i++){
	        if (!prime[i])
	        {
	            int p = i; // If i is prime
	            while (p!=0)
	            {
	                freq[p%10]++;
	                p /= 10;
	            }
	        }
	    }
	 
	    // Finding digit with highest frequency.
	    int max = freq[0], ans = 0;
	    for (int j = 1; j < 10; j++)
	    {
	        if (max <= freq[j])
	        {
	            max = freq[j];
	            ans = j;
	        }
	    }
	 
	    System.out.println("ans:"+ans);
	    return ans;
	}
	
	public static void main(String[] args) {
		int L = 2, R = 9;
		maxDigitInPrimes(L, R);
	}
}
