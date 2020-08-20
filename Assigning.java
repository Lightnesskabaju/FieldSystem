/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fieldSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lightness kabajunes
 */
public class Assigning extends javax.swing.JFrame {
    /**
     * Creates new form Assigning
     */
    public Assigning() {
        initComponents();
        displaySupervisors();
        displayStudents();
    }
    public void displayStudents()
    {
        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/fieldsystem","root","");
            String sql="SELECT RegNo,FullName,Organization,District,Region,Phone FROM student";
            PreparedStatement pst;
            pst=conn.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            DefaultTableModel model=(DefaultTableModel) Table1.getModel();
            model.setRowCount(0);
            while(rs.next())
            {
                Object[] content={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
                model.addRow(content);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    public void displayAssigning()
    {
         try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/fieldsystem","root","");
            String sql="SELECT * FROM assigning";
            PreparedStatement pst;
            pst=conn.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            DefaultTableModel model=(DefaultTableModel) assigningTable.getModel();
            model.setRowCount(0);
            while(rs.next())
            {
                Object[] content={rs.getString(1),rs.getString(2),rs.getString(3)};
                model.addRow(content);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        
    }
    public void selectStudent()
    {
        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/fieldsystem","root","");
            
            String sqll="SELECT  RegNo,FullName,Organization,District,Region,Phone FROM Student";
            PreparedStatement pstt;
            pstt=conn.prepareStatement(sqll);
            ResultSet rss= pstt.executeQuery();
            DefaultTableModel modell=(DefaultTableModel) Table1.getModel();
            int selectedIndexRoww=Table1.getSelectedRow();
            String FullName=modell.getValueAt(selectedIndexRoww,1).toString();
            String Organization=modell.getValueAt(selectedIndexRoww,2).toString();
       
            String qry="INSERT INTO assigning(StudentName,Organization) VALUES(?,?)";
            PreparedStatement pst;
            pst=conn.prepareStatement(qry);
            pst.setString(1,FullName);
            pst.setString(2,Organization);
            pst.executeUpdate();
            displayAssigning();

       
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    public void selectedSupervisor()
    {
         try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/fieldsystem","root","");
            String sql="SELECT FirstName,Surname,phone FROM Supervisor";
            PreparedStatement pst;
            pst=conn.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            DefaultTableModel model=(DefaultTableModel) Table2.getModel();
            int selectedIndexRow=Table2.getSelectedRow();
            String SupervisorName=model.getValueAt(selectedIndexRow,1).toString();
            String sqll="SELECT FirstName,Surname,phone FROM Supervisor";
            PreparedStatement ps;
            ps=conn.prepareStatement(sql);
            ResultSet rss= ps.executeQuery();
            String update="UPDATE assigning SET SuperVisorName=?";
            PreparedStatement p=conn.prepareStatement(update);
            p.setString(1,SupervisorName);
            p.executeUpdate();
            displayAssigning();
            
       
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }
        public void displaySupervisors()
         {
        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/fieldsystem","root","");
            String sql="SELECT FirstName,Surname,Phone FROM Supervisor";
            PreparedStatement pst;
            pst=conn.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            DefaultTableModel model=(DefaultTableModel) Table2.getModel();
            model.setRowCount(0);
            while(rs.next())
            {
                Object[] content={rs.getString(1),rs.getString(2),rs.getString(3)};
                model.addRow(content);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        assigningTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));
        jPanel2.setForeground(new java.awt.Color(255, 153, 255));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 204));
        jLabel2.setText("LIST OF STUDENT");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(50, 20, 190, 20);

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RegNo", "Full Name", "Organization", "District", "Region", "Contact"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table1);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(12, 60, 350, 440);
        jPanel2.add(jLabel4);
        jLabel4.setBounds(80, 480, 170, 0);

        assigningTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StudentName", "Organization", "SuperVisorName"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(assigningTable);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(370, 70, 452, 402);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ASSIGNING");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(430, 20, 280, 30);

        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(710, 483, 80, 30);

        jButton2.setText("CLEAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(570, 480, 90, 30);

        jButton3.setText("SEE ALL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(453, 480, 80, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 130, 870, 520);

        jPanel3.setBackground(new java.awt.Color(255, 153, 204));
        jPanel3.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 51));
        jLabel3.setText("LIST OF SUPERVISOR");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(84, 24, 190, 40);

        Table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Surname", "Contact"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table2);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 410, 440);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(870, 120, 450, 530);

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 204));
        jLabel1.setText("ASSIGNING SUPERVISOR TO STUDENTS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(408, 408, 408)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(510, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1370, 116);

        jPanel4.setBackground(new java.awt.Color(255, 153, 204));
        jPanel4.setLayout(null);
        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 110, 870, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table2MouseClicked
        // TODO add your handling code here:Supervisor
        selectedSupervisor();
    }//GEN-LAST:event_Table2MouseClicked

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        // TODO add your handling code here:
        selectStudent();
    }//GEN-LAST:event_Table1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:submit
        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/fieldsystem","root","");
            String sql="SELECT * FROM assigning";
            PreparedStatement pst;
            pst=conn.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            DefaultTableModel model=(DefaultTableModel) assigningTable.getModel();
            model.setRowCount(0);
            while(rs.next())
            {
                Object[] content={rs.getString(1),rs.getString(2),rs.getString(3)};
                model.addRow(content);
                String StudentName=rs.getString(1);
            String SupervisorName=rs.getString(3);
            String update="UPDATE Student SET Supervisor=? WHERE FullName=?";
            PreparedStatement p=conn.prepareStatement(update);
            p.setString(1,SupervisorName);
             p.setString(2,StudentName);
             p.executeUpdate();
            }
            
             JOptionPane.showMessageDialog(null,"Updated Sucessfully");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:clear
                 try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/fieldsystem","root","");
            String sql="DELETE FROM assigning";
            PreparedStatement pst;
            pst=conn.prepareStatement(sql);
            pst.execute();
            displayAssigning();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        SeeStudent std=new SeeStudent();
        std.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Assigning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Assigning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Assigning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Assigning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Assigning().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JTable Table2;
    private javax.swing.JTable assigningTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
