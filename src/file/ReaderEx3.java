package file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderEx3 {
public static void main(String[] args)throws FileNotFoundException,IOException{
	FileInputStream fis=new FileInputStream
			("C:/development/kyclassical_2014/WebContent/jsp/test0106.jsp");
	BufferedReader reader=new BufferedReader(new InputStreamReader(fis));
	String str=null;
	while((str=reader.readLine())!=null){
		System.out.println(str);
	}
	fis.close();
	reader.close();
}
}
