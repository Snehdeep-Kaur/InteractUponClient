
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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
public class TeacherUploadAssignment extends javax.swing.JFrame {

    String department;
    String tid;
    String cn;
    JFileChooser chooser;
    File f;

    public TeacherUploadAssignment(String id,String dept) {
        department = dept;
        tid =id;
        initComponents();
        setSize(1280,766);
        getCoursenames(department);
        filepathtf.setEditable(false);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void getCoursenames(String dn) {
        try {

            HttpResponse<String> res = Unirest.get("http://localhost:8999/getcoursenames")
                    .queryString("departmentname", dn)
                    .asString();

            coursecb.removeAllItems();
            //coursecb.addItem("All");

            if (res.getStatus() == 200) {
                String data = res.getBody();
                System.out.println(data);
                StringTokenizer st = new StringTokenizer(data, ":&");
                while (st.hasMoreTokens()) {

                    String coursename = st.nextToken();
                    coursecb.addItem(coursename);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSemester(String dn, String cn) {
        try {

            HttpResponse<String> res = Unirest.get("http://localhost:8999/getsemesters")
                    .queryString("departmentname", dn)
                    .queryString("coursename", cn)
                    .asString();

            semcb.removeAllItems();
            //coursecb.addItem("All");

            if (res.getStatus() == 200) {
                String data = res.getBody();
                System.out.println(data);
                StringTokenizer st = new StringTokenizer(data, ":&");
                while (st.hasMoreTokens()) {
                    String semester = st.nextToken();
                    semcb.addItem(semester);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        semcb = new javax.swing.JComboBox();
        coursecb = new javax.swing.JComboBox();
        titletf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailsta = new javax.swing.JTextArea();
        addbtn = new javax.swing.JButton();
        filepathtf = new javax.swing.JTextField();
        choosebtn = new javax.swing.JButton();
        subdate = new com.toedter.calendar.JDateChooser();
        backbtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        semcb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        semcb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                semcbItemStateChanged(evt);
            }
        });
        getContentPane().add(semcb);
        semcb.setBounds(240, 180, 320, 40);

        coursecb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        coursecb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                coursecbItemStateChanged(evt);
            }
        });
        getContentPane().add(coursecb);
        coursecb.setBounds(240, 120, 320, 40);
        getContentPane().add(titletf);
        titletf.setBounds(240, 240, 320, 40);

        detailsta.setColumns(20);
        detailsta.setRows(5);
        jScrollPane1.setViewportView(detailsta);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(240, 320, 320, 90);

        addbtn.setBackground(new java.awt.Color(0, 0, 153));
        addbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        addbtn.setForeground(new java.awt.Color(255, 255, 255));
        addbtn.setText("Add");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });
        getContentPane().add(addbtn);
        addbtn.setBounds(510, 620, 140, 50);

        filepathtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filepathtfActionPerformed(evt);
            }
        });
        getContentPane().add(filepathtf);
        filepathtf.setBounds(240, 450, 200, 40);

        choosebtn.setBackground(new java.awt.Color(102, 255, 153));
        choosebtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        choosebtn.setForeground(new java.awt.Color(102, 153, 0));
        choosebtn.setText("Choose");
        choosebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosebtnActionPerformed(evt);
            }
        });
        getContentPane().add(choosebtn);
        choosebtn.setBounds(440, 450, 120, 40);
        getContentPane().add(subdate);
        subdate.setBounds(240, 520, 320, 40);

        backbtn.setBackground(new java.awt.Color(255, 0, 0));
        backbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        backbtn.setForeground(new java.awt.Color(255, 255, 255));
        backbtn.setText("Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        getContentPane().add(backbtn);
        backbtn.setBounds(170, 620, 140, 50);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/uploadassignments.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void coursecbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_coursecbItemStateChanged
        cn = evt.getItem().toString();
        getSemester(department, cn);
    }//GEN-LAST:event_coursecbItemStateChanged

    private void semcbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_semcbItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_semcbItemStateChanged

    private void choosebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosebtnActionPerformed
        chooser = new JFileChooser();
        int r = chooser.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            f = chooser.getSelectedFile();
            filepathtf.setText(f.getName());
        }
    }//GEN-LAST:event_choosebtnActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        try{
            cn = coursecb.getSelectedItem().toString();
            String sem = semcb.getSelectedItem().toString();
            System.out.println(sem);
            String title = titletf.getText();
            String details = detailsta.getText();
            SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
            String sd = dcn.format(subdate.getDate());
            LocalDate datenow = LocalDate.now();
            
            if (cn.equals("") || sem.equals("") || title.equals("") || details.equals("") || sd.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter values");
            } else if (f == null) {
                JOptionPane.showMessageDialog(this, "Please choose file");
            } else {
                HttpResponse<String> res = Unirest.post("http://localhost:8999/uploadassignment")
                        .queryString("tid", tid)
                        .queryString("departmentname", department)
                        .queryString("coursename", cn)
                        .queryString("semester", sem)
                        .queryString("title", title)
                        .queryString("detail", details)
                        .queryString("submissiondate",sd)
                        .queryString("assignmentdate",datenow)
                        .field("file", f)
                        .asString();

                if (res.getStatus() == 200) {
                    String responsetext = res.getBody();
                    System.out.println(responsetext + "   hello");
                    if (responsetext.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Assignment uploaded successfuly");
                        titletf.setText("");
                        detailsta.setText("");
                        filepathtf.setText("");
                    } else {
                        JOptionPane.showMessageDialog(this, "Upload failed");
                    }

                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_addbtnActionPerformed

    private void filepathtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filepathtfActionPerformed
        
    }//GEN-LAST:event_filepathtfActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        this.dispose();
        new Teacherhome(tid).setVisible(true);
    }//GEN-LAST:event_backbtnActionPerformed
    
    
    

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
            java.util.logging.Logger.getLogger(TeacherUploadAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherUploadAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherUploadAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherUploadAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TeacherUploadAssignment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JButton backbtn;
    private javax.swing.JButton choosebtn;
    private javax.swing.JComboBox coursecb;
    private javax.swing.JTextArea detailsta;
    private javax.swing.JTextField filepathtf;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox semcb;
    private com.toedter.calendar.JDateChooser subdate;
    private javax.swing.JTextField titletf;
    // End of variables declaration//GEN-END:variables
}
