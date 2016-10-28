package com.demo.data.sort;

/**
 * @Description: 选择排序
 *
 * @author Cyrus
 *
 * @time: 2016年9月23日 下午2:59:31
 *
 */
// 思想：从第一个记录开始，进行一轮比较后，得到最小记录，然后将其与第一个记录交换，对不包括第一个记录的剩余记录进行比较，直至所有记录有序
// 复杂度：O(n^2)
// 不稳定
public class SelectSort {

	public static void selectSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];//记录最小的数
			int flag = i;//记录最小的数的位置
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < temp) {
					temp = arr[j];// 找出最小值
					flag = j;// 记录最小值位置
				}
			}
			if (flag != i) {// 交换数据
				arr[flag] = arr[i];
				arr[i] = temp;
			}
		}
	}
}
