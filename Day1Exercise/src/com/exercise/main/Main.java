package com.exercise.main;

import java.util.List;

import com.cedarsoftware.util.GraphComparator;
import com.cedarsoftware.util.GraphComparator.Delta;

public class Main {

	public static void main(String[] args) {
		Group g1=new Group("child1", "parent1");
		Group g2=new Group("child1", "parent2");
		List<Delta> delta=GraphComparator.compare(g1, g2, null);
		System.out.println(delta);
	}
}
