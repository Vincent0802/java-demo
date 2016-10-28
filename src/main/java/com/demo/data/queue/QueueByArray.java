package com.demo.data.queue;

import java.util.LinkedList;

/**
 * @Description: 数组实现队列
 *
 * @author Vincent
 *
 * @time: 2016年9月28日 上午10:52:01
 *
 */
public class QueueByArray<E> {

	private LinkedList<E> list = new LinkedList<E>();

	private int size = 0;

	public synchronized void put(E data) {
		list.addLast(data);
		size++;
	}

	public synchronized E pop() {
		size--;
		return list.removeFirst();
	}

	public synchronized boolean isEmpty() {
		return size == 0;
	}

	public synchronized int size() {
		return size;
	}
}
