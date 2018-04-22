package com.exercise;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestExceptionPropagation2{  
  void m() throws IOException{  
    throw new java.io.IOException("device error");//checked exception  
  }  
  void n()throws IOException{  
    m();  
  }  
  void p() throws IOException{  
   try{  
    n();  
   }catch(Exception e){System.out.println("exception handeled"+e.getMessage()); throw new FileNotFoundException("chained");}  
  }  
  public static void main(String args[]) throws Exception{  
   TestExceptionPropagation2 obj=new TestExceptionPropagation2();  
   try {
   obj.p();
   }catch (Exception e) {
	   System.out.println("Final");
}finally {
	System.out.println("mohsin");
	throw new Exception();
	
}
//   System.out.println("normal flow");  
  }  
}  