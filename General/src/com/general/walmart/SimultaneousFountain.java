package com.general.walmart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SimultaneousFountain {

	/**
	 * https://www.hackerearth.com/problem/algorithm/magnificent-fountains/
	 * https://www.hackerearth.com/submission/5298978/
	 * @param args
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t > 0)
		{
			int n = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			BigInteger[] arr = new BigInteger[n];
			for(int i=0; i<n; i++)
			{
				arr[i] = new BigInteger(str[i]);
			}
			BigInteger  lcm = BigInteger.ZERO;
			BigInteger a = arr[0];
			for(int i=1; i<n; i++)
			{
				BigInteger b = arr[i];
				BigInteger prod = a.multiply(b);
				BigInteger g = a.gcd(b);
				lcm = prod.divide(g);
				a = lcm;
			}
 
			System.out.println(lcm.mod(new BigInteger("1000000007")));		
			t--;
		}
	}
}
