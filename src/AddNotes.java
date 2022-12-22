
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;
import javax.swing.ButtonGroup;
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
public class AddNotes extends javax.swing.JFrame {

    String department;
    String tid;
    String cn;
    JFileChooser chooser;
    File f;


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

    public AddNotes(String id,String dept) {
        initComponents();
        department = dept;
        tid =id;
        setSize(1280,766);
        getCoursenames(department);
        filepath.setEditable(false);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        semcb = new javax.swing.JComboBox();
        coursecb = new javax.swing.JComboBox();
        titletf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailta = new javax.swing.JTextArea();
        audiorbtn = new javax.swing.JRadioButton();
        pdfrbtn = new javax.swing.JRadioButton();
        docrbtn = new javax.swing.JRadioButton();
        videorbtn = new javax.swing.JRadioButton();
        choosebtn = new javax.swing.JButton();
        filepath = new javax.swing.JTextField();
        addbtn = new javax.swing.JButton();
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
        semcb.setBounds(250, 180, 420, 40);

        coursecb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        coursecb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                coursecbItemStateChanged(evt);
            }
        });
        getContentPane().add(coursecb);
        coursecb.setBounds(250, 110, 420, 50);
        getContentPane().add(titletf);
        titletf.setBounds(250, 250, 420, 40);

        detailta.setColumns(20);
        detailta.setRows(5);
        jScrollPane1.setViewportView(detailta);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(250, 320, 420, 110);

        audiorbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        audiorbtn.setText("AUDIO");
        getContentPane().add(audiorbtn);
        audiorbtn.setBounds(460, 450, 90, 30);

        pdfrbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        pdfrbtn.setText("PDF");
        getContentPane().add(pdfrbtn);
        pdfrbtn.setBounds(250, 450, 70, 30);

        docrbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        docrbtn.setText("DOCX");
        getContentPane().add(docrbtn);
        docrbtn.setBounds(350, 450, 80, 30);

        videorbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        videorbtn.setText("VIDEO");
        getContentPane().add(videorbtn);
        videorbtn.setBounds(580, 450, 87, 30);

        choosebtn.setBackground(new java.awt.Color(51, 255, 153));
        choosebtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        choosebtn.setForeground(new java.awt.Color(0, 51, 153));
        choosebtn.setText("Choose");
        choosebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosebtnActionPerformed(evt);
            }
        });
        getContentPane().add(choosebtn);
        choosebtn.setBounds(520, 510, 150, 50);

        filepath.setEditable(false);
        getContentPane().add(filepath);
        filepath.setBounds(250, 510, 270, 50);

        addbtn.setBackground(new java.awt.Color(102, 255, 204));
        addbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        addbtn.setForeground(new java.awt.Color(153, 51, 0));
        addbtn.setText("Add");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });
        getContentPane().add(addbtn);
        addbtn.setBounds(570, 620, 190, 60);

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
        backbtn.setBounds(180, 620, 190, 60);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/addNotes.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void choosebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosebtnActionPerformed
        chooser = new JFileChooser();
        int r = chooser.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            f = chooser.getSelectedFile();
            filepath.setText(f.getName());
        }
    }//GEN-LAST:event_choosebtnActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        try{
            cn = coursecb.getSelectedItem().toString();
            String sem = semcb.getSelectedItem().toString();
            String title = titletf.getText();
            String details = detailta.getText();
            LocalDate datenow = LocalDate.now();
//            LocalTime time = LocalTime.now();
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH.mm");
//            String t = time.format(dtf);
            ButtonGroup G = new ButtonGroup();
            G.add(pdfrbtn);
            G.add(docrbtn);
            G.add(audiorbtn);
            G.add(videorbtn);
            String type ="";
            if(pdfrbtn.isSelected()){
                type = "pdf";
            }else if(docrbtn.isSelected()){
                type = "docx";
            }else if(audiorbtn.isSelected()){
                type = "Mp3";
            }else{
                type = "Mp4";
            }
            
            
            
            if (cn.equals("") || sem.equals("") || title.equals("") || details.equals("")||type.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter values");
            } else if (f == null) {
                JOptionPane.showMessageDialog(this, "Please choose file");
            } else {
                HttpResponse<String> res = Unirest.post("http://localhost:8999/uploadnotes")
                        .queryString("title", title)
                        .queryString("detail", details)
                        .queryString("type",type)
                        .queryString("tid",tid)
                        .queryString("departmentname", department)
                        .queryString("coursename", cn)
                        .queryString("semester", sem)
                        .queryString("date",datenow)
                        .field("file", f)
                        .asString();

                if (res.getStatus() == 200) {
                    String responsetext = res.getBody();
                    System.out.println(responsetext + "   hello");
                    if (responsetext.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Notes uploaded successfuly");
                        titletf.setText("");
                        detailta.setText("");
                        filepath.setText("");
                    } else {
                        JOptionPane.showMessageDialog(this, "Upload failed");
                    }

                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_addbtnActionPerformed

    private void coursecbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_coursecbItemStateChanged
        cn = evt.getItem().toString();
        getSemester(department, cn);
    }//GEN-LAST:event_coursecbItemStateChanged

    private void semcbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_semcbItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_semcbItemStateChanged

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        this.dispose();
        new Teacherhome(tid).setVisible(true);
    }//GEN-LAST:event_backbtnActionPerformed

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
            java.util.logging.Logger.getLogger(AddNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AddNotes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JRadioButton audiorbtn;
    private javax.swing.JButton backbtn;
    private javax.swing.JButton choosebtn;
    private javax.swing.JComboBox coursecb;
    private javax.swing.JTextArea detailta;
    private javax.swing.JRadioButton docrbtn;
    private javax.swing.JTextField filepath;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton pdfrbtn;
    private javax.swing.JComboBox semcb;
    private javax.swing.JTextField titletf;
    private javax.swing.JRadioButton videorbtn;
    // End of variables declaration//GEN-END:variables
}
