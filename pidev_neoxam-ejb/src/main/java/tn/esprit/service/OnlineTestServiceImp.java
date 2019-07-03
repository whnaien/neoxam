package tn.esprit.service;


import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.esprit.dao.OnlineTestRemoteDao;
import tn.esprit.dao.impl.OnlineTestDaoImp;
import tn.esprit.entities.OnlineTest;

@Stateless
public class OnlineTestServiceImp implements OnlineTestServiceRemote, OnlineTestServiceLocal {
    
	@EJB
	OnlineTestRemoteDao ot;
	
	@Override
	public int createNewOnlineTestPerUser(OnlineTest onlineTest) {
		
		return ot.ajouterOnlineTest(onlineTest);
	}
	
	
	
	
	

}
