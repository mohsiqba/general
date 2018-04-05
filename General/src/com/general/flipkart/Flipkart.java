package com.general.flipkart;

import java.util.Arrays;

public class Flipkart {

	// Function to count the no of ways
	public static long countways(long a[], int n)
	{	
		long cnt[]=new long[a.length];
		long  s = 0;
		int y=0,z=0;
		System.out.println(Arrays.toString(cnt));
		// Calculating the sum of the array
		// and storing it in variable s
		for (int i = 0 ; i < n ; i++)
		{
			s += a[i];
		}
		
		long approx=s/3;
		
		for(int i=0,j=a.length-1;i<j;) {
			//calculate i and j
			for(int k=i;k<a.length;k++) {
				
			}
			checkAndValidate(a,i,j,s);
		}
		
		
	}

	private static int checkAndValidate(long[] a, int i, int j, long sum) {
		long sum1=0,sum2=0,sum3=0;	
		boolean flag=false;
		
		long newSum=sum-a[i]-a[j];
		if(newSum/3!=0)
			return 0;
		
		
		for(int r=0;r<i;r++) {
				sum1+=a[r];
		}
			
		for(int r=i+1;r<j;r++) {
			sum2+=a[r];
		}
		if(sum1==sum2) {
			for(int r=j+1;r<a.length;r++) {
				sum3+=a[r];
			}
			if(sum1==sum3)
				flag=true;
		}
		return flag?(i+j+2):0;
	}

	// Driver function
	public static void main(String[] args) 
	{
		int n = 11;
		long a[] = {1, 3, 5, 7, 3,5,1,6,5,3,1};
		System.out.println(countways(a, n));
	}

}
