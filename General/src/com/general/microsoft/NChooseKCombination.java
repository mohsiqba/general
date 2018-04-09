package com.general.microsoft;

public class NChooseKCombination {

	static long binomialCoeff(int n, int k)
    {
        long C[] = new long[k + 1];
        
        // nC0 is 1
        C[0] = 1;  
      
        for (int i = 1; i <= n; i++)
        {
            // Compute next row of pascal 
            // triangle using the previous row
            for (int j = Math.min(i, k); j > 0; j--)
                C[j] = C[j] + C[j-1];
        }
        return C[k];
    }
     
    /* Driver program  */
    public static void main(String[] args) 
    {
         int n = 100, k = 2;
            System.out.printf("Value of C(%d, %d) is %d "
                                , n, k, binomialCoeff(n, k));
    }

}
