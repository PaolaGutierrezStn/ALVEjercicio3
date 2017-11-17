package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.LecteurDAO;
import model.Lecteur;

public class LecteurDAOImpl  implements LecteurDAO{
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public LecteurDAOImpl() {
		getConnetion();
	}
	
	public Connection getConnetion() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/testdb", "postgres", "1234");
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void createLecteur(Lecteur lecteur) {
		try {
		if(connection != null) {
			preparedStatement = connection.prepareStatement("INSERT INTO lecteurs (name, phone,"
									+ "address)values (?,?,?);");
			preparedStatement.setString(1,lecteur.getName() );
			preparedStatement.setString(2,lecteur.getPhone() );
			preparedStatement.setString(3,lecteur.getAddress());
			preparedStatement.execute();
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Lecteur readLecteur(Long numberLecteur) {
		Lecteur lecteur = null;
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("SELECT * FROM lecteurs WHERE numberLecteur=?");
				
				preparedStatement.setLong(1, numberLecteur);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					lecteur = new Lecteur(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
											resultSet.getString(4));
				}
				
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return lecteur;
	}

	@Override
	public List<Lecteur> readAllLecteurs() {
		List<Lecteur> lecteurs = new ArrayList<Lecteur>();
		try {
		
				preparedStatement = connection.prepareStatement("SELECT * FROM lecteurs");
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					Lecteur lecteur = new Lecteur(
									resultSet.getLong(1), 
									resultSet.getString(2), 
									resultSet.getString(3),
									resultSet.getString(4));
					lecteurs.add(lecteur);
				}
				}catch(SQLException e) {
				e.printStackTrace();
			}
		return lecteurs;
	}

	@Override
	public void updateLecteur(Lecteur lecteur) {
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("UPDATE lecteurs SET name=?, "
											+ "phone=?,"
										+ "address=? WHERE numberLecteur=?;");
				preparedStatement.setString(1,lecteur.getName() );
				preparedStatement.setString(2,lecteur.getPhone() );
				preparedStatement.setString(3,lecteur.getAddress());
				preparedStatement.setLong(4, lecteur.getNumberLecteur());
				preparedStatement.execute();
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteLecteur(Long numberLecteur) {
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement("DELETE FROM lecteurs WHERE numberLecteur=?;");
				preparedStatement.setLong(1, numberLecteur);
				preparedStatement.execute();
				
			}catch(SQLException e){
				e.printStackTrace();
				
			}
		}
		
	}
	
	

	
}
