
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class studenthome extends javax.swing.JFrame {
    String id;
    String photo;
    String department;
    String c,s;

    
    public studenthome(String sid) {
        id = sid;
        initComponents();
        setSize(1280,766);
        setResizable(false);
        getProfile(sid);
        setLocationRelativeTo(null);
    }


    public void getProfile(String studentid) {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:8999/getStudentProfile")
                    .queryString("studentid", studentid)
                    .asString();

            if (res.getStatus() == 200) {
                String data = res.getBody();
                System.out.println(data);
                StringTokenizer st = new StringTokenizer(data, ":#");
                while (st.hasMoreTokens()) {
                    String sid = st.nextToken();
                    String rollno = st.nextToken();
                    String sname = st.nextToken();
                    String sfname = st.nextToken();
                    String dob = st.nextToken();
                    String phoneno = st.nextToken();
                    String email = st.nextToken();
                    String dept = st.nextToken();
                    String course = st.nextToken();
                    String semester = st.nextToken();
                    department = dept;
                    c = course;
                    s = semester;
                    String address = st.nextToken();
                    photo = st.nextToken();
                    sidlb.setText("Student ID:  "+sid);
                    srolllb.setText("Roll no:  "+rollno);
                    namelb.setText("Name: "+sname);
                    fnamelb.setText("Father's Name: "+sfname);
                    doblb.setText("DOB: "+dob);
                    phnlb.setText("Phone No:  "+phoneno);
                    emaillb.setText("Email:  "+email);
                    departmentlb.setText("Department:  "+dept);
                    courselb.setText("Course:  "+course);
                    semlb.setText("Semester:  "+semester);
                    addresslb.setText("Address:  "+address);
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

        jPanel1 = new javax.swing.JPanel();
        photoviewlb = new javax.swing.JLabel();
        departmentlb = new javax.swing.JLabel();
        addresslb = new javax.swing.JLabel();
        sidlb = new javax.swing.JLabel();
        fnamelb = new javax.swing.JLabel();
        srolllb = new javax.swing.JLabel();
        namelb = new javax.swing.JLabel();
        phnlb = new javax.swing.JLabel();
        emaillb = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        courselb = new javax.swing.JLabel();
        semlb = new javax.swing.JLabel();
        doblb = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        changepassbtn = new javax.swing.JButton();
        vabtn1 = new javax.swing.JButton();
        vnbtn = new javax.swing.JButton();
        ViewNotesbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(null);

        photoviewlb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(photoviewlb);
        photoviewlb.setBounds(530, 30, 260, 230);

        departmentlb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        departmentlb.setForeground(new java.awt.Color(255, 255, 255));
        departmentlb.setText("Department");
        jPanel1.add(departmentlb);
        departmentlb.setBounds(30, 460, 530, 40);

        addresslb.setText("Address");
        jPanel1.add(addresslb);
        addresslb.setBounds(30, 610, 530, 40);

        sidlb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sidlb.setForeground(new java.awt.Color(255, 255, 255));
        sidlb.setText("Student ID");
        jPanel1.add(sidlb);
        sidlb.setBounds(30, 110, 530, 40);

        fnamelb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        fnamelb.setForeground(new java.awt.Color(255, 255, 255));
        fnamelb.setText("Father's Name");
        jPanel1.add(fnamelb);
        fnamelb.setBounds(30, 260, 530, 40);

        srolllb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        srolllb.setForeground(new java.awt.Color(255, 255, 255));
        srolllb.setText("Roll no");
        jPanel1.add(srolllb);
        srolllb.setBounds(30, 160, 530, 40);

        namelb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        namelb.setForeground(new java.awt.Color(255, 255, 255));
        namelb.setText("Name");
        jPanel1.add(namelb);
        namelb.setBounds(30, 210, 530, 40);

        phnlb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        phnlb.setForeground(new java.awt.Color(255, 255, 255));
        phnlb.setText("Phone no");
        jPanel1.add(phnlb);
        phnlb.setBounds(30, 360, 530, 40);

        emaillb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        emaillb.setForeground(new java.awt.Color(255, 255, 255));
        emaillb.setText("E-mail");
        jPanel1.add(emaillb);
        emaillb.setBounds(30, 410, 530, 40);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Student Profile");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(50, 30, 430, 30);

        courselb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        courselb.setForeground(new java.awt.Color(255, 255, 255));
        courselb.setText("Course");
        jPanel1.add(courselb);
        courselb.setBounds(30, 510, 530, 40);

        semlb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        semlb.setForeground(new java.awt.Color(255, 255, 255));
        semlb.setText("Semester");
        jPanel1.add(semlb);
        semlb.setBounds(30, 560, 530, 40);

        doblb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        doblb.setForeground(new java.awt.Color(255, 255, 255));
        doblb.setText("DOB");
        jPanel1.add(doblb);
        doblb.setBounds(30, 310, 570, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 80, 820, 620);

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
        jButton1.setBounds(980, 650, 190, 50);

        changepassbtn.setBackground(new java.awt.Color(153, 255, 0));
        changepassbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        changepassbtn.setForeground(new java.awt.Color(102, 0, 0));
        changepassbtn.setText("Change Password");
        changepassbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changepassbtnActionPerformed(evt);
            }
        });
        getContentPane().add(changepassbtn);
        changepassbtn.setBounds(930, 210, 260, 50);

        vabtn1.setBackground(new java.awt.Color(0, 0, 153));
        vabtn1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        vabtn1.setForeground(new java.awt.Color(102, 255, 255));
        vabtn1.setText("View Assignments");
        vabtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vabtn1ActionPerformed(evt);
            }
        });
        getContentPane().add(vabtn1);
        vabtn1.setBounds(930, 320, 260, 50);

        vnbtn.setBackground(new java.awt.Color(255, 153, 153));
        vnbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        vnbtn.setForeground(new java.awt.Color(51, 0, 102));
        vnbtn.setText("View Notifications");
        vnbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vnbtnActionPerformed(evt);
            }
        });
        getContentPane().add(vnbtn);
        vnbtn.setBounds(930, 430, 260, 50);

        ViewNotesbtn.setBackground(new java.awt.Color(153, 51, 0));
        ViewNotesbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ViewNotesbtn.setForeground(new java.awt.Color(255, 255, 102));
        ViewNotesbtn.setText("View Notes");
        ViewNotesbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewNotesbtnActionPerformed(evt);
            }
        });
        getContentPane().add(ViewNotesbtn);
        ViewNotesbtn.setBounds(930, 540, 260, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/studentHome.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changepassbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changepassbtnActionPerformed
        this.dispose();  
        new StudentChangePassword(id).setVisible(true);
    }//GEN-LAST:event_changepassbtnActionPerformed

    private void vabtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vabtn1ActionPerformed
        this.dispose();
        new ViewAssignments(id,department,c,s).setVisible(true);
    }//GEN-LAST:event_vabtn1ActionPerformed

    private void vnbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vnbtnActionPerformed
        this.dispose();
        new  StudentViewNotifications(id,department,c,s).setVisible(true);
    }//GEN-LAST:event_vnbtnActionPerformed

    private void ViewNotesbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewNotesbtnActionPerformed
        this.dispose();
        new ViewNotes(id,department,c,s).setVisible(true);
    }//GEN-LAST:event_ViewNotesbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new mainpage().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(studenthome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studenthome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studenthome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studenthome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new studenthome().setVisible(true);
            }
        });
    }
    
    public void putPicture(){
        try {
                photoviewlb.setSize(250,250);
                URL uri = new URL("http://localhost:8999/GetResource/" + photo);
                BufferedImage bimg = ImageIO.read(uri);
                Image img = bimg.getScaledInstance(photoviewlb.getWidth(), photoviewlb.getHeight(), Image.SCALE_SMOOTH);
                photoviewlb.setIcon(new ImageIcon(img));
               
            } catch (Exception e) {
                e.printStackTrace();
            }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ViewNotesbtn;
    private javax.swing.JLabel addresslb;
    private javax.swing.JButton changepassbtn;
    private javax.swing.JLabel courselb;
    private javax.swing.JLabel departmentlb;
    private javax.swing.JLabel doblb;
    private javax.swing.JLabel emaillb;
    private javax.swing.JLabel fnamelb;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel namelb;
    private javax.swing.JLabel phnlb;
    private javax.swing.JLabel photoviewlb;
    private javax.swing.JLabel semlb;
    private javax.swing.JLabel sidlb;
    private javax.swing.JLabel srolllb;
    private javax.swing.JButton vabtn1;
    private javax.swing.JButton vnbtn;
    // End of variables declaration//GEN-END:variables
}
