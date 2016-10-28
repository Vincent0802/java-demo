package com.demo.data.string;

/**
 * @Description: 删除字符串中重复的字符
 *
 * @author Vincent
 *
 * @time: 2016年9月28日 下午2:06:02
 *
 */
public class Remove {

	/**
	 * 删除字符串中重复的字符(蛮力法)
	 * <p>
	 * 思路：看成字符数组，双重循环遍历，重复的字符设置为\0，最后去除。
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public static String removeDirectly(String str) {
		char[] cstr = str.toCharArray();
		for (int i = 0; i < cstr.length; i++) {
			if (cstr[i] == '\0') {
				continue;
			}
			for (int j = i + 1; j < cstr.length; j++) {
				if (cstr[j] == '\0') {
					continue;
				}
				if (cstr[i] == cstr[j]) {
					// cstr[i] = '\0';//保留后面的重复字符
					cstr[j] = '\0';// 保留前面的重复字符
				}
			}
		}
		int k = 0;
		for (int i = 0; i < cstr.length; i++) {
			if (cstr[i] != '\0') {
				cstr[k++] = cstr[i];
			}
		}
		return new String(cstr, 0, k);
	}

	/**
	 * 删除字符串中重复的字符(空间换时间法)
	 * <p>
	 * 思路：假设字符串只有ASCII字符（0-255），申请256大小的数组保存字符出现的次数，初始化为0，将对应的字符的ASCII码为下标，
	 * 字符出现次数为0则置1，若为1则代表出现过，将该字符置为\0，最后去掉。只需遍历一次O（n）。只用1bit即可实现，所以为节省空间，
	 * 申请大小为8的int数组，每个int占32bit，共256bit。够用
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public static String remove(String str) {
		char[] c = str.toCharArray();
		int n = c.length;
		int[] flag = new int[8];
		int i;
		for (i = 0; i < n; i++) {
			flag[i] = 0;
		}
		for (i = 0; i < n; i++) {
			int index = (int) c[i] / 32;// 记录下标
			int shift = (int) c[i] % 32;
			System.out.println(
					c[i] + ";" + (int) c[i] + ":" + index + ":" + shift + ":" + (1 << shift) + ":" + flag[index]);
			if ((flag[index] & (1 << shift)) != 0) {
				c[i] = '\0';
			}
			flag[index] |= (1 << shift);
			System.out.println("flag[index] = " + flag[index]);
		}
		int k = 0;
		for (i = 0; i < c.length; i++) {
			if (c[i] != '\0') {
				c[k++] = c[i];
			}
		}
		return new String(c, 0, k);
	}

	/**
	 * 删除字符串中重复的字符(正则表达式)
	 * <p>
	 * Note:
	 * </p>
	 * <p>
	 * (?s) 开启单行模式 DOTALL 让. 号匹配任意字符
	 * </p>
	 * <p>
	 * (.) 任意字符 并捕获在第一组
	 * </p>
	 * <p>
	 * (?=.*\1) 这是断言, 表示后面内容将是 任意个字符加上第一组所捕获的内容
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public static String removeByPattern(String str) {
		str = str.replaceAll("(?s)(.)(?=.*\\1)", "");
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
