package Controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Josphat Wanjiru
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
*
* @author Josphat Wanjiru
*/
public class connect
{
static PreparedStatement pre =null;
static Connection conn=null;
/**
* Connect to database
*/
 public static Connection ConnectDb()
 {
try{Class.forName("com.mysql.jdbc.Driver");
Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
return conn;
}catch (Exception e) {
return null;
}
}


    /**
     *
     * @return
     * @throws Exception
     */
    public static Vector getHostels()throws Exception
{
  conn = ConnectDb();
 pre = conn.prepareStatement("select * from person");

ResultSet rs = pre.executeQuery();
Vector<Vector<String>> hostelVector = new Vector<Vector<String>>();



while(rs.next())
{
Vector<String> hostel = new Vector<String>();
hostel.add(rs.getString(1)); 
hostel.add(rs.getString(2)); 
hostel.add(rs.getString(3)); 
hostel.add(rs.getString(4));
hostel.add(rs.getString(5));
hostel.add(rs.getString(6));
//
hostelVector.add(hostel);
}

/*Close the connection after use (MUST)*/
if(conn!=null)
conn.close();

return hostelVector;
}
    
/*     public static Vector getrooms()throws Exception
{
  conn = ConnectDb();
 pre = conn.prepareStatement("select * from rooms");

ResultSet rs = pre.executeQuery();
Vector<Vector<String>> roomsVector = new Vector<Vector<String>>();



while(rs.next())
{
Vector<String> rooms = new Vector<String>();
rooms.add(rs.getString(1)); 
rooms.add(rs.getString(2));

rooms.add(rs.getString(3)); 
rooms.add(rs.getString(4));



roomsVector.add(rooms);
}

Close the connection after use (MUST)
if(conn!=null)
conn.close();

return roomsVector;
}
    */
}
