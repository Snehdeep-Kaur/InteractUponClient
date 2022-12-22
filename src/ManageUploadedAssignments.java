
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
public class ManageUploadedAssignments extends javax.swing.JFrame {

    String cn;
    String dn;
    String teacherid;
    String sem;
    ArrayList<ManageUploadedAssignments.assignments> al;
    ManageUploadedAssignments.tablemodel tm;

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

    public ManageUploadedAssignments(String departmentname, String tid) {
        dn = departmentname;
        teacherid = tid;
        initComponents();
        setSize(1280,766);
        al = new ArrayList<>();
        tm = new ManageUploadedAssignments.tablemodel();
        table.setModel(tm);
        getCoursenames(departmentname);
        getAssignments(teacherid);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    public void getAssignments(String teacherid) {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:8999/manageuploadedassignments")
                    .queryString("teacherid", teacherid)
                    .queryString("coursename", cn)
                    .queryString("semester", sem)
                    .queryString("departmentname", dn)
                    .asString();

            al.clear();
            if (res.getStatus() == 200) {
                String data = res.getBody();
                StringTokenizer st = new StringTokenizer(data, "&");
                while (st.hasMoreTokens()) {
                    String next = st.nextToken();
                    StringTokenizer st1 = new StringTokenizer(next, ":#");
                    String assignmentid = st1.nextToken();
                    String tid = st1.nextToken();
                    String courseid = st1.nextToken();
                    String semester = st1.nextToken();
                    String title = st1.nextToken();
                    String detail = st1.nextToken();
                    String file = st1.nextToken();
                    String submissiondate = st1.nextToken();
                    String assignmentdate = st1.nextToken();
                    al.add(new ManageUploadedAssignments.assignments(assignmentid, courseid, semester, title, detail, file, submissiondate, assignmentdate));
                }
                table.getColumnModel().getColumn(5).setCellRenderer(new ManageUploadedAssignments.ImageRenderer());
                table.setRowHeight(100);

                tm.fireTableDataChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class tablemodel extends AbstractTableModel {

        String names[] = {"Assignment ID", "Course Name", "Semester", "Title", "Details", "File", "Submission Date", "Assignment Date"};

        public int getColumnCount() {
            return 8;
        }

        public int getRowCount() {
            return al.size();
        }

        public String getColumnName(int column) {
            return names[column];
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return al.get(rowIndex).aid;
            } else if (columnIndex == 1) {
                return al.get(rowIndex).courseid;
            } else if (columnIndex == 2) {
                return al.get(rowIndex).semester;
            } else if (columnIndex == 3) {
                return al.get(rowIndex).title;
            } else if (columnIndex == 4) {
                return al.get(rowIndex).detail;
            } else if (columnIndex == 5) {
                return al.get(rowIndex).file;
            } else if (columnIndex == 6) {
                return al.get(rowIndex).submissiondate;
            } else {
                return al.get(rowIndex).assignmentdate;
            }

        }
    }

    class ImageRenderer extends DefaultTableCellRenderer {

        JLabel lb = new JLabel();
        String rest;
        String extension;
        String imgpath;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            try {
                String path = al.get(row).file;
                StringTokenizer pt = new StringTokenizer(path, ".");
                while (pt.hasMoreTokens()) {
                    rest = pt.nextToken();
                    extension = pt.nextToken();
                }
                extension = extension.toLowerCase();
                if (extension.equals("pdf")) {
                    imgpath = "D:\\IndustrialTraining1\\pdf icon.jpg";
                } else if (extension.equals("docx")) {
                    imgpath = "D:\\IndustrialTraining1\\docx icon.png";
                } else if (extension.equals("mp3")){
                    imgpath = "D:\\IndustrialTraining1\\audio icon.jpg";
                } else if (extension.equals("mp4")){
                    imgpath ="D:\\IndustrialTraining1\\video icon.jpg";
                }
                lb.setSize(100, 100);
                ImageIcon ic = new ImageIcon(imgpath);
                Image image = ic.getImage();
                Image img = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                lb.setIcon(new ImageIcon(img));

            } catch (Exception e) {
                e.printStackTrace();
            }
            return lb;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        semcb = new javax.swing.JComboBox();
        coursecb = new javax.swing.JComboBox();
        bkbtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        vsbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

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
        jScrollPane1.setBounds(40, 210, 1200, 380);

        semcb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        semcb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                semcbItemStateChanged(evt);
            }
        });
        getContentPane().add(semcb);
        semcb.setBounds(780, 130, 400, 40);

