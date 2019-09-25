package harsh.rane.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import harsh.rane.dao.AccountDao;
import harsh.rane.entity.Account;

@RestController
public class AccountController
{
	private static final Logger LOGGER = LogManager.getLogger(AccountController.class);
	
	@Autowired
	AccountDao acdao;
	
	@GetMapping(path="getdetails/{accountid}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Account getAccountbyid(@PathVariable int accountid)
	{
		Account account = acdao.getAccoById(accountid);
		
		if(account==null)
		{
			LOGGER.error("account id not valid");
			return null;
		}
		return account;
	}
}
