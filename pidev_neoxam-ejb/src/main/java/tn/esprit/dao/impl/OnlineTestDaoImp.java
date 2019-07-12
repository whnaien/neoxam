package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.dao.inter.OnlineTestLocalDao;
import tn.esprit.dao.inter.OnlineTestRemoteDao;
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
		try{
		em.remove(em.contains(e) ? e : em.merge(e));
		}catch (Exception ex) {
			ex.getMessage();
		}
		return "onlineTest deleted" + onlineTestId;
	}

	@Override
	public List<OnlineTest> getAllOnlineTestJPQL() {
		return em.createQuery("SELECT e FROM OnlineTest e ", OnlineTest.class).getResultList();
	}

	@Override
	public boolean updateOnlineTest(int onlineTestId, OnlineTest e) {

		if (e != null) {
			OnlineTest ot = em.find(OnlineTest.class, onlineTestId);
			ot.setOnlineTestaddressURL(e.getOnlineTestaddressURL());
			ot.setOnlineTestdescription(e.getOnlineTestdescription());
			ot.setOnlineTestDuration(e.getOnlineTestDuration());
			ot.setOnlineTestType(e.getOnlineTestType());
			ot.setIsActif(e.getIsActif());
			if (e.getDaoQuestions() != null) {
				ot.setDaoQuestions(e.getDaoQuestions());
			}
			em.persist(ot);
			return true;
		}

		return false;
	}

	@Override
	public OnlineTest getOnlineTestById(int onlineTestId) {
		// TODO Auto-generated method stub
		return em.find(OnlineTest.class, onlineTestId);
	}

}
