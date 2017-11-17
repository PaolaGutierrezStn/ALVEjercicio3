package report;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Lecteur;
import dao.LecteurDAOImpl;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Servlet implementation class LecteurReport
 */
@WebServlet("/LecteurReport")
public class LecteurReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LecteurDAOImpl dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LecteurReport() {
        super();
       
        	dao = new LecteurDAOImpl() {
			
			@Override
			public void updateLecteur(Lecteur lecteur) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Lecteur readLecteur(Long numberLecteur) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Lecteur> readAllLecteurs() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void deleteLecteur(Long numberLecteur) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void createLecteur(Lecteur lecteur) {
				// TODO Auto-generated method stub
				
			}
		};
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reportPath = "C:\\Users\\vazquez\\Desktop\\proyecto4-master\\Lecteur\\src\\report\\lecteursReport.jrxml";
		try {
			
			JasperReport report = JasperCompileManager.compileReport(reportPath);
			
			Map<String, Object> data = new HashMap<String, Object>();
			// data.put("Image", this.getServletContext().getRealPath("/")+"/images/helloWorld.jpg");
			JasperPrint print = JasperFillManager.fillReport(report, data, dao.getConnetion());
			
			JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
			
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
			
			
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
