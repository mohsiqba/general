package com.exercise.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 	5
	1 2 3 4 5
	2
	1 3 2 -1
	1 5 2 -2
	2 3 2 -1
 */
public class Albums {
	public static void main(String[] args) throws Exception {
        List<Integer> out=new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String[] price=br.readLine().split(" ");
        Arrays.sort(price);
        int M=Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            out.add(find(price,br.readLine().split(" ")));
        }
        
        for (int output : out) {
			System.out.println(output);
		}
	}

	private static Integer find(String[] price,String[] split) {
		int count=0;
		int l=Integer.valueOf(split[0]);
		int r=Integer.valueOf(split[1]);
		int k=Integer.valueOf(split[2]);
		int idx=getClosestK(price,l);
		for (int i = idx; i < price.length; i++) {
			int pr=Integer.valueOf(price[i]);
			if(pr<=r && pr%k==0)
				count++;
		}
		return count;
	}

	private static int getNearestIndex(String[] price, int string) {
		int idx=-1;
		for (int i = price.length-1; i >=0; i--) {
			if (string>=Integer.valueOf(price[i]))
				return i;
		}
		return idx;
	}
	
	public static int getNearestIndex(String[] a, int x) {

	    int low = 0;
	    int high = a.length - 1;

	    if (high < 0)
	        throw new IllegalArgumentException("The array cannot be empty");

	    while (low < high) {
	        int mid = (low + high) / 2;
	        assert(mid < high);
	        int d1 = Math.abs(Integer.valueOf(a[mid  ]) - x);
	        int d2 = Math.abs(Integer.valueOf(a[mid+1]) - x);
	        if (d2 <= d1)
	        {
	            low = mid+1;
	        }
	        else
	        {
	            high = mid;
	        }
	    }
	    return high;
	}
}
