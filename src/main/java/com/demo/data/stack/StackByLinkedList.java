package com.demo.data.stack;

/**
 * @Description: 链表实现栈
 *
 * @author Vincent
 *
 * @time: 2016年9月28日 上午10:52:21
 *
 */
class Node<E> {
	Node<E> next = null;
	public E data;

	public Node(E data) {
		this.data = data;
	}
}

public class StackByLinkedList<E> {

	private Node<E> top = null;

	public boolean isEmpty() {
		return top == null;
	}

	public void push(E data) {
		Node<E> newNode = new Node<E>(data);
		newNode.next = top;
		top = newNode;
	}

	public E pop() {
		if (this.isEmpty()) {
			return null;
		}
		E data = top.data;
		top = top.next;
		return data;
	}

	public E peek() {
		if (this.isEmpty()) {
			return null;
		}
		return top.data;
	}
}
