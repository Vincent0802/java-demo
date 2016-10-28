package com.demo.data.queue;

import java.util.Stack;

/**
 * @Description: 用两个栈的实现队列
 *
 * @author Vincent
 *
 * @time: 2016年9月28日 上午10:54:54
 *
 */
public class QueueByTwoStack<E> {

	private Stack<E> s1 = new Stack<E>();

	private Stack<E> s2 = new Stack<E>();

	public synchronized void put(E data) {
		s1.push(data);
	}

	public synchronized E pop() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}

	public synchronized boolean isEmpty() {
		return s1.isEmpty() && s2.isEmpty();
	}

}
