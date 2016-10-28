package com.demo.data.sort;

import com.demo.data.array.ArrayDemo;

/**
 * @Description: 堆排序
 *
 * @author Cyrus
 *
 * @time: 2016年9月23日 下午3:07:19
 *
 */
// 思想：将数组A创建为一个最大堆，然后交换堆的根(最大元素)和最后一个叶节点x，将x从堆中去掉形成新的堆A1，然后重复以上动作，直到堆中只有一个节点。
// 复杂度：O(nlogn)
// 不稳定
public class HeapSort {

	public static void heapSort(int[] arr) {
		int i;
		int n = arr.length;
		for (i = n / 2 - 1; i >= 0; i--) {
			adjustMaxHeap(arr, i, n - 1);// 初始化堆
			System.out.println("初始化交换：");
			ArrayDemo.printArray(arr);
		}
		for (i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			adjustMaxHeap(arr, 0, i - 1);// 调整堆
			System.out.println("交换：");
			ArrayDemo.printArray(arr);
		}
	}

	@SuppressWarnings("unused")
	private static void adjustMinHeap(int[] arr, int pos, int len) {
		int child;
		int temp;
		for (temp = arr[pos]; 2 * pos + 1 <= len; pos = child) {
			child = 2 * pos + 1;
			if (child < len && arr[child] > arr[child + 1]) {
				child++;
			}
			if (arr[child] < temp) {
				arr[pos] = arr[child];
			} else {
				break;
			}
		}
		arr[pos] = temp;
	}

	private static void adjustMaxHeap(int[] arr, int pos, int len) {
		int child;
		int temp;
		for (temp = arr[pos]; 2 * pos + 1 <= len; pos = child) {
			child = 2 * pos + 1;
			if (child < len && arr[child] < arr[child + 1]) {
				child++;
			}
			if (arr[child] > temp) {//始终将目标结点与子节点比较。如果比最大子节点小，交换
				arr[pos] = arr[child];
			} else {//如果父节点比最大子节点大，说明不必做操作
				break;
			}
		}
		arr[pos] = temp;//最后将目标结点放在最后交换的子节点位置，此时的pos=child
	}

}
