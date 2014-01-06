package file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ex3Main {
	public static void main(String[] args) throws IOException {
		ValueObjectEx3 v1=
				new ValueObjectEx3("이름1", "111-1111", "thank26@naver.com");
		ValueObjectEx3 v2=
				new ValueObjectEx3("이름2", "폰:222-2222","think000@daum.net");
		ValueObjectEx3 v3=
				new ValueObjectEx3("이름3", "폰:333-3333", "kkk@naver.com");
		
		ValueObjectListEx3 obj =new ValueObjectListEx3();
		obj.getList().add(v1);
		obj.getList().add(v2);
		obj.getList().add(v3);
		
		ObjectOutputStream oos=
				new ObjectOutputStream(
						new FileOutputStream(
								"C:/development/kyclassical_2014/WebContent/jsp/ex1.txt"));
		oos.writeObject(obj);
		oos.close();
		
	}
}
