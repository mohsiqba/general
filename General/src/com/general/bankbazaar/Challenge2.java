package com.general.bankbazaar;

import java.util.HashMap;
import java.util.Map;

class Challenge2 { 
	/*
	 * Complete the functions below. You may declare more variables for this class.
	 * Please do NOT rename this class.
	 */

	public static void main(String[] args) {
        int arr[] = {1, 1,2,2,2, 3, 4};
       // System.out.println(countDuplicates(arr));
        //System.out.println(getUmbrellas(4, new int[] {2,4}));
        //System.out.println(getUmbrellas(1, new int[] {2}));
        
        //System.out.println(getUmbrellas(1000, new int[] {2,4}));
        //System.out.println(getUmbrellas(1, new int[] {2}));
        
        System.out.println(minCoins(10000, new int[] {2,4}));
        System.out.println(minCoins(1, new int[] {2}));
	}

	
    static int countDuplicates(int[] numbers) {
    	int nonUnique=0;
    	Map<Integer,Integer> map=null;
    	if(numbers!=null && numbers.length>0) {
    		map=new HashMap<>();
    		for(int num:numbers) {
    			if(map.containsKey(num)) {
    				if(map.get(num)==1)
    					nonUnique++;
    				map.put(num, map.get(num)+1);
    			}else
    				map.put(num, 1);
    		}
    	}
    	return nonUnique;
    }
    
    //uses backtracking
    static int getUmbrellas(int n, int[] p) {
    	if (n == 0) return 0;
    	int numOfUmbrella = Integer.MAX_VALUE;
    	for (int i=0; i<p.length; i++){
    		if (p[i] <= n){
    			int intermediateResult = getUmbrellas(n-p[i],p);
    			if (intermediateResult != Integer.MAX_VALUE && intermediateResult + 1 < numOfUmbrella)
    				numOfUmbrella = intermediateResult + 1;
    		}
    	}
    	return numOfUmbrella==Integer.MAX_VALUE?-1:numOfUmbrella;
    }
    
    //should have used DP
    static int minCoins( int V,int coins[])
    {
        // table[i] will be storing 
        // the minimum number of coins
        // required for i value. So 
        // table[V] will have result
        int table[] = new int[V + 1];
 
        // Base case (If given value V is 0)
        table[0] = 0;
 
        // Initialize all table values as Infinite
        for (int i = 1; i <= V; i++)
        table[i] = Integer.MAX_VALUE;
 
        // Compute minimum coins required for all
        // values from 1 to V
        for (int i = 1; i <= V; i++)
        {
            // Go through all coins smaller than i
            for (int j = 0; j < coins.length; j++)
            if (coins[j] <= i)
            {
                int sub_res = table[i - coins[j]];
                if (sub_res != Integer.MAX_VALUE 
                       && sub_res + 1 < table[i])
                       table[i] = sub_res + 1;
                        
                 
            }
             
        }
        return table[V]==Integer.MAX_VALUE?-1:table[V];
         
    }

}
