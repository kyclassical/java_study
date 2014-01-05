package file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class FindDialog extends JDialog{
 InputEx1 parent;
 int current_idx;
 public FindDialog(InputEx1 parent,boolean modal){
	 super(parent,modal);
	 this.parent=parent;
	 initComponents();
	 setVisible(true);
 }
 private javax.swing.JButton jButton1;
 private javax.swing.JButton jButton2;
 private javax.swing.JButton jButton3;
 private javax.swing.JLabel jLabel1;
 private javax.swing.JTextField word_tf;
private void initComponents() {
	  jLabel1 = new javax.swing.JLabel();
      word_tf = new javax.swing.JTextField();
      jButton1 = new javax.swing.JButton();
      jButton2 = new javax.swing.JButton();
      jButton3 = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      jLabel1.setText("검색 단어 : ");

      jButton1.setText("다음찾기");
      jButton1.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              jButton1ActionPerformed(evt);
          }
      });

      jButton2.setText("이전찾기");

      jButton3.setText("닫기");
      
      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
              .addContainerGap()
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                      .addComponent(jLabel1)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(word_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addGap(0, 0, Short.MAX_VALUE))
                  .addGroup(layout.createSequentialGroup()
                      .addComponent(jButton2)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(jButton1)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                      .addComponent(jButton3)))
              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
              .addGap(24, 24, 24)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(jLabel1)
                  .addComponent(word_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(jButton2)
                  .addComponent(jButton1)
                  .addComponent(jButton3))
              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      
    pack();
	
}
protected void jButton1ActionPerformed(ActionEvent evt) {
	String str=parent.jTextArea1.getText();
	String f_str=word_tf.getText().trim();
	int idx=str.indexOf(f_str, current_idx);
	if(idx !=-1){
		current_idx=idx+f_str.length();
		parent.jTextArea1.select(idx, current_idx);
	}
	
}
}
