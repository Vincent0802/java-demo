package com.demo.data.file;

import java.util.Scanner;

/**
 * @Description 文件操作入口函数
 *
 * @author Cyrus
 *
 * @Time 2016年10月2日 下午3:12:55
 *
 */
public class FileMainApp {

	@SuppressWarnings("unused")
	private static int a = 0;
	
	@SuppressWarnings({ "resource", "static-access" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner read = new Scanner(System.in);
		String str = read.nextLine();
		int n = Integer.parseInt(str);
		FileMainApp.a++;
		FileMainApp app = new FileMainApp();
		app.a++;
		System.out.println("n = " + Math.sqrt(n));
	}

}
