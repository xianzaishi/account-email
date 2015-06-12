package com.juvenxu.mvnbook.account.email;

public interface AccountEmailService {
	/**
	 * 发送html格式邮件
	 * @param to	接收地址
	 * @param subject	邮件主题
	 * @param htmlText	邮件内容
	 */
	void sendMail(String to, String subject, String htmlText);	// throws AccountEmailException;
}
