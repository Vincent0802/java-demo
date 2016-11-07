package com.demo.data.serializable;

import java.io.Serializable;

/**
 * @Description 序列化测试对象
 *
 * @author Vincent
 *
 * @Time 2016年11月7日 下午7:34:20
 *
 */
public class Student implements Serializable {

	private String name;

	private char sex;

	private int year;

	private double gpa;

	private static int i = 0;

	public Student() {

	}

	public Student(String name, char sex, int year, double gpa, int i) {
		this.name = name;
		this.sex = sex;
		this.year = year;
		this.gpa = gpa;
		this.i = i;
	}

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		Student.i = i;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getName() {
		return this.name;
	}

	public char getSex() {
		return this.sex;
	}

	public int getYear() {
		return this.year;
	}

	public double getGpa() {
		return this.gpa;
	}
}
