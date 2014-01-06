package file2;

public class MemberMain {
public static void main(String[] args) {
	MemberVO vo=new MemberVO();
	vo.setId("me");
	vo.setPwd("1234");
	vo.setPhone("010-1111-1111");
	System.out.println(vo);
}
}
