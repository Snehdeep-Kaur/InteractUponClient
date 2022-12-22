
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;
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
public class PostNotifications extends javax.swing.JFrame {
    
    
    String cn;
    String department;
    String teacherid;
    String sem;
    
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
                    .queryString("semester", sem)
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
    
    public void getNotifications(String tid) {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:8999/getallnotifications")
                    .queryString("tid", tid)
                    .queryString("coursename", cn)
                    .queryString("semester",sem)
                    .queryString("departmentname",department)
                    .asString();

            if (res.getStatus() == 200) {
                vnpnl.removeAll();
                String data = res.getBody();
                System.out.println(data);
                StringTokenizer st = new StringTokenizer(data, "&&");
                int y = 10;
                while (st.hasMoreTokens()) {
                    Messages obj = new Messages();
                    obj.setBounds(10, y, 750, 145);
                    vnpnl.add(obj);
                    String messages = st.nextToken();
                    StringTokenizer st1 = new StringTokenizer(messages, "###");
                    while (st1.hasMoreTokens()) {
                        String msg = st1.nextToken();
                        String tname = st1.nextToken();
                        String time = st1.nextToken();
                        String date = st1.nextToken();
                        obj.msgta.setText(msg);
                        obj.namelb.setText("~"+ tname);
                        obj.timelb.setText(time);
                        obj.dtlb.setText(date);
                    }
                    y = y + 155;
                }
                
                vnpnl.setPreferredSize(new Dimension(jScrollPane3.getWidth()-20,100+y));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public PostNotifications(String tid, String dn) {
        initComponents();
        teacherid = tid;
        department = dn;
        setSize(1280,766);
        getNotifications(teacherid);
        getCoursenames(department);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        semcb = new javax.swing.JComboBox();
        coursecb = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        notita = new javax.swing.JTextArea();
        postbtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        vnpnl = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        semcb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        semcb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                semcbItemStateChanged(evt);
            }
        });
        getContentPane().add(semcb);
        semcb.setBounds(660, 130, 340, 51);

        coursecb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        coursecb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                coursecbItemStateChanged(evt);
            }
        });
        getContentPane().add(coursecb);
        coursecb.setBounds(150, 130, 350, 51);

        notita.setColumns(20);
        notita.setRows(5);
        jScrollPane2.setViewportView(notita);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(40, 570, 960, 120);

        postbtn.setBackground(new java.awt.Color(0, 255, 51));
        postbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        postbtn.setForeground(new java.awt.Color(102, 0, 153));
        postbtn.setText("Post");
        postbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postbtnActionPerformed(evt);
            }
        });
        getContentPane().add(postbtn);
        postbtn.setBounds(1030, 570, 190, 50);

        javax.swing.GroupLayout vnpnlLayout = new javax.swing.GroupLayout(vnpnl);
        vnpnl.setLayout(vnpnlLayout);
        vnpnlLayout.setHorizontalGroup(
            vnpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1137, Short.MAX_VALUE)
        );
        vnpnlLayout.setVerticalGroup(
            vnpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(vnpnl);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(50, 200, 1160, 300);

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
        jButton1.setBounds(1030, 640, 190, 50);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/postNotification.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void postbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postbtnActionPerformed
        try {
            String msg = notita.getText();
            if (msg.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter a message");
            } else {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH.mm");
                LocalDate date = LocalDate.now();
                LocalTime time = LocalTime.now();
                String t = time.format(dtf);
                HttpResponse<String> res = Unirest.get("http://localhost:8999/postnotification")
                        .queryString("coursename", cn)
                        .queryString("departmentname", department)
                        .queryString("semester", sem)
                        .queryString("tid", teacherid)
                        .queryString("message", msg)
                        .queryString("date", date)
                        .queryString("time", t)
                        .asString();

                if (res.getStatus() == 200) {
                    String responsetext = res.getBody();
                    if (responsetext.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Notification posted successfuly");
                        getNotifications(teacherid);
                        notita.setText("");
                        
                    } else {
                        JOptionPane.showMessageDialog(this, "Unable to post notification");
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        
    }//GEN-LAST:event_postbtnActionPerformed

    private void coursecbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_coursecbItemStateChanged
        cn = evt.getItem().toString();
        getSemester(department, cn);
    }//GEN-LAST:event_coursecbItemStateChanged

    private void semcbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_semcbItemStateChanged
        sem = evt.getItem().toString();
        getNotifications(teacherid);
    }//GEN-LAST:event_semcbItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         this.dispose();
         new Teacherhome(teacherid).setVisible(true);
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
            java.util.logging.Logger.getLogger(PostNotifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PostNotifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PostNotifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PostNotifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new PostNotifications().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox coursecb;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea notita;
    private javax.swing.JButton postbtn;
    private javax.swing.JComboBox semcb;
    private javax.swing.JPanel vnpnl;
    // End of variables declaration//GEN-END:variables
}
