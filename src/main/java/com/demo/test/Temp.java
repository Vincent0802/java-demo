package com.demo.test;

import java.util.ArrayList;
import java.util.Iterator;

public class Temp {
	
	public static void main (String[] args){
        ArrayList<String> list = new Temp().Permutation("");
		Iterator iterator = list.iterator();  
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
    }
	
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> list = new ArrayList<String>();
		if(str.isEmpty()) {
			return list;
		}
       	char[] cs = str.toCharArray();
		int n = cs.length;
        boolean[] used = new boolean[n];
		char[] cache = new char[n];
		int result = n;
		out:
		while(true) {
			int index =  0;
			while(used[index]) {
				used[index] = false;
				++result;
				if(++index == n) {
					break out;
				}
			}
			used[index] = true;
			cache[--result] = cs[index];
			list.add(new String(cache).substring(result));
		}		
		return list;
	}
}