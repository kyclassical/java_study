package chatEx;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx1 {
 ServerSocket ss;
 public ServerEx1() {
	 try {
		ss=new ServerSocket(2000);
		System.out.println("서버시작");
	} catch (Exception e) {
		// TODO: handle exception
	}
 }
 public void exe() {
	 while(true) {
		 try {
			Socket s=ss.accept();
			String ip=s.getInetAddress().getHostAddress();
			InputStream in=s.getInputStream();
			byte[] buf=new byte[2048];
			int size=-1;
			while((size=in.read(buf))!=-1) {
				String str=new String(buf, 0, size);
				System.out.println(ip+":"+str);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }
 }
 public static void main(String[] args) {
	 new ServerEx1().exe();
 }
 
}
