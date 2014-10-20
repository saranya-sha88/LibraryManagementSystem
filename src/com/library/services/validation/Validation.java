package com.library.services.validation;

import com.library.services.accessitems.Book;
import com.library.services.accessitems.Video;
import com.library.services.useroperations.MemberShipId;

public class Validation {
	
	private Book book;
	private Video video;
	private MemberShipId memberShip;

	
	public Validation()
	{
		this.book = new Book();
		this.video = new Video();
		this.memberShip = new MemberShipId();
	}
	
	public boolean validateMemberId(String memberId)
	{
		boolean isValidMember;
		isValidMember = memberShip.validateMemberId(memberId);
		System.out.print(isValidMember);
		return isValidMember;
	}
	
	public boolean validateItemId(String itemId)
	{
		boolean isValidItem = false;
		
		if(itemId.contains("V"))
		{
			isValidItem = video.validateItemId(itemId);
		}else
		{
			isValidItem = book.validateItemId(itemId);
		}
		return isValidItem;
	}

	public boolean validateItemPrice(String itemId,double price)
	{
		return false;
	}
	

}
