package file;

import java.io.Serializable;
import java.util.ArrayList;

public class ValueObjectListEx3 implements Serializable{
 ArrayList<ValueObjectEx3> list;
 public ValueObjectListEx3() {
	 list=new ArrayList<ValueObjectEx3>();
 }
public ArrayList<ValueObjectEx3> getList() {
	return list;
}
public void setList(ArrayList<ValueObjectEx3> list) {
	this.list = list;
}
 
}
