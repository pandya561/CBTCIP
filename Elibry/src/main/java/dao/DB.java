package dao;

import java.sql.*;

public class DB {
public static Connection getCon(){
	Connection con=null;
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:33060/jaydb?useSSL=false","root","J@y561");
		
	}catch(Exception e){System.out.println(e);}
	return con;
}
}
