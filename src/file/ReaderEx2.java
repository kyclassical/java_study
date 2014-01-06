package file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReaderEx2 {
public static void main(String[] args) throws IOException {
	InputStream key=System.in;
	InputStreamReader reader=new InputStreamReader(key);
	BufferedReader br=new BufferedReader(reader);
	System.out.println("입력");
	String str=br.readLine();
	System.out.println("받은값"+str);
}
}
