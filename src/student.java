
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Image;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class student extends javax.swing.JFrame {

    String dn;
    String cn;
    JFileChooser chooser;
    File f;
    ImageIcon ic;

    public void getDepartmentnames() {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:8999/getdepartmentnames")
                    .asString();

            deptcb.removeAllItems();
            //deptcb.addItem("All");

            if (res.getStatus() == 200) {
                String data = res.getBody();
                System.out.println(data);
                StringTokenizer st = new StringTokenizer(data, ":&");
                while (st.hasMoreTokens()) {
                    String departmentname = st.nextToken();
                    deptcb.addItem(departmentname);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    public student() {
        initComponents();
        setSize(1280, 766);
        getDepartmentnames();
        //getCoursenames();
        dn = deptcb.getSelectedItem().toString();
        chooser = new JFileChooser();
        setLocationRelativeTo(null);
        setResizable(false);
        //cn = coursecb.getSelectedItem().toString();
    }
    public boolean isMobileNumberValid(String str){
        Pattern ptrn = Pattern.compile("(0/91)?[1-9][0-9]{9}");
        Matcher match = ptrn.matcher(str);
        return (match.find()&&match.group().equals(str));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emailtf = new javax.swing.JTextField();
        deptcb = new javax.swing.JComboBox();
        coursecb = new javax.swing.JComboBox();
        semcb = new javax.swing.JComboBox();
        rolltf = new javax.swing.JTextField();
        nametf = new javax.swing.JTextField();
        dobpick = new com.toedter.calendar.JDateChooser();
        fnametf = new javax.swing.JTextField();
        pntf = new javax.swing.JTextField();
        photoviewlb = new javax.swing.JLabel();
        browsebtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        addta = new javax.swing.JTextArea();
        addbtn = new javax.swing.JButton();
        emailtf1 = new javax.swing.JTextField();
        backbtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        deptcb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        deptcb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                deptcbItemStateChanged(evt);
            }
        });
        getContentPane().add(deptcb);
        deptcb.setBounds(230, 110, 320, 40);

        coursecb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        coursecb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                coursecbItemStateChanged(evt);
            }
        });
        getContentPane().add(coursecb);
        coursecb.setBounds(230, 170, 320, 40);

        semcb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(semcb);
        semcb.setBounds(230, 230, 320, 40);
        getContentPane().add(rolltf);
        rolltf.setBounds(230, 290, 320, 40);
        getContentPane().add(nametf);
        nametf.setBounds(230, 350, 320, 40);
        getContentPane().add(dobpick);
        dobpick.setBounds(230, 470, 320, 40);
        getContentPane().add(fnametf);
        fnametf.setBounds(230, 410, 320, 40);
        getContentPane().add(pntf);
        pntf.setBounds(230, 530, 320, 40);

        photoviewlb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(photoviewlb);
        photoviewlb.setBounds(780, 130, 310, 260);

        browsebtn.setBackground(new java.awt.Color(153, 255, 204));
        browsebtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        browsebtn.setForeground(new java.awt.Color(0, 0, 255));
        browsebtn.setText("Browse");
        browsebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsebtnActionPerformed(evt);
            }
        });
        getContentPane().add(browsebtn);
        browsebtn.setBounds(780, 90, 310, 40);

        addta.setColumns(20);
        addta.setRows(5);
        jScrollPane1.setViewportView(addta);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(780, 410, 430, 210);

        addbtn.setBackground(new java.awt.Color(0, 204, 204));
        addbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        addbtn.setForeground(new java.awt.Color(0, 0, 102));
        addbtn.setText("Add");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });
        getContentPane().add(addbtn);
        addbtn.setBounds(760, 650, 190, 50);
        getContentPane().add(emailtf1);
        emailtf1.setBounds(230, 590, 320, 40);

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
        backbtn.setBounds(370, 650, 190, 50);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/addStudent.png"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(0, 0, 1260, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deptcbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_deptcbItemStateChanged
        dn = evt.getItem().toString();
        getCoursenames(dn);
    }//GEN-LAST:event_deptcbItemStateChanged

    private void coursecbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_coursecbItemStateChanged
        cn = evt.getItem().toString();
        getSemester(dn, cn);
    }//GEN-LAST:event_coursecbItemStateChanged

    private void browsebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsebtnActionPerformed
        int r = chooser.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            f = chooser.getSelectedFile();
            ic = new ImageIcon(f.getAbsolutePath());
            Image image = ic.getImage();
            Image nimage = image.getScaledInstance(photoviewlb.getWidth(), photoviewlb.getHeight(), java.awt.Image.SCALE_SMOOTH);
            ic = new ImageIcon(nimage);
            photoviewlb.setIcon(ic);
        }
    }//GEN-LAST:event_browsebtnActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        try {
            dn = deptcb.getSelectedItem().toString();
            cn = coursecb.getSelectedItem().toString();
            String sem = semcb.getSelectedItem().toString();
            String roll = rolltf.getText();
            String name = nametf.getText();
            String fn = fnametf.getText();
            SimpleDateFormat dcn = new SimpleDateFormat("dd-MM-yyyy");
            String dob = dcn.format(dobpick.getDate());
            String pn = pntf.getText();
            String em = emailtf1.getText();
            String ad = addta.getText();
            System.out.println(dob);
            if (dn.equals("") || cn.equals("") || sem.equals("") || roll.equals("") || name.equals("") || fn.equals("") || dob.equals("") || pn.equals("") || em.equals("") || ad.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter values");
                System.out.println(dn + cn + sem + roll + name + fn + dob + pn + em + ad);
                
            }else if (pn.length()>12 || isMobileNumberValid(pn) || ( !em.contains("@") || !em.contains("."))) {
                    JOptionPane.showMessageDialog(this, "Please enter correct values");  
            }else if (f == null) {
                JOptionPane.showMessageDialog(this, "Please choose file");
            } else {
                HttpResponse<String> res = Unirest.post("http://localhost:8999/addstudent")
                        .queryString("departmentname", dn)
                        .queryString("coursename", cn)
                        .queryString("semester", sem)
                        .queryString("rollno", roll)
                        .queryString("name", name)
                        .queryString("fathername", fn)
                        .queryString("dob", dob)
                        .queryString("phoneno", pn)
                        .queryString("email", em)
                        .queryString("address", ad)
                        .field("photo", f)
                        .asString();

                if (res.getStatus() == 200) {
                    String responsetext = res.getBody();
                    System.out.println(responsetext + "   hello");
                    if (responsetext.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Student added successfuly");
                        rolltf.setText("");
                        nametf.setText("");
                        fnametf.setText("");
                        pntf.setText("");
                        emailtf1.setText("");
                        addta.setText("");
                        photoviewlb.setIcon(null);
                    } else {
                        JOptionPane.showMessageDialog(this, "Student already exist");
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addbtnActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        this.dispose();
        new adminhome().setVisible(true);
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
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JTextArea addta;
    private javax.swing.JButton backbtn;
    private javax.swing.JButton browsebtn;
    private javax.swing.JComboBox coursecb;
    private javax.swing.JComboBox deptcb;
    private com.toedter.calendar.JDateChooser dobpick;
    private javax.swing.JTextField emailtf;
    private javax.swing.JTextField emailtf1;
    private javax.swing.JTextField fnametf;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nametf;
    private javax.swing.JLabel photoviewlb;
    private javax.swing.JTextField pntf;
    private javax.swing.JTextField rolltf;
    private javax.swing.JComboBox semcb;
    // End of variables declaration//GEN-END:variables
}
