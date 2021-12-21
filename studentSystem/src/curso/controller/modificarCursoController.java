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
 * Servlet implementation class modificarCursoController
 */
@WebServlet("/modificarCursoController")
public class modificarCursoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modificarCursoController() {
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
		
		String apagar = request.getParameter("apagar");
		String alterar = request.getParameter("alterar");
		String salvaalt = request.getParameter("salvaalt");
		String idCourse = request.getParameter("idCourse");
		String name = request.getParameter("name");
		String semester = request.getParameter("semester");
		String idUser = request.getParameter("idUser");

		if (apagar != null && idCourse != null) {
			new Curso().excluir(Integer.valueOf(idCourse));
			RequestDispatcher dispatcher = request.getRequestDispatcher("buscarCurso.jsp");
			request.setAttribute("mensagem", "Curso apagado caso não esteja selecionado em alguma atividade!");
			dispatcher.forward(request, response);
		} else if (alterar != null && idCourse != null) {
			Curso curso = new Curso().buscarCursoPorId(Integer.valueOf(idCourse));
			RequestDispatcher dispatcher = request.getRequestDispatcher("alterarCurso.jsp");
			request.setAttribute("curso", curso);
			dispatcher.forward(request, response);
		} else if (salvaalt != null && name != null && !name.isEmpty() && 
					semester != null && !semester.isEmpty() ) {
			Curso curso = new Curso(Integer.valueOf(idCourse), name, semester, idUser);
			curso.alterarCurso();
			RequestDispatcher dispatcher = request.getRequestDispatcher("buscarCurso.jsp");
			request.setAttribute("mensagem", "Matéria editada com sucesso!");
			dispatcher.forward(request, response);			
		}	
	}

}
