package com.library.services.memberoperations;

import com.library.services.accessitems.Book;
import com.library.services.accessitems.Video;
import com.library.services.txhistory.TransactionHistory;
import com.library.services.txhistory.TransactionHistoryInfo;
import com.library.services.validation.Validation;

public class LostItem {
	
	private Validation validation;
	
	private Book book;
	
	private Video video;
	
	private Fine fine;
	
	private TransactionHistory txHistory;
	
	private TransactionHistoryInfo txHistoryInfo;
	
	public LostItem()
	{
		book = new Book();
		video = new Video();
		txHistory = new TransactionHistory();
	}
	
	public boolean manageLostItem(String memberId, String itemId, double price)
	{
		
		return false;
	}
	
	private int updateLostItemStatus(String itemId) {
		
		return 0;
	}

}
