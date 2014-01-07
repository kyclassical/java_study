package chatEx;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JFrame;

public class ClientEx2 extends JFrame implements Runnable {
	Socket s;
	InputStream in;
	OutputStream out;
	Thread t;
	public ClientEx2() {
		initComponents();
		connected();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
			//x버튼을 선택할때 
				//서버로 종료메세지를 보낸다 
				String str="x:||:";
				try {
					out.write(str.getBytes());
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		
		
		});
		
	}
	 private void connected() {
		try {
			s=new Socket("192.168.0.4",2222);
			out= s.getOutputStream();
			in=s.getInputStream();
			t=new Thread(this);
			t.start();
			setTitle("연결완료");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	private javax.swing.JTextArea area;
	    private javax.swing.JTextField input;
	    private javax.swing.JButton jButton1;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JScrollPane jScrollPane1;
	private void initComponents() {
		 jScrollPane1 = new javax.swing.JScrollPane();
	     area = new javax.swing.JTextArea();
	     jPanel1 = new javax.swing.JPanel();
	     input = new javax.swing.JTextField();
	     jButton1 = new javax.swing.JButton();

	     setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
	     setPreferredSize(new java.awt.Dimension(400, 500));
	     area.setEditable(false);
	     area.setColumns(20);
	     area.setRows(5);
	     jScrollPane1.setViewportView(area);
	     getContentPane().add(jScrollPane1,BorderLayout.CENTER);
	     jPanel1.setLayout(new BorderLayout());
	     input.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
		     inputActionPerformed(evt);
			}
		});
	     jPanel1.add(input,BorderLayout.CENTER);
	    
	     jButton1.setText("메세지보내기");
	     jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
				
			}
		});
	     jPanel1.add(jButton1, BorderLayout.LINE_END);
	     getContentPane().add(jPanel1,BorderLayout.PAGE_END);
	     pack();
	     
		
	}
	protected void jButton1ActionPerformed(ActionEvent evt) {
		//보내기 버튼을 선택했을때
		sendMsg();
		input.setText("");
		
	}
	protected void inputActionPerformed(ActionEvent evt) {
		//input에서 엔터를 쳤을때
		sendMsg();
		input.setText("");
		
	}
	private void sendMsg() {
		String str=input.getText().trim();
		if(str.length()>0){
			try {
				out.write(str.getBytes());
			} catch (Exception ex) {
				// TODO: handle exception
			}
		}
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ClientEx2().setVisible(true);
				
			}
		});
	}
	@Override
	public void run() {
	byte[] buf=new byte[2048];
	int size=-1;
	while(true) {
		try {
			size=in.read(buf);
			String str=new String(buf,0,size);
			if(str.equals("x:||:"))
			break;
			area.append(str+"\r\n");
			int len=area.getText().length();
			area.setCaretPosition(len);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		System.exit(0);
	}
	
	
	
	
}
