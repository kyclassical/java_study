package file2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import file.ValueEx1;

public class ObjectStreamEx1 {
public static void main(String[] args)throws FileNotFoundException,IOException {
	ValueEx1 v1=new ValueEx1("일지매", 100);
	ObjectOutputStream oos=new ObjectOutputStream(
			new FileOutputStream("C:/development/kyclassical_2014/WebContent/jsp/ex4.txt"));
	oos.writeObject(v1);
	oos.close();
}
}
