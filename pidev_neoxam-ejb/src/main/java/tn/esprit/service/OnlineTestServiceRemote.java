package tn.esprit.service;

import javax.ejb.Remote;

import tn.esprit.dao.impl.OnlineTestDaoImp;
import tn.esprit.entities.OnlineTest;

@Remote
public interface OnlineTestServiceRemote {
	
	public int createNewOnlineTestPerUser(OnlineTest onlineTest);
	
	
	
	

}
