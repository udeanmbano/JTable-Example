package View;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import Controller.connect;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Josphat Wanjiru
 */
public class Hostels extends javax.swing.JFrame {
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    File file = null;
    String path="";
    TableColumn column =null;
   public String text;
    

  Vector vector = new Vector();
     public int getRowCount() {
    return vector == null ? 0 : vector.size();
  }

  
    
    
     private Vector<Vector<String>> data; //used for data from database
    private Vector<String> header; 
    /**
     * Creates new form table2
     */
    public Hostels() throws Exception {
        //get data from database
        connect sql = new connect();
        
        data = connect.getHostels();
        
        //create header for the table
        header = new Vector<String>();
        header.add("personID"); 
        header.add("FirstName"); 
        header.add("MiddleName"); 
        header.add("LastName"); 
        header.add("email"); 
        header.add("phone"); 
      
         
    

    /**
     * Creates new form Hostels
     */
   // public Hostels() 
        
        initComponents();
      setIcon();
     
        
        //set location
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, 
        size.height/2 - getHeight()/2); 
        
        //connect to database
        conn=connect.ConnectDb();
         Hostels.setAutoCreateRowSorter(true);
    }
   
    public void refresh() throws SQLException{
    String sql = "SELECT * FROM person ";
    pst=conn.prepareStatement(sql);
    rs=pst.executeQuery();
    Hostels.setModel(DbUtils.resultSetToTableModel(rs));
    
    
    }
   public void hoster()throws Exception{
   String add1= rs.getString("personId");
            y1.setText(add1);
            int y1=Integer.parseInt(add1); 
            String add2= rs.getString("firstName");
            y2.setText(add2);
            String add3= rs.getString("middleName");
            y3.setText(add3);
            String add4= rs.getString("lastName");
            y4.setText(add4);
             String add5= rs.getString("email");
            y5.setText(add5);
             String add6= rs.getString("phone");
            y6.setText(add6);
             
   }
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        y1 = new javax.swing.JTextField();
        y2 = new javax.swing.JTextField();
        y3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        y5 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        save = new javax.swing.JButton();
        y6 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        y4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Hostels = new javax.swing.JTable();
        LINK = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MUni");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hostels Details"));

        jLabel1.setText("Person ID");

        jLabel2.setText("First Name");

        jLabel3.setText("Middle Name");
        jLabel3.setToolTipText("");

        jLabel4.setText("Last Name");

        y1.setText("0");
        y1.setToolTipText("Hostel Code");
        y1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                y1ActionPerformed(evt);
            }
        });

        y2.setToolTipText("Hostel Location");

        y3.setToolTipText("Hostel Name");

        jLabel7.setText("Search By ID");

        search.setToolTipText("Enter To Search");
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
        });

        y5.setToolTipText("Rooms Capacity");
        y5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                y5ActionPerformed(evt);
            }
        });

        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jButton2.setText("NEW");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(update)
                .addGap(33, 33, 33)
                .addComponent(delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel5.setText("Email");

        jLabel6.setText("Phone");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 12, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(y5, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                                    .addComponent(y1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                                    .addComponent(y2, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                                    .addComponent(y3, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                                    .addComponent(y6)
                                    .addComponent(y4))))
                        .addGap(3, 3, 3))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(y1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(y2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(y3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(y4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(y5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(y6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        Hostels.setBackground(new java.awt.Color(255, 204, 204));
        Hostels.setBorder(new javax.swing.border.MatteBorder(null));
        Hostels.setModel(new javax.swing.table.DefaultTableModel(
            data,header
        ));
        Hostels.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HostelsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Hostels);

        LINK.setBackground(new java.awt.Color(51, 51, 255));
        LINK.setFont(new java.awt.Font("Trebuchet MS", 2, 11)); // NOI18N
        LINK.setForeground(new java.awt.Color(51, 51, 255));
        LINK.setText("MUni with JTable and JSwing Add Form");
        LINK.setToolTipText("");
        LINK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LINK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LINKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LINKMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LINK, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(LINK, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1.getAccessibleContext().setAccessibleName("MUni");

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    //method to clear all fields
    public void clearfields()
    {
        y1.setText("");
        y2.setText("");
        y3.setText("");
        y4.setText("");
        y5.setText("");
        y6.setText("");    
        
        
    } 
    
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try{
           /* if (y1.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter hostel code","Error", JOptionPane.ERROR_MESSAGE);
                return;}*/
           if (y2.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter hostel location","Error", JOptionPane.ERROR_MESSAGE);
                return;}
            else if (y3.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter hostel name","Error", JOptionPane.ERROR_MESSAGE);
                return;}
            else if (y4.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter no of rooms","Error", JOptionPane.ERROR_MESSAGE);
                return;}
            else if (y5.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter no of rooms","Error", JOptionPane.ERROR_MESSAGE);
                return;}     
        else if (y6.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter no of rooms","Error", JOptionPane.ERROR_MESSAGE);
                return;}
           y1.setText("0");
             String p1 = y1.getText();
        String p2 = y2.getText();
        String p3 = y3.getText();
        String p4 = y4.getText();
        String p5 = y5.getText();
        String p6 = y6.getText();
        
 String sql = "INSERT INTO person (`personId`,`firstName`, `middleName`, `lastName`,`email`,`phone`) VALUES ('"+(p1)+"','"+(p2)+"','"+(p3)+"','"+(p4)+"','"+(p5)+"','"+(p6)+"')";
        
           pst=conn.prepareStatement(sql);  
        
        pst.execute();
        
       
        refresh();//Update jTable After adding a new record
        JOptionPane.showMessageDialog(null, "Record Successfully Saved");
            }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
        
    } 
    //Bring selected data in table to fields
    private void HostelsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HostelsMouseClicked
       
        int row=Hostels.getSelectedRow();
        String Table_Click=(Hostels.getModel().getValueAt(row, 0).toString());
        
        
        try{
        String sql="Select * from person where personId='"+Table_Click+"'";
        pst= conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
            hoster();  
                  
                  
          
        }
       
        
        
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_HostelsMouseClicked

//GEN-FIRST:event_jButton1ActionPerformed
 
//GEN-LAST:event_jButton1ActionPerformed

    private void LINKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LINKMouseClicked
try{
        Desktop.getDesktop().browse(new URI("http://www.worftec.com/1"));
}catch (URISyntaxException| IOException ex){

}     
// TODO add your handling code here:
    }//GEN-LAST:event_LINKMouseClicked

    private void LINKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LINKMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_LINKMouseEntered

    

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        clearfields();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        try
        {

            String add1=y1.getText();
            String add2=y2.getText();
            String add3=y3.getText();
            String add4=y4.getText();
            String add5=y5.getText();
            String add6=y6.getText();

            String sql="Update person set `firstName`='"+add2+"',`middleName`='"+add3+"',`lastName`='"+add4+"',`email`='"+add5+"',`phone`='"+add6+"' where `personId`='"+add1+"'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            update.setEnabled(true);
            refresh();
            JOptionPane.showMessageDialog(null, "Record Updated Sucessfully");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        String sql= "delete from person where personId= ?";
        int P = JOptionPane.showConfirmDialog(null," Are you sure want to delete ?","Confirmation",JOptionPane.YES_NO_OPTION);

        try
        {
            if (P==0){
                pst=conn.prepareStatement(sql);
                pst.setString(1, y1.getText());
                JOptionPane.showConfirmDialog(null, "Delete Record?");
                pst.execute();
                //JOptionPane.showMessageDialog(null, "deleted");
                refresh();
                clearfields();
                JOptionPane.showMessageDialog(null, "Record Sucessfully Deleted");
            }}
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);

            }

            // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void y5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_y5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_y5ActionPerformed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        try{
            String sql="Select * from person where personId=?";
            pst= conn.prepareStatement(sql);
            pst.setString(1,search.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                hoster();

            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_searchKeyPressed

    private void y1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_y1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_y1ActionPerformed

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
            java.util.logging.Logger.getLogger(Hostels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hostels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hostels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hostels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                try {                
                    new Hostels().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Hostels.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Hostels;
    private javax.swing.JLabel LINK;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton save;
    private javax.swing.JTextField search;
    private javax.swing.JButton update;
    private javax.swing.JTextField y1;
    private javax.swing.JTextField y2;
    private javax.swing.JTextField y3;
    private javax.swing.JTextField y4;
    private javax.swing.JTextField y5;
    private javax.swing.JTextField y6;
    // End of variables declaration//GEN-END:variables

  private void setIcon() {
     setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
        //To change body of generated methods, choose Tools | Templates.
   }}
  
   


