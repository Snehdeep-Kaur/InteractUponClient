
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Color;
import javax.swing.JOptionPane;


public class StudentLogin extends javax.swing.JFrame {

   
    public StudentLogin() {
        initComponents();
        setSize(1286,750);
        setResizable(false);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        susertf = new javax.swing.JTextField();
        spasspf = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        loginbtn = new javax.swing.JButton();
        fplbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        susertf.setBackground(new java.awt.Color(0, 0, 0));
        susertf.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        susertf.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(susertf);
        susertf.setBounds(210, 280, 350, 50);

        spasspf.setBackground(new java.awt.Color(0, 0, 0));
        spasspf.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        spasspf.setForeground(new java.awt.Color(255, 255, 255));
        spasspf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spasspfActionPerformed(evt);
            }
        });
        getContentPane().add(spasspf);
        spasspf.setBounds(210, 360, 350, 50);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(110, 520, 180, 60);

        loginbtn.setBackground(new java.awt.Color(51, 255, 255));
        loginbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        loginbtn.setForeground(new java.awt.Color(0, 102, 102));
        loginbtn.setText("Login");
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });
        getContentPane().add(loginbtn);
        loginbtn.setBounds(340, 520, 180, 60);

        fplbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fplbl.setForeground(new java.awt.Color(255, 51, 0));
        fplbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fplblMouseClicked(evt);
            }
        });
        getContentPane().add(fplbl);
        fplbl.setBounds(170, 440, 330, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/StudentLogin.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
         try {
            String studentid = susertf.getText();
            String password = new String(spasspf.getPassword());

            if (studentid.equals("") || password.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter values");
            } else {
                HttpResponse<String> res = Unirest.get("http://localhost:8999/Studentlogin")
                        .queryString("studentid", studentid)
                        .queryString("password", password)
                        .asString();
                if (res.getStatus() == 200) {
                    String responsetext = res.getBody();
                    System.out.println(responsetext);
                    if (responsetext.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Login Successful");
                        System.out.println(studentid);
                        new studenthome(studentid).setVisible(true);
                        this.dispose();

                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid studentid/password");

                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_loginbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new mainpage().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fplblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fplblMouseClicked
       fplbl.setForeground(Color.blue);
       new ForgotPassword().setVisible(true);
    }//GEN-LAST:event_fplblMouseClicked

    private void spasspfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spasspfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spasspfActionPerformed

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
            java.util.logging.Logger.getLogger(StudentLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fplbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loginbtn;
    private javax.swing.JPasswordField spasspf;
    private javax.swing.JTextField susertf;
    // End of variables declaration//GEN-END:variables
}