        coursecb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        coursecb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                coursecbItemStateChanged(evt);
            }
        });
        getContentPane().add(coursecb);
        coursecb.setBounds(210, 130, 360, 40);

        bkbtn.setBackground(new java.awt.Color(255, 0, 0));
        bkbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        bkbtn.setForeground(new java.awt.Color(255, 255, 255));
        bkbtn.setText("Back");
        bkbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkbtnActionPerformed(evt);
            }
        });
        getContentPane().add(bkbtn);
        bkbtn.setBounds(630, 630, 190, 50);

        delbtn.setBackground(new java.awt.Color(0, 0, 153));
        delbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        delbtn.setForeground(new java.awt.Color(153, 255, 255));
        delbtn.setText("Delete");
        delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtnActionPerformed(evt);
            }
        });
        getContentPane().add(delbtn);
        delbtn.setBounds(980, 630, 170, 50);

        vsbtn.setBackground(new java.awt.Color(153, 0, 153));
        vsbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        vsbtn.setForeground(new java.awt.Color(255, 153, 255));
        vsbtn.setText("View Submissions");
        vsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vsbtnActionPerformed(evt);
            }
        });
        getContentPane().add(vsbtn);
        vsbtn.setBounds(120, 630, 340, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/viewUploadedAssignments.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void coursecbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_coursecbItemStateChanged
        cn = evt.getItem().toString();
        getSemester(dn, cn);
    }//GEN-LAST:event_coursecbItemStateChanged

    private void semcbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_semcbItemStateChanged
        sem = evt.getItem().toString();
        getAssignments(teacherid);
    }//GEN-LAST:event_semcbItemStateChanged

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
        try {
            int row = -1;
            row = table.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Please select a row");
            } else {
                String aid = al.get(row).aid;
                HttpResponse<String> res = Unirest.get("http://localhost:8999/deleteassignments")
                        .queryString("aid", aid)
                        .asString();
                if (res.getStatus() == 200) {
                    String responsetext = res.getBody();
                    if (responsetext.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Assignment deleted successfully");
                        getAssignments(teacherid);

                    } else {
                        JOptionPane.showMessageDialog(this, "Deletion failed");

                    }
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_delbtnActionPerformed

    private void vsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vsbtnActionPerformed
        int row = -1;
        row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row");
        } else {
            String aid = al.get(row).aid;
            this.dispose();
            new ViewSubmissions(aid, dn, teacherid).setVisible(true);
        }


    }//GEN-LAST:event_vsbtnActionPerformed

    private void bkbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkbtnActionPerformed
        this.dispose();
        new Teacherhome(teacherid).setVisible(true);
    }//GEN-LAST:event_bkbtnActionPerformed

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
            java.util.logging.Logger.getLogger(ManageUploadedAssignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageUploadedAssignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageUploadedAssignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageUploadedAssignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ManageUploadedAssignments().setVisible(true);
            }
        });
    }

    class assignments {

        String aid, courseid, semester, title, detail, file, submissiondate, assignmentdate;

        public assignments(String aid, String courseid, String semester, String title, String detail, String file, String submissiondate, String assignmentdate) {
            this.aid = aid;
//            this.tid = tid;
            this.courseid = courseid;
            this.semester = semester;
            this.title = title;
            this.detail = detail;
            this.file = file;
            this.submissiondate = submissiondate;
            this.assignmentdate = assignmentdate;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bkbtn;
    private javax.swing.JComboBox coursecb;
    private javax.swing.JButton delbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox semcb;
    private javax.swing.JTable table;
    private javax.swing.JButton vsbtn;
    // End of variables declaration//GEN-END:variables
}
