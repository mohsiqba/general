package com.exercise;
import java.util.Arrays;
import java.util.Scanner;

/*
This Java code is given for your convenience. Feel free to modify as required.
*/

class CutShort
{
	static Long i=0L,j=1L;
	public static Long solveProblem(Long l,Long sum,Long f) {
		if(l==0) return 0L;
		if(l==1) return 2L;
		if (l<=sum) return f;
		sum=i+j;
		i=j;
		j=sum;
		return solveProblem(l,sum,f+sum);
	}

//Sample code only. Feel free to change to accept the input described in the problem.

	public static void main (String[] args) throws java.lang.Exception
	{
		//Scanner in = new Scanner(System.in);
		/*Parse input here*/
        //Long l=in.nextLong();
        //Long f=solveProblem(l,0L,1L);
		//System.out.println("This is the output"+f);
		System.out.println(Class.forName("com.exercise.CutShort").getName());
		System.out.println((Class.forName("com.exercise.CutShort").newInstance().getClass()));
	}
}