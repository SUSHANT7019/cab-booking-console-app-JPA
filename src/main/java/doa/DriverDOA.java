package doa;

import java.util.List;

import app.JPAUtil;
import entity.Customer;
import entity.Driver;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DriverDOA {

	
	
	
	public static void registerDriver(Driver d)
	{
		EntityTransaction transaction=null;
		try(EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager()){
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(d);
			transaction.commit();
			
			System.out.println("\nDriver registered ...");
			
		}catch(Exception e) {
			if(transaction!=null) 
			{
			transaction.rollback();
			}
			System.out.println("\nCan not  register driver :" +e.getMessage());
		
		}
		
	}//registerDriver
	
	public static List<Driver> getavAilableDriver(){
		try(EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager()){
			return entityManager.createQuery("From Driver where available=TRUE",Driver.class).getResultList();
		}catch(Exception e) {
			System.out.println("Can Not Get Availabel Driver:"+e.getMessage());
			
		}
		return null;
	}//getavAilableDriver
	
	public static List<Driver> getAllDriver()
	{
		try(EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager()){
			System.out.println("Getting All Drivers");
			return entityManager.createQuery("From Driver",Driver.class).getResultList();
		}catch(Exception e) {
			System.out.println("Cant not get All Drivers:"+e.getMessage());
		}
		return null;
	}//getAllDriver
	
	public static void removeDriver(int driver_id) {
		EntityTransaction transaction=null;
		try(EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager()){
		    transaction = entityManager.getTransaction();
			transaction.begin();
		    Driver d=entityManager.find(Driver.class, driver_id);
			entityManager.remove(d);
			transaction.commit();
			System.out.println("Driver removed successfully");
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println("Can not remove Driver :"+e.getMessage());
		}
	}//removeDriver
	
	public static void changeAvailability(int driver_id) {
		EntityTransaction transaction= null; 
		try(EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();){
			transaction=entityManager.getTransaction();
			transaction.begin();
			Driver d = entityManager.find(Driver.class, driver_id);
			d.setAvailable(!d.isAvailable());
			entityManager.merge(d);
			transaction.commit();
		}
		catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println("Can not Upadte Driver :"+e.getMessage());
		}
	}//  changeAvailability
	
	
	public static Driver getDriverById(int driver_id) {
		try(EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager()){
			return entityManager.find(Driver.class, driver_id);
		}catch(Exception e) {
			System.out.println("Can not get Driver by Id :"+e.getMessage());
		}
		return null;
	}//getDriverById
	
}//Class END
