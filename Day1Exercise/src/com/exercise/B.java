package com.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class B {
	public static void main(String[] args) {
		 A a=new A("Hello","World");
		 System.out.println(a.valueA+":"+a.valueA);
		 

		 int[] arr1= {8,1,3,1,4,5,6,3,2};
		 int[] arr= {6,1,1,2,2,2,3,1,1,1,2,2,2,2,2};
		 System.out.println(countDuplicates1(arr));
		 System.out.println(countDuplicates2(arr));
		 
		 System.out.println(countDuplicates1(arr1));
		 System.out.println(countDuplicates2(arr1));
	}
	
	static int countDuplicates1(int[] numbers){
		 int count=0;
		 boolean flag=true;
		Arrays.sort(numbers);
		 Set<Integer> set=new HashSet<>();
		 for(int i:numbers) {
			 //System.out.println(i+":"+count+":"+flag);
			 if(set.add(i)==false) {
				 if(flag)
					 count++;
				 //System.out.println("count:"+count);
				 flag=false;
			 }else {
				 flag=true;
			 }
		 }
		 System.out.println("count:"+count);
		 return count;
	}
	
	static int countDuplicates2(int[] numbers){
		Map<Integer,Integer> map=new HashMap<>();
		int count=0;
		for(int i:numbers) {
			if(map.containsKey(i)) {
				if(map.get(i).equals(1)) {
					count++;
					map.put(i, 2);
				}
			}else {
				map.put(i, 1);
			}
		}
		return count;	
	}
}
