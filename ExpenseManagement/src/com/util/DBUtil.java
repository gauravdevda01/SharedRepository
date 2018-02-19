package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.User;

public class DBUtil 
{
	DBUtil obj=new DBUtil();
	
	public Connection getConnection()
	{
		Connection con=null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public void insertIntoDB(User user)
	{
		Connection con=obj.getConnection();
		PreparedStatement pst=null;
		Statement st=null;
		
		try {
			st=con.createStatement();
			st.execute("use Expense_Management");
			
			pst=con.prepareStatement("insert into User(First_Name, middle_name, last_name, user_name, email_id, mobile_num, is_active) values(?,?,?,?,?,?,?)");
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getMiddleName());
			pst.setString(3, user.getLastName());
			pst.setString(4, user.getUserName());
			pst.setString(5, user.getEmail());
			pst.setInt(6, user.getMobileNum());
			pst.setString(7, "N");
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public User checkCredentials(String userName, String pwd)
	{
		Connection con=obj.getConnection();
		Statement st=null;
		ResultSet rs=null;
		User user=new User();
		
		try {
			
			st=con.createStatement();
			
			st.execute("use Expense_Management");
			
			rs=st.executeQuery("select first_name, middle_name, last_name, email_id, mobile_num, user_name, password, role_id, is_active from User where user_name="+userName+"&& password="+pwd+"&& is_active='Y");
			
			while(rs.next())
			{
				user.setFirstName(rs.getString("first_name"));
				user.setMiddleName(rs.getString("middle_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email_id"));
				user.setMobileNum(rs.getInt("mobile_num"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setRoleId(rs.getInt("role_id"));
//				user.setIsActive(rs.getString("is_active");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}
}
