package com.library.services.accessitems;

public class LibraryItemInfo {

	private String id;
	private String title;
	private String status;
	private String dateBorrowed;
	private String dateDue;
	private String reservationDetail;
	private String location;
	private double fine;
	private double price;
	private String memberId;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getDateDue() {
		return dateDue;
	}
	public void setDateDue(String dateDue) {
		this.dateDue = dateDue;
	}
	public String getReservationDetail() {
		return reservationDetail;
	}
	public void setReservationDetail(String reservationDetail) {
		this.reservationDetail = reservationDetail;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	

}
