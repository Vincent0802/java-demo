package com.demo.test;

import com.demo.data.utils.OutUtils;

/**
 * @Description 测试用例主函数入口
 *
 * @author Vincent
 *
 * @Time 2016年10月5日 上午9:45:58
 *
 */

public class Test {

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

	public static void main(String args[]) {
		OutUtils.print(new Test().countBitDiff(1999, 2299) + "");
	}
}
