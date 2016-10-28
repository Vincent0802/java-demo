package com.demo.data.stack;

import com.demo.data.utils.OutUtils;

/**
 * @Description: 用O(1)时间复杂度求栈的最小元素
 *
 * @author Vincent
 *
 * @time: 2016年9月28日 上午10:54:54
 *
 */
public class StackDemo {

	private StackByLinkedList<Integer> elem;
	
	private StackByLinkedList<Integer> min;
	
	public StackDemo() {
		elem = new StackByLinkedList<Integer>();
		min = new StackByLinkedList<Integer>();
	}
	
	public void push(int data) {
		elem.push(data);
		if(min.isEmpty()) {
			min.push(data);
		} else {
			if(data < min.peek()) {
				min.push(data);
			}
		}
	}
	
	public int pop() {
		int topData = elem.peek();
		elem.pop();
		if(topData == this.min()) {
			min.pop();
		}
		return topData;
	}

	public int min() {
		if(min.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			min.peek();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		StackDemo demo = new StackDemo();
		demo.push(1);
		demo.push(5);
		demo.push(3);
		demo.push(0);
		demo.push(2);
		demo.push(4);
		OutUtils.print("min = " + demo.min.pop());
	}
	
}
