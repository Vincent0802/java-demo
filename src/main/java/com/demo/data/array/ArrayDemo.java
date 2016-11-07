package com.demo.data.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description: Array的基本操作
 *
 * @author Cyrus
 *
 * @time: 2016年9月28日 上午10:37:41
 *
 */
public class ArrayDemo {

	/**
	 * 打印数组
	 * 
	 * @param arr
	 */
	public static void printArray(int[] arr) {
		System.out.println("一维数组值如下：");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("data" + i + " = " + arr[i]);
		}
	}

	/**
	 * 找出第二大的数
	 * 
	 * @param arr
	 */
	public static int findSecondMax(int arr[]) {
		int max = 0;
		int sec_max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				sec_max = max;
				max = arr[i];
			} else {
				if (arr[i] > sec_max) {
					sec_max = arr[i];
				}
			}
		}
		return sec_max;
	}

	/**
	 * 求最大子数组的和（动态规划）
	 * 
	 * @param arr
	 */
	public static int maxSubArray(int arr[]) {
		int n = arr.length;
		int nAll = arr[0];// 有n个数字数组的最大子数组的和
		int nEnd = arr[0];// 有n个数字数组包含最后一个元素的子数组的最大和
		for (int i = 1; i < n; i++) {
			nEnd = max(nEnd + arr[i], arr[i]);
			nAll = max(nEnd, nAll);
		}
		return nAll;
	}

	/**
	 * 求最小子数组的和（动态规划）
	 * 
	 * @param arr
	 */
	public static int minSubArray(int arr[]) {
		int n = arr.length;
		int nAll = arr[0];// 有n个数字数组的最小子数组的和
		int nEnd = arr[0];// 有n个数字数组包含最后一个元素的子数组的最小和
		for (int i = 1; i < n; i++) {
			nEnd = min(nEnd + arr[i], arr[i]);
			nAll = min(nEnd, nAll);
		}
		return nAll;
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

	private static int min(int a, int b) {
		return a < b ? a : b;
	}

	/**
	 * 找出重复最多的数（借助Map）
	 * 
	 * @param arr
	 * @return
	 */
	public static int findFrequent(int arr[]) {

		return 1;
	}

	/**
	 * 求数组两两相加为sum的组合种数（排序法，建议堆排序或者快排）
	 * 
	 * @param arr
	 * @return
	 */
	public static int findSum(int arr[], int sum) {

		return 1;
	}

	/**
	 * 将数组循环右移k位(思想：借助数组反转)
	 * 
	 * @param arr
	 * @param k
	 */
	public static int[] shiftK(int arr[], int k) {
		int n = arr.length;
		k = k % n;// 防止k > n，右移k位与k%n是一样的
		reverse(arr, n - k, n - 1);
		reverse(arr, 0, n - k - 1);
		reverse(arr, 0, n - 1);
		return arr;
	}

	private static void reverse(int[] arr, int b, int e) {
		for (; b < e; b++, e--) {
			int temp = arr[e];
			arr[e] = arr[b];
			arr[b] = temp;
		}
	}

	/**
	 * 找出数组中出现1次的元素，其他元素出现2次，时间O(n),空间O(1)
	 * 
	 * @param arr
	 * @param appearTimes
	 */
	public static void findOnce(int arr[]) {

	}

	/**
	 * 找出数组中出现1次的元素，其他元素出现appearTimes次
	 * 
	 * @param arr
	 * @param appearTimes
	 */
	public static void findOnce(int arr[], int appearTimes) {

	}

	/**
	 * 找出数组唯一重复的值(异或法)
	 * 
	 * @param arr
	 * @param appearTimes
	 */
	public static int findXORDup(int arr[]) {

		return 1;
	}

	/**
	 * 找出数组唯一重复的值(空间换时间法)
	 * 
	 * @param arr
	 * @param appearTimes
	 */
	public static int findElem(int arr[]) {

		return 1;
	}

	/**
	 * 找出数组至少一个的重复的值(取反法)
	 * 
	 * @param arr
	 * @param appearTimes
	 */
	public static int findXOR(int arr[]) {

		return 1;
	}

	/**
	 * 找出数组至少一个的重复的值(类似单链表是否含有环的算法。数组index从0开始不可直接使用)
	 * 
	 * @param arr
	 * @param appearTimes
	 */
	public static int findInteger(int arr[]) {

		return 1;
	}

	/**
	 * 递归求数组最大值
	 * 
	 * @param arr
	 * @param begin
	 * @return
	 */
	public static int maxNum(int arr[], int begin) {

		return 1;
	}

	/**
	 * 求数组数对之差的最大值（动态规划法）
	 * 
	 * @param arr
	 * @return
	 */
	public static int getMax(int arr[]) {

		return 1;
	}

	/**
	 * 得到数组绝对值最小的数（二分法）
	 * 
	 * @param arr
	 * @return
	 */
	public static int getMinAbsolute(int arr[]) {

		return 1;
	}

	/**
	 * 得到数组两个元素最小的距离
	 * 
	 * @param arr
	 * @return
	 */
	public static int minDistance(int arr[]) {

		return 1;
	}

	/**
	 * 求指定数字在数组中第一次出现的位置（跳跃式搜索）
	 * 
	 * @param arr
	 * @return
	 */
	public static int findIndex(int arr[], int param) {

		return 1;
	}

	/**
	 * 合并两个有序子段，空间O(1)
	 * 
	 * @param arr
	 * @return
	 */
	public static void sort(int arr[], int mid) {

	}

	/**
	 * @param arr
	 * @param mid
	 */
	@SuppressWarnings("unused")
	private static void findRightPlaceForMid(int arr[], int mid) {

	}

	/**
	 * 计算两个有序数组的交集（二路归并法）考虑两个数组的长度差距较大情况
	 * 
	 * @param arr
	 * @return
	 */
	public static ArrayList<Integer> mixed(int arr1[], int arr2[]) {

		return null;
	}

	/**
	 * 求数组的反序对个数（分治归并法）
	 * 
	 * @param arr
	 * @return
	 */
	public static int reverseCount(int arr[]) {

		return 2;
	}

	/**
	 * ，三个升序数组，各取一个元素，求最小三元组（分治归并法）
	 * 
	 * @param arr
	 * @return
	 */
	public static int minThreeDistance(int a[], int b[], int c[]) {

		return 2;
	}

	/**
	 * 春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现， 某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。写出
	 * 具体算法思路和代码实现，要求算法尽可能高效。 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。 若没有金
	 * 额超过总数的一半，返回0。 测试样例： [1,2,3,2,2],5 返回：2
	 * 
	 * @param gifts
	 * @param n
	 * @return
	 */
	public int getValue(int[] gifts, int n) {
		Arrays.sort(gifts);
		int ans = gifts[n / 2];
		int num = 0;
		for (int i = 0; i < gifts.length; i++) {
			if (gifts[i] == ans) {
				num++;
			}
		}
		return num <= n / 2 ? 0 : ans;
	}

}
