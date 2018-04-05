package com.general.mmt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 * print integer
 * @author MohsinIqbal
 *
 */
public class PrintNumbers {

	public static void main(String args[] ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		List<String> result=countNumbers(line);

		for(String str:result)
			System.out.println(str);
	}
	
	
	private static List<String> countNumbers(String line) {
		List<String> result= new ArrayList<>();
		String temp="";
		Boolean flag=false;
			for(char c:line.toCharArray()) {
				if(c>=48 && c<=57) {
					flag=true;
					temp+=c;
				}else
					flag=false;
				if(!flag && temp!="") {
					result.add(temp);
					temp="";
				}
			}
			if(temp!="")
				result.add(temp);
			return result;
	}


	

}
