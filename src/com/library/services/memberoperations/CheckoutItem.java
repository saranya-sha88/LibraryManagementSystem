package com.library.services.memberoperations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.library.services.accessitems.Book;
import com.library.services.accessitems.BookInfo;
import com.library.services.accessitems.LibraryItemInfo;
import com.library.services.accessitems.Video;
import com.library.services.txhistory.TransactionHistory;
import com.library.services.txhistory.TransactionHistoryInfo;
import com.library.services.validation.Validation;

public class CheckoutItem {
	
    private static final String ITEM_STATUS = "checkedout";
    private static final int FICTION_BOOK_LIMIT = 3;
    private static final int NON_FICTION_BOOK_LIMIT = 2;
    private static final int VIDEO_LIMIT = 2;
	private Book checkoutBook;// = new Book();
	private Video checkoutVideo;
	private TransactionHistory txHistory;
	private Fine fine;
	private Validation validate;
	private TransactionHistoryInfo transactionHistoryInfo;
	
	
	public CheckoutItem()
	{
		validate = new Validation();
		checkoutBook = new Book();
		checkoutVideo = new Video();
		txHistory = new TransactionHistory();
	}
	
	public List<LibraryItemInfo> checkout(String memberId, String itemId)
	{
		List<LibraryItemInfo> bookList, videoList;
		
		updateStatusInTable(memberId,itemId);
		
		bookList = checkoutBook.queryForCheckedoutItem(memberId);
		videoList = checkoutVideo.queryForCheckedoutItem(memberId);
		
		bookList.addAll(videoList);
		
		insertIntoTxHistory(itemId);
		
		return bookList;
	}
	
	private void insertIntoTxHistory(String itemId)
	{
		List<LibraryItemInfo> itemList;
		TransactionHistoryInfo txHistoryInfo = new TransactionHistoryInfo();
		
		if(itemId.contains("V"))
		{
			itemList = checkoutVideo.queryForItem(itemId);
		}else{
			itemList = checkoutBook.queryForItem(itemId);
		}
		
		System.out.println("itemList size :"+itemList.size());
		if(null != itemList && itemList.size() > 0)
		{
			txHistoryInfo.setItemId(itemList.get(0).getId());
			txHistoryInfo.setTitle(itemList.get(0).getTitle());
			txHistoryInfo.setStatus(itemList.get(0).getStatus());
			txHistoryInfo.setDateBorrowed(itemList.get(0).getDateBorrowed());
			txHistoryInfo.setDueDate(itemList.get(0).getDateDue());
			txHistoryInfo.setMemberId(itemList.get(0).getMemberId());
			
		}
		
		txHistory.insertRowInTxTable(txHistoryInfo);
		
	}
	
	public Map<String,String> checkMaximumCheckouts(String memberId)
	{
		List<LibraryItemInfo> bookList,videoList;
		Map<String,String> checkoutInfo = new HashMap<String,String>();
		int fbookCount = 0, nfbookCount = 0, videoCount = 0;
		BookInfo bookInfo;
		
		bookList = checkoutBook.queryForCheckedoutItem(memberId);
		videoList = checkoutVideo.queryForCheckedoutItem(memberId);
		
		if(null != bookList && bookList.size() > 0)
		{
			for(LibraryItemInfo itemInfo : bookList)
			{
				bookInfo = (BookInfo) itemInfo;
				if(bookInfo.getType().equalsIgnoreCase("Fiction"))
				{
					fbookCount++;
				}else{
					nfbookCount++;
				}
				
			}
		}
		
		if(null != videoList && videoList.size() > 0)
		{
			videoCount = videoList.size();
		}
		
		if(fbookCount == FICTION_BOOK_LIMIT)
		{
			checkoutInfo.put("FB", "EXCEEDED");
		}
		
		if(nfbookCount == NON_FICTION_BOOK_LIMIT)
		{
			checkoutInfo.put("NFB", "EXCEEDED");
		}
		
		if(videoCount == VIDEO_LIMIT)
		{
			checkoutInfo.put("V", "EXCEEDED");
		}
		return checkoutInfo;
	}
	
	private int updateStatusInTable(String memberId,String itemId)
	{
		int updateStatus = 0;
		
		if(itemId.contains("V"))
		{
			updateStatus = checkoutVideo.updateItemStatusInTable(memberId, itemId, ITEM_STATUS);	
		}else{
			updateStatus = checkoutBook.updateItemStatusInTable(memberId, itemId, ITEM_STATUS);
		}
		
		return updateStatus;
	}
	
	public boolean isItemAvailable(String itemId)
	{
		boolean isItemAvail = false;
		
		if(itemId.contains("V"))
		{
			isItemAvail = checkoutVideo.isItemAvailable(itemId);
		}else{
			isItemAvail = checkoutBook.isItemAvailable(itemId);
		}
		return isItemAvail;
	}
	
	private boolean checkForFines(String memberId)
	{
		return true;
	}

/*	public static void main(String args[])
	{
		boolean isItemAvail = false;
		List<LibraryItemInfo> list;
		Map<String,String> checkedoutItem = new HashMap<String,String>();
		CheckoutItem checkout = new CheckoutItem();
		//checkedoutItem = checkout.checkMaximumCheckouts("4086469659");
		list = checkout.checkout("4086469659", "F1001");
		System.out.print("checout Item        "+list.size());
		
	}*/
}
