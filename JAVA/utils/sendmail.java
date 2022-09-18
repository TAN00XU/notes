package com.hykes.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * 发送普通文本邮件
 * 1、创建session对象，加载properties对象
 * 2、通过session对象得到transport对象
 * 3、使用邮件的用户名和密码连接邮件服务器
 * 4、设置Message邮件对象
 * 5、发送邮件
 */
public class sendmail {
	public static void main(String[] args) throws MessagingException {
		
		// 设置邮件服务器的相关配置
		Properties props = new Properties();
		// 设置邮箱服务器的主机名
		props.setProperty("mail.smtp.host", "smtp.163.com");
		// 设置邮箱服务器的端口
		props.setProperty("mail.smtp.port", "25");
		// 设置邮箱服务器是否需要身份认证
		props.setProperty("mail.smtp.auth", "true");
		
		/*
		  使用javamail发送邮件
		 */
		Transport transport = null;
		for (int i = 0; i < 100; i++) {
//		1、创建session对象，加载properties对象
			Session session = Session.getInstance(props);
			session.setDebug(true);
//		2、通过session对象得到transport对象
			transport = session.getTransport();
//		3、使用邮件的用户名和密码连接邮件服务器
			transport.connect("smtp.163.com", "ming2776174480", "SWVJTFUKQQZUDICR");
//		4、设置Message邮件对象
			Message message = createSimpleMail(session);
//		5、发送邮件
			transport.sendMessage(message, message.getAllRecipients());
		}
		// 关闭对象
		transport.close();
		
	}
	
	private static Message createSimpleMail(Session session) throws MessagingException {
		// 创建邮件对象
		MimeMessage message = new MimeMessage(session);
		// 设置邮件的发送人
		message.setFrom("ming2776174480@163.com");
		// 设置邮件的收件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("2937678186@qq.com"));
		// 设置邮件的内容
		message.setSubject("测试邮件发送");
		// 设置发送日期
		message.setSentDate(new Date());
		// 设置邮件的文本内容
		message.setText("测试邮件发送");
		
		// 返回邮件对象
		return message;
	}
}
