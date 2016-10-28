package com.demo.data.array;

import com.demo.data.array.ArrayDemo;
import com.demo.data.sort.ShellSort;
import com.demo.data.utils.OutUtils;

/**
 * @Description: Array主函数入口
 *
 * @author Cyrus
 *
 * @time: 2016年9月23日 下午2:50:13
 *
 */
public class ArrayMainApp {

	public static void main(String[] args) {
		OutUtils.out();
		// int arr[] = { 3, 1, 5, 6, 0 };
		int arr[] = { 10, 12, 5, 11, 3 };
		System.out.println("排序前：");
		ArrayDemo.printArray(arr);

		// BubbleSort.arrayBubbleSort(arr);
		// HeapSort.heapSort(arr);
		// InsertSort.insertSort(arr);
		// MergeSort.mergeSort(arr, 0, arr.length - 1);
		// QuickSort.quickSort(arr);
		// SelectSort.selectSort(arr);
		ShellSort.shellSort(arr);
		System.out.println("排序后：");
		ArrayDemo.printArray(arr);
	}

}
