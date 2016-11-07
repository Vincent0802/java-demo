package com.demo.data.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Description 序列化实例
 *
 * @author Vincent
 *
 * @Time 2016年10月22日 下午9:13:32
 *
 */
public class MySerializable {

	public static void main(String[] args) {
		Student st = new Student("Tom", 'M', 20, 3.6, 2);
		DataObject data = new DataObject();
		data.setWord("123");
		data.setI(2);
		File file = new File("C:\\Users\\Administrator\\Desktop\\student.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			// Student对象序列化过程
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			oos.writeObject(st);
			oos.writeObject(data);
			oos.flush();
			oos.close();
			fos.close();

			// Student对象反序列化过程
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			/*Student st1 = (Student) ois.readObject();
			System.out.println("name = " + st1.getName());
			System.out.println("sex = " + st1.getSex());
			System.out.println("year = " + st1.getYear());
			System.out.println("gpa = " + st1.getGpa());
			System.out.println("i = " + st1.getI());*/
			DataObject tmp = (DataObject)ois.readObject();
			System.out.println("word = " + tmp.getWord());
			System.out.println("i = " + tmp.getI());
			ois.close();
			fis.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}