package file;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class WriteEx1 extends JFrame {
 private PrintWriter pw;
 public WriteEx1() {
	 initComponents();
 }

 private javax.swing.JMenu jMenu1;
 private javax.swing.JMenu jMenu2;
 private javax.swing.JMenuBar jMenuBar1;
 private javax.swing.JMenuItem jMenuItem1;
 private javax.swing.JMenuItem jMenuItem2;
 private javax.swing.JMenuItem jMenuItem3;
 private javax.swing.JScrollPane jScrollPane1;
 private javax.swing.JPopupMenu.Separator jSeparator2;
 private javax.swing.JTextArea jTextArea1;
private void initComponents() {
	jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();
    jMenuItem2 = new javax.swing.JMenuItem();
    jSeparator2 = new javax.swing.JPopupMenu.Separator();
    jMenuItem3 = new javax.swing.JMenuItem();
    jMenu2 = new javax.swing.JMenu();
    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    setPreferredSize(new Dimension(500, 500));
    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jScrollPane1.setViewportView(jTextArea1);
    getContentPane().add(jScrollPane1,BorderLayout.CENTER);
    jMenu1.setText("File");
    jMenuItem1.setText("Open");
    jMenu1.add(jMenuItem1);
    jMenuItem2.setText("Save");
    jMenuItem2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent evt) {
			jMenuItem2ActionPerformed(evt);
			
		}
	});
    jMenu1.add(jMenuItem2);
    jMenu1.add(jSeparator2);
    jMenuItem3.setText("Exit");
    jMenu1.add(jMenuItem3);
    jMenuBar1.add(jMenu1);
    setJMenuBar(jMenuBar1);
    pack();
	
}
protected void jMenuItem2ActionPerformed(ActionEvent evt) {
	JFileChooser jfc=new JFileChooser();
	int cmd=jfc.showSaveDialog(this);
	if(cmd !=JFileChooser.APPROVE_OPTION)
		return;
	try {
		File f1=jfc.getSelectedFile();
		pw=new PrintWriter(f1);
		String str=jTextArea1.getText().replaceAll("\n", "\r\n");
		pw.write(str);
		pw.flush();
		if(pw.checkError()){
			throw new IOException("전송오류");
		}
		JOptionPane.showMessageDialog(this, "저장완료");
		setTitle(f1.getAbsolutePath());
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
public static void main(String args[]) {
	EventQueue.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			new WriteEx1().setVisible(true);
			
		}
	});
}
}
