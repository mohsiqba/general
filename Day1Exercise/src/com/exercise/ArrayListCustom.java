package com.exercise;

import java.util.Arrays;

public class ArrayListCustom<E> {
	private final Integer INITIAL_CAPACITY=10;
	private Integer ITERATION=1;
	private Double LOAD_FACTOR= 0.75;
	private Object[] data;
	private Integer size=0;
	
	public ArrayListCustom() {
		data =new Object[INITIAL_CAPACITY];
	}
	
	public void add(E value) {
		if(ITERATION*INITIAL_CAPACITY*LOAD_FACTOR>=size) {
			ITERATION*=2;
			ensureCapacity();
		}
		data[size++]=value;
	}
	public E get(Integer index) {
		if(index<0 || index>=size) {
			throw new ArrayIndexOutOfBoundsException("index:"+index+" size :"+size);
		}
		return (E)data[index];
	}
	public E remove(Integer index) {
		if(index<0 || index>=size) {
			throw new ArrayIndexOutOfBoundsException("index:"+index+" size :"+size);
		}
		Object val=data[index];
		for(Integer i=index;i<size-1;i++)
			data[i]=data[i+1];
		size--;
		return (E)val;
	}
	private void ensureCapacity() {
		Integer new_capacity=data.length*2;
		data=Arrays.copyOf(data, new_capacity);
	}
	@Override
	public String toString() {
		StringBuilder sb =new StringBuilder("[") ;
		for(Integer i=0;i<size-1;i++) {
			sb.append(data[i]).append(",");
		}
		sb.append(data[size-1]).append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ArrayListCustom<String> list=new ArrayListCustom<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		System.out.println("list :"+list);
		System.out.println("0:"+list.get(0));
		System.out.println("removed 0:"+list.remove(0));
		list.remove(0);
		System.out.println("list2 :"+list);
		list.get(5);
	}
}
