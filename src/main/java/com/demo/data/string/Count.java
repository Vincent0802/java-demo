package com.demo.data.string;

/**
 * @Description: 统计一行字符有多少个单词
 *
 * @Algorithm：TODO
 *
 * @author Vincent
 *
 * @time: 2016年10月17日 下午1:20:12
 *
 */
public class Count {

	/**
	 * 统计一行字符有多少个单词
	 * <p>
	 * 思路：字符出现次数可以由空格出现次数决定，若一个字符为非空格，而他的前面是空格，则表示新的单词开始。加入一个flag判断前一个字符是否是空格
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public static int countWord(String str) {
		int count = 0;
		int flag = 0;// 考虑第一个字母前无空格
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				flag = 0;
			} else if (flag == 0) {
				flag = 1;
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
