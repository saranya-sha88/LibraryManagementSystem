package com.library.services.accessitems;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.library.integration.DatabaseConnection;

public class Video implements LibraryItemInterface{
	
	private final int borrowPeriod = 7;
	private DatabaseConnection dbConn;
	private LibraryItemInfo videoInfo;
	private Connection connection;
	private Statement stmt;
	
	
		public Video()
	{
		dbConn = new DatabaseConnection();
	}
		
		
	@Override
	public List<LibraryItemInfo> queryForItem(String searchCriteria) {
		List<LibraryItemInfo> itemList = new ArrayList<LibraryItemInfo>();
		String sql = "select videoid,title,director,price,location,status,reservationdetail,fine,dateborrowed,datedue,memberid from VideoTable where title like '%"+searchCriteria+"%' or director = '"+searchCriteria+"' or videoid = '"+searchCriteria+"'";
		try {
			connection = dbConn.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				VideoInfo videoInfo = new VideoInfo();
				videoInfo.setId(rs.getString("videoid"));
				videoInfo.setTitle(rs.getString("title"));
				videoInfo.setDirector(rs.getString("director"));
				videoInfo.setLocation(rs.getString("location"));
				videoInfo.setStatus(rs.getString("status"));
				videoInfo.setPrice(rs.getDouble("price"));
				videoInfo.setReservationDetail(rs.getString("reservationdetail"));
				videoInfo.setFine(rs.getDouble("fine"));
				videoInfo.setDateBorrowed(rs.getString("dateborrowed"));
				videoInfo.setDateDue(rs.getString("datedue"));
				videoInfo.setMemberId(rs.getString("memberid"));
				itemList.add(videoInfo);
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
	public boolean validateItemId(String itemId) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		//dbConn= new DatabaseConnection();
		//Connection conn = null;
		//Statement stmt;
		String sql;
		ResultSet result = null;
		boolean isValid=false;
		// sql = "select videoid from videotable where videoid="+itemId+";";
		sql = "select videoid from videotable where videoid = '"+itemId+"';";
		
		try {
			connection = dbConn.getConnection();
			stmt = connection.createStatement();
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
			dbConn.closeConnection(connection);
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
			
			String sql = "update videoTable set status='"+status+"', memberId ='"+memberId+"',dateborrowed ='"+startDate+"',datedue ='"+endDate+"' where videoId = '"+itemId+"' ";
			
			connection = dbConn.getConnection();
			stmt = connection.createStatement();
			updateStatus =  stmt.executeUpdate(sql);

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
	public int queryTotalFine(String memberId) {
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
		String sql = "select * from videoTable where videoId = '"+itemId+"' and status = 'available' ";
		try {
			connection = dbConn.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
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
		String sql = "select videoid,title,director,price,location,status,reservationdetail,fine,dateborrowed,datedue,memberid from VideoTable where memberId = '"+memberId+"' ";
		try {
			connection = dbConn.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				VideoInfo videoInfo = new VideoInfo();
				videoInfo.setId(rs.getString("videoid"));
				videoInfo.setTitle(rs.getString("title"));
				videoInfo.setDirector(rs.getString("director"));
				videoInfo.setLocation(rs.getString("location"));
				videoInfo.setStatus(rs.getString("status"));
				videoInfo.setPrice(rs.getDouble("price"));
				videoInfo.setReservationDetail(rs.getString("reservationdetail"));
				videoInfo.setFine(rs.getDouble("fine"));
				videoInfo.setDateBorrowed(rs.getString("dateborrowed"));
				videoInfo.setDateDue(rs.getString("datedue"));
				itemList.add(videoInfo);
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
