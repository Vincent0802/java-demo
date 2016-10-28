package com.demo.data.string;

import java.util.Arrays;

/**
 * @Description: 比较两个字符串是否由相同的字符(字母及字母的个数相同)组成
 *
 * @Algorithm：TODO
 *
 * @author Vincent
 *
 * @time: 2016年10月17日 下午1:21:09
 *
 */
public class Compare {

	/**
	 * 比较两个字符串是否由相同的字符(字母及字母的个数相同)组成（排序法）
	 * 
	 * @param s1
	 * @param s2
	 * @return boolean
	 */
	public static boolean compareBySort(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		// byte[] bs1 = s1.getBytes();
		// byte[] bs2 = s2.getBytes();//转换成字节数组
		char[] bs1 = s1.toCharArray();
		char[] bs2 = s2.toCharArray();// 转换成字符数组
		Arrays.sort(bs1);
		Arrays.sort(bs2);
		s1 = new String(bs1);
		s2 = new String(bs2);
		if (s1.equals(s2)) {
			return true;
		}
		return false;
	}

	/**
	 * 比较两个字符串是否由相同的字符组成（空间换时间法）
	 * <p>
	 * 思路：假设字符串只有ASCII字符（0-255），申请256大小的数组保存字符出现的次数，初始化为0，将对应的字符的ASCII码为下标，第一次出现
	 * +1， 第二次-1，最后检验是否各个元素的值为0，是则相同，否则不同
	 * </p>
	 * 
	 * @param s1
	 * @param s2
	 * @return boolean
	 */
	public static boolean compare(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		// byte[] bs1 = s1.getBytes();
		// byte[] bs2 = s2.getBytes();//转换成字节数组
		char[] bs1 = s1.toCharArray();
		char[] bs2 = s2.toCharArray();// 转换成字符数组
		int[] count = new int[256];
		for (int i = 0; i < 256; i++) {
			count[i] = 0;
		}
		for (int i = 0; i < bs1.length; i++) {
			count[bs1[i] - '0']++;
		}
		for (int i = 0; i < bs2.length; i++) {
			count[bs2[i] - '0']--;
		}
		for (int i = 0; i < 256; i++) {
			if (count[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
