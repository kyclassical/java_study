package chatEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClientEx1 {
public static void main(String[] args)throws IOException {
	System.out.println("입력");
	BufferedReader reader=
			new BufferedReader(new InputStreamReader(System.in));
	String str=reader.readLine();
	if(str.length()<1)
		return;
	Socket s=new Socket("192.168.0.4", 2000);
	OutputStream out=s.getOutputStream();
	out.write(str.getBytes());
	out.close();
}
}
