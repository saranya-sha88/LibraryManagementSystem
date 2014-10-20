package com.library.services.memberoperations;

import java.util.List;

import com.library.services.accessitems.Book;
import com.library.services.accessitems.LibraryItemInfo;
import com.library.services.accessitems.Video;
import com.library.services.txhistory.TransactionHistory;
import com.library.services.txhistory.TransactionHistoryInfo;
import com.library.services.validation.Validation;

public class Fine {

	
	private double totalFine;
	private Book checkoutBook;
	private Video checkoutVideo;
	private TransactionHistory txHistory;
	private Validation validate;
	private TransactionHistoryInfo transactionHistoryInfo;
	private LibraryItemInfo itemInfo;
	
	public List<LibraryItemInfo> calculateFine(String memberId)
	{
		return null;
	}
	public int payFine(String memberId, double amount)
	{
		return 0;
	}
	
	private int updateFineAmountInTable(String memberId)
	{
		return 0;
	}
	
	public boolean checkForFines(String memberId)
	{
		return true;
	}
	
}
