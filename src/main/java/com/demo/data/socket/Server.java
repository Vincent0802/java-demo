package com.demo.data.socket;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

/**
 * @Description Socket服务端
 *
 * @author Vincent
 *
 * @Time 2016年10月19日 下午10:16:15
 *
 */
public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket server = null;
			try {
				server = new ServerSocket(4700);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Socket socket = null;
			try {
				socket = server.accept();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String line = null;
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			BufferedReader sin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("Client : " + sin.readLine());
			line = in.readLine();
			while(!line.equals("bye")) {
				os.println(line);
				os.flush();
				System.out.println("Server : " + line);
				System.out.println("Client : " + sin.readLine());
				line = in.readLine();
			}
			os.close();
			in.close();
			sin.close();
			socket.close();
			server.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
