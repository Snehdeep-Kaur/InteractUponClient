
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
public class ViewNotesDetails extends javax.swing.JFrame {

    String noteid,sid;
    String tname;
    String title;
    String file;
    String dn, cn, sem;
    
    
    public ViewNotesDetails(String id, String nid, String tn,String departmentname, String coursename, String semester) {
        initComponents();
        tname=tn;
        sid = id;
        noteid = nid;
        dn=departmentname;
        cn=coursename;
        sem=semester;
        setSize(1280,760);
        titletf.setEditable(false);
        postedbytf.setEditable(false);
        postedontf.setEditable(false);
        detailstf.setEditable(false);
        getNotesDetails(noteid, tname);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        downbtn = new javax.swing.JButton();
        photolb = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        detailstf = new javax.swing.JTextField();
        titletf = new javax.swing.JTextField();
        postedbytf = new javax.swing.JTextField();
        postedontf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        downbtn.setBackground(new java.awt.Color(0, 255, 204));
        downbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        downbtn.setForeground(new java.awt.Color(0, 0, 204));
        downbtn.setText("Download");
        downbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downbtnActionPerformed(evt);
            }
        });
        getContentPane().add(downbtn);
        downbtn.setBounds(440, 560, 210, 70);

        photolb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(photolb);
        photolb.setBounds(720, 140, 430, 420);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(110, 560, 180, 70);
        getContentPane().add(detailstf);
        detailstf.setBounds(220, 460, 350, 50);
        getContentPane().add(titletf);
        titletf.setBounds(220, 170, 350, 50);

        postedbytf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postedbytfActionPerformed(evt);
            }
        });
        getContentPane().add(postedbytf);
        postedbytf.setBounds(220, 260, 350, 50);

        postedontf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postedontfActionPerformed(evt);
            }
        });
        getContentPane().add(postedontf);
        postedontf.setBounds(220, 360, 350, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/NOTES DETAILS student.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void downbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downbtnActionPerformed
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
                        JOptionPane.showMessageDialog(ViewNotesDetails.this, "File downloaded Successfully");
                        Desktop.getDesktop().open(new File(downloadfile));
                    } catch (Exception ex) {
                        Logger.getLogger(ViewNotesDetails.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            fos.close();
                        } catch (IOException ex) {
                            Logger.getLogger(ViewNotesDetails.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

            }).start();
    }//GEN-LAST:event_downbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new ViewNotes(sid, dn, cn, sem).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void postedbytfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postedbytfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_postedbytfActionPerformed

    private void postedontfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postedontfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_postedontfActionPerformed

    public void getNotesDetails(String noteid, String tname) {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:8999/getcompletenotesdetails")
                    .queryString("noteid", noteid)
                    .queryString("tname", tname)
                    .asString();

            if (res.getStatus() == 200) {
                String data = res.getBody();
                StringTokenizer st = new StringTokenizer(data, ":#");
                while (st.hasMoreTokens()) {
                    String tl = st.nextToken();
                    title = tl;
                    String tn = st.nextToken();
                    String date = st.nextToken();
                    String detail = st.nextToken();
                    file = st.nextToken();
                    titletf.setText(tl);
                    postedbytf.setText(tn);
                    postedontf.setText(date);
                    detailstf.setText(detail);
                    putPicture();
                }

            }
        }catch (Exception e) {
            e.printStackTrace();
    }

}
    public void putPicture(){
        try {
            String rest ="";
            String extension="";
            String imgpath = "";    
            String path = file;
                StringTokenizer pt = new StringTokenizer(path, ".");
                while (pt.hasMoreTokens()) {
                    rest = pt.nextToken();
                    extension = pt.nextToken();
                }
                extension = extension.toLowerCase();
                if (extension.equals("pdf")) {
                    imgpath = "D:\\IndustrialTraining1\\pdf icon.jpg";
                } else if (extension.equals("docx")) {
                    imgpath = "D:\\IndustrialTraining1\\docx icon.png";
                } else if (extension.equals("mp3")){
                    imgpath = "D:\\IndustrialTraining1\\audio icon.jpg";
                } else if (extension.equals("mp4")){
                    imgpath ="D:\\IndustrialTraining1\\video icon.jpg";
                }
                photolb.setSize(200,190);
                ImageIcon ic = new ImageIcon(imgpath);
                Image image = ic.getImage();
                Image img = image.getScaledInstance(200, 190, Image.SCALE_SMOOTH);
                photolb.setIcon(new ImageIcon(img));

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
            java.util.logging.Logger.getLogger(ViewNotesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewNotesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewNotesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewNotesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ViewNotesDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField detailstf;
    private javax.swing.JButton downbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel photolb;
    private javax.swing.JTextField postedbytf;
    private javax.swing.JTextField postedontf;
    private javax.swing.JTextField titletf;
    // End of variables declaration//GEN-END:variables
}
