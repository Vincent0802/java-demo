package com.demo.data.queue;

import com.demo.data.utils.OutUtils;

/**
 * @Description: 链表实现队列
 *
 * @author Vincent
 *
 * @time: 2016年9月28日 上午10:52:21
 *
 */

class Node<E> {

	Node<E> next = null;

	E data;

	public Node(E data) {
		this.data = data;
	}

}

public class QueueByLinkedList<E> {

	private Node<E> head = null;

	private Node<E> tail = null;

	public boolean isEmpty() {
		return head == tail;
	}

	public void put(E data) {
		Node<E> newNode = new Node<E>(data);
		if (head == null && tail == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;// head不动，tail后移
		}
	}

	public E pop() {
		if (this.isEmpty()) {
			return null;
		}
		E data = head.data;
		head = head.next;
		return data;
	}

	public int size() {
		Node<E> tmp = head;
		int n = 0;
		while (tmp != null) {
			n++;
			tmp = tmp.next;
		}
		return n;
	}

	public static void main(String[] args) {
		QueueByLinkedList<Integer> queue = new QueueByLinkedList<Integer>();
		queue.put(1);
		queue.put(2);
		queue.put(3);
		OutUtils.print("size = " + queue.size());
		OutUtils.print("head = " + queue.pop());
		OutUtils.print("head = " + queue.pop());
	}
}
