package com.library.services.useroperations;

import com.library.integration.DatabaseConnection;
import java.sql.*;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;

public class MemberShipId {
	
	//private static final String COUNTY = "spingfield";
	private MemberInfo memberInfo;
	private DatabaseConnection dbConn;
	 public MemberShipId()
	 {
		 this.dbConn = new DatabaseConnection(); 
	 }

	DatabaseConnection getDbConn() {
		return dbConn;
	}
	void setDbConn(DatabaseConnection dbConn) {
		this.dbConn = dbConn;
	}
	MemberInfo getMemberInfo() {
		return memberInfo;
	}
	void setMemberInfo(MemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}
	
	public MemberShipId(MemberInfo memberInfo)
	{
		this.memberInfo = memberInfo;
		
		this.dbConn = new DatabaseConnection();
	}
	public void getMembershipId()
	{
		return;
	}
	public String issueMembershipCard(MemberInfo memberInfo)
	{
		String memberId;
		Date date = new Date();
		memberId = generateMemberId();
		memberInfo.setMemberId(memberId);
		memberInfo.setStartDate(date.toString());
		
		insertMemberInfo(memberInfo);
		
		
		
		return String.valueOf(memberId);
	}
	private int insertMemberInfo(MemberInfo memberinfo)
	{
		Connection conn;
		Statement stmt;
		String sql;
		
		conn = getDbConn().getConnection();
		try {
			stmt = conn.createStatement();
		      sql = "INSERT memberinfo values('"+(memberinfo.getMemberId())+"','"+memberinfo.getName()+"','"+memberinfo.getCounty()+"','"+memberinfo.getEmail()+"','"+memberinfo.getPhoneNumber()+"','"+memberinfo.getStartDate()+"');";    
		      System.out.print(sql);
		      stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			getDbConn().closeConnection(conn);
		}
	      

		
		return 0;
	}
	private String generateMemberId()
	{
		MemberInfo memberInfo;
		memberInfo = getMemberInfo();
		
		return memberInfo.getPhoneNumber();
	}
	public boolean validateMemberId(String memberId)
	{
		Connection conn = null;
		Statement stmt;
		String sql;
		ResultSet result = null;
		boolean isValid = false;
		 sql = "select memberid from memberinfo where memberid='"+memberId+"';";
		
		try {
			conn = getDbConn().getConnection();
			stmt = conn.createStatement();
			result = stmt.executeQuery(sql);
			System.out.println(result);
			if(result.next())
				isValid = true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn != null)
				getDbConn().closeConnection(conn);
		}
	    
		return isValid;
		    
	}
	public int queryTotalMembers()
	{
		return 0;
	}
	
	public MemberInfo queryForMemberInfo(String memberId)
	{
		return null;
	}
	

}
