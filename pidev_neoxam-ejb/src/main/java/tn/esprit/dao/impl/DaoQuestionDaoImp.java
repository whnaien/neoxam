package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.dao.inter.DaoQuestionLocalDao;
import tn.esprit.dao.inter.DaoQuestionRemoteDao;
import tn.esprit.entities.DaoQuestion;
import tn.esprit.entities.OnlineTest;

@Stateless
public class DaoQuestionDaoImp implements DaoQuestionRemoteDao, DaoQuestionLocalDao {

	@PersistenceContext(unitName = "pidev")
	EntityManager em;

	@Override
	public int save(DaoQuestion daoQuestion) {
		em.persist(daoQuestion);
		return daoQuestion.getDaoQuestionId();
	}

	@Override
	public String deleteById(int daoQuestionId) {
		DaoQuestion e = em.find(DaoQuestion.class, daoQuestionId);
		em.remove(em.contains(e) ? e : em.merge(e));
		
		
		return "DaoQuestion deleted" + daoQuestionId;
	}

	@Override
	public DaoQuestion find(Integer id) {
		return em.find(DaoQuestion.class, id);
	}

	@Override
	public List<DaoQuestion> findAll() {
		return em
				.createQuery("SELECT e FROM DaoQuestion e ", DaoQuestion.class).getResultList();
	}

	@Override
	public boolean updateById(int id, DaoQuestion e) {
		if (e != null) {
			DaoQuestion ot = em.find(DaoQuestion.class, id); 
			ot.setDescription(e.getDescription());
			ot.setQuestion(e.getQuestion());
			ot.setProp1(e.getProp1());
			ot.setProp2(e.getProp2());
			ot.setProp3(e.getProp3());
			ot.setProp4(e.getProp4());
			ot.setResponse(e.getResponse());
			em.persist(ot);
			return true;
			}
			
			return false;
	}

	@Override
	public boolean delete(DaoQuestion o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(DaoQuestion o) {
		// TODO Auto-generated method stub
		return false;
	}

}
