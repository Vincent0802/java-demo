package com.demo.data.thread;

import java.util.ArrayList;

/**
 * @Description: java同步
 *
 * @author Vincent
 *
 * @time: 2016年10月20日 下午4:31:47
 *
 */
class InsertData {

	private ArrayList<Integer> arrayList = new ArrayList<Integer>();

	public void insert(Thread thread) {
		synchronized (InsertData.class) {
			for (int i = 0; i < 100; i++) {
				System.out.println(thread.getName() + "在插入数据" + i);
				arrayList.add(i);
			}
		}
	}
}

public class MySynchronized {

	public static void main(String[] args) {

		final InsertData insertData = new InsertData();

		new Thread() {
			public void run() {
				insertData.insert(Thread.currentThread());
			};
		}.start();

		new Thread() {
			public void run() {
				insertData.insert(Thread.currentThread());
			};
		}.start();

	}

}
