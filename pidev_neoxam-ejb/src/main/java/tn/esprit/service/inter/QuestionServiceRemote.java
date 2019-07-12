package tn.esprit.service.inter;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.dao.impl.OnlineTestDaoImp;
import tn.esprit.entities.DaoQuestion;
import tn.esprit.entities.OnlineTest;
import tn.esprit.entities.OnlineTestResult;
import tn.esprit.entities.Question;

@Remote
public interface QuestionServiceRemote {
	
	public int createNewQuestionPerUser(Question question);
	public String deleteQuestionByIdPerUser (int questionId);
	public List<Question> getAllQuestionJPQLPerUser ();
	public boolean updateQuestionPerUser (int questionId,Question question);
	public Question getQuestionByIdPerUser (int questionId);
	
}
