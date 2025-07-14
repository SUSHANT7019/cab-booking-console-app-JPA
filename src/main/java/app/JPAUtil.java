package app;




import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf;
    static 
    {
        try 
        {
            emf = Persistence.createEntityManagerFactory("Cab_Booking");
        } catch (Throwable e)
        	{
        	throw new ExceptionInInitializerError(e);
        	}
    }

    public static EntityManagerFactory getEntityManagerFactory() 
    {
        return emf;
    }
    public static void shutDown()
    {

    	if(emf!=null && emf.isOpen())
    	{

    		emf.close();

    	}
    }
}