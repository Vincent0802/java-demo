package com.demo.data.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description: 输出字符的所有排列，用无向图的遍历解决
 *
 * @Algorithm：将字符当作节点构成无向图，分别从节点做图的深度优先遍历，遍历Set集合去除重复
 *
 * @author Vincent
 *
 * @time: 2016年10月19日 下午3:35:50
 *
 */
public class IntCombine {

	private int[] numbers = new int[] { 1, 2, 2 };

	private int n = numbers.length;

	private boolean[] visited = new boolean[n];

	private int[][] graph = new int[n][n];

	String combine = "";

	public Set<String> getAllCombinations() {
		buildGraph();
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < n; i++) {
//			OutUtils.print("step " + i + ":");
			this.depthFirstSearch(i, set);
		}
		return set;
	}

	private void buildGraph() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					graph[i][j] = 0;
				} else {
					graph[i][j] = 1;
				}
			}
		}
	}

	private void depthFirstSearch(int start, Set<String> set) {
		visited[start] = true;
		combine = combine + numbers[start];
		set.add(combine);
//		OutUtils.print("before = " + combine);
		for (int j = 0; j < n; j++) {
			if (graph[start][j] == 1 && visited[j] == false) {
//				OutUtils.print("step " + j + ":");
				depthFirstSearch(j, set);
			}
		}
		combine = combine.substring(0, combine.length() - 1);// 将字符串combine置空
		// combine = "";
//		OutUtils.print("after = " + combine);
		visited[start] = false;
	}

	public static void main(String[] args) {
		IntCombine com = new IntCombine();
		Set<String> set = com.getAllCombinations();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String str = (String) it.next();
			System.out.println(str);
		}
	}
}
