
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;
import java.util.StringTokenizer;
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
public class ManageNotes extends javax.swing.JFrame {

    String cn;
    String dn;
    String teacherid;
    String sem;
    ArrayList<ManageNotes.notes> al;
    ManageNotes.tablemodel tm;

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

    public ManageNotes(String departmentname, String tid) {
        dn = departmentname;
        teacherid = tid;
        initComponents();
        setSize(1280,735);
        al = new ArrayList<>();
        tm = new ManageNotes.tablemodel();
        table.setModel(tm);
        getCoursenames(departmentname);
        getNotes(teacherid);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    public void getNotes(String teacherid) {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:8999/manageuploadednotes")
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
                    String noteid = st1.nextToken();
                    String title = st1.nextToken();
                    String detail = st1.nextToken();
                    String type = st1.nextToken();
                    System.out.println(type);
                    String file = st1.nextToken();
                    
                    System.out.println(file);
                    
                    String courseid = st1.nextToken();
                    String semester = st1.nextToken();
                    String date = st1.nextToken();
                    al.add(new ManageNotes.notes(noteid, courseid, semester, title, detail, type, file, date));
                }
                table.getColumnModel().getColumn(5).setCellRenderer(new ManageNotes.ImageRenderer());
                table.setRowHeight(100);

                tm.fireTableDataChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class tablemodel extends AbstractTableModel {

        String names[] = {"ID","Course ID","Semester","Title", "Details", "Type","File", "Date"};

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
            if(columnIndex ==0){
                return al.get(rowIndex).noteid;
            } else if (columnIndex == 1) {
                return al.get(rowIndex).courseid;
            } else if (columnIndex == 2) {
                return al.get(rowIndex).semester;
            } else if (columnIndex == 3) {
                return al.get(rowIndex).title;
            } else if (columnIndex == 4) {
                return al.get(rowIndex).detail;
            } else if (columnIndex == 5) {
                return al.get(rowIndex).type;
            } else if (columnIndex == 6) {
                return al.get(rowIndex).file;
            } else{
                return al.get(rowIndex).date;
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
        backbtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        semcb = new javax.swing.JComboBox();
        coursecb = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

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
        jScrollPane1.setBounds(50, 230, 1180, 380);

        backbtn.setText("Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        getContentPane().add(backbtn);
        backbtn.setBounds(290, 640, 220, 50);

        delbtn.setText("Delete");
        delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtnActionPerformed(evt);
            }
        });
        getContentPane().add(delbtn);
        delbtn.setBounds(760, 640, 210, 50);

        semcb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        semcb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                semcbItemStateChanged(evt);
            }
        });
        getContentPane().add(semcb);
        semcb.setBounds(830, 140, 360, 40);

        coursecb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        coursecb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                coursecbItemStateChanged(evt);
            }
        });
        getContentPane().add(coursecb);
        coursecb.setBounds(240, 140, 340, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/manageNotes.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1290, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
        try {
            int row = -1;
            row = table.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Please select a row");
            } else {
                String nid = al.get(row).noteid;
                HttpResponse<String> res = Unirest.get("http://localhost:8999/deletenotes")
                        .queryString("noteid", nid)
                        .asString();
                if (res.getStatus() == 200) {
                    String responsetext = res.getBody();
                    if (responsetext.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Notes deleted successfully");
                        getNotes(teacherid);

                    } else {
                        JOptionPane.showMessageDialog(this, "Deletion failed");

                    }
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_delbtnActionPerformed

    private void coursecbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_coursecbItemStateChanged
        cn = evt.getItem().toString();
        getSemester(dn,cn);
    }//GEN-LAST:event_coursecbItemStateChanged

    private void semcbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_semcbItemStateChanged
        sem = evt.getItem().toString();
        getNotes(teacherid);
    }//GEN-LAST:event_semcbItemStateChanged

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        this.dispose();
        new Teacherhome(teacherid).setVisible(true);
    }//GEN-LAST:event_backbtnActionPerformed

    
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
            java.util.logging.Logger.getLogger(ManageNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                  //new ManageNotes().setVisible(true);
            }
        });
    }
    class notes {

        String noteid, title, detail, type, file, courseid, semester,  date;

        public notes(String noteid, String courseid, String semester, String title, String detail, String type, String file, String date) {
            this.noteid = noteid;
            this.courseid = courseid;
            this.semester = semester;
            this.title = title;
            this.detail = detail;
            this.type = type;
            this.file = file;
            this.date = date;
        }
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JComboBox coursecb;
    private javax.swing.JButton delbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox semcb;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
