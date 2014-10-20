package com.library.services.accessitems;

import java.util.ArrayList;
import java.util.List;

public interface LibraryItemInterface {

	
	List<LibraryItemInfo> queryForItem(String searchCriteria);
	boolean validateItemId( String itemId);
    int updateFineAmountInTable(String memberId);
	int updateItemStatusInTable(String memberId, String itemId, String status);
	int updateReserveStatusInTable(String memberId,String itemId);
	int addItemInTable(LibraryItemInfo itemInfo);
	List<LibraryItemInfo> queryTotalItems();
	int queryNumberOfCheckedOutItems();
	int queryTotalFine(String memberId);
	int updateLostItemStatus(String itemId);
	List<LibraryItemInfo> queryForCheckedoutItem(String memberId);
	boolean isItemAvailable(String itemId);
	boolean checkMemberItemAssociation(String memberId,String itemId);
	boolean validateItemPrice(String itemId,double price);
	String getReservedStatus(String itemId);
	
}
