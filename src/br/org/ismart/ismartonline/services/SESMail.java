/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ismart.ismartonline.services;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SESMail { 
    
    static final String FROM = "naoresponda@ismartonline.com.br";
    static final String HOST = "email-smtp.us-east-1.amazonaws.com";
    static final int PORT = 587;
    static String SES_USERNAME;
    static String SES_PASSWORD;
    
    private final String subject;
    private final String content;
    private final String destinatary;
    
    public SESMail(String subject, String content, String destinatary) {
        this.subject = subject;
        this.content = content;
        this.destinatary = destinatary;
    }
    

    public void send() throws Exception {

        SES_USERNAME = System.getProperty("SES_USERNAME");
        SES_PASSWORD = System.getProperty("SES_PASSWORD");
    	Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtps");
    	props.put("mail.smtp.host", HOST); 
        props.put("mail.smtp.socketFactory.port", PORT);
    	props.put("mail.smtp.port", PORT); 
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.starttls.required", "true");

    	Session session = Session.getInstance(props);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(FROM));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(destinatary));
        message.setSubject(subject,"utf-8");
        message.setContent(content, "text/html; charset=utf-8");
        
        Transport transport = session.getTransport("smtp");
        transport.connect(HOST, PORT, SES_USERNAME, SES_PASSWORD);
        transport.sendMessage(message, message.getAllRecipients());

    }
}