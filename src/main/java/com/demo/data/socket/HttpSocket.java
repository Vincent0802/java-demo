package com.demo.data.socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import com.demo.data.utils.OutUtils;

/**
 * @Description: Socket实现Http请求
 *
 * @Algorithm：TODO
 *
 * @author Vincent
 *
 * @time: 2016年10月19日 下午4:49:54
 *
 */
public class HttpSocket {

	private int port;

	private String host;

	private Socket socket;

	private BufferedReader reader;

	private BufferedWriter writer;

	public HttpSocket(String host, int port) {
		socket = new Socket();
		this.port = port;
		this.host = host;
	}  

	@SuppressWarnings("unused")
	public void sendGet() throws IOException {
		String path = "";
		SocketAddress dest = new InetSocketAddress(host, port);
		socket.connect(dest);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"GBK"));  
        OutputStream out = socket.getOutputStream();  
        StringBuffer sb = new StringBuffer("GET /index.html HTTP/1.1\r\n");  
        sb.append("User-Agent: Java/1.6.0_20\r\n");  
        sb.append("Host: www.pconline.com.cn:80\r\n");  
        sb.append("Accept: text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2\r\n");  
        sb.append("Connection: Close\r\n");  
        sb.append("\r\n");  
        out.write(sb.toString().getBytes());  
        out.flush();
        String tmp = "";  
        while((tmp = br.readLine())!=null){  
            System.out.println(tmp);  
        }  
        out.close();  
        br.close();  
        
		/*OutputStreamWriter streamWriter = new OutputStreamWriter(socket.getOutputStream());
		writer = new BufferedWriter(streamWriter);

		writer.write("GET" + path + "HTTP/1.1\r\n");
		writer.write("Host: " + this.host + "\r\n");
		writer.write("\r\n");
		writer.flush();

		BufferedInputStream streamReader = new BufferedInputStream(socket.getInputStream());
		reader = new BufferedReader(new InputStreamReader(streamReader, "utf-8"));
		String line = null;
		while ((line = reader.readLine()) != null) {
			OutUtils.print(line);
		}
		reader.close();
		writer.close();
		socket.close();*/
	}

	public void sendPost() throws IOException {
		String path = "";
		String data = "data";
		SocketAddress dest = new InetSocketAddress(host, port);
		socket.connect(dest);
		OutputStreamWriter streamWriter = new OutputStreamWriter(socket.getOutputStream());
		writer = new BufferedWriter(streamWriter);

		writer.write("POST" + path + "HTTP/1.1\r\n");
		writer.write("Host: " + this.host + "\r\n");
		writer.write("Content-Length: " + data.length() + "\r\n");
		writer.write("Content-Type: application/x-www-form-urlencoded\r\n");
		writer.write("\r\n");
		writer.write(data);
		writer.flush();
		writer.write("\r\n");
		writer.flush();

		BufferedInputStream streamReader = new BufferedInputStream(socket.getInputStream());
		reader = new BufferedReader(new InputStreamReader(streamReader, "utf-8"));
		String line = null;
		while ((line = reader.readLine()) != null) {
			OutUtils.print(line);
		}
		reader.close();
		writer.close();
		socket.close();
	}

	public static void main(String[] args) {
		HttpSocket td = new HttpSocket("127.0.0.1", 8081);
		try {
			td.sendGet(); //send HTTP GET Request
//			td.sendPost(); // send HTTP POST Request
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
