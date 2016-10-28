package com.demo.data.sort;

/**
 * @Description: 插入排序
 *
 * @author Cyrus
 *
 * @time: 2016年9月23日 下午3:04:38
 *
 */
// 思想：按照记录的大小依次将当前处理的记录插入到之前的有序序列中，直至最后一个序列插入到有序序列为止（类似两个指针）
// 复杂度：O(n^2)
// 稳定
public class InsertSort {

	/**
	 * 以此种方法实现减少交换次数
	 * 
	 * @param arr
	 *            要排序的数组
	 */
	public static void insertSort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i;
			if (arr[j - 1] > temp) {
				while (j >= 1 && arr[j - 1] > temp) {
					arr[j] = arr[j - 1];//小的数前移
					j--;
				}
			}
			arr[j] = temp;
		}
	}

}
