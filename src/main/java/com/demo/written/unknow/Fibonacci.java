package com.demo.written.unknow;

/**
 * @Description: fibonacci数列
 *
 * @author Vincent
 *
 * @time: 2016年11月3日 下午5:00:40
 *
 */
public class Fibonacci {

	public int fibonacci(int n) {
		if (n <= 0 || n > 39) {
			return 0;
		}
		int result[] = new int[] { 0, 1 };

		if (n <= 2) {
			return result[n - 1];
		}
		int fibN = 0;
		int fibOne = 0;
		int fibTwo = 1;
		while ((n--) > 2) {
			fibN = fibOne + fibTwo;
			fibOne = fibTwo;
			fibTwo = fibN;
		}
		return fibN;
	}

	public static void main(String[] args) {
		new Fibonacci().fibonacci(3);
	}

}
