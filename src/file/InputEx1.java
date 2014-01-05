package file;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class InputEx1 extends JFrame{
 private File f1;
 public InputEx1() {
	 initComponents();
 }
 private javax.swing.JMenu jMenu1;
 private javax.swing.JMenu jMenu2;
 private javax.swing.JMenuBar jMenuBar1;
 private javax.swing.JMenuItem jMenuItem1;
 private javax.swing.JMenuItem jMenuItem2;
 private javax.swing.JMenuItem jMenuItem3;
 private javax.swing.JMenuItem jMenuItem4;
 private javax.swing.JMenuItem jMenuItem5;
 private javax.swing.JScrollPane jScrollPane1;
 private javax.swing.JPopupMenu.Separator jSeparator1;
 javax.swing.JTextArea jTextArea1; 

 private void initComponents() {
	 jScrollPane1 = new javax.swing.JScrollPane();
     jTextArea1 = new javax.swing.JTextArea();
     jMenuBar1 = new javax.swing.JMenuBar();
     jMenu1 = new javax.swing.JMenu();
     jMenuItem4 = new javax.swing.JMenuItem();
     jMenuItem1 = new javax.swing.JMenuItem();
     jMenuItem2 = new javax.swing.JMenuItem();
     jSeparator1 = new javax.swing.JPopupMenu.Separator();
     jMenuItem3 = new javax.swing.JMenuItem();
     jMenu2 = new javax.swing.JMenu();
     jMenuItem5 = new javax.swing.JMenuItem();

     setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
     setPreferredSize(new java.awt.Dimension(600, 500));

     jTextArea1.setColumns(20);
     jTextArea1.setRows(5);
     jScrollPane1.setViewportView(jTextArea1);

     getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

     jMenu1.setText("File");

     jMenuItem4.setText("New");
     jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
             jMenuItem4ActionPerformed(evt);
         }
     });
     jMenu1.add(jMenuItem4);

     jMenuItem1.setText("Open...");
     jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
             jMenuItem1ActionPerformed(evt);
         }
     });
     jMenu1.add(jMenuItem1);

     jMenuItem2.setText("Save...");
     jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
             jMenuItem2ActionPerformed(evt);
         }
     });
     jMenu1.add(jMenuItem2);
     jMenu1.add(jSeparator1);

     jMenuItem3.setText("Exit");
     jMenu1.add(jMenuItem3);

     jMenuBar1.add(jMenu1);

     jMenu2.setText("Edit");

     jMenuItem5.setText("Find...");
     jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
             jMenuItem5ActionPerformed(evt);
         }
     });
     jMenu2.add(jMenuItem5);

     jMenuBar1.add(jMenu2);

     setJMenuBar(jMenuBar1);

     pack();
      
	
}

 private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
     // 열기 기능
     JFileChooser jfc = new JFileChooser("c:");
     int cmd = jfc.showOpenDialog(this);
     
     if(cmd == JFileChooser.APPROVE_OPTION){
         FileInputStream fis = null;
         try {
             // 사용자가 선택한 파일 가져오기
             f1 = jfc.getSelectedFile();
             fis = new FileInputStream(f1);
             
             // 읽기를 하기 전에 변수들 준비
             int size = -1;
             byte[] buf = new byte[2048];
             StringBuffer sBuf = new StringBuffer();
             
             // 읽기를 수행하는 반복문
             while((size = fis.read(buf)) != -1){
                 // 읽은 자원은 buf에 있다. 이것을 String으로 생성!
                 String s = new String(buf, 0, size);
                 
                 // 생성된 문자열을 StringBuffer에 추가한다.
                 sBuf.append(s);
             }
             
             // StringBuffer에 있는 자원을 String으로 변환하여
             // JTextArea에 문자열로 지정한다.
             jTextArea1.setText(sBuf.toString());
             
             //커서를 첫 행으로 이동!
             jTextArea1.setCaretPosition(0);
         } catch (Exception ex) {
             // 해당 예외가 발생하면 수행하는 곳!
         } finally {
             // 예외가 발생하든 안하든 무조건 수행하는 곳
             try {
                 fis.close();
             } catch (IOException ex) {
             }
         }
     }
 }                                          

 private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
     // 저장 기능
     if(f1 == null){
         // 한번도 저장하지 않은 경우
         JFileChooser jfc = new JFileChooser(
                 "c:/my_study/java_study");
         int cmd = jfc.showSaveDialog(this);
         
         if(cmd != JFileChooser.APPROVE_OPTION)
             return; // 더 이상 수행하지 못한다.
         else
             f1 = jfc.getSelectedFile();
     }
     
     // 여기에는 한번이라도 저장된 파일 또는 위의
     // 파일선택기에서 [저장]을 선택한 경우다.
     // f1이 null이 아닌 상태이며 이때 스트림을 얻어낸다.
     FileOutputStream fos = null;
     try{
         fos = new FileOutputStream(f1);
         // 쓰기를 하고자 하는 문자열은 area에 있으므로 가져오자
         String str = jTextArea1.getText().replaceAll("\n", "\r\n");
         
         fos.write(str.getBytes());// 쓰기
         setTitle(f1.getAbsolutePath());// 제목 바꾸기
     }catch(Exception e){
     }finally{
         try {
             fos.close();
         } catch (IOException ex) {
         }
     }
 }                                          

 private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
     // 새문서 기능
     f1 = null;
     jTextArea1.setText("");
     setTitle("");
 }                                          

 private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
     // 찾기 기능
     FindDialog fd = new FindDialog(this, false);
     // modal은 대화창이 닫힐때까지 다른 작업 못함!
     // modaless는 다른 창에서의 작업이 허용됨!
     
 }                                          
 public static void main(String args[]) {
    

   
     java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
             new InputEx1().setVisible(true);
         }
     });
 }
}
