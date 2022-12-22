
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Image;
import java.io.File;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class addteacher extends javax.swing.JFrame {

    JFileChooser chooser;
    File f;
    ImageIcon ic;

    public void getDepartmentnames() {
        try {

            HttpResponse<String> res = Unirest.get("http://localhost:8999/getdepartmentnames")
                    .asString();

            tdnamecb.removeAllItems();

            if (res.getStatus() == 200) {
                String data = res.getBody();
                System.out.println(data);
                StringTokenizer st = new StringTokenizer(data, ":&");
                while (st.hasMoreTokens()) {
                    String departmentname = st.nextToken();
                    tdnamecb.addItem(departmentname);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
  

    public addteacher() {
        initComponents();
        setSize(1286, 750);
        setResizable(false);
        setLocationRelativeTo(null);
        chooser = new JFileChooser();
        getDepartmentnames();
    }
    
    public boolean isMobileNumberValid(String str){
        Pattern ptrn = Pattern.compile("(0/91)?[1-9][0-9]{9}");
        Matcher match = ptrn.matcher(str);
        return (match.find()&&match.group().equals(str));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel10 = new javax.swing.JLabel();
        tnametf = new javax.swing.JTextField();
        tfathertf = new javax.swing.JTextField();
        tqualificationtf = new javax.swing.JTextField();
        tphonetf = new javax.swing.JTextField();
        temailtf = new javax.swing.JTextField();
        tdnamecb = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        taddressta = new javax.swing.JTextArea();
        tpasspf = new javax.swing.JPasswordField();
        tbrowsebtn = new javax.swing.JButton();
        tphotoviewlb = new javax.swing.JLabel();
        tbackbtn = new javax.swing.JButton();
        taddbtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel10.setText("Photo");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(40, 710, 120, 40);

        tnametf.setBackground(new java.awt.Color(0, 0, 0));
        tnametf.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tnametf.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tnametf);
        tnametf.setBounds(250, 160, 360, 50);

        tfathertf.setBackground(new java.awt.Color(0, 0, 0));
        tfathertf.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tfathertf.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tfathertf);
        tfathertf.setBounds(250, 230, 360, 50);

        tqualificationtf.setBackground(new java.awt.Color(0, 0, 0));
        tqualificationtf.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tqualificationtf.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tqualificationtf);
        tqualificationtf.setBounds(250, 440, 360, 50);

        tphonetf.setBackground(new java.awt.Color(0, 0, 0));
        tphonetf.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tphonetf.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tphonetf);
        tphonetf.setBounds(250, 300, 360, 50);

        temailtf.setBackground(new java.awt.Color(0, 0, 0));
        temailtf.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        temailtf.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(temailtf);
        temailtf.setBounds(250, 370, 360, 50);

        tdnamecb.setBackground(new java.awt.Color(0, 0, 0));
        tdnamecb.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tdnamecb.setForeground(new java.awt.Color(255, 255, 255));
        tdnamecb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(tdnamecb);
        tdnamecb.setBounds(880, 160, 330, 50);

        taddressta.setBackground(new java.awt.Color(0, 0, 0));
        taddressta.setColumns(20);
        taddressta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        taddressta.setForeground(new java.awt.Color(255, 255, 255));
        taddressta.setRows(5);
        jScrollPane1.setViewportView(taddressta);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(250, 510, 360, 130);

        tpasspf.setBackground(new java.awt.Color(0, 0, 0));
        tpasspf.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tpasspf.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tpasspf);
        tpasspf.setBounds(880, 230, 330, 50);

        tbrowsebtn.setBackground(new java.awt.Color(51, 255, 153));
        tbrowsebtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        tbrowsebtn.setText("Browse");
        tbrowsebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbrowsebtnActionPerformed(evt);
            }
        });
        getContentPane().add(tbrowsebtn);
        tbrowsebtn.setBounds(880, 300, 330, 40);

        tphotoviewlb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(tphotoviewlb);
        tphotoviewlb.setBounds(880, 340, 330, 220);

        tbackbtn.setBackground(new java.awt.Color(255, 0, 0));
        tbackbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        tbackbtn.setForeground(new java.awt.Color(255, 255, 255));
        tbackbtn.setText("Back");
        tbackbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbackbtnActionPerformed(evt);
            }
        });
        getContentPane().add(tbackbtn);
        tbackbtn.setBounds(730, 590, 190, 50);

        taddbtn.setBackground(new java.awt.Color(51, 255, 255));
        taddbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        taddbtn.setForeground(new java.awt.Color(0, 102, 102));
        taddbtn.setText("Add");
        taddbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taddbtnActionPerformed(evt);
            }
        });
        getContentPane().add(taddbtn);
        taddbtn.setBounds(980, 590, 200, 50);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/AddTeachers.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbrowsebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbrowsebtnActionPerformed
        
        int r = chooser.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            f = chooser.getSelectedFile();
            ic = new ImageIcon(f.getAbsolutePath());
            Image image = ic.getImage();
            Image nimage = image.getScaledInstance(280, 170, java.awt.Image.SCALE_SMOOTH);
            ic = new ImageIcon(nimage);
            tphotoviewlb.setIcon(ic);
        }
        
    }//GEN-LAST:event_tbrowsebtnActionPerformed
    
    private void taddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taddbtnActionPerformed
        try {
            String tn = tnametf.getText();
            String tfn = tfathertf.getText();
            String tpn = tphonetf.getText();
            String te = temailtf.getText();
            String tq = tqualificationtf.getText();
            String dn = tdnamecb.getSelectedItem().toString();
            String ta = taddressta.getText();
            String tpass = new String(tpasspf.getPassword());
            if (tn.equals("") || tfn.equals("") || tpn.equals("") || te.equals("") || tq.equals("") || dn.equals("") || ta.equals("") || tpass.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter values"); 
            }else if (tpn.length()>12 || isMobileNumberValid(tpn) || ( !te.contains("@") || !te.contains("."))) {
                    JOptionPane.showMessageDialog(this, "Please enter correct values");  
            } else if (f == null) {
                JOptionPane.showMessageDialog(this, "Please choose file");
            } else {
                HttpResponse<String> res = Unirest.post("http://localhost:8999/addteachers")
                        .queryString("teachername", tn)
                        .queryString("tfathername", tfn)
                        .queryString("tphoneno", tpn)
                        .queryString("temail", te)
                        .queryString("tqualification", tq)
                        .queryString("departmentname", dn)
                        .queryString("taddress", ta)
                        .queryString("tpassword", tpass)
                        .field("tphoto", f)
                        .asString();

                if (res.getStatus() == 200) {
                    String responsetext = res.getBody();
                    if (responsetext.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Teacher added successfuly");
                        tnametf.setText("");
                        tfathertf.setText("");
                        tphonetf.setText("");
                        temailtf.setText("");
                        tqualificationtf.setText("");
                        taddressta.setText("");
                        tpasspf.setText("");
                        tphotoviewlb.setIcon(null);

                    } else {
                        JOptionPane.showMessageDialog(this, "Teacher already exist");
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_taddbtnActionPerformed

    private void tbackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbackbtnActionPerformed
        this.dispose();
        new adminhome().setVisible(true);
    }//GEN-LAST:event_tbackbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addteacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addteacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addteacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addteacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addteacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton taddbtn;
    private javax.swing.JTextArea taddressta;
    private javax.swing.JButton tbackbtn;
    private javax.swing.JButton tbrowsebtn;
    private javax.swing.JComboBox tdnamecb;
    private javax.swing.JTextField temailtf;
    private javax.swing.JTextField tfathertf;
    private javax.swing.JTextField tnametf;
    private javax.swing.JPasswordField tpasspf;
    private javax.swing.JTextField tphonetf;
    private javax.swing.JLabel tphotoviewlb;
    private javax.swing.JTextField tqualificationtf;
    // End of variables declaration//GEN-END:variables
}
