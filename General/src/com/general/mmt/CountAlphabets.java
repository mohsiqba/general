package com.general.mmt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * count alphabets
 * @author MohsinIqbal
 *
 */
public class CountAlphabets {

	public static void main(String args[] ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		int[] result=countAlphabets(line);

		for(int num:result)
			System.out.print(num+" ");
	}
	
	
	private static int[] countAlphabets(String line) {
			int[] result=new int[26];
			for(int i=0;i<26;i++)
				result[i]=0;
			
			for(char c:line.toCharArray()) {
				if((c>=65 && c<=90 )|| (c>=97 && c<=122) && (Character.toUpperCase(c)==c ||Character.toLowerCase(c)==c))
					result[Character.toUpperCase(c)%65]+=1;
					
			}
			
			return result;
	}


	

}
