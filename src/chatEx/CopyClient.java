package chatEx;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class CopyClient extends Thread {
 Socket s;
 InputStream in;
 OutputStream out;
 String ip;
 ServerEx2 server;
 
 public CopyClient(Socket s, ServerEx2 server) {
	 this.s=s;
	 this.server=server;
	 try {
		in=s.getInputStream();
		out=s.getOutputStream();
		ip=s.getInetAddress().getHostAddress();
	} catch (Exception e) {
		// TODO: handle exception
	}
 }

@Override
public void run() {
	byte[] buf=new byte[2048];
	int size=-1;
	while(true) {
		try {
			size=in.read(buf);
			String str=new String(buf,0,size);
			if(str.equals("x:||:")) {
				out.write(str.getBytes());
				break;
			}
			server.sendMessage(ip+":"+str);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	server.delClient(this);
}
 
}
