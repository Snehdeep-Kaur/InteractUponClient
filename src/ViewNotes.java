
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class ViewNotes extends javax.swing.JFrame {

    String dn, cn, semester, assignmentid, tn, sid;

    
    public ViewNotes(String id,String departmentname, String coursename, String sem) {
        sid = id;
        dn = departmentname;
        cn = coursename;
        semester = sem;
        initComponents();
        setSize(1280,766);
        getNotes(departmentname, coursename, sem);
        setLocationRelativeTo(null);
        setResizable(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        vnpnl = new javax.swing.JPanel();
        backbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        vnpnl.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout vnpnlLayout = new javax.swing.GroupLayout(vnpnl);
        vnpnl.setLayout(vnpnlLayout);
        vnpnlLayout.setHorizontalGroup(
            vnpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1157, Short.MAX_VALUE)
        );
        vnpnlLayout.setVerticalGroup(
            vnpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(vnpnl);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 130, 1180, 530);

        backbtn.setBackground(new java.awt.Color(255, 0, 51));
        backbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        backbtn.setForeground(new java.awt.Color(255, 255, 255));
        backbtn.setText("Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        getContentPane().add(backbtn);
        backbtn.setBounds(1100, 680, 160, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/viewnotes.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        this.dispose();
        new studenthome(sid).setVisible(true);
    }//GEN-LAST:event_backbtnActionPerformed

    public void getNotes(String dn, String cn, String sem) {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:8999/getallnotes")
                    .queryString("departmentname", dn)
                    .queryString("coursename", cn)
                    .queryString("semester", sem)
                    .asString();

            if (res.getStatus() == 200) {
                String data = res.getBody();
                System.out.println(data);
                StringTokenizer st = new StringTokenizer(data, "&");
                int y = 10;
                while (st.hasMoreTokens()) {
                    ViewNotesPanel obj = new ViewNotesPanel();
                    obj.setBounds(10, y, 770, 200);
                    vnpnl.add(obj);
                    String notes = st.nextToken();
                    StringTokenizer st1 = new StringTokenizer(notes, ":#");
                    while (st1.hasMoreTokens()) {
                        String nid = st1.nextToken();
                        String tname = st1.nextToken();
                        String title = st1.nextToken();
                        String date = st1.nextToken();
                        obj.titlelb.setText("Title:   " + title);
                        obj.pblb.setText("Posted By:   " + tname);
                        obj.polb.setText("Posted on:   " + date);
                        obj.vdbtn.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ViewNotes.this.dispose();
                                new ViewNotesDetails(sid, nid, tname, dn, cn, sem).setVisible(true);
                                
                            }
                        });
                       
                    }
                    y = y + 220;
                }
            }
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
            java.util.logging.Logger.getLogger(ViewNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ViewNotes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel vnpnl;
    // End of variables declaration//GEN-END:variables
}
