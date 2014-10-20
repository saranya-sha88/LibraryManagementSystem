package com.library.services.txhistory;

import java.util.Date;

public class TransactionHistoryInfo {
	
	private String itemId;
	private String memberId;
	private String title;
	private String status;
	private String dateBorrowed;
	private String dueDate;
	private String director;
	private String reservedMember;
	private double finesPaid;
	private double finesOverdue;
	private String finePaidDate;
	private String returnedDate;
	private Date txStartDate;
	
	
	
	
	public Date getTxStartDate() {
		return txStartDate;
	}
	public void setTxStartDate(Date txStartDate) {
		this.txStartDate = txStartDate;
	}
	public String getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(String returnedDate) {
		this.returnedDate = returnedDate;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getFinePaidDate() {
		return finePaidDate;
	}
	public void setFinePaidDate(String finePaidDate) {
		this.finePaidDate = finePaidDate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getReservedMember() {
		return reservedMember;
	}
	public void setReservedMember(String reservedMember) {
		this.reservedMember = reservedMember;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDateBorrowed() {
		return dateBorrowed;
	}
	public void setDateBorrowed(String dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public double getFinesPaid() {
		return finesPaid;
	}
	public void setFinesPaid(double finesPaid) {
		this.finesPaid = finesPaid;
	}
	public double getFinesOverdue() {
		return finesOverdue;
	}
	public void setFinesOverdue(double finesOverdue) {
		this.finesOverdue = finesOverdue;
	}
	

}
