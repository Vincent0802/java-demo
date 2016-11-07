package com.demo.data.array;

public class MaxSubArray {

	/**
	 * @Description: begin :子数组的开始位置
	 */
	private static int begin = 0;

	/**
	 * @Description: end : 子数组的结束位置
	 */
	private static int end = 0;

	/**
	 * 求最大子数组的和（动态规划），并记录最大子数组的位置
	 * 
	 * @param arr
	 */
	public static int maxSubArray(int arr[]) {
		int n = arr.length;
		int maxSum = Integer.MIN_VALUE;
		int nSum = 0;// 有n个数字数组的最大子数组的和
		int nStart = 0;// 有n个数字数组包含最后一个元素的子数组的最大和
		for (int i = 0; i < n; i++) {
			if (nSum < 0) {
				nSum = arr[i];
				nStart = i;
			} else {
				nSum += arr[i];
			}
			if (nSum > maxSum) {
				maxSum = nSum;
				begin = nStart;
				end = i;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 1, 5 };
		System.out.println("max = " + maxSubArray(arr));
		System.out.println("begin = " + begin + " end = " + end);
	}

}
