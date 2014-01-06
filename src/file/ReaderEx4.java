package file;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ReaderEx4 extends JFrame{
	public ReaderEx4() {
		initComponents();
	}

	 private javax.swing.JTextArea area;
	    private javax.swing.JMenu jMenu1;
	    private javax.swing.JMenu jMenu2;
	    private javax.swing.JMenuBar jMenuBar1;
	    private javax.swing.JMenuItem jMenuItem1;
	    private javax.swing.JMenuItem jMenuItem2;
	    private javax.swing.JMenuItem jMenuItem3;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JPopupMenu.Separator jSeparator1;
	private void initComponents() {
		 jScrollPane1 = new javax.swing.JScrollPane();
	        area = new javax.swing.JTextArea();
	        jMenuBar1 = new javax.swing.JMenuBar();
	        jMenu1 = new javax.swing.JMenu();
	        jMenuItem1 = new javax.swing.JMenuItem();
	        jMenuItem2 = new javax.swing.JMenuItem();
	        jSeparator1 = new javax.swing.JPopupMenu.Separator();
	        jMenuItem3 = new javax.swing.JMenuItem();
	        jMenu2 = new javax.swing.JMenu();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setPreferredSize(new java.awt.Dimension(400, 400));
	        area.setColumns(20);
	        area.setRows(5);
	        jScrollPane1.setViewportView(area);
	        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

	        jMenu1.setText("File");

	        jMenuItem1.setText("Open");
	        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem1ActionPerformed(evt);
	            }
	        });
	        jMenu1.add(jMenuItem1);

	        jMenuItem2.setText("Save");
	        jMenu1.add(jMenuItem2);
	        jMenu1.add(jSeparator1);

	        jMenuItem3.setText("Exit");
	        jMenu1.add(jMenuItem3);

	        jMenuBar1.add(jMenu1);

	        jMenu2.setText("Edit");
	        jMenuBar1.add(jMenu2);

	        setJMenuBar(jMenuBar1);

	        pack();
		
	}
	protected void jMenuItem1ActionPerformed(ActionEvent evt) {
		JFileChooser jfc=new JFileChooser("c:/");
		int cmd=jfc.showOpenDialog(this);
		if(cmd!=JFileChooser.APPROVE_OPTION)
			return;
		File f1=jfc.getSelectedFile();
		BufferedReader reader=null;
		try {
			reader =new BufferedReader(new InputStreamReader(
					new FileInputStream(f1)));
			area.setText("");
			String str=null;
			while((str=reader.readLine())!=null){
				area.append(str);
				area.append("\r\n");
			}
			setTitle(f1.getAbsolutePath());
			area.setCaretPosition(0);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException ex) {
				// TODO: handle exception
			}
		}
		
	}

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ReaderEx4().setVisible(true);
				
			}
		});
	}
	
	
	
	
	
	
}
