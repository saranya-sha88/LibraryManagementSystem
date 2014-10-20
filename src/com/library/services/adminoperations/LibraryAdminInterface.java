package com.library.services.adminoperations;

import java.util.List;
import java.util.Map;

import com.library.services.accessitems.LibraryItemInfo;

public interface LibraryAdminInterface {
	
	Map<String,Integer> queryTotalBookVideo();
	int queryTotalMembers();
	int queryNumberOfCheckedoutItems();
	String queryTitleOfMostCheckedOutBook(String monthYear);
	int queryTotalFines(String fromDate, String toDate);
	void getGraph();
	int addItemToLibrary(LibraryItemInfo itemInfo);
	
	

}
