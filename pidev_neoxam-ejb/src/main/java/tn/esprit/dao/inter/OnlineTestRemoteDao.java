package tn.esprit.dao.inter;


import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.OnlineTest;

@Remote
public interface OnlineTestRemoteDao {
	
	public int ajouterOnlineTest(OnlineTest onlineTest);
	public String deleteOnlineTestById (int empId);
	public List<OnlineTest> getAllOnlineTestJPQL ();
	public boolean updateOnlineTest (int onlineTestId, OnlineTest e);
	public OnlineTest getOnlineTestById (int onlineTestId);
	

}
