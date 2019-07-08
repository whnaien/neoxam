package tn.esprit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.esprit.dao.impl.OnlineTestDaoImp;
import tn.esprit.dao.inter.DaoQuestionRemoteDao;
import tn.esprit.dao.inter.OnlineTestRemoteDao;
import tn.esprit.entities.DaoQuestion;
import tn.esprit.entities.OnlineTest;
import tn.esprit.entities.Question;
import tn.esprit.service.inter.OnlineTestServiceLocal;
import tn.esprit.service.inter.OnlineTestServiceRemote;
import tn.esprit.service.inter.QuestionServiceLocal;
import tn.esprit.service.inter.QuestionServiceRemote;

@Stateless
public class QuestionServiceImp implements QuestionServiceRemote, QuestionServiceLocal {

	@EJB
	DaoQuestionRemoteDao ot;
	
	
	/**
	 * The following service is used to update an existent DAO question based
	 * on the Question entity. Using this manner, the business entity will 
	 * be segregated from the DAO entity because it does not have the same feature
	 * 
	 * @param questionId the first parameter is the question test id to modify 
	 * @param question the second parameter is the new question test to keep  
	 */

	@Override
	public boolean updateQuestionPerUser(int questionId, Question question) {
		if (question != null) {
			
			DaoQuestion d = new DaoQuestion();
			d.setQuestion(question.getQuestion());
			d.setProp1(question.getProp1());
			d.setProp2(question.getProp2());
			d.setProp3(question.getProp3());
			d.setProp4(question.getProp4());
			d.setDescription(question.getDescription());
			d.setResponse(question.getResponse());
			
			
			return ot.updateById(questionId, d);
		}
		return false;
	}
	
	
	
	
	/**
	 * The following service is used to create a new question based
	 * on the user type because only test manager has this ability
	 * 
	 * @param question the new question test to create 
	 *  
	 */

	@Override
	public int createNewQuestionPerUser(Question question) {
		
		DaoQuestion d = new DaoQuestion();
		d.setQuestion(question.getQuestion());
		d.setProp1(question.getProp1());
		d.setProp2(question.getProp2());
		d.setProp3(question.getProp3());
		d.setProp4(question.getProp4());
		d.setDescription(question.getDescription());
		d.setResponse(question.getResponse());
		
		return ot.save(d);
	}
	/**
	 * The following service is used to delete an existant question based
	 * on the user type because only test manager has this ability
	 * 
	 * @param question the question test to delete 
	 *  
	 */

	@Override
	public String deleteQuestionByIdPerUser(int questionId) {
		return ot.deleteById(questionId);
	}
	
	/**
	 * The following service is used to display the whole
	 * list of the available question tests.
	 * This list can be modified to match any expected requirement
	 *
	 */

	@Override
	public List<Question> getAllQuestionJPQLPerUser() {
		
		List<Question> questions =  new ArrayList<Question>();
		
		for (DaoQuestion d :ot.findAll() ) {
		
			Question q = new Question();
			q.setQuestionId(d.getDaoQuestionId());
			q.setDescription(d.getDescription());
			q.setProp1(d.getProp1());
			q.setProp2(d.getProp2());
			q.setProp3(d.getProp3());
			q.setProp4(d.getProp4());
			q.setQuestion(d.getQuestion());
			q.setResponse(d.getResponse());
			q.setWarningCorrectResponse("The correct Answer is " + d.getResponse());
			
			questions.add(q);
			
		}
		return questions;
	}

	
	
	/**
	 * The following service is used to display a question based
	 * on the user type and the test identification
	 * 
	 * @param questionId the first parameter is a question identifier  
	 *  
	 */
	

	@Override
	public Question getQuestionByIdPerUser(int questionId) {
		
		DaoQuestion d = ot.find(questionId);
		Question q = new Question();
		
		if (d!=null) {
		q.setDescription(d.getDescription());
		q.setQuestionId(d.getDaoQuestionId());
		q.setResponse(d.getResponse());
		q.setProp1(d.getProp1());
		q.setProp2(d.getProp2());
		q.setProp3(d.getProp3());
		q.setProp4(d.getProp4());
		q.setQuestion(d.getQuestion());
		q.setWarningCorrectResponse("The correct Answer is " + d.getResponse());
		}
		
		
		return q;
		
		
		
		
	}




	




	




	



	




	

}
