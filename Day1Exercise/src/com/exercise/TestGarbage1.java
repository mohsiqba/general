package com.exercise;
class D{}
public class TestGarbage1{
	private D d;
 public void finalize(){System.out.println("object is garbage collected");} 
 
 void start() {
	 System.out.println("1");
	 d=new D();
	 System.out.println("2");
	 this.take(d);
	 System.out.println("4");
 }
 void take(D d) {
	 d=null;
	 System.gc();
	 System.out.println("3");
	 d=new D();
	 System.out.println("3.1");
 }
 public static void main(String args[]){  
  TestGarbage1 s1=new TestGarbage1();  
  s1.start();
  System.out.println("5");
  s1=null;
  System.gc();  
 }  
}  