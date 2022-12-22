
public class AssignmentPanel extends javax.swing.JPanel {

   
    public AssignmentPanel() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tlb = new javax.swing.JLabel();
        ablb = new javax.swing.JLabel();
        sdlb = new javax.swing.JLabel();
        vdbtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));
        setLayout(null);

        tlb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tlb.setText("Title: ");
        add(tlb);
        tlb.setBounds(12, 13, 380, 40);

        ablb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ablb.setText("Assigned by:");
        add(ablb);
        ablb.setBounds(10, 60, 380, 40);

        sdlb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sdlb.setText("Submission Date:");
        add(sdlb);
        sdlb.setBounds(10, 110, 380, 40);

        vdbtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        vdbtn.setText("View Details");
        vdbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vdbtnActionPerformed(evt);
            }
        });
        add(vdbtn);
        vdbtn.setBounds(470, 20, 190, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void vdbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vdbtnActionPerformed
       
    }//GEN-LAST:event_vdbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel ablb;
    public javax.swing.JLabel sdlb;
    public javax.swing.JLabel tlb;
    public javax.swing.JButton vdbtn;
    // End of variables declaration//GEN-END:variables
}
