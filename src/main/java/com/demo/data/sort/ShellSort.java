package com.demo.data.sort;

/**
 * @Description: 希尔排序
 *
 * @author Cyrus
 *
 * @time: 2016年9月23日 下午3:06:27
 *
 */
// 思想：将序列分为多个子序列，是每个子序列的元素相对较少，然后对每个子序列进行直接插入排序，待每个子序列基本有序后，在对所有元素
// 进行直接插入排序
// 复杂度：O(n^s) 1<s<2 s为所选分组
// 不稳定
public class ShellSort {

	public static void shellSort(int arr[]) {
		int i, j, h, temp;
		for (h = arr.length / 2; h > 0; h = h / 2) {// 确定所选的分组2 1
			for (i = h; i < arr.length; i++) {// 从分割的位置开始操作
				temp = arr[i];
				for (j = i - h; j >= 0; j -= h) {// 向与后面的比较
					if (temp < arr[j]) {
						arr[j + h] = arr[j];// 相隔h个单位交换
					} else {
						break;// 最终都是两两相比，若不交换则没必要再循环下去
					}
				}
				arr[j + h] = temp;
			}
		}
	}
}
