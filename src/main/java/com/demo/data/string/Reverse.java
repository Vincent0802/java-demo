package com.demo.data.string;

/**
 * @Description: 反转字符串
 *
 * @Algorithm：TODO
 *
 * @author Vincent
 *
 * @time: 2016年10月17日 下午1:18:19
 *
 */
public class Reverse {

	/**
	 * 反转字符串使用库函数
	 * 
	 * @param str
	 *            字符串
	 * @return 翻转后的字符串
	 */
	public static String reverseByLibrary(String str) {
		return new StringBuffer(str).reverse().toString();
	}

	/**
	 * 反转句子中的单词不使用库函数（思路：转换成char数组操作。先整个串反转，在每个单词反转）
	 * 
	 * @param str
	 *            字符串
	 * @return 翻转后的字符串
	 */
	public static String reverse(String str) {
		char[] cstr = str.toCharArray();
		// 反转整个字符串
		swap(cstr, 0, cstr.length - 1);
		int begin = 0;
		// 反转每个单词
		for (int i = 1; i < cstr.length; i++) {
			if (cstr[i] == ' ') {
				swap(cstr, begin, i - 1);// 交换空格的前一个
				begin = i + 1;// begin等于空格的后一个
			}
		}
		// 最后将三个单词顺序恢复
		swap(cstr, 0, cstr.length - 1);
		return new String(cstr);
	}

	/**
	 * 反转字符数组的内容
	 * 
	 * @param str
	 * @param front
	 * @param end
	 */
	private static void swap(char cstr[], int front, int end) {
		while (front < end) {
			char temp = cstr[end];
			cstr[end] = cstr[front];
			cstr[front] = temp;
			front++;
			end--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
