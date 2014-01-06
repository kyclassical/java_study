package file2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PersonalInput {
	public static void main(String[] args)throws IOException ,ClassNotFoundException {
		ObjectInputStream ois=
				new ObjectInputStream(
						new FileInputStream(
								"C:/development/kyclassical_2014/WebContent/jsp/ex5.txt"));
		Personal p=(Personal)ois.readObject();
		System.out.println("name"+p.getName());
		System.out.println("age"+p.getAge());
		ois.close();
	}
}
