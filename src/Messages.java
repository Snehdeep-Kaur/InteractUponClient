/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class Messages extends javax.swing.JPanel {

    /**
     * Creates new form Messages
     */
    public Messages() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        namelb = new javax.swing.JLabel();
        msgta = new javax.swing.JLabel();
        timelb = new javax.swing.JLabel();
        dtlb = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 102));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(null);

        namelb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        namelb.setText("~");
        add(namelb);
        namelb.setBounds(570, 80, 140, 30);

        msgta.setAutoscrolls(true);
        add(msgta);
        msgta.setBounds(10, 10, 660, 60);
        add(timelb);
        timelb.setBounds(610, 110, 140, 30);
        add(dtlb);
        dtlb.setBounds(430, 110, 150, 30);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel dtlb;
    public javax.swing.JLabel msgta;
    public javax.swing.JLabel namelb;
    public javax.swing.JLabel timelb;
    // End of variables declaration//GEN-END:variables
}
