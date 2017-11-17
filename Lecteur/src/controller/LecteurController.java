package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Lecteur;
import dao.LecteurDAOImpl;

/**
 * Servlet implementation class LecteurController
 */
@WebServlet("/LecteurController")
public class LecteurController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Lecteur lecteur;
	private List<Lecteur> lecteurs;
	private LecteurDAOImpl lecteurDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LecteurController() {
        super();
        lecteur = new Lecteur();
        lecteurs = new ArrayList<Lecteur>();
        lecteurDAO = new LecteurDAOImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if (request.getParameter("btn_save")!= null) {
			
	lecteur.setName(request.getParameter("name"));
	lecteur.setPhone(request.getParameter("phone"));
	lecteur.setAddress(request.getParameter("address"));
	if(lecteur.getNumberLecteur()==0L) {
				lecteurDAO.createLecteur(lecteur);
				}else {
					lecteurDAO.updateLecteur(lecteur);
			}
			
			lecteurs = lecteurDAO.readAllLecteurs();
			request.setAttribute("lecteurs", lecteurs);
			request.getRequestDispatcher("lecteur_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			lecteur = new Lecteur();
			request.getRequestDispatcher("lecteur_form.jsp").forward(request, response);
			
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				Long numberLecteur = Long.parseLong(request.getParameter("numberLecteur"));
				lecteur = lecteurDAO.readLecteur(numberLecteur);
				
			}catch (Exception e) {
				
				lecteur = new Lecteur();
			}
			request.setAttribute("lecteur", lecteur);
			
			request.getRequestDispatcher("lecteur_form.jsp").forward(request, response);
			
			
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			Long numberLecteur = Long.parseLong(request.getParameter("numberLecteur"));
			lecteurDAO.deleteLecteur(numberLecteur);
			lecteurs = lecteurDAO.readAllLecteurs();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("lecteurs", lecteurs);
			request.getRequestDispatcher("lecteur_list.jsp").forward(request, response);
		}else {
			lecteurs = lecteurDAO.readAllLecteurs();
			request.setAttribute("lecteurs", lecteurs);
			request.getRequestDispatcher("lecteur_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
