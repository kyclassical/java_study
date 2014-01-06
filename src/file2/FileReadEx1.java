package file2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReadEx1 {
 public static void main(String[] args) throws FileNotFoundException,IOException {
	 System.out.println("파일의 내용을 읽었습니다");
	 System.out.println("==================");
	 FileInputStream fis=new FileInputStream(new File("C:/development/kyclassical_2014/WebContent/jsp/ex7.txt"));
	 byte[] buf=new byte[2048];
	 int size=-1;
	 while((size=fis.read(buf))!=-1){
		 String str=new String(buf,0,size);
		 System.out.println(str);
	 }
	 fis.close();
 }
}
