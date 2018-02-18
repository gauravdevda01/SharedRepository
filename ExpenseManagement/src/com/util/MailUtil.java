package com.util;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bean.User;
import com.util.ExpenseConstants.MAIL_TYPE;

public class MailUtil {

	private static MailUtil mailUtil=null;
	private Properties properties =null;

	public static MailUtil getInstance()
	{
		if(mailUtil==null)
		{
			mailUtil=new MailUtil();
		}
		return mailUtil;
	}
	
	private MailUtil()
	{
		properties=PropertyUtil.getInstance().getAllProperties();
	}
	
	public void sendMain(ExpenseConstants.MAIL_TYPE mailType, List<String> recepientsMailIds, User user)
	{
		System.out.println("userName: "+properties.getProperty("mail.username") +" , pwd: "+properties.getProperty("mail.pwd"));
		Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(properties.getProperty("mail.username"), properties.getProperty("mail.pwd"));
                    }
                });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(properties.getProperty("mail.from")));
            InternetAddress recipients[]=new InternetAddress[recepientsMailIds.size()];
            int i=0;
            for(String mailId:recepientsMailIds)
            {
            	recipients[i++]=new InternetAddress(mailId);
            }
            message.setRecipients(Message.RecipientType.TO, recipients);
            message.setSubject(mailType.equals(ExpenseConstants.MAIL_TYPE.APPROVAL_REQUEST)?properties.getProperty("mail.approval.subject"):properties.getProperty("mail.confirmation.subject"));
            message.setText(getMessageBody(user, mailType),"utf-8","html");
            Transport.send(message);
            System.out.println("Email has been sent successfully ");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
	}
	
	public static void main(String a[])
	{
		MailUtil util= MailUtil.getInstance();
		User user=new User("Dummy", null,"SURNAME",null,null,null,null,null,null);
		util.sendMain(MAIL_TYPE.APPROVAL_REQUEST, Arrays.asList(new String[]{"gauravdummy1@gmail.com"}),user);
	}
	
	private String getMessageBody(User user, MAIL_TYPE mailType)
	{
		StringBuffer html=new StringBuffer("");
		if(mailType.equals(MAIL_TYPE.APPROVAL_REQUEST))
		{
			html.append("<h2 align=\"center\"> Expense Management </h2>");
			html.append("<p>User <b> "+user.getFirstName()+" "+user.getLastName()+" </b> has requested to get access. Please APPROVE/REJECT his request.</p>");
		}
		else 
		{
			html.append("<p> Your Request for Access to Expense Management has been approved. You cam login to expense Management");
		}
		return html.toString();
	}
}
