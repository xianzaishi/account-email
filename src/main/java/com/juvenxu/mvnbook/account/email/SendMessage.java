package com.juvenxu.mvnbook.account.email;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SendMessage {
//	@Autowired
//	@Qualifier("AccountEmailServiceImpl")
//	private static AccountEmailServiceImpl accountEmailService; // = new AccountEmailServiceImpl();
	
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
		AccountEmailService accountEmailService = (AccountEmailService) ctx.getBean("accountEmailService");
		
		String subject = "Test Subject";
		String htmlText = "<h3>Test</h3>";
		accountEmailService.sendMail("xianzaishi@gmail.com", subject, htmlText);
	}
}
