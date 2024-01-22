package com.Him.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Hotel")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customer_Id;
	@Column(name="booking_room")
	private int booking_room;
	@Column(name="food_ordered")
	private String food_ordered;
	public long getCustomerId() {
		return customer_Id;
	}
	public void setCustomerId(long customer_Id) {
		this.customer_Id = customer_Id;
	}
	public int getBooking_room() {
		return booking_room;
	}
	public void setBooking_room(int booking_room) {
		this.booking_room = booking_room;
	}
	public String getFood_ordered() {
		return food_ordered;
	}
	public void setFood_ordered(String food_ordered) {
		this.food_ordered = food_ordered;
	}
	public Hotel() {
		
	}
	public Hotel(long customerId, int booking_room, String food_ordered) {
		super();
		this.customer_Id=customer_Id;
		this.booking_room = booking_room;
		this.food_ordered = food_ordered;
	}
	@Override
	public String toString() {
		return "Hotel [customer_Id=" + customer_Id + ", booking_room=" + booking_room + ", food_ordered=" + food_ordered
				+ "]";
	}
	

}
