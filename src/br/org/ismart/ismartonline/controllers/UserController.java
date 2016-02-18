package br.org.ismart.ismartonline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.ismart.ismartonline.models.User;

@Controller
public class UserController {
	

	@RequestMapping("/cadastro")
	public String novo() {

		return "usuario/form";

	}

	@RequestMapping("/cadastro/novo")
	public String salva(User user) {

	//	dao.salva(user);
		
		//sendMail(user);

		return "forward:login";
	}

	
//	public void sendMail(User user){
//		
//			Properties props = new Properties();
//            /** Parâmetros de conexão com servidor Gmail */
//            props.put("mail.smtp.host", "smtp.gmail.com");
//            props.put("mail.smtp.socketFactory.port", "465");
//            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//            props.put("mail.smtp.auth", "true");
//            props.put("mail.smtp.port", "465");
//
//            Session session = Session.getDefaultInstance(props,
//                        new javax.mail.Authenticator() {
//                             protected PasswordAuthentication getPasswordAuthentication() 
//                             {
//                                   return new PasswordAuthentication("juliocvidal@gmail.com", "");
//                             }
//                        });
//
//            /** Ativa Debug para sessão */
//            session.setDebug(true);
//
//            try {
//
//                  Message message = new MimeMessage(session);
//                  message.setFrom(new InternetAddress("juliocvidal@gmail.com")); //Remetente
//
//                  Address[] toUser = InternetAddress //Destinatário(s)
//                             .parse(user.getUsername());  
//
//                  message.setRecipients(Message.RecipientType.TO, toUser);
//                  message.setSubject("Complete seu cadastro no Ismart");//Assunto
//                  message.setText("Link para completar cadastro: (em construção)");
//                  /**Método para enviar a mensagem criada*/
//                  Transport.send(message);
//
//                  System.out.println("Feito!!!");
//
//             } catch (MessagingException e) {
//                  throw new RuntimeException(e);
//            }
//      
//		}


}
