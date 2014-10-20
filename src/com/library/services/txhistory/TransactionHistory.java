package com.library.services.txhistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.library.integration.DatabaseConnection;
import com.library.services.accessitems.LibraryItemInfo;
import com.library.services.memberoperations.Fine;

public class TransactionHistory {
	
	private DatabaseConnection dbConn; 
	private TransactionHistoryInfo txHistoryInfo;
	private Fine fine;/*Fine class is used for calculating fine amount whenever member query for TX history*/
	private Connection connection;
	private Statement statement;
	private PreparedStatement pStatement;
	
	
	public TransactionHistory()
	{
		dbConn = new DatabaseConnection();
	}
	
	public List<TransactionHistoryInfo> queryForTransactionHistory(String fromDate, String toDate,String memberId)
	{
		TransactionHistoryInfo txHistoryInfo;
		List<TransactionHistoryInfo> txList = new ArrayList<TransactionHistoryInfo>();
		
		 
		  String sql = "select itemid,memberid,title,dateborrowed,datedue,status,reservationdetail,finespaid,finesoverdue,finepaiddate,returneddate,txstartdate from txhistory where memberid = '"+memberId+"' and txStartDate between str_to_date('"+fromDate+"','%m-%d-%Y') and str_to_date('"+toDate+"','%m-%d-%Y') ;";
		  try
		  {
			  
			  connection  = dbConn.getConnection();
			  statement = connection.prepareStatement(sql);
			 // pStatement.setDate(0, fromDate);
			 // pStatement.setDate(1, (java.sql.Date) toDate);
			  ResultSet rs = statement.executeQuery(sql);
			  
			  while(rs.next())
			  {
				  txHistoryInfo = new TransactionHistoryInfo();
				  txHistoryInfo.setItemId(rs.getString("itemid"));
				  txHistoryInfo.setMemberId(rs.getString("memberid"));
				  txHistoryInfo.setTitle(rs.getString("title"));
				  txHistoryInfo.setDateBorrowed(rs.getString("dateborrowed"));
				  txHistoryInfo.setDueDate(rs.getString("datedue"));
				  txHistoryInfo.setStatus(rs.getString("status"));
				  txHistoryInfo.setFinesPaid(rs.getDouble("finespaid"));
				  txHistoryInfo.setFinesOverdue(rs.getDouble("finesoverdue"));
				  txHistoryInfo.setFinePaidDate(rs.getString("finepaiddate"));
				  txHistoryInfo.setReturnedDate(rs.getString("returneddate"));
				  txHistoryInfo.setTxStartDate(rs.getDate("txstartdate"));
				  
				  txList.add(txHistoryInfo);
				  
			  }
			  
			  
		  }catch(SQLException e)
		  {
			  
		  }
			
		return txList;
	}
	
	public int insertRowInTxTable(TransactionHistoryInfo txInfo)
	{
	
	  int insertStatus = 0;
	  String entryDateVal;
	  Date entryDate = new Date();
	  SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
	  entryDateVal = format.format(entryDate);
	  
	  txInfo.setTxStartDate(entryDate);
	  
	  String sql = "insert into txhistory values('"+txInfo.getItemId()+"','"+txInfo.getMemberId()+"','"+txInfo.getTitle()+"','"+txInfo.getDateBorrowed()+"','"+txInfo.getDueDate()+"','"+txInfo.getStatus()+"','"+txInfo.getReservedMember()+"','"+txInfo.getFinesPaid()+"','"+txInfo.getFinesOverdue()+"','"+txInfo.getFinePaidDate()+"','"+txInfo.getReturnedDate()+"',str_to_date('"+entryDateVal+"','%m-%d-%Y'));";
	  try
	  {
		  
		  connection  = dbConn.getConnection();
		   statement = connection.createStatement();
		  insertStatus = statement.executeUpdate(sql);
		  
		  
	  }catch(SQLException e)
	  {
		  
	  }
		return insertStatus;
	}
	
	public String queryTitleOfMostCheckedoutBook(String monthYear)
	{
		return null;
	}
	
	public int queryTotalFines(String fromDate, String toDate)
	{
		return 0;
	}
	
}
