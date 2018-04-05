package com.general.flipkart;

class pdd{
	int x;int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	pdd(int x,int y){
		this.x=x;
		this.y=y;
	}
}
public class flipkart3 {

	// This pair is used to store the X and Y
	// coordinate of a point respectively

	// Function to find the line given two points
	static void lineFromPoints(pdd P, pdd Q)
	{
		double a = Q.y - P.y;
		double b = P.x - Q.x;
		double c = a*(P.x) + b*(P.y);

		System.out.println(a+"|"+b+"|"+c);
		if(c==0)
			System.out.println(1);
		else
			System.out.println(0);
	}

	static int constructIndex(String index){
		int value=0;
		for(int j=0;j<index.length();j++) {
			value*=26;
			value+=index.charAt(j)-'A'+1;
		}
		return value;
	}
	// Driver code
	public static void main(String[] args) {
		
		
		pdd P = new pdd(5000,constructIndex("EQXD"));
		pdd Q = new pdd(50, constructIndex("ALL"));
		lineFromPoints(P, Q);
		
		P = new pdd(1,constructIndex("A"));
		Q = new pdd(2, constructIndex("B"));
		lineFromPoints(P, Q);
		
		
		constructIndex("AA");
		constructIndex("AB");
		constructIndex("AC");
		constructIndex("BA");
		constructIndex("CA");
	}
}
