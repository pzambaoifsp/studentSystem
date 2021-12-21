package nota.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nota.model.Nota;

/**
 * Servlet implementation class cadastrarNotaController
 */
@WebServlet("/cadastrarNotaController")
public class cadastrarNotaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastrarNotaController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String idCourse = request.getParameter("idCourse");
		String name = request.getParameter("name");
		String grade = request.getParameter("grade");
		String idUser = request.getParameter("idUser");
		String mensagem;
				
		Nota nota = new Nota();
		
		if(name != null && !name.isEmpty() && 
			idCourse != null && !idCourse.isEmpty() &&
			grade != null && !grade.isEmpty() &&
			idUser != null &&
			Double.parseDouble(request.getParameter("grade")) >= 1 && 
			Double.parseDouble(request.getParameter("grade")) <= 12) {
				
			mensagem = "Nota cadastrada com sucesso!";
			
			nota.setIdCourse(idCourse);
			nota.setName(name);
			nota.setGrade(grade);
			nota.setIdUser(idUser);
			nota.salvar();				
						
		} else {
			mensagem = "Os campos precisam ser preenchidos corretamente!";
		}
		
		request.setAttribute("mensagem", mensagem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarNota.jsp");
		dispatcher.forward(request, response);
	}

}
