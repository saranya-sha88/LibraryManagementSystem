package com.library.services.useroperations;

import java.util.List;

import com.library.services.accessitems.LibraryItemInfo;

public class MemberInfo {

		private String name;
		private String county;
		private String email;
		private String phoneNumber;
		private String startDate;
		private boolean isFeePaid;
		private String memberId;
		private List<LibraryItemInfo> checkedOutItems;
		private boolean isFbookLimitExceeded = false;
		private boolean isNFbookLimitExceeded = false;
		private boolean isVideoLimitExceeded = false;
		private boolean isInvalidCredentials = false;
		private double fineOverdue = 0;
		
		
		
		
		
		
		
		public boolean isFbookLimitExceeded() {
			return isFbookLimitExceeded;
		}
		
		public void setFbookLimitExceeded(boolean isFbookLimitExceeded) {
			this.isFbookLimitExceeded = isFbookLimitExceeded;
		}
		
		public boolean isNFbookLimitExceeded() {
			return isNFbookLimitExceeded;
		}
		
		public void setNFbookLimitExceeded(boolean isNFbookLimitExceeded) {
			this.isNFbookLimitExceeded = isNFbookLimitExceeded;
		}
		
		public boolean isVideoLimitExceeded() {
			return isVideoLimitExceeded;
		}
		
		public void setVideoLimitExceeded(boolean isVideoLimitExceeded) {
			this.isVideoLimitExceeded = isVideoLimitExceeded;
		}
		
		public boolean isInvalidCredentials() {
			return isInvalidCredentials;
		}
		
		public void setInvalidCredentials(boolean isInvalidCredentials) {
			this.isInvalidCredentials = isInvalidCredentials;
		}
		
		public double getFineOverdue() {
			return fineOverdue;
		}
		
		public void setFineOverdue(double fineOverdue) {
			this.fineOverdue = fineOverdue;
		}
		
		public List<LibraryItemInfo> getCheckedOutItems() {
			return checkedOutItems;
		}
		
		public void setCheckedOutItems(List<LibraryItemInfo> checkedOutItems) {
			this.checkedOutItems = checkedOutItems;
		}
		
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		
		public String getMemberId() {
			return memberId;
		}
		public void setMemberId(String memberId) {
			this.memberId = memberId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCounty() {
			return county;
		}
		public void setCounty(String county) {
			this.county = county;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getStartDate() {
			return startDate;
		}
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		public boolean isFeePaid() {
			return isFeePaid;
		}
		public void setFeePaid(boolean isFeePaid) {
			this.isFeePaid = isFeePaid;
		}
	
		
}
