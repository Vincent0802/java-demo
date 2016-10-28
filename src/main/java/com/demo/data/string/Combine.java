package com.demo.data.string;

/**
 * @Description: 输出字符所有的组合
 *
 * @Algorithm：例如ABC，形如001代表C,110代表AB
 *
 * @author Vincent
 *
 * @time: 2016年10月17日 上午10:33:22
 *
 */
public class Combine {

	private static void combine(char[] c) {
		if (c == null) {
			return;
		}
		int len = c.length;
		boolean[] used = new boolean[len];
		char[] cache = new char[len];
		int result = len;
		while (true) {
			int index = 0;
			while (used[index]) {
				used[index] = false;
				++result;
				if (++index == len) {
					return;
				}
			}
			used[index] = true;
			cache[--result] = c[index];
			System.out.println(new String(cache).substring(result) + " ");
		}
	}

	private static void combine(char[] c, int begin, int len, StringBuffer sb) {
		if (len == 0) {
			System.out.println(sb + " ");
			return;
		}
		if (begin == c.length) {
			return;
		}
		sb.append(c[begin]);
		combine(c, begin + 1, len - 1, sb);
		sb.deleteCharAt(sb.length() - 1);
		combine(c, begin + 1, len, sb);
	}

	public static void main(String[] args) {
		String s = "abc";
		char[] c = s.toCharArray();
		combine(c);
		System.out.println("Recursion....");
		StringBuffer sb = new StringBuffer("");
		int len = c.length;
		for (int i = 1; i < len; i++) {
			combine(c, 0, i, sb);
		}
	}

}
