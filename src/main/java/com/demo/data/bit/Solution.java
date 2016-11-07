package com.demo.data.bit;

import com.demo.data.utils.OutUtils;

/**
 * @Description: 世界上有10种人，一种懂二进制，一种不懂。那么你知道两个int32整数m和n的二进制表达，有多少个位(bit)不同么？
 *
 * @author Vincent
 *
 * @time: 2016年10月24日 下午6:03:06
 *
 */
public class Solution {

	public int countBitDiff1(int m, int n) {
		int count = 0;
		while (m > 0 && n > 0) {
			if (((m & 1) == 1) && ((n & 1) == 1)) {
				m >>= 1;
				n >>= 1;
			} else {
				count++;
			}
		}
		return count;
	}

	public int countBitDiff(int m, int n) {
		int dif = m ^ n;// 先将二者做异或运算，得到结果；
		int cnt = 0;
		while (dif != 0) {
			dif = dif & (dif - 1);
			cnt++;
		} // 统计一个整数dif含有多少个1；
		return cnt;
	}

	public int countBit(int m, int n) {
		int cnt = 0;
		while (n >= m) {
			int dif = n;
			while (dif != 0) {
				dif = dif & (dif - 1);
				cnt++;
			}
			n--;
		}
		return cnt;
	}

	public static void main(String args[]) {
		OutUtils.print(new Solution().countBit(1, 128) + "");
	}

}
