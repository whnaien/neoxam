package tn.esprit.dao.inter;

import java.util.List;


import tn.esprit.entities.OnlineTestResult;
import tn.esprit.entities.OnlineTestResultPk;

public interface OnlineTestResultRemoteDao extends ObjectGenericDao<OnlineTestResult, Integer> {
	
	
	boolean delete(int idUser,int idTest);
	OnlineTestResult find(Integer id); 
	List<OnlineTestResult> findAll();
	OnlineTestResult saveCombinedKey(OnlineTestResult o) ;
	boolean update(OnlineTestResult o);
	OnlineTestResult findByCombinedKey(int keyUSer, int KeyTest);
	boolean updateCombinedKey(OnlineTestResult o1, int idUser,int idTest);
}
