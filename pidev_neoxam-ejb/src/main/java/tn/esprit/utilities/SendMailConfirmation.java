package tn.esprit.utilities;

import java.util.Properties;

import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Walid Hnaien
 */

@Stateless
public class SendMailConfirmation {
	private String smtpHost = "localhost";

	public static boolean SendMailScore(String mail, String output) throws MessagingException {
		boolean debug = false;

		// Set the host smtp address
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.user", "hnaien@gmail.com");
		props.put("mail.smtp.password", "05449764");
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		// create some properties and get the default Session
		Session session = Session.getDefaultInstance(props, null);
		session.setDebug(debug);

		// create a message
		Message msg = new MimeMessage(session);

		// set the from and to address
		InternetAddress addressFrom = new InternetAddress("hnaien@gmail.com");

		InternetAddress addressTo = new InternetAddress();
       	addressTo = new InternetAddress(mail);

		msg.setRecipient(Message.RecipientType.TO, addressTo);
		// Setting the Subject and Content Type
		msg.setFrom(addressFrom);

		msg.setSubject("OnlineTest Result");
		msg.setText(output);
		Transport t = session.getTransport("smtp");
		t.connect("smtp.gmail.com", "hnaien@gmail.com", "05449764");
		t.sendMessage(msg, msg.getAllRecipients());
		t.close();

		return true;

	}

	public SendMailConfirmation() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	public SendMailConfirmation(String email, String welcome, String welcome_to_getaway_app__) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}
}