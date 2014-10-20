package com.library.services.accessitems;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.library.integration.DatabaseConnection;

public class Book implements LibraryItemInterface{

	
	private final int borrowPeriod = 15;
	private DatabaseConnection dbConn; 
	private LibraryItemInfo bookInfo;
	private Connection connection;
	private Statement statement;
	
	public Book()
	{
		dbConn = new DatabaseConnection();
	}
	
	@Override
	public int queryTotalFine(String memberId)
	{
		return 0;
	}

	@Override
	public List<LibraryItemInfo> queryTotalItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryNumberOfCheckedOutItems() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<LibraryItemInfo> queryForItem(String searchCriteria) {
		
		List<LibraryItemInfo> itemList = new ArrayList<LibraryItemInfo>();
		String sql = "select bookid,booktype,title,author,price,location,status,reservationdetail,fine,dateborrowed,datedue,memberid from BookTable where title like '%"+searchCriteria+"%' or author = '"+searchCriteria+"' or bookid = '"+searchCriteria+"'";
		try {
			connection = dbConn.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				BookInfo itemInfo = new BookInfo();
				itemInfo.setId(rs.getString("bookid"));
				itemInfo.setTitle(rs.getString("title"));
				itemInfo.setAuthor(rs.getString("author"));
				itemInfo.setLocation(rs.getString("location"));
				itemInfo.setStatus(rs.getString("status"));
				itemInfo.setPrice(rs.getDouble("price"));
				itemInfo.setReservationDetail(rs.getString("reservationdetail"));
				itemInfo.setFine(rs.getDouble("fine"));
				itemInfo.setType(rs.getString("booktype"));
				itemInfo.setDateBorrowed(rs.getString("dateborrowed"));
				itemInfo.setDateDue(rs.getString("datedue"));
				itemInfo.setMemberId(rs.getString("memberid"));
				itemList.add(itemInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			dbConn.closeConnection(connection);
		}
		return itemList;
	}

	@Override
	public boolean validateItemId(String itemId) {
		// TODO Auto-generated method stub

		Connection conn = null;
		Statement stmt;
		String sql;
		ResultSet result = null;
		boolean isValid=false;
		
		 sql = "select bookid from booktable where bookid='"+itemId+"';";
		
		try {
			conn = dbConn.getConnection();
			stmt = conn.createStatement();
			result = stmt.executeQuery(sql);
			System.out.println("result");
			if(result.next())
				isValid = true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbConn.closeConnection(conn);
		}
		return isValid;
		    
	
		
	}

	@Override
	public int updateFineAmountInTable(String memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateItemStatusInTable(String memberId, String itemId, String status) {
		
		String startDate,endDate;
		int updateStatus = 0;
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		
		Calendar calendar = Calendar.getInstance();
		
		try {
			
			startDate = dateFormat.format(currentDate);
			calendar.add(Calendar.DATE, borrowPeriod);
			endDate = dateFormat.format(calendar.getTime());
			
			String sql = "update bookTable set status='"+status+"', memberId ='"+memberId+"',dateborrowed ='"+startDate+"',datedue ='"+endDate+"' where bookid = '"+itemId+"' ";
			
			connection = dbConn.getConnection();
			statement = connection.createStatement();
			updateStatus =  statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			if(null != connection)
			dbConn.closeConnection(connection);
		}
		
	
		return updateStatus;
	}

	@Override
	public int updateReserveStatusInTable(String memberId, String itemId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addItemInTable(LibraryItemInfo itemInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateLostItemStatus(String itemId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isItemAvailable(String itemId) {
		
		boolean isItemAvail = false;
		String sql = "select * from bookTable where bookid = '"+itemId+"' and status = 'available' ";
		try {
			connection = dbConn.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next())
				isItemAvail = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			if(null != connection)
			dbConn.closeConnection(connection);
		}
		
		return isItemAvail;
	}

	@Override
	public boolean checkMemberItemAssociation(String memberId, String itemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateItemPrice(String itemId, double price) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LibraryItemInfo> queryForCheckedoutItem(String memberId) {
		
		List<LibraryItemInfo> itemList = new ArrayList<LibraryItemInfo>();
		String sql = "select bookid,booktype,title,author,price,location,status,reservationdetail,fine,dateborrowed,datedue,memberid from BookTable where memberId = '"+memberId+"' ";
		try {
			connection = dbConn.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				BookInfo itemInfo = new BookInfo();
				itemInfo.setId(rs.getString("bookid"));
				itemInfo.setTitle(rs.getString("title"));
				itemInfo.setAuthor(rs.getString("author"));
				itemInfo.setLocation(rs.getString("location"));
				itemInfo.setStatus(rs.getString("status"));
				itemInfo.setPrice(rs.getDouble("price"));
				itemInfo.setReservationDetail(rs.getString("reservationdetail"));
				itemInfo.setFine(rs.getDouble("fine"));
				itemInfo.setType(rs.getString("booktype"));
				itemInfo.setDateBorrowed(rs.getString("dateborrowed"));
				itemInfo.setDateDue(rs.getString("datedue"));
				itemInfo.setMemberId(rs.getString("memberid"));
				itemList.add(itemInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			if(null != connection)
			dbConn.closeConnection(connection);
		}
		return itemList;
	}

	@Override
	public String getReservedStatus(String itemId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}	

