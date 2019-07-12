package tn.esprit.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.QueryParam;

import tn.esprit.dao.impl.OnlineTestDaoImp;
import tn.esprit.dao.inter.OnlineTestRemoteDao;
import tn.esprit.dao.inter.OnlineTestResultRemoteDao;
import tn.esprit.entities.OnlineTest;
import tn.esprit.entities.OnlineTestResult;
import tn.esprit.service.inter.OnlineTestResultServiceLocal;
import tn.esprit.service.inter.OnlineTestResultServiceRemote;
import tn.esprit.service.inter.OnlineTestServiceLocal;
import tn.esprit.service.inter.OnlineTestServiceRemote;

@Stateless
public class OnlineTestResultServiceImp implements OnlineTestResultServiceRemote, OnlineTestResultServiceLocal {

	@EJB
	OnlineTestResultRemoteDao ot;

	/**
	 * The following service is used to update an existent onlineTestResult based on
	 * the user type because only test manager has this ability
	 * 
	 * @param onlineTestResult the first parameter is the online test id to modify
	 * @param onlineTestResult the second parameter is the new online test to keep
	 */

	@Override
	public boolean updateOnlineTestResultPerUser(OnlineTestResult newResult,int idUser,int idTest) {
		if (newResult != null)
			return ot.updateCombinedKey(newResult,idUser,idTest);
		return false;
	}

	/**
	 * The following service is used to create a new onlineTestResult based on the
	 * user type because only test manager has this ability
	 * 
	 * @param onlineTestResult the new online test to create
	 * 
	 */

	@Override
	public OnlineTestResult createNewOnlineTestResultPerUser(OnlineTestResult onlineTestResult) {

		return ot.saveCombinedKey(onlineTestResult);
	}

	/**
	 * The following service is used to delete an existant onlineTestResult based on
	 * the user type because only test manager has this ability
	 * 
	 * @param onlineTestResult the online test to delete
	 * 
	 */

	@Override
	public boolean deleteOnlineTestResultByIdPerUser(int idUser,int idTest) {
		return ot.delete(idUser,idTest);
	}

	/**
	 * The following service is used to display the whole list of the available
	 * online tests. This list can be modified to match any expected requirement
	 *
	 */

	@Override
	public List<OnlineTestResult> getAllOnlineTestResultJPQLPerUser() {

		return ot.findAll();
	}

	/**
	 * The following service is used to display a onlineTestResult based on the user
	 * type and the test identification
	 * 
	 * @param onlineTestResult the first parameter is a test identifier
	 * 
	 */

	@Override
	public OnlineTestResult getOnlineTestResultByIdPerUser(int idUser, int idTest) {
		return ot.findByCombinedKey(idUser,idTest);
	}

}
