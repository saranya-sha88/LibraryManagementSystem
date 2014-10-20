package com.library.services.memberoperations;

import com.library.services.accessitems.Book;
import com.library.services.accessitems.Video;
import com.library.services.txhistory.TransactionHistory;
import com.library.services.txhistory.TransactionHistoryInfo;
import com.library.services.useroperations.MemberInfo;
import com.library.services.useroperations.MemberShipId;
import com.library.services.validation.Validation;

public class ReturnItem {
	
	private static final String ITEM_STATUS = "available";
	private Book returnBook;// = new Book();
	private Video returnVideo;
	private TransactionHistory txHistory;
	private Fine fine;
	private Validation validate;
	private TransactionHistoryInfo transactionHistoryInfo;
	private MemberInfo memberInfo;
	private MemberShipId memberShipId;
	
	public boolean returnBookVideo(String memberId, String id)
	{
		returnBook = new Book();
		returnVideo = new Video();
		memberShipId = new MemberShipId();
		validateCredentials(memberId,id);
		return true;
	}
	
	private boolean validateCredentials(String memberId, String id)
	{
		boolean isValid = true;
		isValid = memberShipId.validateMemberId(memberId);
		if(id.startsWith("V"))
		{
			isValid = returnVideo.validateItemId(id);
		
		}
		else
		{
			System.out.println("Item is a book!!!!!!!");
		isValid = returnBook.validateItemId(id);
		
		}
		
		
		return isValid;
	}
	
	private int updateStatusInTable(String memberId,String id)
	{
		return 0;
	}
	private boolean checkMemberItemAssociation(String memberId,String itemId)
	{
		return true;
	}
	private boolean checkForFines(String memberId)
	{
		return true;
	}
	
	private MemberInfo queryForMemberInfo( String memberId)
	{
		return null;
	}
	
	private int sendAlertMail(String emailAddress)
	{
		return 0;
	}
	private String getReservedStatus(String itemId)
	{
		return "";
	}
	
}
