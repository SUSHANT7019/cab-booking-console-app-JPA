package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Driver")
public class Driver {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int driver_id;

@Column(name ="name")
private String name;

@Column(name="available")
private boolean available;



public Driver() {  }


public Driver(String name, boolean available) {
	this.name = name;
	this.available = available;
}



public int getDriver_id() {
	return driver_id;
}


public void setDriver_id(int driver_id) {
	this.driver_id = driver_id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public boolean isAvailable() {
	return available;
}


public void setAvailable(boolean available) {
	this.available = available;
}


@Override
public String toString() {
	return "Driver [driver_id=" + driver_id + ", name=" + name + ", available=" + available + "]";
}





}
