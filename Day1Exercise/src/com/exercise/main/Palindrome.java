package com.exercise.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		List<Integer> count = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for (int i = 0; i < N; i++) {
        	count.add(computePalindrome(s.nextInt(),s.nextInt()));
        }
        s.close();
        for (Integer integer : count) {
        	System.out.println(integer);
		}
        
        
	}

	private static Integer computePalindrome(int low, int high) {
		int count=0;
		if(isPalindrome(String.valueOf(low)))
			count++;
		if(isPalindrome(String.valueOf(high)))
			count++;
		int [] l = convertToArray(low);
		int [] h = convertToArray(high);
		while(low<high){
			int num= low/10+Integer.valueOf(String.valueOf(low).charAt(0));
			
			
			
				
		}
		
		
		return count;
	}
	
	private static int[] convertToArray(int temp){
		int []i = new int[]{0,0,0,0};
		int j=3;
		do{
		    i[j--]=(temp % 10);
		    temp /= 10;
		} while  (temp > 0);
		return i;
	}
	private static boolean isPalindrome(String num){
		for (int i = 0,j=3; i < 2 && j>1; i++,j--) {
			if(num.charAt(i)!=num.charAt(j))
				return false;
		}
		return true;
		
	}
}
