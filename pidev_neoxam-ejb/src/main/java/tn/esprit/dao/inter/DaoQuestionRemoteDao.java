package tn.esprit.dao.inter;

import java.util.List;

import tn.esprit.entities.DaoQuestion;

public interface DaoQuestionRemoteDao extends ObjectGenericDao<DaoQuestion, Integer> {
	
    int save(DaoQuestion o);
	String deleteById(int id) ;
	DaoQuestion find(Integer id);
	List<DaoQuestion> findAll() ;
	boolean updateById(int id, DaoQuestion o);

}
