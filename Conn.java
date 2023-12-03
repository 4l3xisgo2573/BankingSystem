package bank.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");  
        c = DriverManager.getConnection("jdbc:mysql:///bankmanagementSystem", "root", "Spool.1337");
        s = c.createStatement();
    } catch(Exception e){
       System.out.print(e);
    }
    
  }
}
