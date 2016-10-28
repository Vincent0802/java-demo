package com.demo.data.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @Description: 输出到文件
 *
 * @author Vincent
 *
 * @time: 2016年9月27日 上午9:30:20
 *
 */
public class OutUtils {

	/**
	 * @Description: PATH : 文件输出路径
	 */
	private final static String PATH = "D:\\data.txt";

	/**
	 * 将System.out输出到文件
	 */
	public static void out() {
		try {
			File path = new File(PATH);
			PrintStream out = new PrintStream(new FileOutputStream(path));
			System.setOut(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void print(String str) {
		System.out.println(str);
	}
	
	public static void print(int[] a) {
		for(int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}
}
