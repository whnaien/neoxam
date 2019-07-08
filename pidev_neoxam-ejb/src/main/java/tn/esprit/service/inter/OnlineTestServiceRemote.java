package tn.esprit.service.inter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import tn.esprit.dao.impl.OnlineTestDaoImp;
import tn.esprit.entities.OnlineTest;
import tn.esprit.entities.Question;

@Remote
public interface OnlineTestServiceRemote {
	
	public int createNewOnlineTestPerUser(OnlineTest onlineTest);
	public String deleteOnlineTestByIdPerUser (int empId);
	public List<OnlineTest> getAllOnlineTestJPQLPerUser ();
	public boolean updateOnlineTestPerUser (int onlineTestId, OnlineTest e);
	public OnlineTest getOnlineTestByIdPerUser (int onlineTestId);
	public boolean affecterQuestionToOnlineTest(int onlineTestId, int question);
	public int calculatecorrectOnlineTest(int testId,OnlineTest onlineTestPasse);
	public boolean scoreAllocationToCandiadte(int testId,int candidateId,String score);
	public String javaCompilerExecution (String sourceCode) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException;
	
	
	//public void affecterOnlineTestACandidat(int onlineTestId, int candidatId);
	//public String getOnlineTestById(int onlineTestId);
	//public long getNombreOnlineTestJPQL();
	//public List<String> getAllOnlineTestTypesJPQL();
	
	

}
