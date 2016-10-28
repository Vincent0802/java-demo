package com.demo.data.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Description Socket客户端
 *
 * @author Vincent
 *
 * @Time 2016年10月19日 下午10:15:27
 *
 */
public class Client {
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 4700);//向本机的4700端口发出客户请求
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));//由系统的标准输入设备构造BufferedReader对象
			PrintWriter os = new PrintWriter(socket.getOutputStream());//由Socket得到输出流，并构造PrintWriter对象
			BufferedReader sin = new BufferedReader(new InputStreamReader(socket.getInputStream()));//得到输入流
			String line = null;
			line = in.readLine();
			while(!line.equals("bye")) {
				os.println(line);
				os.flush();
				System.out.println("Client : " + line);//输出客户端输入内容
				System.out.println("Server : " + sin.readLine());//输出服务端输入内容
				line = in.readLine();//客户端输入，继续循环
			}
			os.close();
			in.close();
			sin.close();
			socket.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
