package com.demo.written.toutiao;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description 木棒拼图
 *
 * @author Cyrus
 *
 * @Time 2016年10月10日 下午10:05:29
 *
 */

public class StackPuzzle {

	/**
	 * <p>
	 * NOTE:有一个由很多木棒构成的集合，每个木棒有对应的长度，请问能否用集合中的这些木棒以某个顺序首尾相连构成一个面积大于 0
	 * 的简单多边形且所有木棒都要用上，简单多边形即不会自交的多边形。 初始集合是空的，有两种操作，要么给集合添加一个长度为 L
	 * 的木棒，要么删去集合中已经有的某个木棒。每次操作结束后你都需要告知是否能用集合中的这些木棒构成一个简单多边形。
	 * </p>
	 */
	private static void handleData(int[][] data) {
		List<Integer> dataList = new ArrayList<Integer>();
		for (int i = 0; i < data.length; i++) {
			if (data[i][0] == 1) {
				dataList.add(data[i][1]);
			} else {
				dataList.remove(data[i][1]);
			}
			judge(dataList);
		}
	}

	private static void judge(List<Integer> dataList) {
		if (dataList.size() < 3) {
			System.out.println("No");
		} else {
			int sum = 0;
			int i = 0;
			Collections.sort(dataList);
			for (i = 0; i < dataList.size() - 1; i++) {
				sum += dataList.get(i);
			}
			if (sum > dataList.get(i)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Begin......");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] data = new int[n][2];
		for (int i = 0; i < n; i++) {
			data[i][0] = sc.nextInt();
			data[i][1] = sc.nextInt();
		}
		handleData(data);
		System.out.println("End......");
	}
}