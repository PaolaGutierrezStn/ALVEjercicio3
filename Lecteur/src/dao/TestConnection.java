package dao;

import java.util.List;

import model.Lecteur;

public class TestConnection {
	public static void main(String[] args) {
		LecteurDAOImpl lecteurDAOImpl = new LecteurDAOImpl();
		lecteurDAOImpl.createLecteur(new Lecteur(6L, "Potero","GSILBN","Vespertino"));
		
		List<Lecteur> lecteurs = lecteurDAOImpl.readAllLecteurs();
		for (Lecteur lecteur : lecteurs) {
			System.out.println(lecteur);
			
		}
	}

}
