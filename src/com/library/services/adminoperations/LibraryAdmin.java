package com.library.services.adminoperations;

import java.util.List;
import java.util.Map;

import com.library.services.accessitems.Book;
import com.library.services.accessitems.LibraryItemInfo;
import com.library.services.accessitems.Video;
import com.library.services.memberoperations.Fine;
import com.library.services.txhistory.TransactionHistory;
import com.library.services.useroperations.MemberShipId;

public class LibraryAdmin implements LibraryAdminInterface {
	
	private Book queryBook;
	private Video queryVideo;
	private TransactionHistory txHistory;
	private MemberShipId memberShip;
	
	

	@Override
	public Map<String,Integer> queryTotalBookVideo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryTotalMembers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryNumberOfCheckedoutItems() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String queryTitleOfMostCheckedOutBook(String monthYear) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryTotalFines(String fromDate, String toDate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void getGraph() {
		// TODO Auto-generated method stub
		
	}
	public int addItemToLibrary(LibraryItemInfo itemInfo) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
