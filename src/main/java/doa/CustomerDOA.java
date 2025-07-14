package doa;

import java.util.List;

import app.JPAUtil;
import entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CustomerDOA {
	public static void addCustomer(Customer c) {
		EntityTransaction transaction =null;
		try(EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager()){
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(c);
			transaction.commit();
			System.out.println("Customer added....");
		}catch(Exception e) {
			if(transaction!=null)
			{
				transaction.rollback();
			}
			System.out.println("Can not add Customer :"+e.getMessage());
		}
	}//addCustomer
	
	public static void removeCustomer(int customer_id) {
		EntityTransaction transaction = null;
		try(EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager()){
			transaction =entityManager.getTransaction();
			transaction.begin();
			Customer c= entityManager.find(Customer.class, customer_id);
			entityManager.remove(c);
			transaction.commit();
			System.out.println("Customer removed ");
		}catch(Exception e ) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println("Can not remove Customer "+e.getMessage());
		}
	}//removeCustomer
	
	public static List<Customer> getAllCustomer(){
		try(EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager()){
			return entityManager.createQuery("From Customer ",Customer.class).getResultList();
		}catch(Exception e) {
			System.out.println("Can not get Customer :"+e.getMessage());
		}
		return null;
	}//getAllCustomer
	
	
	public static Customer getCustomerById(int customer_id) {
		try(EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager()){
			return entityManager.find(Customer.class, customer_id);
		}catch(Exception e) {
			System.out.println("Can not get customer by Id :"+e.getMessage());
		}
		return null;
	}//getCustomerById
}
