
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ManageCourse extends javax.swing.JFrame {

    ArrayList<ManageCourse.courses> al;
    tablemodel tm;

    public ManageCourse() {
        initComponents();
        setSize(1286, 750);
        setResizable(false);
        setLocationRelativeTo(null);
        al = new ArrayList<>();
        tm = new tablemodel();
        table.setModel(tm);

        getCourses();

    }

    public void getCourses() {
        try {

            HttpResponse<String> res = Unirest.get("http://localhost:8999/managecourse")
                    .asString();

            al.clear();
            if (res.getStatus() == 200) {
                String data = res.getBody();
                StringTokenizer st = new StringTokenizer(data, "&");
                while (st.hasMoreTokens()) {
                    String courses = st.nextToken();
                    StringTokenizer st1 = new StringTokenizer(courses, ":#");
                    String courseid = st1.nextToken();

                    String coursename = st1.nextToken();
                    String departmentname = st1.nextToken();
                    String semester = st1.nextToken();
                    String description = st1.nextToken();
                    al.add(new ManageCourse.courses(courseid,coursename, departmentname, semester, description));
                }
                tm.fireTableDataChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class tablemodel extends AbstractTableModel {

        String names[] = {"Course Name", "Department name", "Semester", "Description"};

        public int getColumnCount() {
            return 4;
        }

        public int getRowCount() {
            return al.size();
        }

        public String getColumnName(int column) {
            return names[column];
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return al.get(rowIndex).coursename;
            } else if (columnIndex == 1) {
                return al.get(rowIndex).departmentname;
            } else if (columnIndex == 2) {
                return al.get(rowIndex).semester;
            } else {
                return al.get(rowIndex).description;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        backbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        table.setBackground(new java.awt.Color(51, 51, 51));
        table.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        table.setForeground(new java.awt.Color(255, 255, 255));
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
        table.setRowHeight(28);
        jScrollPane3.setViewportView(table);

        jScrollPane2.setViewportView(jScrollPane3);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(150, 150, 980, 420);

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
        backbtn.setBounds(310, 610, 220, 50);

        deletebtn.setBackground(new java.awt.Color(51, 255, 255));
        deletebtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        deletebtn.setForeground(new java.awt.Color(0, 102, 102));
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        getContentPane().add(deletebtn);
        deletebtn.setBounds(750, 610, 220, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/ManageCourses.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        try {
            int row = -1;
            row = table.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Please select a row");
            } else {
                String cid = al.get(row).courseid;
                //System.out.println(cname);
                HttpResponse<String> res = Unirest.get("http://localhost:8999/deletecourse")
                        .queryString("cid", cid)
                        .asString();
                if (res.getStatus() == 200) {
                    String responsetext = res.getBody();
                    if (responsetext.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Course deleted successfully");
                        getCourses();

                    } else {
                        JOptionPane.showMessageDialog(this, "Deletion failed");

                    }
                }
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_deletebtnActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        this.dispose();
        new adminhome().setVisible(true);
    }//GEN-LAST:event_backbtnActionPerformed

    class courses {

        String courseid, coursename, departmentname, semester, description;

        public courses(String courseid, String coursename, String departmentname, String semester, String description) {
            this.courseid = courseid;
            this.coursename = coursename;
            this.departmentname = departmentname;
            this.semester = semester;
            this.description = description;
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
            java.util.logging.Logger.getLogger(ManageCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
