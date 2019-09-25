package harsh.rane.util;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DbUtil {
	
	@Autowired
	private EntityManagerFactory entitymanagerfactory; 
	
	@Bean
	public SessionFactory getSessionFactory() 
	{
		SessionFactory sessionfactory=entitymanagerfactory.unwrap(SessionFactory.class);
		
		if(sessionfactory==null)	
		{throw new NullPointerException("factory is not hibernate factory");}
		
		return sessionfactory;
	}
}
