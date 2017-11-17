package dao;

import java.util.List;

import model.Lecteur;

public interface LecteurDAO {

	void createLecteur(Lecteur lecteur);
	Lecteur readLecteur(Long numberLecteur);
	List<Lecteur> readAllLecteurs();
	void updateLecteur(Lecteur lecteur);
	void deleteLecteur(Long numberLecteur);
}
