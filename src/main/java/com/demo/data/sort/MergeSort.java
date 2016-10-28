package com.demo.data.sort;

/**
 * @Description: 归并排序
 *
 * @author Cyrus
 *
 * @time: 2016年9月23日 下午3:05:32
 *
 */
// 思想：对于给定的一个记录，首先将每两个相邻的长度为1的子序列进行合并，得到n/2（向上取整）个长度为2或1的有序子序列，再将其两两归并，反复执行
// 复杂度：O(nlogn)
// 关键步骤：
// 1：划分半字表
// 2：合并半子表
// 稳定
public class MergeSort {

	public static void mergeSort(int arr[], int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(arr, p, q);// 排序左半部分
			mergeSort(arr, q + 1, r);// 排序右半部份
			merge(arr, p, q, r);// 合并子表
		}
	}

	private static void merge(int arr[], int p, int q, int r) {
		int i, j, k, n1, n2;
		n1 = q - p + 1;
		n2 = r - q;
		int[] left = new int[n1];
		int[] right = new int[n2];
		for (i = 0, k = p; i < n1; i++, k++) {// 复制左半部分
			left[i] = arr[k];
		}
		for (i = 0, k = q + 1; i < n2; i++, k++) {// 复制右半部份
			right[i] = arr[k];
		}
		for (k = p, i = 0, j = 0; i < n1 && j < n2; k++) {
			if (left[i] > right[j]) {
				arr[k] = right[j];
				j++;
			} else {
				arr[k] = left[i];
				i++;
			}
		}
		if (i < n1) {
			for (j = i; j < n1; j++, k++) {// 左半部分还剩余
				arr[k] = left[j];
			}
		}
		if (j < n2) {
			for (i = j; i < n2; i++, k++) {// 右半部份还剩余
				arr[k] = right[i];
			}
		}
	}
}
