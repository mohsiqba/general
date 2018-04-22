package com.exercise.main;
import java.lang.reflect.Field;

public class ClassFieldTest {

	public static void main(String args[]) throws Exception {
		Group g1=new Group("child1", "parent2");
		Group g2=new Group("child1", "parent4");
		Class ftClass = g1.getClass();

		Field[] fields=ftClass.getDeclaredFields();
		for(Field field:fields){
			System.out.println("field:"+field.getDeclaringClass()+" | "+field.getType()+" | "+field.getName());
			System.out.println("1:"+field.get(g1).equals(field.get(g2)));
			System.out.println("2:"+field.get(g2));
		}
		Field f1 = ftClass.getDeclaredField("parentGrp");
		System.out.println(f1);
		f1.set(g1, "this is public");
		String str1 = (String) f1.get(g1);
		System.out.println("pub field: " + str1);

		Field f2 = ftClass.getDeclaredField("parentGrp");
		f2.set(g1, "this is protected");
		String str2 = (String) f2.get(g1);
		System.out.println("\npro field: " + str2);

		try {
			System.out.println("\nThis will throw a NoSuchFieldException");
			Field f3 = ftClass.getDeclaredField("parentPub");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}