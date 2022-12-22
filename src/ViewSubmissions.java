
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ViewSubmissions extends javax.swing.JFrame {

    String assignmentid;
    String dn, id;
    ArrayList<ViewSubmissions.vsub> al;
    ViewSubmissions.tablemodel tm;

    public ViewSubmissions(String aid, String departmentname, String tid) {
        assignmentid = aid;
        dn=departmentname;
        id=tid;
        initComponents();
        setSize(1280,766);
        al = new ArrayList<>();
        tm = new ViewSubmissions.tablemodel();
        table.setModel(tm);
        getSubmissions(assignmentid);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void getSubmissions(String assignmentid) {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:8999/getsubmittedassignments")
                    .queryString("aid", assignmentid)
                    .asString();

            al.clear();
            if (res.getStatus() == 200) {
                String data = res.getBody();
                System.out.println(data);
                StringTokenizer st = new StringTokenizer(data, "&");
                while (st.hasMoreTokens()) {
                    String next = st.nextToken();
                    StringTokenizer st1 = new StringTokenizer(next, ":#");
                    String sid = st1.nextToken();
                    String rollno = st1.nextToken();
                    String file = st1.nextToken();
                    String subdate = st1.nextToken();
                    al.add(new ViewSubmissions.vsub(sid,rollno,file,subdate));
                }
                table.getColumnModel().getColumn(2).setCellRenderer(new ViewSubmissions.ImageRenderer());
                table.setRowHeight(100);

                tm.fireTableDataChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class tablemodel extends AbstractTableModel {

        String names[] = {"Student ID", "Roll no", "File", "Date"};

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
                return al.get(rowIndex).sid;
            } else if (columnIndex == 1) {
                return al.get(rowIndex).roll;
            } else if (columnIndex == 2) {
                return al.get(rowIndex).file;
            } else {
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
                    imgpath = "C:\\Users\\Lenovo\\Downloads\\pdficon.png";
                } else if (extension.equals("docx")) {
                    imgpath = "C:\\Users\\Lenovo\\Downloads\\docxicon.png";
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
        dnldbtn = new javax.swing.JButton();
        bckbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

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
        jScrollPane1.setBounds(60, 130, 1160, 470);

        dnldbtn.setBackground(new java.awt.Color(153, 255, 153));
        dnldbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        dnldbtn.setForeground(new java.awt.Color(51, 102, 0));
        dnldbtn.setText("Download");
        dnldbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dnldbtnActionPerformed(evt);
            }
        });
        getContentPane().add(dnldbtn);
        dnldbtn.setBounds(760, 640, 230, 50);

        bckbtn.setBackground(new java.awt.Color(255, 0, 0));
        bckbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        bckbtn.setForeground(new java.awt.Color(255, 255, 255));
        bckbtn.setText("Back");
        bckbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bckbtnActionPerformed(evt);
            }
        });
        getContentPane().add(bckbtn);
        bckbtn.setBounds(280, 640, 230, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/viewAssignmentSubmissions.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1290, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dnldbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dnldbtnActionPerformed
        int index = table.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "please select assignment first");
        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    FileOutputStream fos = null;
                    try {
                        String filepath = al.get(index).file;
                        HttpResponse<InputStream> HttpResponse = Unirest.get("http://localhost:8999/GetResource/" + filepath).asBinary();
                        String filename = filepath.substring(filepath.lastIndexOf("/"));
                        InputStream is = HttpResponse.getBody();
                        fos = new FileOutputStream(System.getProperty("user.home") + "/Downloads/" + filename);
                        String downloadfile = System.getProperty("user.home") + "/Downloads/" + filename;
                        long contentlength = Integer.parseInt(HttpResponse.getHeaders().getFirst("Content-Length"));
                        byte b[] = new byte[10000];
                        int r;
                        long count = 0;
                        while (true) {
                            r = is.read(b, 0, 10000);
                            fos.write(b, 0, r);
                            count = count + r;
                            int per = (int) (count * 100 / contentlength);
                            if (count == contentlength) {
                                break;
                            }
                        }
                        fos.close();
                        JOptionPane.showMessageDialog(ViewSubmissions.this, "file downloaded");
                        Desktop.getDesktop().open(new File(downloadfile));
                    } catch (Exception ex) {
                        Logger.getLogger(ViewSubmissions.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            fos.close();
                        } catch (IOException ex) {
                            Logger.getLogger(ViewSubmissions.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

            }).start();

        }
    }//GEN-LAST:event_dnldbtnActionPerformed

    private void bckbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bckbtnActionPerformed
        this.dispose();
        new ManageUploadedAssignments(dn, id).setVisible(true);
    }//GEN-LAST:event_bckbtnActionPerformed

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
            java.util.logging.Logger.getLogger(ViewSubmissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSubmissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSubmissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSubmissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ViewSubmissions().setVisible(true);
            }
        });
    }

    class vsub {

        String sid, roll, file, date;

        public vsub(String sid, String roll, String file, String date) {
            this.sid = sid;
            this.roll = roll;
            this.file = file;
            this.date = date;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bckbtn;
    private javax.swing.JButton dnldbtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
