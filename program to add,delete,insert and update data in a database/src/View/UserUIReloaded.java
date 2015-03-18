/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;
import Controller.UserBean;
import Model.User;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JPasswordField;
import javax.swing.table.*;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Mbano
 */
public class UserUIReloaded extends JFrame {
        JTextField text1,text2;
        JPasswordField text3,text4;
  JLabel label1,label2,label3,label4;
  int count=0;
  JButton nextRecord,previousRecord,firstRecord,lastRecord,createRecord,UpdateRecord,deleteRecord,saveRecord,closeButton;
    static JPanel panel2;
    private UserBean User = new UserBean();

public UserUIReloaded(){
  text1=new JTextField();
  text2=new JTextField();
  text3=new JPasswordField();
  text4=new JPasswordField();
  label1=new JLabel("User ID");
  label2=new JLabel("UserName");
  label3=new JLabel("Password");
  label4=new JLabel("Confirm Password");
nextRecord=new JButton("Next");
previousRecord=new JButton("Previous");
firstRecord=new JButton("First");
lastRecord=new JButton("Last");
createRecord=new JButton("AddNew");
UpdateRecord=new JButton("Update");
deleteRecord=new JButton("Delete");
saveRecord=new JButton("Save");
saveRecord.setEnabled(false);
closeButton=new JButton("Close");
panel2=new JPanel(new GridLayout(9,2,2,2));
panel2.add(label1);
panel2.add(text1);
panel2.add(label2);
panel2.add(text2);
panel2.add(label3);
panel2.add(text3);
panel2.add(label4);
panel2.add(text4);
panel2.add(nextRecord);
panel2.add(previousRecord);
panel2.add(firstRecord);
panel2.add(lastRecord);
panel2.add(createRecord);
panel2.add(UpdateRecord);
panel2.add(saveRecord);
panel2.add(deleteRecord);
panel2.add(closeButton);
 setFieldData(User.moveFirst());

createRecord.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
       User p2 = getFieldData();
       
            p2.setUsername("");
            p2.setPassword("");
            setFieldData(p2);
            createRecord.setText("Save");
              createRecord.setEnabled(false);
              UpdateRecord.setEnabled(false);
              saveRecord.setEnabled(true);
              createRecord.setToolTipText("Click Save when done adding your data");
      }});
      closeButton.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
 StartPage rr = new StartPage();
 rr.setSize(400, 300);
         rr.setLocationRelativeTo(null);
 rr.setVisible(true);
 dispose();
      }});
saveRecord.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
          User p2 = getFieldData();
      if (isEmptyFieldData()) {
               JOptionPane.showMessageDialog(null,
               "Cannot create an empty record");
               return;
            }
            if (User.create(p2) != null)
               JOptionPane.showMessageDialog(null,
               "New User created successfully.");
               createRecord.setText("AddNew");
              createRecord.setEnabled(true);
              UpdateRecord.setEnabled(true);
              
              UpdateRecord.setToolTipText("Click Save to save new record");
      }});
deleteRecord.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        User p2 = new User();
        if (isEmptyFieldData()) {
               JOptionPane.showMessageDialog(null,
               "Cannot delete an empty record");
               return;
            }
            p2 = User.getCurrent();
            User.delete();
            JOptionPane.showMessageDialog(
               null,"User with ID:"
               + String.valueOf(p2.getiduser()
               + " is deleted successfully"));
                UpdateRecord.setEnabled(true);
      }});
UpdateRecord.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
         User p2 = getFieldData(); 
         

String jpf1Text=Arrays.toString(text3.getPassword());   //get the char array of password and convert to string represenation
String jpf2Text=Arrays.toString(text4.getPassword());
String output="Passwords are not matching make sure you confirm password 1" + jpf1Text +"Paswword 2 :"+ jpf2Text;
//compare the fields contents
if(!(jpf1Text.equals(jpf2Text))) {//they are equal
JOptionPane.showMessageDialog(null,output);
               return;
}

      if (isEmptyFieldData()) {
               JOptionPane.showMessageDialog(null,
               "Cannot update an empty record");
               return;
            }
String sha1password = DigestUtils.shaHex(jpf1Text);
p2.setPassword(sha1password);
            if (User.update(p2) != null)
               JOptionPane.showMessageDialog(
               null,"User with ID:" + String.valueOf(p2.getiduser()
               + " is updated successfully : encrypted" + sha1password));
      }});
      
nextRecord.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
           setFieldData(User.moveNext());
      }});
      
  previousRecord.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
setFieldData(User.movePrevious());
    }
      });

  firstRecord.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
      
 setFieldData(User.moveFirst());
    }
    
  });
     lastRecord.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
setFieldData(User.moveLast());
    }
  });
  
    }
   private void setFieldData(User p) {
      text1.setText(String.valueOf(p.getiduser()));
      text2.setText(p.getUsername());
      text3.setText(p.getPassword());
 
   }
     private boolean isEmptyFieldData() {
      return (text1.getText().trim().isEmpty()
         && text2.getText().trim().isEmpty()
         && text3.getText().trim().isEmpty()
       
      );
   }

     private User getFieldData() {
      User p2 = new User();
      
      p2.setUsername(text2.getText());
      p2.setPassword(text3.getText());
          return p2;
   }
}
