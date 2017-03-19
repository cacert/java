package com.hackerrank;

import java.util.LinkedList;
import java.util.List;

public class MyHashTable {
	private Myentry[] arr = new Myentry[100];
	private MyList[] list = new MyList[100]; 
	
	public static void main(String[] args) {
		MyHashTable table = new MyHashTable();
		table.put("kasim", "Sert");
		table.put("Eren", "Eren");
		table.put("Merve","Merve");
		System.err.println(table.get("kasim"));
		System.err.println(table.get("Merve"));
		System.err.println(table.get("Eren"));
		System.err.println(table.get("Ayse"));
		
	}
	
	public void put(String key, String value){
		int hash = getHash(key);
		if (list[hash]==null){
			list[hash] = new MyList();
		}
		list[hash].list.add(new Myentry(key, value));
	}
	public String get(String key){
		return list[getHash(key)] == null ? null : list[getHash(key)].list.get(0).value;
	}
	private int getHash(String key){
		return key.hashCode()%100;
	}
	
	class Myentry{
		String key; String value;
		public Myentry(String key, String value) {
			this.key=key;
			this.value=value;
		}
	}
	class MyList {
		List<Myentry> list = new LinkedList<>();
	}
}
