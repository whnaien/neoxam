package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.dao.OnlineTestLocalDao;
import tn.esprit.dao.OnlineTestRemoteDao;
import tn.esprit.entities.OnlineTest;

@Stateless
public class OnlineTestDaoImp implements OnlineTestRemoteDao, OnlineTestLocalDao {
	
	@PersistenceContext(unitName = "pidev")
	EntityManager em;

	@Override
	public int ajouterOnlineTest(OnlineTest onlineTest) {
		em.persist(onlineTest);
		return onlineTest.getIdTestOnline();
	}

	@Override
	public String deleteOnlineTestById(int onlineTestId) {
		OnlineTest e = em.find(OnlineTest.class, onlineTestId);
		em.remove(em.contains(e) ? e : em.merge(e));
		
		
		return "onlineTest deleted" + onlineTestId;
	}

	@Override
	public List<OnlineTest> getAllOnlineTestJPQL() {
		return em
				.createQuery("SELECT e FROM OnlineTest e ", OnlineTest.class).getResultList();
	}

	@Override
	public void updateOnlineTest(OnlineTest e) {
		OnlineTest emp = em.find(OnlineTest.class, e.getIdTestOnline()); 
		emp.setIsActif(e.getIsActif());
		
		
	}
	
	
	
	
	
	

}
