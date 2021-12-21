package curso.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.model.Curso;

/**
 * Servlet implementation class createCourseController
 */
@WebServlet("/cadastrarCursoController")
public class cadastrarCursoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastrarCursoController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @return 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("name");
		String semester = request.getParameter("semester");
		String idUser = request.getParameter("idUser");
		String mensagem;
		Curso curso = new Curso();
		
		
		if(name != null && !name.isEmpty() && 
			semester != null && !semester.isEmpty() &&
			idUser != null &&
			Integer.parseInt(request.getParameter("semester")) >= 1 && 
			Integer.parseInt(request.getParameter("semester")) <= 12) {
				
			mensagem = "Matéria cadastrada com sucesso!";
			
			curso.setName(name);
			curso.setSemester(semester);
			curso.setIdUser(idUser);
			curso.salvar();
					
						
		} else {
			mensagem = "Os campos precisam ser preenchidos corretamente!";
		}
		
		request.setAttribute("mensagem", mensagem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarCurso.jsp");
		dispatcher.forward(request, response);
	}

}
