package com.exercise;

public class HashMapCustom<K,V> {
	private final Integer INITIAL_CAPACITY = 4;
	private Entry<K,V>[] table;
	private 
	
	static class Entry<K,V>{
		K key;
		V value;
		Entry<K,V> next;
		public Entry(K key,V value,Entry next) {
			this.key=key;
			this.value=value;
			this.next=next;
		}
	}
	
	public HashMapCustom(){
		table=new Entry[INITIAL_CAPACITY];
	}
	
	public void put(K key,V value) {
		if(key==null)
			return;
		Integer hash=hash(key);
		System.out.println("key:"+key+" |hash:"+hash);
		Entry<K, V> newEntry=new Entry<K, V>(key, value, null);
		if(table[hash]==null)
			table[hash]=newEntry;
		else {
			Entry<K, V> prev=null;
			Entry<K, V> cur=table[hash];
			while(cur!=null) {
				if(cur.key.equals(newEntry.key)) {
					if(prev==null) {
						newEntry.next=cur.next;
						table[hash]=newEntry;
						return;
					}else {
						prev.next=newEntry;
						newEntry.next=cur.next;
						return;
					}
				}
				prev=cur;
				cur=cur.next;
			}
			prev.next=newEntry;
			
		}
	}
	public V get(K key) {
		if(key==null)
			return null;
		Integer hash=hash(key);
		if(table[hash]==null)
			return null;
		else {
			Entry<K, V> cur=table[hash];
			while(cur!=null) {
				if(cur.key.equals(key))
					return cur.value;
				cur=cur.next;
			}
		}
		return null;
	}
	public Boolean remove(K key) {
		if(key==null)
			return Boolean.FALSE;
		Integer hash=hash(key);
		if(table[hash]==null)
			return Boolean.FALSE;
		else {
			Entry<K, V> prev=null;
			Entry<K, V> cur=table[hash];
			while(cur!=null) {
				if(cur.key.equals(key)) {
					if(prev==null) {
						table[hash]=cur.next;
						return Boolean.TRUE;
					}else {
						prev.next=cur.next;
						return Boolean.TRUE;
					}
				}
				prev=cur;
				cur=cur.next;
			}
			return Boolean.FALSE;
			
		}
	}
	public Integer hash(K key) {
		return Math.abs(key.hashCode())%INITIAL_CAPACITY;
	}
	@Override
	public String toString() {
		Entry<K,V> temp=null;
		StringBuilder sb =new StringBuilder("{") ;
		for(Integer i=0;i<table.length;i++) {
			temp=table[i];
			while(temp!=null) {
				sb.append("[").append(temp.key).append(",").append(temp.value).append("]").append(",");
				temp=temp.next;
			}
		}
		sb.append("}");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		HashMapCustom<String, Integer> map=new HashMapCustom<>();
		System.out.println("map1 :"+map);
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.put("D", 4);
		map.put("E", 5);
		map.put(null, 6);
		System.out.println("map2 :"+map);
		
		System.out.println("map.get(A) :"+map.get("A"));
		System.out.println("map.get(null) :"+map.get(null));
		System.out.println("map.get(F) :"+map.get("F"));
		
		System.out.println("map.remove(C) :"+map.remove("C"));
		System.out.println("map.get(F) :"+map.remove("F"));
		map.remove("A");
		map.remove("B");
		System.out.println("map3 :"+map);
	}
}
