package tn.esprit.service.impl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import tn.esprit.dao.impl.OnlineTestDaoImp;
import tn.esprit.dao.inter.DaoQuestionRemoteDao;
import tn.esprit.dao.inter.OnlineTestRemoteDao;
import tn.esprit.entities.DaoQuestion;
import tn.esprit.entities.OnlineTest;
import tn.esprit.entities.OnlineTestResult;
import tn.esprit.entities.OnlineTestResultPk;
import tn.esprit.entities.Question;
import tn.esprit.service.inter.OnlineTestResultServiceRemote;
import tn.esprit.service.inter.OnlineTestServiceLocal;
import tn.esprit.service.inter.OnlineTestServiceRemote;
import tn.esprit.utilities.SendMailConfirmation;

@Stateless
public class OnlineTestServiceImp implements OnlineTestServiceRemote, OnlineTestServiceLocal {

	@EJB
	OnlineTestRemoteDao ot;
	@EJB
	DaoQuestionRemoteDao oq;
	@EJB
	OnlineTestResultServiceRemote tr;

	/**
	 * The following service is used to update an existent onlineTest based on the
	 * user type because only test manager has this ability
	 * 
	 * @param onlineTestId the first parameter is the online test id to modify
	 * @param onlineTestId the second parameter is the new online test to keep
	 */

	@Override
	public boolean updateOnlineTestPerUser(int onlineTestId, OnlineTest e) {

		if (e != null)
			return ot.updateOnlineTest(onlineTestId, e);
		return false;

	}

	/**
	 * The following service is used to create a new onlineTest based on the user
	 * type because only test manager has this ability
	 * 
	 * @param onlineTest the new online test to create
	 * 
	 */

	@Override
	public int createNewOnlineTestPerUser(OnlineTest onlineTest) {

		return ot.ajouterOnlineTest(onlineTest);
	}

	/**
	 * The following service is used to delete an existant onlineTest based on the
	 * user type because only test manager has this ability
	 * 
	 * @param onlineTestId the online test to delete
	 * 
	 */

	@Override
	public String deleteOnlineTestByIdPerUser(int onlineTestId) {

		return ot.deleteOnlineTestById(onlineTestId);
	}

	/**
	 * The following service is used to display the whole list of the available
	 * online tests. This list can be modified to match any expected requirement
	 *
	 */

	@Override
	public List<OnlineTest> getAllOnlineTestJPQLPerUser() {
		return ot.getAllOnlineTestJPQL();
	}

	/**
	 * The following service is used to display a onlineTest based on the user type
	 * and the test identification
	 * 
	 * @param onlineTestId the first parameter is a test identifier
	 * 
	 */

	@Override
	public OnlineTest getOnlineTestByIdPerUser(int onlineTestId) {
		return ot.getOnlineTestById(onlineTestId);

	}

	/**
	 * The following service is used to assign a question to a test
	 * 
	 * @param onlineTestId the first parameter is a test identifier
	 * @param question     the first parameter is a question identifier
	 * 
	 */

	@Override
	public boolean affecterQuestionToOnlineTest(int onlineTestId, int questionId) {

		DaoQuestion d = oq.find(questionId);
		OnlineTest m = ot.getOnlineTestById(onlineTestId);
		List<DaoQuestion> l = m.getDaoQuestions();
		l.add(d);
		m.setDaoQuestions(l);

		return ot.updateOnlineTest(onlineTestId, m);

	}

	/**
	 * The following service is used to get the number of correct answers
	 * 
	 * @param testId    the first parameter is a test identifier
	 * @param questions the first parameter is a list of questions
	 * 
	 */

	@Override
	public int calculatecorrectOnlineTest(int onlineTestId, OnlineTest onlineTestPasse) {

		OnlineTest o = ot.getOnlineTestById(onlineTestId);
		List<DaoQuestion> d = o.getDaoQuestions();
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		int score = 0;
		for (DaoQuestion s : d) {
			m.put(s.getDaoQuestionId(), s.getResponse());
		}
		for (DaoQuestion f : onlineTestPasse.getDaoQuestions()) {
			int k = m.get(f.getDaoQuestionId());
			if (k == f.getResponse()) {
				score++;
			}
		}
		return score;

	}

	/**
	 * The following service is used to get the number of correct answers
	 * 
	 * @param testId      the first parameter is a test identifier
	 * @param candidateId the first parameter is a list of questions
	 * 
	 */

	@Override
	public boolean scoreAllocationToCandiadte(int idOnlineTest, int idCandidate, String score) {

		OnlineTestResultPk pk = new OnlineTestResultPk();
		pk.setIdCandidate(idCandidate);
		pk.setIdOnlineTest(idOnlineTest);
		OnlineTestResult ontr = tr.getOnlineTestResultByIdPerUser(idCandidate, idOnlineTest);
		if (pk.equals(ontr.getOnlineTestResultPk())) {
			ontr.setOnlineTestResultScore(score);
			tr.updateOnlineTestResultPerUser(ontr, idCandidate, idOnlineTest);
			return true;

		}

		return false;

	}

	/**
	 * The following service is used to get the number of correct answers
	 * 
	 * @param sourceCode sourceCode
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * 
	 */

	@Override
	public String javaCompilerExecution(String reponse)
			throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

		String source = "package test; public class Test { " + "  public String  testCal() {" + reponse + " } }";

		// Save source in .java file.
		File root = new File("/java"); // On Windows running on C:\, this is C:\java.
		File sourceFile = new File(root, "test/Test.java");
		sourceFile.getParentFile().mkdirs();
		Files.write(sourceFile.toPath(), source.getBytes(StandardCharsets.UTF_8));

		// Compile source file.
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		compiler.getSourceVersions();
		compiler.run(null, null, null, sourceFile.getPath());

		// Load and instantiate compiled class.
		URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { root.toURI().toURL() });
		Class<?> cls = Class.forName("test.Test", true, classLoader); // Should print "hello".
		// Should print "world".
		Method sumInstanceMethod = cls.getMethod("testCal", null);

		Object operationsInstance = cls.newInstance();
		String result = (String) sumInstanceMethod.invoke(operationsInstance);
		return result;

	}

	@Override
	public boolean sendAnEmailToCandidate(String email, String body) throws MessagingException {

		if (SendMailConfirmation.SendMailScore(email, body))

			return true;
		return false;

	}

}
