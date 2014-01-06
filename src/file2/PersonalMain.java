package file2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PersonalMain {
	public static void main(String[] args)throws IOException {
		Personal p= new Personal();
		p.setName("마루치");
		p.setAge(90);
		ObjectOutputStream oos=new ObjectOutputStream(
				new FileOutputStream("C:/development/kyclassical_2014/WebContent/jsp/ex5.txt"));
		oos.writeObject(p);
		oos.close();
	}
}
