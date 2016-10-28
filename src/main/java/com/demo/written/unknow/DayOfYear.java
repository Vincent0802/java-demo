package com.demo.written.unknow;

public class DayOfYear {

	private static int[] days = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	/**
	 * 输入年月日，求是这一年的第几天
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return 这一年的第几天
	 */
	public static int getDayOfYear(int year, int month, int day) {
		int i;
		int sum = 0;
		if (month == 1) {
			return day;
		}
		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
			for (i = 0; i < month - 1; i++) {
				if (i == 2) {
					sum += 29;
				} else {
					sum += days[i];
				}
			}
			return sum + day;
		} else {
			for (i = 0; i < month - 1; i++) {
				sum += days[i];
			}
			return sum + day;
		}
	}
	
	public static void main(String[] args) {
		int year = 2016;
		int month = 3;
		int day = 23;
		System.out.println(getDayOfYear(year, month, day));

	}
	
}
