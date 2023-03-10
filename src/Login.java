
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Color;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setSize(1286, 750);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        Adusername = new javax.swing.JTextField();
        AdPassword = new javax.swing.JPasswordField();
        AdLoginbtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        fplbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jTextField2.setBackground(new java.awt.Color(0, 51, 153));
        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Adusername.setBackground(new java.awt.Color(0, 0, 0));
        Adusername.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Adusername.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Adusername);
        Adusername.setBounds(230, 280, 330, 50);

        AdPassword.setBackground(new java.awt.Color(0, 0, 0));
        AdPassword.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        AdPassword.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(AdPassword);
        AdPassword.setBounds(230, 370, 330, 50);

        AdLoginbtn.setBackground(new java.awt.Color(51, 255, 255));
        AdLoginbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        AdLoginbtn.setForeground(new java.awt.Color(0, 102, 102));
        AdLoginbtn.setText("Login");
        AdLoginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdLoginbtnActionPerformed(evt);
            }
        });
        getContentPane().add(AdLoginbtn);
        AdLoginbtn.setBounds(350, 530, 149, 46);

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(140, 530, 142, 46);

        fplbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fplbl.setForeground(new java.awt.Color(255, 51, 0));
        fplbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fplblMouseClicked(evt);
            }
        });
        getContentPane().add(fplbl);
        fplbl.setBounds(170, 440, 340, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/AdminLogin.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fplblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fplblMouseClicked
        new ForgotPasswordAdmin().setVisible(true);
    }//GEN-LAST:event_fplblMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        new mainpage().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void AdLoginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdLoginbtnActionPerformed
        try {

            String username = Adusername.getText();
            String password = new String(AdPassword.getPassword());

            if (username.equals("") || password.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter values");
            } else {
                HttpResponse<String> res = Unirest.get("http://localhost:8999/Adminlogin")
                .queryString("username", username)
                .queryString("password", password)
                .asString();
                if (res.getStatus() == 200) {
                    String responsetext = res.getBody();
                    if (responsetext.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Login Successful");
                        new adminhome().setVisible(true);
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid username/password");

                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_AdLoginbtnActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdLoginbtn;
    private javax.swing.JPasswordField AdPassword;
    private javax.swing.JTextField Adusername;
    private javax.swing.JLabel fplbl;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
