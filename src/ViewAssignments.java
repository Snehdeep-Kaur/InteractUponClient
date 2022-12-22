
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.util.StringTokenizer;

public class ViewAssignments extends javax.swing.JFrame {

    String dn, cn, semester, assignmentid, tn, sid;

    public ViewAssignments(String id,String departmentname, String coursename, String sem) {
        sid = id;
        dn = departmentname;
        cn = coursename;
        semester = sem;
        initComponents();
        setSize(1280,766);
        getAssignments(departmentname, coursename, sem);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        vapnl = new javax.swing.JPanel();
        backbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        vapnl.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout vapnlLayout = new javax.swing.GroupLayout(vapnl);
        vapnl.setLayout(vapnlLayout);
        vapnlLayout.setHorizontalGroup(
            vapnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1107, Short.MAX_VALUE)
        );
        vapnlLayout.setVerticalGroup(
            vapnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(vapnl);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 120, 1130, 510);

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
        backbtn.setBounds(1090, 660, 150, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/ViewAssignments.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        this.dispose();
        new studenthome(sid).setVisible(true);
    }//GEN-LAST:event_backbtnActionPerformed

    public void getAssignments(String dn, String cn, String sem) {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:8999/getassignments")
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
                    AssignmentPanel obj = new AssignmentPanel();
                    obj.setBounds(10, y, 770, 200);
                    vapnl.add(obj);
                    String assignments = st.nextToken();
                    StringTokenizer st1 = new StringTokenizer(assignments, ":#");
                    while (st1.hasMoreTokens()) {
                        String aid = st1.nextToken();
                       
                        String tname = st1.nextToken();
                       
                        String courseid = st1.nextToken();
                        String semester = st1.nextToken();
                        String title = st1.nextToken();
                        String detail = st1.nextToken();
                        String file = st1.nextToken();
                        String submissiondate = st1.nextToken();
                        String assignmentdate = st1.nextToken();
                        obj.tlb.setText("Title:   " + title);
                        obj.ablb.setText("Assigned By:   " + tname);
                        obj.sdlb.setText("Submission Date:   " + submissiondate);
                        obj.vdbtn.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ViewAssignments.this.dispose();
                                new ViewDetails(sid, aid, tname, dn, cn, semester).setVisible(true);
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
            java.util.logging.Logger.getLogger(ViewAssignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAssignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAssignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAssignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new ViewAssignments().setVisible(true);
            }
        });
    }
 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel vapnl;
    // End of variables declaration//GEN-END:variables
}
