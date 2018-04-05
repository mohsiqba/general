package com.general.walmart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompatibilityDifference {

	 private static Integer findCompatibilityDifference(Integer kohli[], Integer dhoni[], Integer n)
	    {
	        Integer res = 0;
	      
	        for (Integer i = 0; i < n; i++) {
	            if (kohli[i] != dhoni[i]) {
	                Integer j = i + 1;
	                while (kohli[i] != dhoni[j]) 
	                    j++;
	                while (j != i) {
	                    Integer temp = dhoni[j - 1];
	                    dhoni[j - 1] = dhoni[j];
	                    dhoni[j] = temp;
	                    j--;
	                    res++;
	                }
	                //System.out.println("after a2:"+Arrays.toString(a2));
	            }/*else {
	            	System.out.println("elements are same:"+a1[i]);
	            }*/
	        }
	        return res;
	    }
	      
	 
	 
	 
	    // Driver code
	    public static void main(String args[]) throws IOException
	    {
	        Integer a1[] = { 3, 1, 2, 4, 5 };
	        Integer a2[] = { 3, 2, 4, 1, 5 };
	        Integer n = a1.length;
	         
	        System.out.println(findCompatibilityDifference(a1, a2, n));
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        Integer numOfMovies = Integer.parseInt(br.readLine());
	        Integer[] kohli=new Integer[numOfMovies];
	        
	        Integer i=0;
	        for(String str:br.readLine().split(" ")) {
	        	kohli[i++]=Integer.parseInt(str);
	        }
	        i=0;
	        Integer[] dhoni=new Integer[numOfMovies];
	        for(String str:br.readLine().split(" ")) {
	        	dhoni[i++]=Integer.parseInt(str);
	        }
	        System.out.println(findCompatibilityDifference(kohli, dhoni, numOfMovies));
	    }

}
