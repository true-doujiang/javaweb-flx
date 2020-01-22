package cn.itcast;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class IeDemo {

	/**
	 * 手机里面用的多
	 */
	public static void main(String[] args) throws Exception {
		//request();
		response();
	}
	
	//向服务器发送http请求
	public static void request() throws Exception{
		URL url = new URL("http://localhost:8088/day12/servlet/ServletDemo1");
		HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
		
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("referer", "http://www.sina.com");
		OutputStream out = conn.getOutputStream();
		out.write("name=aaaa".getBytes());
		
		System.out.println(conn.getResponseCode());
	}
	
	
	//处理服务器回送的http响应
	public static void response() throws Exception{
		URL url = new URL("http://localhost:8088/day12/servlet/ServletDemo1");
		HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
		
		System.out.println(conn.getResponseCode());
		System.out.println(conn.getHeaderField("Content-Length"));
		
		InputStream in = conn.getInputStream();
		byte buffer[] = new byte[1024];
		int len = 0;
		while((len=in.read(buffer))>0){
			System.out.println(new String(buffer,0,len,"UTF-8"));
		}
	}

}
