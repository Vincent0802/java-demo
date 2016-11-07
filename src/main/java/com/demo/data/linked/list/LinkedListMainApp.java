package com.demo.data.linked.list;

import com.demo.data.linked.list.LinkedListDemo;
import com.demo.data.linked.list.Node;

/**
 * @Description: LinkedList主函数入口
 *
 * @author Cyrus
 *
 * @time: 2016年9月23日 下午2:50:13
 *
 */
public class LinkedListMainApp {

	public static void main(String[] args) {
		Node head = null;
		int arr[] = { 3, 5, 6, 1, 0 };
		for (int i = 0; i < 5; i++) {
			head = LinkedListDemo.addNode(head, arr[i]);
		}
		LinkedListDemo.printList(head);
//		System.out.println("操作前：");
//		LinkedListDemo.printReversely(head);

		// demo.deleteNode(head, 2);
		// demo.insert(head, 100, 4);
		Node newHead = LinkedListDemo.findMiddle(head);
		System.out.println("操作后：");
		System.out.println(newHead.data);
//		LinkedListDemo.printList(newHead);
	}

}
