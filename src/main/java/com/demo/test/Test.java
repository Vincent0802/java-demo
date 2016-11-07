package com.demo.test;

import java.io.Serializable;
import java.util.*;

/**
 * @Description 测试用例主函数入口
 *
 * @author Vincent
 *
 * @Time 2016年10月5日 上午9:45:58
 *
 */

class DataObject implements Serializable {
	private static int i = 0;
	private String word = " ";

	public void setWord(String word) {
		this.word = word;
	}

	public void setI(int i) {
		DataObject.i = i;
	}
	
	public void print() {
		System.out.println( "i = " + this.i + ", word = " + this.word);
	}
}

public class Test {

	private static void test(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			try {
				if (arr[i] % 2 == 0) {
					throw new NullPointerException();
				} else {
					System.out.print(i);
				}
			} finally {
				System.out.print("e");
			}
		}
	}

	public int solution(int[] A) {
		// write your code in Java SE 8
		int n = A.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int i = 0;
		int temp = 0;
		int max = 0;
		while (i < n && i >= 0) {
			temp = A[i];
			while (temp != A[i] || A[temp] != i) {
				i = temp;
				temp = A[i];
			}
			if (Math.abs(i - temp) > max)
				max = Math.abs(i - temp);
			i++;
		}
		return max;
	}

	public static void main(String[] args) {
		/*Test t = new Test();
		int[] A = { 2, 3, 1, 1, 3 };
		int a = t.solution(A);
		System.out.println("a = " + a);*/
		DataObject object = new DataObject();
		object.setWord("123");
		object.setI(2);
		object.print();
	}
}
