package entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Booking")
public class Booking {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int booking_id;

@ManyToOne
@JoinColumn(name="Customer_id")
private Customer customer_id;

@ManyToOne
@JoinColumn(name="driver_id")
private Driver driver_id;


@Column(name="date")
private Date date;


public Booking() {  }


public Booking(Customer customer_id, Driver driver_id, Date date) {
	
	this.customer_id= customer_id;
	this.driver_id = driver_id;
	this.date = date;
}


public int getBooking_id() {
	return booking_id;
}


public void setBooking_id(int booking_id) {
	this.booking_id = booking_id;
}


public Customer getCustomer_id() {
	return customer_id;
}


public void setCustomer_id(Customer customer_id) {
	this.customer_id = customer_id;
}


public Driver getDriver_id() {
	return driver_id;
}


public void setDriver_id(Driver driver_id) {
	this.driver_id = driver_id;
}


public Date getDate() {
	return date;
}


public void setDate(Date date) {
	this.date = date;
}


@Override
public String toString() {
	return "Booking [booking_id=" + booking_id + ", customer_id=" + customer_id + ", driver_id=" + driver_id + ", date="
			+ date + "]";
}


 


}
