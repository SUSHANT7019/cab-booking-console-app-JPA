package doa;

import java.util.List;

import app.JPAUtil;
import entity.Booking;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class BookingDOA {
	public static void addBooking(Booking b) {
		EntityTransaction transaction= null;
		
		try(EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager()){
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(b);
			transaction.commit();
			System.out.println("Booking added successfully with ID: " + b.getBooking_id());
		}catch(Exception e ) {
			if(transaction!=null) {
				transaction.rollback();
			}
			System.out.println("Can not add Booking :"+e.getMessage());
		}
	}//addBooking
	
	public static void cancleBooking(int booking_id)
	{
		EntityTransaction transaction=null;
		try(EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager()){
			transaction = entityManager.getTransaction();
			transaction.begin();
			Booking b = entityManager.find(Booking.class, booking_id);
			entityManager.remove(b);
			transaction.commit();
		}
		catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println("Can not cancle booking :"+e.getMessage());
		}
	}//cancleBooking
	
	public static List<Booking> getAllBooking(){
		try(EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager()){
			return entityManager.createQuery("From Booking",Booking.class).getResultList();
		}catch (Exception e) {
			System.out.println("Can not get All Booking : "+e.getMessage());
		}
		return null; 
	}//getAllBooking
	
	public static Booking getBookingById( int booking_id){
		try(EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager()){
			return entityManager.find(Booking.class, booking_id);
		}catch (Exception e) {
			System.out.println("Can not get  Booking By Id: "+e.getMessage());
		}
		return null; 
	}//getBookingById
	
	

}//BookingDOA
