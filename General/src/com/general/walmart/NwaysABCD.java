package com.general.walmart;

import java.util.Arrays;

public class NwaysABCD {
	//recursive
	static int funcCountRecursive( int n, int m )
	{

	     if(n==m)
	        return 1;
	     if(n<m)
	        return 0;
	     if ( m == 1 )
	        return 1;
	     if ( m==2 )
	        return (funcCountRecursive(n-2,2) + funcCountRecursive(n - 1, 1));
	     if ( m==3 )
	        return (funcCountRecursive(n-3,3) + funcCountRecursive(n - 1, 2));

	     return (funcCountRecursive(n-1, 3) + funcCountRecursive(n - 4, 4));
	}

	//DP
	/**
	 * 	not working
	 * 	DP[n,1] = 1
	 *	DP[n,2] = DP[n-2, 2] + DP[n-1,1]
	 *	DP[n,3] = DP[n-3, 3] + DP[n-1,2]
	 *	DP[n,4] = DP[n-4, 4] + DP[n-1,3]
	 *	So Final DP equation is ==>
	 *	DP[n,k] = DP[n-k, k] + DP[n-1,k-1]
	 *if(k>n) then 0
		if k==0 then 0
		if(n==0) then 0
		for i=1 till n -> for j=1 till k -> update array[][]
		nk	0	1	2	3	4	5	6	7	8	9	10
		0	0	0	0	0	0	0	0	0	0	0	0
		1	0	1	0	0	0	0	0	0	0	0	0
		2	0	1	1	0	0	0	0	0	0	0	0
		3	0	1	1	1	0	0	0	0	0	0	0
		4	0	1	2	1	1	0	0	0	0	0	0
		5	0	1	2	2	1	1	0	0	0	0	0
		6	0	1	3	3	2	2	1	0	0	0	0
		7	0	1	3	4	3	3	3	1	0	0	0
		8	0	1	4	5	5	5	5	5	1	0	0
		9	0	1	4	7	6	6	6	6	6	1	0
		10	0	1	5	8	9	9	9	9	9	9	1
	 */
	static int funcCountDP(int n,int k) {
		if(n==0||k==0)
			return 0;
		int arr[][]=new int[n+1][n+1];
		for(int i=1;i<n;i++)
			arr[i][i]=1;
		for(int i=1;i<=n;i++) {
			System.out.println("i:"+i);
			for(int j=1;(j<=k && i>=j);j++) {
				System.out.print(" j:"+j);
				arr[i][j]=arr[i-j][j]+arr[i-1][j-1];
			}
		}
		for(int i=0;i<=n;i++)
			System.out.println("arr["+i+"]:"+Arrays.toString(arr[i]));
		return arr[n][k];
	}
	public static void main(String[] args) {
		for(int i=0;i<=10;i++) {
			for(int j=0;j<=10;j++) {
				//System.out.println("[n,k]:["+i+","+j+"]:"+funcCountRecursive(i, j));
			}
		}
		funcCountDP(8, 4);
	}
}
