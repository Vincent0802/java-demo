package com.demo.written.toutiao;

import java.util.Scanner;

/**
 * @Description 或与加
 *
 * @author Cyrus
 *
 * @Time 2016年10月10日 下午10:58:22
 *
 */
public class OrAndPlus {

	/*
	 * 给定 x, k ，求满足 x + y = x | y 的第 k 小的正整数 y 。 | 是二进制的或(or)运算，例如 3 | 5 = 7。
	 * 比如当 x=5，k=1时返回 2，因为5+1=6 不等于 5|1=5，而 5+2=7 等于 5 | 2 = 7。
	 */
	public static long getNum(long x, long k) {
		long bitNum = 1;
		long num = 0;
		// 目标是把k的各位依次填在x中是0的位上
		// bitNum用来移动到x中零的位置，然后把k的最低位放在x的零位上, k左移，将下一位变成最低位,bitNum一直左移，
		// 直到x中的下一个为0的位上。
		while (k != 0) {
			if ((x & bitNum) == 0) {// x中当前bitNUM为0的话,把k的最低位放在这儿
				// k&1是将k的最低位取出来,
				// bitNum*(k&1)的结果就是得到bitNum位和当前k的最低位一样的一个数,而其它位都是0
				// 而num原来的bitNum为肯定为0，num+(bitNum*(k&1)) 就将k的最低位放在x的这个零上了。
				num += bitNum;//就是累加k的每个位
				k >>= 1;
			}
			bitNum <<= 1; // bitNum的1一直左移到x中第k个零的位置,（0001）循环左移1的位置判断x哪个位置为0
		}
		return num;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			long x = scanner.nextLong();
			long k = scanner.nextLong();
			System.out.println(getNum(x, k));
		}
	}

}