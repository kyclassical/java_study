package file2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import file.ValueEx1;

public class ObjectStreamEx2 {
	public static void main(String[] args)throws IOException,ClassNotFoundException {
		ObjectInputStream ois=
				new ObjectInputStream(new FileInputStream("C:/development/kyclassical_2014/WebContent/jsp/ex4.txt"));
	ValueEx1 obj=(ValueEx1)ois.readObject();
	System.out.println("name"+obj.getName());
	System.out.println("value"+obj.getValue());
	ois.close();
	
	}
}
