package com.general.bankbazaar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Challenge { 
	/*
	 * Complete the functions below. You may declare more variables for this class.
	 * Please do NOT rename this class.
	 */

	public static void main(String[] args) {
		//maximumCupcakes(new String[] {"10 2 5","12 4 4","6 2 2","8 4 2","7 2 3"});
		
        int arr[] = {1, 2, 3, 4};
        int r = 2;
        System.out.println(findMaximum(arr, r));
	}

	static void maximumCupcakes(String[] trips) {
		Long n,c,m;
		for(String str:trips) {
			String[] trip=str.split(" ");
			n=Long.valueOf(trip[0]); //money
			c=Long.valueOf(trip[1]); //cupcakes
			m=Long.valueOf(trip[2]); //wrappers

			if (n < c) {
				System.out.println(0);
				return;
			}
			Long cupcakes = n / c;
			cupcakes = cupcakes + (cupcakes - 1) / (m - 1);
			System.out.println(cupcakes);
		}
	}
	
    static int findMaximum(int[] a, int m) {
    	int subSequence[]=new int[m];
        List<int[]> subList=new ArrayList<>();
    	findSubsequences(a, subSequence, 0, a.length-1, 0, m, subList);
    	return Integer.valueOf(findGlobalMaximum(subList));

    }
    
    static void findSubsequences(int a[], int subSequence[], int start,
            int end, int index, int m,List<int[]> subList)
    {
    	if (index == m)
    	{	
    		subList.add(Arrays.copyOf(subSequence, m));
    		return;
    	}

    	for (int i=start; i<=end && end-i+1 >= m-index; i++)
    	{
    		subSequence[index] = a[i];
    		findSubsequences(a, subSequence, i+1, end, index+1, m,subList);
    	}
}

	private static String findGlobalMaximum(List<int[]> subList) {
		Long globalMax=0L;
		for(int[] a:subList) {
			Long currentMinimum=1000000000000000000L;
			//find all x,y pairs in subSequence

			int subSequence[]=new int[2];
			List<int[]> list=new ArrayList<>();
			findSubsequences(a, subSequence, 0, a.length-1, 0, 2, list);
			
			for(int[] b:list) {
				int absDiff=Math.abs(b[0]-b[1]);
				if(absDiff<currentMinimum)
					currentMinimum=(long) absDiff;
			}
			if(currentMinimum>globalMax)
				globalMax=currentMinimum;
			
		}
		return globalMax.toString();
	}

}
