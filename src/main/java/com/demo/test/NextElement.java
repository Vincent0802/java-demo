package com.demo.test;

import java.util.HashMap;
import java.util.Map;

import com.demo.data.utils.OutUtils;

public class NextElement {

	@SuppressWarnings("unused")
	public int[] findNext(int[] A, int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int secMax;
		int[] tmp;
		int[] a = new int[n];
		boolean flag;
		for (int i = 0; i < A.length; i++) {//{ 11, 13, 10, 5, 12, 21, 3 }
			int k = 0;
			tmp = new int[n];
			flag = true;
			secMax = 0;
			for (int j = i + 1; j < A.length; j++) {
				if (flag && A[j] > A[i]) {
//					tmp[k++] = A[j];
					secMax = A[j];
					flag = false;
					continue;
				} else if(A[j] > A[i] && A[j] < secMax){
					secMax = A[j];
				}
			}
//			OutUtils.print("secMax = " + secMax);
			if (secMax == 0) {
				a[i] = -1;
			} else {
				/*secMax = tmp[0];
				for (int j = 1; j < k; j++) {
					if (tmp[j] < secMax) {
						secMax = tmp[j];
					}
				}*/
				a[i] = secMax;
			}
		}
		return a;
	}

	public static void main(String[] args) {
		NextElement t = new NextElement();
		int a[] = new int[] { 11, 13, 10, 5, 12, 21, 3 };
		int n = 7;
		int b[] = t.findNext(a, n);
		OutUtils.print(b);
	}
}
