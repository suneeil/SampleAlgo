package com.selenium.jdbcConnect;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCOnnection {	
	public static void main(String[] args) {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String driver = "com.mysql.cj.jdbc.Driver";//"com.mysql.jdbc.Driver";
		String dbName = "testing";
		String username = "root";
		String pwd = "root";
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		CallableStatement calstmt=null;
		//Connect to DB : To connect to DB you need to create the object of DB
		//Fire the query 
		//Disconnect
		try{
			Class.forName(driver).newInstance();//Create a Object of Driver
			conn = DriverManager.getConnection(url+dbName,username,pwd);
			System.out.println(conn.isClosed());
			Statement st = conn.createStatement();
			rs = st.executeQuery("select * from employee");
			while(rs.next()){
				System.out.println(rs.getString("NAME")+" "+rs.getString(2) + " " + rs.getInt("AGE"));
			}
			//Fire Query
			//st.executeUpdate("INSERT INTO employee VALUES('Raj','Noida', 35)");
			//-------------------------------- Prepared statement to execute query with conditions--------------------------------
			pstmt = conn.prepareStatement("SELECT * FROM employee WHERE PLACE=? and AGE=?");
			pstmt.setString(1, "Shirdi");
			pstmt.setInt(2, 60);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println("-----"+rs.getString("NAME") + " " + rs.getString("PLACE"));
			}
			String insertQuery = "INSERT INTO employee"
					+ "(NAME, PLACE,AGE) VALUES"
					+ "(?,?,?)";
			pstmt = conn.prepareStatement(insertQuery);
			pstmt.setString(1, "Alex");
			pstmt.setString(2, "USA");
			pstmt.setInt(3, 40);
			
			pstmt.executeUpdate();
			System.out.println("Record Inserted");
			//After record is inserted fetch the updated record
			pstmt = conn.prepareStatement("SELECT * FROM employee WHERE PLACE=? and AGE=?");
			pstmt.setString(1, "USA");
			pstmt.setInt(2, 40);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println("Newly Inserted Data: "+rs.getString("NAME") + " " + rs.getString("PLACE"));
			}
			System.out.println("------------------------------");
			//--------------Stored procedure--------------
			/**
			 * 		1.Go to mysql
			 * 		2. In the MYSQL prompt type command "delimiter $$" and Hit enter
			 *      3. Enter the below lines  
			 * 			3a. CREATE PROCEDURE getAllCities()
							3b. BEGIN
							3c. select * from employee;
							3d. END$$
						4. Now change the delimiter by entering the command "delimiter ;" and hit enter 
						5. To call the procedure from MYSQL cmd prompt enter the command 
						 	5a. call getAllCities();
			 */
			String insertStoreProc = "{call getAllCities()}";
			calstmt = conn.prepareCall(insertStoreProc);
			/*	In case to pass argument to stored procedure 
			 * 	String insertStoreProc = "{call getAllCities(?,?,?)}";
			 * 	calstmt.setString(1, "");
				calstmt.setString(2, "");
				calstmt.setInt(3, 33);*/
			calstmt.executeUpdate();
			System.out.println(" CALLING THE STORED PROCEDURE");
			rs = (ResultSet) calstmt.getResultSet();
			while (rs.next()) {
				String name = rs.getString("NAME");
				String place = rs.getString("PLACE");
				System.out.println("NAME: "+ name + ", PLACE: "+ place);
			}
		}catch(Exception e){
			System.out.println("Connection ERROR");
			e.printStackTrace();
		}finally{
			try {
				
				if(rs!=null ){//&& (!rs.isClosed())
					System.out.println("Closing rs");
					rs.close();
				}
				if(pstmt!=null ){//&& (!pstmt.isClosed())
					System.out.println("Closing pstmt");
					pstmt.close();
				}
				if(calstmt!=null){// && (!calstmt.isClosed())
					System.out.println("Closing calstmt");
					calstmt.close();
				}
				
				if((conn!=null) && (!conn.isClosed())){
					System.out.println("Closing conn");
					conn.close();
				}else{
					System.out.println("There was No connection established");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
