package com.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {

	private static MailUtil mailUtil=null;
	private Properties properties =null;

	private MailUtil()
	{
		if(mailUtil==null)
		{
			mailUtil=new MailUtil();
			properties=PropertyUtil.getAllProperties();
		}
	}
	
	public void sendMain(ExpenseConstants.MAIL_TYPE mailType)
	{
		System.out.println("userName: "+properties.getProperty("mail.username") +" , pwd: "+properties.getProperty("mail.pwd"));
		Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(properties.getProperty("mail.username"), properties.getProperty("mail.pwd"));
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(properties.getProperty("mail.from")));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("gauravdummy1@gmail.com"));
            message.setSubject(mailType.equals(ExpenseConstants.MAIL_TYPE.APPROVAL_REQUEST)?properties.getProperty("mail.approval.subject"):properties.getProperty("mail.confirmation.subject"));
            message.setText("Dear Mail Crawler," +
                    "\n\n No spam to my email, please!");

            Transport.send(message);
            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

	  
	}
}
