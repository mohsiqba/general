package com.test;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static List<Job> JOBS=new ArrayList<Job>();;
	static
	{	
		JOBS.add(new JobV1("mohsin1", 1, Bj11.class));
		JOBS.add(new JobV1("mohsin2", 0, Bj12.class));
		JOBS.add(new JobV2("iqbal1", 4, Bj21.class));
		JOBS.add(new JobV2("iqbal2", 8, Bj22.class));
	}
	public static void main(String[] args) {
		for (Job j:JOBS){
			if(j instanceof JobV1){
				System.out.println("1");
				if(((JobV1) j).isEnabled(31))
					System.out.println("1Enabled");
			}else if (j instanceof JobV2){
				System.out.println("2");
			}else System.out.println("3");
		}
		
	}
}
