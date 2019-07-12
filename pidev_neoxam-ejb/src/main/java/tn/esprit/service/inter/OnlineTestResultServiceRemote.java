package tn.esprit.service.inter;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.dao.impl.OnlineTestDaoImp;
import tn.esprit.entities.OnlineTest;
import tn.esprit.entities.OnlineTestResult;

@Remote
public interface OnlineTestResultServiceRemote {
	
	public OnlineTestResult createNewOnlineTestResultPerUser(OnlineTestResult onlineTestResult);
	public boolean deleteOnlineTestResultByIdPerUser (int idUser,int idTest);
	public List<OnlineTestResult> getAllOnlineTestResultJPQLPerUser ();
	public boolean updateOnlineTestResultPerUser (OnlineTestResult newResult,int idUser, int idTest);
	public OnlineTestResult getOnlineTestResultByIdPerUser (int idUser, int idTest);
	
	//public void affecterOnlineTestACandidat(int onlineTestId, int candidatId);
	//public String getOnlineTestById(int onlineTestId);
	//public long getNombreOnlineTestJPQL();
	//public List<String> getAllOnlineTestTypesJPQL();
	
	

}
