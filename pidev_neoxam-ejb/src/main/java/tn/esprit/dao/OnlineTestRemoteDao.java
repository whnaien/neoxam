package tn.esprit.dao;


import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.OnlineTest;

@Remote
public interface OnlineTestRemoteDao {
	
	public int ajouterOnlineTest(OnlineTest onlineTest);
	//public void affecterOnlineTestACandidat(int onlineTestId, int candidatId);
	//public String getOnlineTestById(int onlineTestId);
	//public long getNombreOnlineTestJPQL();
	//public List<String> getAllOnlineTestTypesJPQL();
	public String deleteOnlineTestById (int empId);
	public List<OnlineTest> getAllOnlineTestJPQL ();
	public void updateOnlineTest (OnlineTest e);
	

}
