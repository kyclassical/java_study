package file;

import java.io.Serializable;

public class ValueEx1 implements Serializable {
	String name;
	int value;
	public ValueEx1(String name, int value) {
		this.name=name;
		this.value=value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
}
