package tn.esprit.dao;

import java.util.List;

import tn.esprit.entities.Candidat;





public interface ICandidatCrud {
	public String addCandidat(Candidat candidat);
	public void removeCandidat(String Email); 
	public void updateCandidat (Candidat candidatNewValue);
	public Candidat findCandidatById(String Email);
	public List<Candidat> findAllCandidats();
}
