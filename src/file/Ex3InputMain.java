package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Ex3InputMain {
 public static void main(String[] args)throws FileNotFoundException,IOException,ClassNotFoundException{
	 ObjectInputStream ois=
			 new ObjectInputStream(new FileInputStream("C:/development/kyclassical_2014/WebContent/jsp/ex1.txt"));
	 ValueObjectListEx3 obj=(ValueObjectListEx3) ois.readObject();
	 ArrayList<ValueObjectEx3> list=obj.getList();
	 for(ValueObjectEx3 vo:list) {
		 System.out.println(vo.getName()+"/"+vo.getPhone()+"/"+vo.getEmail());
	 }
	 ois.close();
 
 
 }
}
