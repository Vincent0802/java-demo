package com.demo.data.sort;

import com.demo.data.array.ArrayDemo;
import com.demo.data.linked.list.LinkedListDemo;
import com.demo.data.linked.list.Node;

/**
 * @Description: 冒泡排序
 * 
 * @author Cyrus
 *
 * @time: 2016年9月23日 下午3:05:03
 *
 */
// 思想：从第一个记录开始，依次对相邻两个记录进行比较，若前记录大于后记录，交换位置。进行一轮比较和换位后，
// n个记录最大的将位于第n位，然后对（n-1）个记录进行比较只剩下一个为止.(最大的会一直向后走，
// 所以每比较完一次就减少1个比较个数)
// 复杂度：O(n^2)
// 稳定
public class BubbleSort {

	public static Node bubbleSort(Node head) {
		int a = 1;
		for (int i = 0; i < LinkedListDemo.length(head); i++) {
			for (Node nextNode = head; nextNode.next != null; nextNode = nextNode.next) {
				if (nextNode.data > nextNode.next.data) {
					int temp = nextNode.data;
					nextNode.data = nextNode.next.data;
					nextNode.next.data = temp;
					System.out.println("第" + a + "交换：");
					LinkedListDemo.printList(head);
					a++;
				}

			}
		}
		return head;
	}

	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		int a = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					System.out.println("第" + a + "交换：");
					ArrayDemo.printArray(arr);
					a++;
				}
			}
		}
	}

}
