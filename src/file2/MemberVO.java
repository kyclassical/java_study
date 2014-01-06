package file2;

import java.io.Serializable;

public class MemberVO implements Serializable {
 private String id,pwd,phone;

@Override
public String toString() {
	return "이름:"+id+"비밀번호:"+pwd+"전화번호:"+phone;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getPwd() {
	return pwd;
}

public void setPwd(String pwd) {
	this.pwd = pwd;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}
 
}
