package com.library.services.memberoperations;

import com.library.services.accessitems.Book;
import com.library.services.accessitems.Video;
import com.library.services.txhistory.TransactionHistory;
import com.library.services.txhistory.TransactionHistoryInfo;
import com.library.services.validation.Validation;

public class ReserveItem {
	
	private Book reserveBook;// = new Book();
	private Video reserveVideo;
	private TransactionHistory txHistory;
	private Validation valid;
	private TransactionHistoryInfo transactionHistoryInfo;

	public int reserveBookVideo(String memberId, String itemId)
	{
		return 0;
	}


	
	private int updateStatusInTable(String memberId,String id)
	{
		return 0;
	}
}
