package file2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class RegEx1 extends JFrame {
  boolean id_chk=true;
  boolean id_success;
  public RegEx1() {
	  ArrayList<MemberVO> list=new ArrayList<MemberVO>();
	  try {
		ObjectOutputStream oos=
				new ObjectOutputStream(new FileOutputStream("C:/development/kyclassical_2014/WebContent/jsp/ex7.txt"));
		oos.writeObject(list);
		oos.close();
	} catch (Exception e) {
		
	}
	  initComponents();
  }
  private javax.swing.JTextField id_tf;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JTextField phone_tf;
  private javax.swing.JPasswordField pwd_tf;
  private javax.swing.JPasswordField repwd_tf;
private void initComponents() {
	 jLabel1 = new javax.swing.JLabel();
     jLabel2 = new javax.swing.JLabel();
     id_tf = new javax.swing.JTextField();
     jLabel3 = new javax.swing.JLabel();
     jLabel4 = new javax.swing.JLabel();
     jLabel5 = new javax.swing.JLabel();
     phone_tf = new javax.swing.JTextField();
     jButton1 = new javax.swing.JButton();
     jButton2 = new javax.swing.JButton();
     jButton3 = new javax.swing.JButton();
     pwd_tf = new javax.swing.JPasswordField();
     repwd_tf = new javax.swing.JPasswordField();
     setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     jLabel1.setFont(new Font("굴림",1,48));
     jLabel1.setText("회원가입");
     jLabel2.setText("아이디");
     jLabel3.setText("비밀번호");
     jLabel3.setText("비밀번호확인");
     jLabel5.setText("전화번호");
     jButton1.setText("회원가입");
     jButton1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent evt) {
			jButton1ActionPerformed(evt);
			
		}
	});
     jButton2.setText("중복확인");
     jButton2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent evt) {
			jButton2ActionPerformed(evt);
			
		}
	});
     jButton3.setText("취소");
     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
     getContentPane().setLayout(layout);
     layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(layout.createSequentialGroup()
                     .addGap(36, 36, 36)
                     .addComponent(jLabel1))
                 .addGroup(layout.createSequentialGroup()
                     .addGap(68, 68, 68)
                     .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                         .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGroup(layout.createSequentialGroup()
                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                 .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                 .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                 .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                 .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                 .addComponent(id_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(phone_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(pwd_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(repwd_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                     .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
             .addContainerGap(47, Short.MAX_VALUE))
     );

     layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {id_tf, pwd_tf, repwd_tf});

     layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
             .addGap(31, 31, 31)
             .addComponent(jLabel1)
             .addGap(18, 18, 18)
             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                 .addComponent(jLabel2)
                 .addComponent(id_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                 .addComponent(jLabel3)
                 .addComponent(pwd_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                 .addComponent(jLabel4)
                 .addComponent(repwd_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                 .addComponent(jLabel5)
                 .addComponent(phone_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
             .addGap(18, 18, 18)
             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                 .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
             .addContainerGap(15, Short.MAX_VALUE))
     );
     pack();
     
	
}
protected void jButton2ActionPerformed(ActionEvent evt) {
	String s_id=id_tf.getText().trim();
	if(s_id.length() >0) {
		File f1=new File("C:/development/kyclassical_2014/WebContent/jsp/ex7.txt");
		try {
			FileInputStream fis=new FileInputStream(f1);
			ObjectInputStream ois=new ObjectInputStream(fis);
			ArrayList<MemberVO> list= (ArrayList<MemberVO>)ois.readObject();
			if(list==null || list.size() <1){
				id_success=true;
				return;
			}
			for(MemberVO vo:list){
				if(vo.getId().equals(s_id)){
					JOptionPane.showMessageDialog(this, "이미사용중입니다");
					id_chk=false;
					break;
				}
			}
			if(id_chk)
				id_success=true;
			System.out.println(id_success+""+id_chk);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
protected void jButton1ActionPerformed(ActionEvent evt) {
	if(id_success) {
		String p1=new String(pwd_tf.getPassword());
		String p2=new String(repwd_tf.getPassword());
		if(p1.equals(p2)) {
			MemberVO vo=new MemberVO();
			vo.setId(id_tf.getText().trim());
			vo.setPwd(p2);
			vo.setPhone(phone_tf.getText().trim());
			try {
				ObjectInputStream ois=
						new ObjectInputStream(new FileInputStream("C:/development/kyclassical_2014/WebContent/jsp/ex7.txt"));
				ArrayList<MemberVO> list=(ArrayList<MemberVO>)ois.readObject();
				list.add(vo);
				ObjectOutputStream oos=new ObjectOutputStream(
						new FileOutputStream("C:/development/kyclassical_2014/WebContent/jsp/ex6.txt"));
				oos.writeObject(list);
				JOptionPane.showMessageDialog(this, "저장완료");
				oos.close();
				ois.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog(this, "아이디를 중복체크하지않았거나\n"+"중복된아이디를 가졌습니다");
		}
	}
	
}
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			new RegEx1().setVisible(true);
			
		}
	});
}

}
