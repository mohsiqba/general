package com.general.mmt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * merge arrays
 * @author MohsinIqbal
 *
 */
public class MergeArrays {

	public static void main(String args[] ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		String[] arrA=(br.readLine()).split(" ");

		line = br.readLine();
		int M = Integer.parseInt(line);
		String[] arrB=(br.readLine()).split(" ");

		String[] arrC=new String[N+M];
		merge(arrA, arrB, N, M, arrC);

		System.out.println(Arrays.toString(arrC));
	}
	
	
	public static void merge(String[] arrA, String[] arrB, int N,int M, String[] arrC){
		int i = 0, j = 0, k = 0;
		while (i<N && j <M)
		{
			if (Integer.parseInt(arrA[i]) < Integer.parseInt(arrB[j]))
				arrC[k++] = arrA[i++];
			else
				arrC[k++] = arrB[j++];
		}

		while (i < N)
			arrC[k++] = arrA[i++];

		while (j < M)
			arrC[k++] = arrB[j++];
	}

}
