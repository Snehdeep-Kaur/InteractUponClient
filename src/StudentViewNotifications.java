
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Dimension;
import java.util.StringTokenizer;


public class StudentViewNotifications extends javax.swing.JFrame {

    String dn, cn, sem, id;
    

    
    public StudentViewNotifications(String sid,String dept, String cname, String semester) {
        initComponents();
        setSize(1280,766);
        dn = dept;
        cn = cname;
        sem = semester;
        id=sid;
        getStudentNotifications(dn, cn, sem);
        setLocationRelativeTo(null);
        setResizable(false);
       
        
    }
     public void getStudentNotifications(String dn, String cn, String sem) {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:8999/getstudentnotifications")
                    .queryString("departmentname",dn)
                    .queryString("coursename",cn)
                    .queryString("semester",sem)
                    .asString();

            if (res.getStatus() == 200) {
                vpnl.removeAll();
                String data = res.getBody();
                System.out.println(data);
                StringTokenizer st = new StringTokenizer(data, "&&");
                int y = 10;
                while (st.hasMoreTokens()) {
                    Messages obj = new Messages();
                    obj.setBounds(10, y, 750, 145);
                    vpnl.add(obj);
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
                
                vpnl.setPreferredSize(new Dimension(jScrollPane1.getWidth()-20,100+y));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        vpnl = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout vpnlLayout = new javax.swing.GroupLayout(vpnl);
        vpnl.setLayout(vpnlLayout);
        vpnlLayout.setHorizontalGroup(
            vpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1167, Short.MAX_VALUE)
        );
        vpnlLayout.setVerticalGroup(
            vpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(vpnl);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 120, 1190, 500);

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
        jButton1.setBounds(110, 640, 140, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/studentViewNotifications.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new studenthome(id).setVisible(true);
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
            java.util.logging.Logger.getLogger(StudentViewNotifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentViewNotifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentViewNotifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentViewNotifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new StudentViewNotifications().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel vpnl;
    // End of variables declaration//GEN-END:variables
}
