package com.demo.data.sort;

import com.demo.data.array.ArrayDemo;

/**
 * @Description: 快速排序
 *
 * @author Cyrus
 *
 * @time: 2016年9月23日 下午3:06:05
 *
 */
// 思想：对于一组记录，通过一趟排序后，将原序列分为两部分，其中前一部分的所有记录均比后一部分的记录小
// ，然后依次对前后两部分的记录进行快排，递归该过程，直至所有记录有序
// 复杂度：O(n^2)
// 不稳定
// 步骤：
// 1.分解
// 2.递归求解
// 3.合并
public class QuickSort {

	public static void quickSort(int arr[]) {
		sort(arr, 0, arr.length - 1);
	}

	private static void sort(int arr[], int low, int high) {
		int i, j, key;
		if (low >= high) {
			return;
		}
		i = low;
		j = high;
		key = arr[i];
		while (i < j) {
			while (i < j && arr[j] >= key) {// 从j右向左找到小于key的记录
				j--;
			}
			if (i < j) {// 找到就交换，并且i向右走
				arr[i++] = arr[j];
			}
			while (i < j && arr[i] < key) {// 从i左向右找到大于key的记录
				i++;
			}
			if (i < j) {// 找到就交换，并且j向左走
				arr[j--] = arr[i];
			}
		}
		System.out.println(arr[i]);
		arr[i] = key;// 交换后将key赋值到最后交换完成的位置，以此种方式减少交换次数，此时i=j
		ArrayDemo.printArray(arr);
		// 以i为中间分界线递归
		sort(arr, low, i - 1);
		sort(arr, i + 1, high);
	}
}
