package com.netapp.ngdc.devexp.azuredevopsapiaccess.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RemainderService {
	
	private Connection con;
	
	public RemainderService() {
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost/myDB;org.postgresql.Driver");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String addRemainder(Remainder remainder) {
		String result = "success";
		String query="Insert into Remainder(id,name,date,time,status) "
				+ "	values("+remainder.getId()+",'"+remainder.getName()
				+"',"+remainder.getrDate()+",'"+remainder.getrTime()+",'"
				+remainder.getStatus()+"')";
		try {
			Statement st=con.createStatement();
			st.executeQuery(query);
		} catch (SQLException e) {
			return "failed";
		}
		return result;
	}
	
	public String removeRemainder(Remainder remainder) {
		String result = "success";
		String query="Delete from Remainder where id='"+remainder.getId()+"'";
		try {
			Statement st=con.createStatement();
			st.executeQuery(query);
		} catch (SQLException e) {
			return "failed";
		}
		return result;		
	}
	
	public String updateRemainder(Remainder remainder) {
		String result = "success";
		String query="Update Remainder set name='"+remainder.getName()+"', date='"
				+remainder.getrDate()+"', time='" +remainder.getrTime()
				+"' where id='"+remainder.getId()+"'";
		try {
			Statement st=con.createStatement();
			st.executeQuery(query);
		} catch (SQLException e) {
			return "failed";
		}
		return result;		
	}
	
	public String viewRemainder(Remainder remainder) {
		String result = "success";
		System.out.println(remainder);
		return result;		
	}
	
	public Remainder getRemainderById(int remainderId) {
		Remainder remainder=null;
		String query="Select * from Remainder wherre id='"+remainder.getId()+"'";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			remainder=new Remainder(rs.getInt("id"),rs.getString("name"),rs.getString("date"),
					rs.getString("time"),rs.getString("staus"));
		} catch (SQLException e) {
			return null;
		}
		return remainder;
	}
	
	public int getMaxID() {
		int id=1;
		String query="Select max(id) from Remainder";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			id=rs.getInt(0);
		} catch (SQLException e) {
			return 0;
		}		
		return id;
	}

}
