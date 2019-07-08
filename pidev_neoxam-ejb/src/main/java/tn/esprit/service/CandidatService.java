package tn.esprit.service;

import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.pff.PSTException;
import com.pff.PSTFile;
import com.pff.PSTFolder;
import com.pff.PSTMessage;

import tn.esprit.dao.impl.CandidatCrud;
import tn.esprit.entities.Candidat;
import tn.esprit.service.inter.IcandidatServiceLocal;
import tn.esprit.service.inter.IcandidatServiceRemote;



@Stateless
@LocalBean
public class CandidatService implements IcandidatServiceLocal,IcandidatServiceRemote  {
	
		@PersistenceContext(unitName = "pidev")
		EntityManager em;
		@EJB
		CandidatCrud candCrud;
		

	@Override
	public String addCandidat(Candidat candidate) {
		return candCrud.addCandidat(candidate);
			
	}

	@Override
	public void removeCandidat(String Email) {
		candCrud.removeCandidat(Email);
		
	}

	@Override
	public void updateCandidat(Candidat candidateNewValue) {

		candCrud.updateCandidat(candidateNewValue);
	}

	@Override
	public Candidat findCandidatById(String Email) {
		// TODO Auto-generated method stub
		return candCrud.findCandidatById(Email);
	}

	@Override
	public List<Candidat> findAllCandidats() {
		// TODO Auto-generated method stub
		return candCrud.findAllCandidats();
	}

	@Override
	public List<Candidat> findCandidatsStringCriteria(String criteria, String value) {
		TypedQuery<Candidat> query = 
				em.createQuery("SELECT c FROM Candidat c WHERE "+ "c."+criteria+"=:value", Candidat.class); 
				query.setParameter("value", value); 
		return query.getResultList();
	}

	@Override
	public List<Candidat> findCandidatsByExp(Integer experience) {
		TypedQuery<Candidat> query = 
				em.createQuery("SELECT c FROM Candidat c WHERE c.Experience=:experience", Candidat.class); 
				query.setParameter("experience", experience); 
		return query.getResultList();
	}

	
	// email  configuration   
    final String senderEmailId = "neoxam0@gmail.com";
    final String senderPassword = "neoxam123";
    final String emailSMTPserver = "smtp.gmail.com";
    final String subject = "test invitation" ;
    final String messageText = "Following your application, I invite you to passe a quiz on our website www.neoxam.com";
	
    
    public void invitCandidat(String receiverEmail) {	
     
    	Properties props = new Properties();
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.host", emailSMTPserver);
    	props.put("mail.smtp.starttls.enable", "true");

     
    	try { 			
    		Authenticator auth = new SMTPAuthenticator();
                    Session session = Session.getInstance(props, auth);
    		Message message = new MimeMessage(session);
    		message.setFrom(new InternetAddress(senderEmailId));
    		message.setRecipients(Message.RecipientType.TO, 
    				InternetAddress.parse(receiverEmail));
    		message.setSubject(subject);
    		message.setText(messageText);
     
    		Transport.send(message); 
    		System.out.println("Email send successfully."); 
        } catch (Exception e) {
    	e.printStackTrace();
        System.err.println("Error in sending email.");
       }
    }
     
    private class SMTPAuthenticator extends 
      javax.mail.Authenticator {
        public PasswordAuthentication 
           getPasswordAuthentication() {
            return new PasswordAuthentication(senderEmailId, 
            		senderPassword);
        }
    }
    
    
    // PST part
	@Override
	public void extarctPst(String filename) {
		
		try {
            PSTFile pstFile = new PSTFile(filename);
            System.out.println(pstFile.getMessageStore().getDisplayName());
            processFolder(pstFile.getRootFolder());
        } catch (Exception err) {
            err.printStackTrace();
        }
		
	}
	
	int depth = -1;
    public void processFolder(PSTFolder folder)
            throws PSTException, java.io.IOException
    {
        depth++;
        // the root folder doesn't have a display name
        if (depth > 0) {
            printDepth();
            System.out.println(folder.getDisplayName());
        }

        // go through the folders...
        if (folder.hasSubfolders()) {
            Vector<PSTFolder> childFolders = folder.getSubFolders();
            for (PSTFolder childFolder : childFolders) {
                processFolder(childFolder);
            }
        }

        // and now the emails for this folder
        if (folder.getContentCount() > 0) {
            depth++;
            PSTMessage email = (PSTMessage)folder.getNextChild();
            while (email != null) {
                printDepth();
                System.out.println("Email: "+email.getSubject());
                email = (PSTMessage)folder.getNextChild();
            }
            depth--;
        }
        depth--;
    }

    public void printDepth() {
        for (int x = 0; x < depth-1; x++) {
            System.out.print(" | ");
        }
        System.out.print(" |- ");
    }
    
    

}
