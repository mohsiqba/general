package com.test;
public class PassByReference {

    public static Integer inc() {
    	Integer i=0;
        i = i+1;    // I think that this must be **sneakally** creating a new integer...  
        System.out.println("Inc: "+i);
        return i;
    }

    public static void main(String[] args) {
        Integer integer = 0;
        for (int i =0; i<10; i++){
            integer=inc();
            System.out.println("main: "+integer);
        }
    }
}