package com.general.walmart;

public class MaxNumberAtmostKSwaps {

	public static void main(String[] args) {
		max1("2519372893".toCharArray(), 6); //approach 2 -> need to validate
	}

	private static void max1(char[] str, int k) {
		String globalMax=new String(str);
		Integer loop=0,i=0;
			while(loop<k) {
			//find max in str
			int maxIdx=0;
			char max='0';
			for(int j=i;j<=(i+k-loop) ;j++) {
				if(max<str[j]) {
					max=str[j];
					maxIdx=j;
				}
			}
			//swap  maxidx with i
			swap(str, maxIdx, i);
			String newMax=new String(str);
			
			if(Long.parseLong(globalMax)<Long.parseLong(newMax))
				globalMax=newMax;
			
			loop+=maxIdx-i;
			i++;
		}
		System.out.println(new String(str));
	}
	
	private static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        while(i>j) {
        	ch[i]=ch[i-1];
        	i--;
        }
        ch[j]=temp;
	}

}