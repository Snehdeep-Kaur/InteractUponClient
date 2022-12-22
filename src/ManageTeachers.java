
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class ManageTeachers extends javax.swing.JFrame {
    
    ArrayList<ManageTeachers.teacher> al;
    ManageTeachers.tablemodel tm;
    String dn;
    
    public void getDepartmentnames() {
        try {
            
            HttpResponse<String> res = Unirest.get("http://localhost:8999/getdepartmentnames")
                    .asString();
            
            mtdnamecb.removeAllItems();
            mtdnamecb.addItem("All");
            
            if (res.getStatus() == 200) {
                String data = res.getBody();
                System.out.println(data);
                StringTokenizer st = new StringTokenizer(data, ":&");
                while (st.hasMoreTokens()) {
                    String departmentname = st.nextToken();
                    mtdnamecb.addItem(departmentname);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public ManageTeachers() {
        initComponents();
        al = new ArrayList<>();
        tm = new ManageTeachers.tablemodel();
        table.setModel(tm);
        getDepartmentnames();
        setSize(1280,766);
        dn = mtdnamecb.getSelectedItem().toString();
        getTeachers(dn);
        setLocationRelativeTo(null);
        setResizable(false);
        
    }
    
    public void getTeachers(String dn) {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:8999/manageteachers")
                    .queryString("departmentname", dn)
                    .asString();
            
            al.clear();
            if (res.getStatus() == 200) {
                String data = res.getBody();
                StringTokenizer st = new StringTokenizer(data, "&");
                while (st.hasMoreTokens()) {
                    String department = st.nextToken();
                    StringTokenizer st1 = new StringTokenizer(department, ":#");
                    String teacherid = st1.nextToken();
                    String tname = st1.nextToken();
                    String tfathername = st1.nextToken();
                    String tphoneno = st1.nextToken();
                    String temail = st1.nextToken();
                    String tqualification = st1.nextToken();
                    String departmentname = st1.nextToken();
                    String taddress = st1.nextToken();
                    String tpassword = st1.nextToken();
                    String tphoto = st1.nextToken();
                    al.add(new ManageTeachers.teacher(teacherid, tname, tfathername, tphoneno, temail, tqualification, departmentname, taddress, tpassword, tphoto));
                }
                
                table.getColumnModel().getColumn(9).setCellRenderer(new ImageRenderer());
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
                
                String photo = al.get(row).tphoto;
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
        
        String names[] = {"Teacher ID", "Teacher name", "Father Name", "Phone No", "E-mail", "Qualification ", "Department Name", "Address", "Password", "Photo"};
        
        public int getColumnCount() {
            return 10;
        }
        
        public int getRowCount() {
            return al.size();
        }
        
        public String getColumnName(int column) {
            return names[column];
        }
        
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return al.get(rowIndex).teacherid;
            } else if (columnIndex == 1) {
                return al.get(rowIndex).tname;
            } else if (columnIndex == 2) {
                return al.get(rowIndex).tfathername;
            } else if (columnIndex == 3) {
                return al.get(rowIndex).tphoneno;
            } else if (columnIndex == 4) {
                return al.get(rowIndex).temail;
            } else if (columnIndex == 5) {
                return al.get(rowIndex).tqualification;
            } else if (columnIndex == 6) {
                return al.get(rowIndex).departmentname;
            } else if (columnIndex == 7) {
                return al.get(rowIndex).taddress;
            } else if (columnIndex == 8) {
                return al.get(rowIndex).tpassword;
            } else {
                return al.get(rowIndex).tphoto;
            }
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mtdnamecb = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        mtbackbtn = new javax.swing.JButton();
        mtdeletebtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        mtdnamecb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        mtdnamecb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mtdnamecbItemStateChanged(evt);
            }
        });
        getContentPane().add(mtdnamecb);
        mtdnamecb.setBounds(320, 130, 500, 50);

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
        jScrollPane1.setBounds(50, 220, 1180, 380);

        mtbackbtn.setBackground(new java.awt.Color(255, 0, 0));
        mtbackbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        mtbackbtn.setForeground(new java.awt.Color(255, 255, 255));
        mtbackbtn.setText("Back");
        mtbackbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mtbackbtnActionPerformed(evt);
            }
        });
        getContentPane().add(mtbackbtn);
        mtbackbtn.setBounds(350, 640, 150, 50);

        mtdeletebtn.setBackground(new java.awt.Color(51, 255, 204));
        mtdeletebtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        mtdeletebtn.setForeground(new java.awt.Color(0, 51, 102));
        mtdeletebtn.setText("Delete");
        mtdeletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mtdeletebtnActionPerformed(evt);
            }
        });
        getContentPane().add(mtdeletebtn);
        mtdeletebtn.setBounds(750, 640, 150, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/manageTeachers.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mtdeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mtdeletebtnActionPerformed
        try {
            int row = -1;
            row = table.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Please select a row");
            } else {
                String tid = al.get(row).teacherid;
                HttpResponse<String> res = Unirest.get("http://localhost:8999/deleteteacher")
                        .queryString("teacherid", tid)
                        .asString();
                if (res.getStatus() == 200) {
                    String responsetext = res.getBody();
                    if (responsetext.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Teacher deleted successfully");
                        getTeachers(dn);
                        
                    } else {
                        JOptionPane.showMessageDialog(this, "Deletion failed");
                        
                    }
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_mtdeletebtnActionPerformed

    private void mtbackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mtbackbtnActionPerformed
        this.dispose();
        new adminhome().setVisible(true);
    }//GEN-LAST:event_mtbackbtnActionPerformed

    private void mtdnamecbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mtdnamecbItemStateChanged
        dn = evt.getItem().toString();
        getTeachers(dn);
    }//GEN-LAST:event_mtdnamecbItemStateChanged
    
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
            java.util.logging.Logger.getLogger(ManageTeachers.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageTeachers.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageTeachers.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageTeachers.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageTeachers().setVisible(true);
            }
        });
    }
    
    class teacher {
        
        String teacherid, tname, tfathername, tphoneno, temail, tqualification, departmentname, taddress, tpassword, tphoto;
        
        public teacher(String teacherid, String tname, String tfathername, String tphoneno, String temail, String tqualification, String departmentname, String taddress, String tpassword, String tphoto) {
            this.teacherid = teacherid;
            this.tname = tname;
            this.tfathername = tfathername;
            this.tphoneno = tphoneno;
            this.temail = temail;
            this.tqualification = tqualification;
            this.departmentname = departmentname;
            this.taddress = taddress;
            this.tpassword = tpassword;
            this.tphoto = tphoto;
        }
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mtbackbtn;
    private javax.swing.JButton mtdeletebtn;
    private javax.swing.JComboBox mtdnamecb;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}
