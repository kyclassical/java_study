package file2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileSaveEx1 {
	public static void main(String[] args) throws FileNotFoundException,IOException {
		System.out.println("파일을 저장할 문자열을 입력하세요");
		BufferedReader reader=
				new BufferedReader(new InputStreamReader(System.in));
		File f1=new File("C:/development/kyclassical_2014/WebContent/jsp/ex6.txt");
		PrintWriter pw=new PrintWriter(f1);
		String str=reader.readLine();
		pw.write(str);
		pw.flush();
		pw.close();
		System.out.println("파일을 저장했습니다");
		System.out.println("파일의 경로:"+f1.getPath());
		System.out.println("파일의 크기:"+f1.length());
	}
}
