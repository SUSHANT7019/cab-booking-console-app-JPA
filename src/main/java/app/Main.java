package app;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import doa.BookingDOA;
import doa.CustomerDOA;
import doa.DriverDOA;
import entity.Booking;
import entity.Customer;
import entity.Driver;


public class Main {

public static Scanner sc= new Scanner(System.in);
	 public static void Exexute() {
		 int choice = 0;
		 do {
			 System.out.println("Enter 1 to add Driver ");
			 System.out.println("Enter 2 to remove Driver ");
			 System.out.println("Enter 3 to view Available Driver ");
			 System.out.println("Enter 4 to view All Driver ");
			 System.out.println("Enter 5 to view Driver by ID ");
			 System.out.println("Enter 6 to add customer ");
			 System.out.println("Enter 7 to remove customer ");
			 System.out.println("Enter 8 to view All Customer ");
			 System.out.println("Enter 9 to view Customer by ID ");
			 
			 System.out.println("Enter 10 to add Booking ");
			 System.out.println("Enter 11 to view All Booking ");
			 System.out.println("Enter 12 to cancle Booking ");
			 System.out.println("Enter 13 to view Booking by ID ");
			 System.out.println("Enter 0 to Exit ");
			 System.out.print("Enter your choice :");
			 choice = sc.nextInt();
			 sc.nextLine(); 
			 switch(choice) {
			 case 1 :
				 System.out.print("Enter Name of Driver :");
				 String name=sc.nextLine();
				 System.out.print("Is Driver available:");
				 boolean available =sc.nextBoolean();
				 sc.nextLine();
				 DriverDOA.registerDriver(new Driver(name,available));
				 break;
			 case 2:
				 System.out.print("Enter Driver ID to remove :");
				 int driver_id = sc.nextInt();
				 sc.nextLine();
				 DriverDOA.removeDriver(driver_id);
				 break;
			 case 3:
				 System.out.println("Available Drivers are:");
				 List<Driver> drivers = DriverDOA.getavAilableDriver();
				 drivers.forEach(System.out::println);
				 break;
				 
			 case 4:
				 System.out.println("All Drivers are:");
				 List<Driver> allDrivers = DriverDOA.getAllDriver();
				 allDrivers.forEach(System.out::println);
				 break;
				 
			 case 5:
				 System.out.print("Enter Driver ID to view :");
				 int id = sc.nextInt();
				 sc.nextLine();
				 Driver driver = DriverDOA.getDriverById(id);
				 if(driver != null) {
					 System.out.println("Driver Details: " + driver);
				 } else {
					 System.out.println("No Driver found with ID: " + id);
				 }
				 break;
			
			 case 6:
				 System.out.println("Enter Customer Details to add:");
				 System.out.print("Enter Customer Name: ");
				 String customerName = sc.nextLine();
				 System.out.print("Enter Customer Phone Number: ");
				 String customerPhone = sc.nextLine();
				 CustomerDOA.addCustomer(new Customer(customerName, customerPhone));
				 break;
				
			 case 7:
				 System.out.print("Enter Customer ID to remove: ");
				 int customerId = sc.nextInt();
				 sc.nextLine();
				 CustomerDOA.removeCustomer(customerId);
				 break;
				 
			 case 8:
				 System.out.println("All Customers are:");
				 List<Customer> allCustomers = CustomerDOA.getAllCustomer();
				 if(allCustomers != null && !allCustomers.isEmpty()) {
					 allCustomers.forEach(System.out::println);
				 } else {
					 System.out.println("No customers found.");
				 }
				 break;
				 
			 case 9:
				 System.out.print("Enter Customer ID to view: ");
				 int custId = sc.nextInt();
				 sc.nextLine();
				 Customer customer = CustomerDOA.getCustomerById(custId);
				 if(customer != null) {
					 System.out.println("Customer Details: " + customer);
				 } else {
					 System.out.println("No Customer found with ID: " + custId);
				 }
				 break;
				 
			 case 10:
				 List<Driver> availableDrivers = DriverDOA.getavAilableDriver();
				 if(availableDrivers.isEmpty()) {
					 System.out.println("No available drivers to book.");
				 } else {
					 System.out.print("Enter Customer ID for booking: ");
					 int custIdForBooking= sc.nextInt();
					 Customer c = CustomerDOA.getCustomerById(custIdForBooking);
					 sc.nextLine();
					 System.out.print("Enter Driver ID for booking: ");
					 int driverIdForBooking = sc.nextInt();
					 sc.nextLine();
			
					 Driver d = DriverDOA.getDriverById(driverIdForBooking);
					 if(d == null || !d.isAvailable()) {
						 System.out.println("Driver is not available for booking.");
					 } else {
					 DriverDOA.changeAvailability(driverIdForBooking);
					 BookingDOA.addBooking(new Booking(c, d, new Date(System.currentTimeMillis())));
					 System.out.println("Booking added successfully.");
					 }
				 }
				 
								 
				 break;
				 
				 case 11:
					 	List<Booking> allBookings = BookingDOA.getAllBooking();
					 if(allBookings != null && !allBookings.isEmpty()) 
					 {
						 	System.out.println("All Bookings are:");			 				 					 
					 allBookings.forEach(System.out::println);
					 } 
					 else 
					 {
						 	System.out.println("No bookings found.");
					 }
					 
				 break;
			case 12:
				 System.out.print("Enter Booking ID to cancel: ");
				 int bookingId = sc.nextInt();
				 sc.nextLine();
				 Booking booking = BookingDOA.getBookingById(bookingId);
				 if(booking != null) {
					 BookingDOA.cancleBooking(bookingId);
					 System.out.println("Booking cancelled successfully.");
				 } else {
					 System.out.println("No Booking found with ID: " + bookingId);
				 }
				 break;
				 
			case 13:
				 System.out.print("Enter Booking ID to view: ");
				 int bookingIdToView = sc.nextInt();
				 sc.nextLine();
				 Booking bookingDetails = BookingDOA.getBookingById(bookingIdToView);
				 if(bookingDetails != null) {
					 System.out.println("Booking Details: " + bookingDetails);
				 } else {
					 System.out.println("No Booking found with ID: " + bookingIdToView);
				 }
				 break;
			 case 0:
				 System.out.println("Exiting the application...");
				
				 break;
			 }
		 }while(choice != 0);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Main.Exexute();
	}

}
