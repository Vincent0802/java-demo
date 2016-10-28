package com.demo.written.toutiao;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description 最大映射
 *
 * @author Cyrus
 *
 * @Time 2016年10月9日 下午9:44:14
 *
 */

public class MaxMapping {

	/**
	 * <p>
	 * NOTE：最大映射： 有 n 个字符串，每个字符串都是由 A-J 的大写字符构成。现在你将每个字符映射为一个 0-9
	 * 的数字，不同字符映射为不同的数字。这样每个字符串就可以看做一个整数，唯一的要求是这些整数
	 * 必须是正整数且它们的字符串不能有前导零。现在问你怎样映射字符才能使得这些字符串表示的整数之和最大？
	 * </p>
	 */
	public static Long maxMapping(int n, String[] strs) {
		long sum = 0;
		int num = 9;
		Map<Character, Long> map = new HashMap<Character, Long>();// 保存节点对应的权重
		List<Character> headList = new ArrayList<Character>();// 头结点列表
		for (int i = 0; i < n; i++) {
			setWeight(strs[i], map, headList);
		}
		List<Map.Entry<Character, Long>> orderedMap = new ArrayList<Map.Entry<Character, Long>>(map.entrySet());
		Collections.sort(orderedMap, new Comparator<Map.Entry<Character, Long>>() {
			@Override
			public int compare(Entry<Character, Long> args0, Entry<Character, Long> args1) {
				return args0.getValue() > args1.getValue() ? -1 : 1;// 降序排列
			}
		});

		if (orderedMap.size() == 10) {
			for (int i = 9; i >= 0; i--) {
				if (!orderedMap.contains(orderedMap.get(i).getKey())) {
					orderedMap.remove(i);
					break;
				}
			}
		}

		for (Entry<Character, Long> entry : orderedMap) {
			sum += num * entry.getValue();
			num--;
		}

		return sum;

	}

	private static void setWeight(String str, Map<Character, Long> map, List<Character> headList) {
		char[] cMap = str.toCharArray();
		Long init = (long) 1;
		for (int i = cMap.length - 1; i >= 0; i--) {
			if (map.containsKey(cMap[i])) {
				map.put(cMap[i], map.get(cMap[i]) + init);
			} else {
				map.put(cMap[i], init);
			}
			init *= 10;
		}
		headList.add(cMap[0]);
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			String[] strs = new String[n];
			for (int i = 0; i < n; i++) {
				strs[i] = scanner.next();
			}
			System.out.println(maxMapping(n, strs));
		}
	}
}
