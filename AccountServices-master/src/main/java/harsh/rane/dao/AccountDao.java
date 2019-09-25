package harsh.rane.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import harsh.rane.entity.Account;

@Repository
public class AccountDao 
{
	private static final Logger LOGGER = LogManager.getLogger(AccountDao.class);
	
	@Autowired
	private SessionFactory sessionfactory;   												
	Session session=null;	
	
	public Account getAccoById(int accountid) 
	{
		session=sessionfactory.openSession();  
		session.beginTransaction();
		
		Account account = session.get(Account.class, accountid);
		
		session.getTransaction().commit();
		session.close();
		
		LOGGER.info("Fetched details from PatientAccount");
		return account;
	} 
}
