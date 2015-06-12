package com.juvenxu.mvnbook.account.email;

import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.mail.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;

public class AccountEmailServiceTest {
	private GreenMail greenMail;
	
	@Before
	public void startMailServer(){
		greenMail = new GreenMail(ServerSetup.SMTP);
		greenMail.setUser("hlzhange@gmail.com", "stevejobs");
		greenMail.start();
	}
	
	@Test
	public void testSendMail() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
		AccountEmailService accountEmailService = (AccountEmailService) ctx.getBean("accountEmailService");
		
		String subject = "Test Subject";
		String htmlText = "<h3>Test</h3>";
		accountEmailService.sendMail("xianzaishi@gmail.com", subject, htmlText);
		
		greenMail.waitForIncomingEmail(2000, 1);
		
		Message[] msgs = greenMail.getReceivedMessages();
		assertEquals(1, msgs.length);
		assertEquals(subject, msgs[0].getSubject());
		assertEquals(htmlText, GreenMailUtil.getBody(msgs[0]).trim());
	}
	
	@After
	public void stopMailServer() throws Exception{
		greenMail.stop();
	}
}











