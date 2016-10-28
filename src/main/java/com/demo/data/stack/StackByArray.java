package com.demo.data.stack;

import java.util.Arrays;

import com.demo.data.utils.OutUtils;

/**
 * @Description: 数组实现栈
 *
 * @author Vincent
 *
 * @time: 2016年9月28日 上午10:52:01
 *
 */
public class StackByArray<E> {

	private Object[] stack;
	
	private int size;
	
	public StackByArray() {
		stack = new Object[10];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	@SuppressWarnings("unchecked")
	public E peek() {
		if(isEmpty()) {
			return null;
		}
		return (E)stack[size - 1];
	}
	
	public E pop() {
		E e = peek();
		stack[size - 1] = null;
		size--;
		return e;
	}
	
	public E push(E data) {
		ensureCapacity(size + 1);
		stack[size++] = data;
		return data;
	}

	private void ensureCapacity(int size) {
		int len = stack.length;
		if(size > len) {
			int newLen = 10;
			stack = Arrays.copyOf(stack, newLen);
		}
	}
	
	public static void main(String[] args) {
		StackByArray<Integer> queue = new StackByArray<Integer>();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		OutUtils.print("size = " + queue.size);
		OutUtils.print("top = " + queue.pop());
		OutUtils.print("top = " + queue.pop());
	}
	
}
