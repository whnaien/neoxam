package tn.esprit.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.dao.inter.OnlineTestResultLocalDao;
import tn.esprit.dao.inter.OnlineTestResultRemoteDao;
import tn.esprit.entities.OnlineTestResult;
import tn.esprit.entities.OnlineTestResultPk;


@Stateless
public class OnlineTestResultDaoImpl implements OnlineTestResultRemoteDao, OnlineTestResultLocalDao{

	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	
	
	
	@Override
	public OnlineTestResult saveCombinedKey(OnlineTestResult o) {
		em.persist(o);
		return o;
	}
	
		
	@Override
	public boolean delete(int idUser,int idTest) {
		
		OnlineTestResultPk pk = new OnlineTestResultPk();
		pk.setIdCandidate(idUser);
		pk.setIdOnlineTest(idTest);
		
		if (pk!=null) {
		OnlineTestResult e = em.find(OnlineTestResult.class, pk);
		em.remove(em.contains(e) ? e : em.merge(e));
		return true;
		}
		return false;
		
	}
	
	
	@Override
	public OnlineTestResult findByCombinedKey(int idUser, int idTest) {
		
		OnlineTestResultPk pk = new OnlineTestResultPk();
		pk.setIdCandidate(idUser);
		pk.setIdOnlineTest(idTest);
		return em.find(OnlineTestResult.class, pk);
	}



	@Override
	public List<OnlineTestResult> findAll() {
		return em
				.createQuery("SELECT e FROM OnlineTestResult e ", OnlineTestResult.class).getResultList();
	}

	
	
	@Override
	public boolean updateCombinedKey(OnlineTestResult newResult, int idUser,int idTest) {
		
		OnlineTestResultPk pk = new OnlineTestResultPk();
		pk.setIdCandidate(idUser);
		pk.setIdOnlineTest(idTest);
		OnlineTestResult availableResult= em.find(OnlineTestResult.class, pk);
		
		
		if (newResult != null) {
			
			OnlineTestResult ot = em.find(OnlineTestResult.class, availableResult.getOnlineTestResultPk()); 
			ot.setOnlineTestResultDate(newResult.getOnlineTestResultDate());
			ot.setOnlineTestResultDescription(newResult.getOnlineTestResultDescription());
			ot.setOnlineTestResultScore(newResult.getOnlineTestResultScore());
			ot.setOnlineTestResultDuration(newResult.getOnlineTestResultDuration());
			ot.setIsActif(newResult.getIsActif());
			ot.setCandidateResult(newResult.getCandidateResult());
			ot.setOnlineTestResult(newResult.getOnlineTestResult());
			
			em.persist(ot);
			return true;
			}
			
			return false;
	}
	
	
	@Override
	public boolean update(OnlineTestResult o) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public int save(OnlineTestResult o) {
		
		return 1;
	}



	@Override
	public OnlineTestResult find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean delete(OnlineTestResult o) {
		// TODO Auto-generated method stub
		return false;
	}


	
	


	
	
	
	
	
	
	
	
	

}
