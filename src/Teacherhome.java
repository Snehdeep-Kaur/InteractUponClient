
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Teacherhome extends javax.swing.JFrame {

    String photo;
    String id;
    String department;
    
    public Teacherhome(String tid) {
        id = tid;
        initComponents();
        setSize(1280,766);
        setResizable(false);
        getProfile(tid);
        setLocationRelativeTo(null);
        
    }

    public void getProfile(String teacherid) {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:8999/getTeacherProfile")
                    .queryString("teacherid", teacherid)
                    .asString();

            if (res.getStatus() == 200) {
                String data = res.getBody();
                StringTokenizer st = new StringTokenizer(data, ":#");
                while (st.hasMoreTokens()) {
                    String tid = st.nextToken();
                    String tname = st.nextToken();
                    String phoneno = st.nextToken();
                    String email = st.nextToken();
                    String qualification = st.nextToken();
                    String dept = st.nextToken();
                    department = dept;
                    String address = st.nextToken();
                    photo = st.nextToken();
                    tidlb.setText("Teacher ID:  "+tid);
                    namelb.setText("Name: "+tname);
                    phnlb.setText("Phone No:  "+phoneno);
                    emaillb.setText("Email:  "+email);
                    quallb.setText("Qualification:  "+qualification);
                    departmentlb.setText("Department:  "+dept);
                    addresslb.setText("Address:  "+address);
                    //welcomelbl.setText("Welcome!!!  "+tname);
                    putPicture();
                    
                }
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profilepanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        photoviewlb = new javax.swing.JLabel();
        tidlb = new javax.swing.JLabel();
        namelb = new javax.swing.JLabel();
        phnlb = new javax.swing.JLabel();
        emaillb = new javax.swing.JLabel();
        quallb = new javax.swing.JLabel();
        departmentlb = new javax.swing.JLabel();
        addresslb = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cpbtn = new javax.swing.JButton();
        uabtn = new javax.swing.JButton();
        mgassbtn = new javax.swing.JButton();
        pnbtn = new javax.swing.JButton();
        addnotesbtn = new javax.swing.JButton();
        mngnotesbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        profilepanel.setBackground(new java.awt.Color(51, 51, 51));
        profilepanel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Teacher Profile");
        profilepanel.add(jLabel1);
        jLabel1.setBounds(10, 20, 190, 28);

        photoviewlb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        profilepanel.add(photoviewlb);
        photoviewlb.setBounds(10, 110, 340, 300);

        tidlb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tidlb.setForeground(new java.awt.Color(255, 255, 255));
        tidlb.setText("Teacher ID:");
        profilepanel.add(tidlb);
        tidlb.setBounds(360, 110, 560, 50);

        namelb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        namelb.setForeground(new java.awt.Color(255, 255, 255));
        namelb.setText("Name:");
        profilepanel.add(namelb);
        namelb.setBounds(360, 160, 550, 30);

        phnlb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        phnlb.setForeground(new java.awt.Color(255, 255, 255));
        phnlb.setText("Phone No:");
        profilepanel.add(phnlb);
        phnlb.setBounds(360, 200, 540, 30);

        emaillb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        emaillb.setForeground(new java.awt.Color(255, 255, 255));
        emaillb.setText("Email:");
        profilepanel.add(emaillb);
        emaillb.setBounds(360, 240, 540, 40);

        quallb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        quallb.setForeground(new java.awt.Color(255, 255, 255));
        quallb.setText("Qualification:");
        profilepanel.add(quallb);
        quallb.setBounds(360, 280, 530, 30);

        departmentlb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        departmentlb.setForeground(new java.awt.Color(255, 255, 255));
        departmentlb.setText("Department:");
        profilepanel.add(departmentlb);
        departmentlb.setBounds(360, 320, 530, 30);

        addresslb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        addresslb.setForeground(new java.awt.Color(255, 255, 255));
        addresslb.setText("Address:");
        profilepanel.add(addresslb);
        addresslb.setBounds(360, 360, 560, 40);

        getContentPane().add(profilepanel);
        profilepanel.setBounds(20, 80, 830, 610);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(940, 650, 250, 50);

        cpbtn.setBackground(new java.awt.Color(0, 255, 204));
        cpbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cpbtn.setForeground(new java.awt.Color(0, 0, 102));
        cpbtn.setText("Change Password");
        cpbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpbtnActionPerformed(evt);
            }
        });
        getContentPane().add(cpbtn);
        cpbtn.setBounds(920, 170, 280, 50);

        uabtn.setBackground(new java.awt.Color(0, 255, 204));
        uabtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        uabtn.setForeground(new java.awt.Color(0, 0, 102));
        uabtn.setText("Upload Assignment");
        uabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uabtnActionPerformed(evt);
            }
        });
        getContentPane().add(uabtn);
        uabtn.setBounds(920, 250, 280, 40);

        mgassbtn.setBackground(new java.awt.Color(0, 255, 204));
        mgassbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        mgassbtn.setForeground(new java.awt.Color(0, 0, 102));
        mgassbtn.setText("Manage Uploaded Assignments");
        mgassbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mgassbtnActionPerformed(evt);
            }
        });
        getContentPane().add(mgassbtn);
        mgassbtn.setBounds(920, 320, 280, 50);

        pnbtn.setBackground(new java.awt.Color(0, 255, 204));
        pnbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        pnbtn.setForeground(new java.awt.Color(0, 0, 102));
        pnbtn.setText("Post Notifications");
        pnbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnbtnActionPerformed(evt);
            }
        });
        getContentPane().add(pnbtn);
        pnbtn.setBounds(920, 400, 280, 40);

        addnotesbtn.setBackground(new java.awt.Color(0, 255, 204));
        addnotesbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        addnotesbtn.setForeground(new java.awt.Color(0, 0, 102));
        addnotesbtn.setText("Upload Notes");
        addnotesbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnotesbtnActionPerformed(evt);
            }
        });
        getContentPane().add(addnotesbtn);
        addnotesbtn.setBounds(920, 470, 280, 50);

        mngnotesbtn.setBackground(new java.awt.Color(0, 255, 204));
        mngnotesbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        mngnotesbtn.setForeground(new java.awt.Color(0, 0, 102));
        mngnotesbtn.setText("Manage Notes");
        mngnotesbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngnotesbtnActionPerformed(evt);
            }
        });
        getContentPane().add(mngnotesbtn);
        mngnotesbtn.setBounds(920, 550, 280, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/teacherHome.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cpbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpbtnActionPerformed
        this.dispose();
        new TeacherChangePassword(id).setVisible(true);
    }//GEN-LAST:event_cpbtnActionPerformed

    private void uabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uabtnActionPerformed
        this.dispose();
        new TeacherUploadAssignment(id,department).setVisible(true);
    }//GEN-LAST:event_uabtnActionPerformed

    private void mgassbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mgassbtnActionPerformed
        this.dispose();
        new ManageUploadedAssignments(department, id).setVisible(true);
    }//GEN-LAST:event_mgassbtnActionPerformed

    private void pnbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnbtnActionPerformed
        this.dispose();
        new PostNotifications(id,department).setVisible(true);
    }//GEN-LAST:event_pnbtnActionPerformed

    private void addnotesbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnotesbtnActionPerformed
        this.dispose();
        new AddNotes(id,department).setVisible(true);
    }//GEN-LAST:event_addnotesbtnActionPerformed

    private void mngnotesbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngnotesbtnActionPerformed
        this.dispose();
        new ManageNotes(department, id).setVisible(true);
    }//GEN-LAST:event_mngnotesbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new mainpage().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    public void putPicture(){
        try {
                photoviewlb.setSize(300,300);
                URL uri = new URL("http://localhost:8999/GetResource/" + photo);
                BufferedImage bimg = ImageIO.read(uri);
                Image img = bimg.getScaledInstance(photoviewlb.getWidth(), photoviewlb.getHeight(), Image.SCALE_SMOOTH);
                photoviewlb.setIcon(new ImageIcon(img));
               
            } catch (Exception e) {
                e.printStackTrace();
            }
        
    }
    
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
            java.util.logging.Logger.getLogger(Teacherhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teacherhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teacherhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teacherhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Teacherhome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addnotesbtn;
    private javax.swing.JLabel addresslb;
    private javax.swing.JButton cpbtn;
    private javax.swing.JLabel departmentlb;
    private javax.swing.JLabel emaillb;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton mgassbtn;
    private javax.swing.JButton mngnotesbtn;
    private javax.swing.JLabel namelb;
    private javax.swing.JLabel phnlb;
    private javax.swing.JLabel photoviewlb;
    private javax.swing.JButton pnbtn;
    private javax.swing.JPanel profilepanel;
    private javax.swing.JLabel quallb;
    private javax.swing.JLabel tidlb;
    private javax.swing.JButton uabtn;
    // End of variables declaration//GEN-END:variables
}
