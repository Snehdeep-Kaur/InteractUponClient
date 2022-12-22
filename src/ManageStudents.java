
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo
 */
public class ManageStudents extends javax.swing.JFrame {

    String dn;
    String cn;
    String sem;
    JFileChooser chooser;
    File f;
    ImageIcon ic;
    ArrayList<ManageStudents.student> al;
    ManageStudents.tablemodel tm;

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

    public ManageStudents() {
        initComponents();
        setSize(1280,766);
        
        dn = deptcb.getSelectedItem().toString();
        chooser = new JFileChooser();
        al = new ArrayList<>();
        tm = new tablemodel();
        table.setModel(tm);
        getDepartmentnames();
        setLocationRelativeTo(null);
        setResizable(false);
       
        //getStudents(dn,cn,sem);

    }

    public void getStudents(String dn, String cn, String sem) {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:8999/managestudents")
                    .queryString("departmentname", dn)
                    .queryString("coursename", cn)
                    .queryString("semester", sem)
                    .asString();

            al.clear();
            if (res.getStatus() == 200) {
                String data = res.getBody();
                StringTokenizer st = new StringTokenizer(data, "&");
                while (st.hasMoreTokens()) {
                    String department = st.nextToken();
                    StringTokenizer st1 = new StringTokenizer(department, ":#");
                    String studentid = st1.nextToken();
                    String srollno = st1.nextToken();
                    String sname = st1.nextToken();
                    String sfname = st1.nextToken();
                    String sdob = st1.nextToken();
                    String sphoneno = st1.nextToken();
                    String semail = st1.nextToken();
                    String saddress = st1.nextToken();
                    String sphoto = st1.nextToken();
                    String departmentname = st1.nextToken();
                    String courseid = st1.nextToken();
                    String semester = st1.nextToken();
                    String spassword = st1.nextToken();

                    al.add(new ManageStudents.student(studentid, srollno, sname, sfname, sdob, sphoneno, semail, saddress, sphoto, departmentname, courseid, semester, spassword));
                }

                table.getColumnModel().getColumn(8).setCellRenderer(new ImageRenderer());
                table.setRowHeight(100);

                tm.fireTableDataChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class ImageRenderer extends DefaultTableCellRenderer {

        JLabel lb = new JLabel();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            try {

                String photo = al.get(row).sphoto;
                lb.setSize(100, 100);
                URL uri = new URL("http://localhost:8999/GetResource/" + photo);
                BufferedImage bimg = ImageIO.read(uri);
                Image img = bimg.getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_SMOOTH);
                lb.setIcon(new ImageIcon(img));

            } catch (Exception e) {
                e.printStackTrace();
            }
            return lb;
        }

    }

    class tablemodel extends AbstractTableModel {

        String names[] = {"Student ID", "Roll No", "Name", "Father Name", "DOB", "Phone No", "E-Mail", "Address", "Photo", "Department name", "Course ID", "Semester", "Password"};

        public int getColumnCount() {
            return 13;
        }

        public int getRowCount() {
            return al.size();
        }

        public String getColumnName(int column) {
            return names[column];
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return al.get(rowIndex).studentid;
            } else if (columnIndex == 1) {
                return al.get(rowIndex).srollno;
            } else if (columnIndex == 2) {
                return al.get(rowIndex).sname;
            } else if (columnIndex == 3) {
                return al.get(rowIndex).sfname;
            } else if (columnIndex == 4) {
                return al.get(rowIndex).sdob;
            } else if (columnIndex == 5) {
                return al.get(rowIndex).sphoneno;
            } else if (columnIndex == 6) {
                return al.get(rowIndex).semail;
            } else if (columnIndex == 7) {
                return al.get(rowIndex).saddress;
            } else if (columnIndex == 8) {
                return al.get(rowIndex).sphoto;
            } else if (columnIndex == 9) {
                return al.get(rowIndex).departmentname;
            } else if (columnIndex == 10) {
                return al.get(rowIndex).courseid;
            } else if (columnIndex == 11) {
                return al.get(rowIndex).semester;
            } else {
                return al.get(rowIndex).spassword;
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        semcb = new javax.swing.JComboBox();
        deptcb = new javax.swing.JComboBox();
        coursecb = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        delbtn = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
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
        semcb.setBounds(910, 140, 280, 40);

        deptcb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        deptcb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                deptcbItemStateChanged(evt);
            }
        });
        getContentPane().add(deptcb);
        deptcb.setBounds(60, 140, 280, 40);

        coursecb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        coursecb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                coursecbItemStateChanged(evt);
            }
        });
        getContentPane().add(coursecb);
        coursecb.setBounds(490, 140, 300, 40);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 240, 1150, 370);

        delbtn.setBackground(new java.awt.Color(0, 255, 204));
        delbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        delbtn.setForeground(new java.awt.Color(51, 0, 204));
        delbtn.setText("Delete");
        delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtnActionPerformed(evt);
            }
        });
        getContentPane().add(delbtn);
        delbtn.setBounds(740, 660, 180, 50);

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
        backbtn.setBounds(350, 660, 180, 50);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/manageStudents.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        this.dispose();
        new adminhome().setVisible(true);
    }//GEN-LAST:event_backbtnActionPerformed

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
        try {
            int row = -1;
            row = table.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Please select a row");
            } else {
                String tid = al.get(row).studentid;
                HttpResponse<String> res = Unirest.get("http://localhost:8999/deletestudent")
                        .queryString("studentid", tid)
                        .asString();
                if (res.getStatus() == 200) {
                    String responsetext = res.getBody();
                    if (responsetext.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Student deleted successfully");
                        getStudents(dn, cn, sem);

                    } else {
                        JOptionPane.showMessageDialog(this, "Deletion failed");

                    }
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_delbtnActionPerformed

    private void coursecbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_coursecbItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cn = evt.getItem().toString();
            getSemester(dn, cn);
        }
    }//GEN-LAST:event_coursecbItemStateChanged

    private void deptcbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_deptcbItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            dn = evt.getItem().toString();
            getCoursenames(dn);
        }
    }//GEN-LAST:event_deptcbItemStateChanged

    private void semcbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_semcbItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            sem = evt.getItem().toString();
            getStudents(dn, cn, sem);
        }
    }//GEN-LAST:event_semcbItemStateChanged

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    class student {

        String studentid, srollno, sname, sfname, sdob, sphoneno, semail, saddress, sphoto, departmentname, courseid, semester, spassword;

        public student(String studentid, String srollno, String sname, String sfname, String sdob, String sphoneno, String semail, String saddress, String sphoto, String departmentname, String courseid, String semester, String spassword) {
            this.studentid = studentid;
            this.srollno = srollno;
            this.sname = sname;
            this.sfname = sfname;
            this.sdob = sdob;
            this.sphoneno = sphoneno;
            this.semail = semail;
            this.saddress = saddress;
            this.sphoto = sphoto;
            this.departmentname = departmentname;
            this.courseid = courseid;
            this.semester = semester;
            this.spassword = spassword;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JComboBox coursecb;
    private javax.swing.JButton delbtn;
    private javax.swing.JComboBox deptcb;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox semcb;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
