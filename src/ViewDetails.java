
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ViewDetails extends javax.swing.JFrame {

    JFileChooser chooser;
    File f;
    String aid,sid;
    String tname;
    int count;
    String file;
    String title;
    String dn,cn,sem;

    public ViewDetails(String id,String assignmentid, String tn,String departmentname, String coursename, String semester) {
        aid = assignmentid;
        tname=tn;
        sid = id;
        dn=departmentname;
        cn=coursename;
        sem=semester;
        initComponents();
        setSize(1280,766);
        setLocationRelativeTo(null);
        downloadtf.setEditable(false);
        filepathtf.setEditable(false);
        getAssignmentDetails(aid,tname);
        checkSubmission(aid,sid);
        titletf.setEditable(false);
        assigntf.setEditable(false);
        adatetf.setEditable(false);
        sdatetf.setEditable(false);
        detailtf.setEditable(false);
        statustf.setEditable(false);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    public void getAssignmentDetails(String aid, String tn) {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:8999/getcompleteassignmentdetails")
                    .queryString("aid", aid)
                    .queryString("tname", tn)
                    .asString();

            if (res.getStatus() == 200) {
                String data = res.getBody();
                StringTokenizer st = new StringTokenizer(data, ":#");
                while (st.hasMoreTokens()) {
                    String id = st.nextToken();
                    String tname = st.nextToken();
                    String courseid = st.nextToken();
                    String semester = st.nextToken();
                    title = st.nextToken();
                    String detail = st.nextToken();
                    file = st.nextToken();
                    String submissiondate = st.nextToken();
                    String assignmentdate = st.nextToken();
                    titletf.setText(title);
                    assigntf.setText(tname);
                    adatetf.setText(assignmentdate);
                    sdatetf.setText(submissiondate);
                    detailtf.setText(detail);
                    statustf.setText("Pending");
                }

            }
        }catch (Exception e) {
            e.printStackTrace();
    }

}
    
    public void checkSubmission(String aid, String sid){
        try{
            HttpResponse<String> res = Unirest.get("http://localhost:8999/checksubmission")
                        .queryString("aid", aid)
                        .queryString("sid", sid)
                        .asString();

                if (res.getStatus() == 200) {
                    String responsetext = res.getBody();
                    if (responsetext.equals("success")) {
                        smtbtn.setEnabled(false);
                        statustf.setText("Submitted");
                    } else {
                        smtbtn.setEnabled(true);
                    }

                }
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        statustf = new javax.swing.JTextField();
        titletf = new javax.swing.JTextField();
        assigntf = new javax.swing.JTextField();
        adatetf = new javax.swing.JTextField();
        sdatetf = new javax.swing.JTextField();
        detailtf = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        choosebtn = new javax.swing.JButton();
        submitbtn = new javax.swing.JButton();
        smtbtn = new javax.swing.JButton();
        filepathtf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        downloadtf = new javax.swing.JTextField();
        dwbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

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
        jButton1.setBounds(60, 630, 150, 40);
        getContentPane().add(statustf);
        statustf.setBounds(300, 500, 360, 50);
        getContentPane().add(titletf);
        titletf.setBounds(300, 130, 360, 50);

        assigntf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assigntfActionPerformed(evt);
            }
        });
        getContentPane().add(assigntf);
        assigntf.setBounds(300, 200, 360, 50);
        getContentPane().add(adatetf);
        adatetf.setBounds(300, 270, 360, 60);
        getContentPane().add(sdatetf);
        sdatetf.setBounds(300, 350, 360, 50);

        detailtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailtfActionPerformed(evt);
            }
        });
        getContentPane().add(detailtf);
        detailtf.setBounds(300, 420, 360, 60);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(null);

        choosebtn.setBackground(new java.awt.Color(102, 255, 204));
        choosebtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        choosebtn.setForeground(new java.awt.Color(0, 153, 102));
        choosebtn.setText("Choose");
        choosebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosebtnActionPerformed(evt);
            }
        });
        jPanel1.add(choosebtn);
        choosebtn.setBounds(220, 20, 133, 51);

        submitbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submitbtn.setText("Submit");
        jPanel1.add(submitbtn);
        submitbtn.setBounds(46, 497, 263, 79);

        smtbtn.setBackground(new java.awt.Color(153, 255, 153));
        smtbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        smtbtn.setForeground(new java.awt.Color(51, 102, 0));
        smtbtn.setText("Submit");
        smtbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smtbtnActionPerformed(evt);
            }
        });
        jPanel1.add(smtbtn);
        smtbtn.setBounds(60, 100, 250, 60);
        jPanel1.add(filepathtf);
        filepathtf.setBounds(10, 20, 210, 50);

        jLabel2.setText("Details:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(-340, -10, 430, 60);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(730, 490, 370, 190);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(null);
        jPanel3.add(downloadtf);
        downloadtf.setBounds(20, 20, 320, 50);

        dwbtn.setBackground(new java.awt.Color(0, 255, 204));
        dwbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        dwbtn.setForeground(new java.awt.Color(0, 102, 102));
        dwbtn.setText("Download");
        dwbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dwbtnActionPerformed(evt);
            }
        });
        jPanel3.add(dwbtn);
        dwbtn.setBounds(50, 90, 260, 60);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(730, 190, 360, 190);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/viewassignmentdetails.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1290, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dwbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dwbtnActionPerformed

            new Thread(new Runnable() {
                @Override
                public void run() {

                    FileOutputStream fos = null;
                    try {
                        String filepath = file;
                        HttpResponse<InputStream> HttpResponse = Unirest.get("http://localhost:8999/GetResource/" + filepath).asBinary();
                        StringTokenizer st = new StringTokenizer(filepath, ".");
                        String rest = st.nextToken();
                        String ext = st.nextToken();
                        String filename = title+"."+ext; 
                        downloadtf.setText(filename);
                        InputStream is = HttpResponse.getBody();
                        fos = new FileOutputStream(System.getProperty("user.home") + "/Downloads/" + filename);
                        String downloadfile = System.getProperty("user.home") + "/Downloads/" + filename;
                        long contentlength = Integer.parseInt(HttpResponse.getHeaders().getFirst("Content-Length"));
                        byte b[] = new byte[10000];
                        int r;
                        long count = 0;
                        while (true) {
                            r = is.read(b, 0, 10000);
                            fos.write(b, 0, r);
                            count = count + r;
                            int per = (int) (count * 100 / contentlength);
                            if (count == contentlength) {
                                break;
                            }
                        }
                        fos.close();
                        JOptionPane.showMessageDialog(ViewDetails.this, "file downloaded");
                        Desktop.getDesktop().open(new File(downloadfile));
                    } catch (Exception ex) {
                        Logger.getLogger(ViewDetails.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            fos.close();
                        } catch (IOException ex) {
                            Logger.getLogger(ViewDetails.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

            }).start();

        
    }//GEN-LAST:event_dwbtnActionPerformed

    private void choosebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosebtnActionPerformed
        chooser = new JFileChooser();
        int r = chooser.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            f = chooser.getSelectedFile();
            filepathtf.setText(f.getName());
        }
    }//GEN-LAST:event_choosebtnActionPerformed

    private void smtbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smtbtnActionPerformed
        try {
            if (f == null) {
                JOptionPane.showMessageDialog(this, "Please choose file");
            } else {
                LocalDate date = LocalDate.now();
                HttpResponse<String> res = Unirest.post("http://localhost:8999/submitassignments")
                        .queryString("aid", aid)
                        .queryString("sid", sid)
                        .queryString("date",date)
                        .field("file", f)
                        .asString();

                if (res.getStatus() == 200) {
                    String responsetext = res.getBody();
                    if (responsetext.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Assignment submitted successfuly");
                        checkSubmission(aid,sid);
                        statustf.setText("Submitted");

                    } else {
                        JOptionPane.showMessageDialog(this, "Submission Failed");
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_smtbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new ViewAssignments(sid, dn, cn, sem).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void detailtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailtfActionPerformed

    private void assigntfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assigntfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assigntfActionPerformed

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
            java.util.logging.Logger.getLogger(ViewDetails.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDetails.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDetails.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDetails.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ViewDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adatetf;
    private javax.swing.JTextField assigntf;
    private javax.swing.JButton choosebtn;
    private javax.swing.JTextField detailtf;
    private javax.swing.JTextField downloadtf;
    private javax.swing.JButton dwbtn;
    private javax.swing.JTextField filepathtf;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField sdatetf;
    private javax.swing.JButton smtbtn;
    private javax.swing.JTextField statustf;
    private javax.swing.JButton submitbtn;
    private javax.swing.JTextField titletf;
    // End of variables declaration//GEN-END:variables
}
