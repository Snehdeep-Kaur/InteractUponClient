
public class adminhome extends javax.swing.JFrame {

    /**
     * Creates new form adminhome
     */
    public adminhome() {
        initComponents();
        setSize(1285,766);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        deptlb = new javax.swing.JLabel();
        courselb = new javax.swing.JLabel();
        teacherlb = new javax.swing.JLabel();
        studentlb = new javax.swing.JLabel();
        logoutlb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/ADMIN HOME.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 720);

        deptlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deptlbMouseClicked(evt);
            }
        });
        getContentPane().add(deptlb);
        deptlb.setBounds(680, 200, 520, 60);

        courselb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courselbMouseClicked(evt);
            }
        });
        getContentPane().add(courselb);
        courselb.setBounds(670, 310, 530, 70);

        teacherlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherlbMouseClicked(evt);
            }
        });
        getContentPane().add(teacherlb);
        teacherlb.setBounds(680, 420, 520, 70);

        studentlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentlbMouseClicked(evt);
            }
        });
        getContentPane().add(studentlb);
        studentlb.setBounds(680, 530, 520, 70);

        logoutlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutlbMouseClicked(evt);
            }
        });
        getContentPane().add(logoutlb);
        logoutlb.setBounds(840, 660, 190, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deptlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deptlbMouseClicked
        new SelectOptionDept().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_deptlbMouseClicked

    private void courselbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courselbMouseClicked
        new SelectOptionCourse().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_courselbMouseClicked

    private void teacherlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherlbMouseClicked
        new SelectOptionTeachers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_teacherlbMouseClicked

    private void studentlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentlbMouseClicked
        new SelectOptionStudents().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_studentlbMouseClicked

    private void logoutlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutlbMouseClicked
        this.dispose();
        new mainpage().setVisible(true);
    }//GEN-LAST:event_logoutlbMouseClicked

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
            java.util.logging.Logger.getLogger(adminhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminhome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel courselb;
    private javax.swing.JLabel deptlb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logoutlb;
    private javax.swing.JLabel studentlb;
    private javax.swing.JLabel teacherlb;
    // End of variables declaration//GEN-END:variables
}
