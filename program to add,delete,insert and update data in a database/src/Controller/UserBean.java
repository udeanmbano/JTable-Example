/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.User;
import com.sun.rowset.JdbcRowSetImpl;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;

/**
 *
 * @author Mbano
 */
public class UserBean {
      static final String JDBC_DRIVER =
      "com.mysql.jdbc.Driver";
   static final String DB_URL =
      "jdbc:mysql://localhost:3306/mydatabase";
   static final String DB_USER = "root";
   static final String DB_PASS = "";
   private JdbcRowSet rowSet = null;
   public UserBean(){
      try {
         Class.forName(JDBC_DRIVER);
         rowSet = new JdbcRowSetImpl();
         rowSet.setUrl(DB_URL);
         rowSet.setUsername(DB_USER);
         rowSet.setPassword(DB_PASS);
         rowSet.setCommand("SELECT * FROM user Order by iduser ASC");
         rowSet.execute();
      }
      catch (SQLException | ClassNotFoundException ex) {
         ex.printStackTrace();
      }
   }
   public User create(User p) {
      try {
         rowSet.moveToInsertRow();
         rowSet.updateInt("iduser", p.getiduser());
         rowSet.updateString("username", p.getUsername());
         rowSet.updateString("password", p.getPassword());
       
         rowSet.insertRow();
         rowSet.moveToCurrentRow();
      } catch (SQLException ex) {
         try {
            rowSet.rollback();
            p = null;
         } catch (SQLException e) {

         }
         ex.printStackTrace();
      }
      return p;
   }

   public User update(User p) {
      try {
         rowSet.updateString("username", p.getUsername());
         rowSet.updateString("password", p.getPassword());
               rowSet.updateRow();
         rowSet.moveToCurrentRow();
      } catch (SQLException ex) {
         try {
            rowSet.rollback();
         } catch (SQLException e) {

         }
         ex.printStackTrace();
      }
      return p;
   }

   public void delete() {
      try {
         rowSet.moveToCurrentRow();
         rowSet.deleteRow();
      } catch (SQLException ex) {
         try {
            rowSet.rollback();
         } catch (SQLException e) { }
         ex.printStackTrace();
      }

   }

   public User moveFirst() {
      User p = new User();
      try {
         rowSet.first();
         p.setiduser(rowSet.getInt("iduser"));
         p.setUsername(rowSet.getString("username"));
         p.setPassword(rowSet.getString("password"));
     
      } catch (SQLException ex) {
         ex.printStackTrace();
      }
      return p;
   }

   public User moveLast() {
      User p = new User();
      try {
         rowSet.last();
         p.setiduser(rowSet.getInt("iduser"));
         p.setUsername(rowSet.getString("username"));
         p.setPassword(rowSet.getString("password"));
       

      } catch (SQLException ex) {
         ex.printStackTrace();
      }
      return p;
   }

   public User moveNext() {
      User p = new User();
      try {
         if (rowSet.next() == false)
            rowSet.previous();
         p.setiduser(rowSet.getInt("iduser"));
         p.setUsername(rowSet.getString("username"));
         p.setPassword(rowSet.getString("password"));
   

      } catch (SQLException ex) {
         ex.printStackTrace();
      }
      return p;
   }

   public User movePrevious() {
      User p = new User();
      try {
         if (rowSet.previous() == false)
            rowSet.next();
         p.setiduser(rowSet.getInt("iduser"));
         p.setUsername(rowSet.getString("username"));
         p.setPassword(rowSet.getString("password"));
     } catch (SQLException ex) {
         ex.printStackTrace();
      }
      return p;
   }

   public User getCurrent() {
      User p = new User();
      try {
         rowSet.moveToCurrentRow();
         p.setiduser(rowSet.getInt("iduser"));
         p.setUsername(rowSet.getString("username"));
         p.setPassword(rowSet.getString("password"));
         } catch (SQLException ex) {
         ex.printStackTrace();
      }
      return p;
   }
}
