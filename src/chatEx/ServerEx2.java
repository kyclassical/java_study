package chatEx;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerEx2 extends Thread {
  ServerSocket ss;
  ArrayList<CopyClient> list;
  public ServerEx2(){
	  list=new ArrayList<CopyClient>();
	  try {
		ss=new ServerSocket(2222);
		System.out.println("서버시작");
	} catch (Exception e) {
		// TODO: handle exception
	}
  }
  public void sendMessage(String m) {
	  for(CopyClient cc:list) {
		  try {
			cc.out.write(m.getBytes());
		} catch (Exception e) {
			// TODO: handle exception
		}
	  }
  }
  public void delClient(CopyClient cc) {
	  list.remove(cc);
  }
@Override
public void run() {
	while(true) {
		try {
			Socket s=ss.accept();
			CopyClient cc=new CopyClient(s, this);
			list.add(cc);
			cc.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
public static void main(String[] args) {
	new ServerEx2().start();
}
  
}
