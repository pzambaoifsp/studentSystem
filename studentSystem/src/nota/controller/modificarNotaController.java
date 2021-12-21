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
 * Servlet implementation class modificarCursoController
 */
@WebServlet("/modificarNotaController")
public class modificarNotaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modificarNotaController() {
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
		String idGrade = request.getParameter("idGrade");
		String idCourse = request.getParameter("idCourse");
		String name = request.getParameter("name");
		String grade = request.getParameter("grade");
		String idUser = request.getParameter("idUser");
		
		if (apagar != null && idGrade != null) {
			new Nota().excluir(Integer.valueOf(idGrade));
			RequestDispatcher dispatcher = request.getRequestDispatcher("buscarNota.jsp");
			request.setAttribute("mensagem", "Nota apagada com sucesso!");
			dispatcher.forward(request, response);
		} else if (alterar != null && idGrade != null) {
			Nota nota = new Nota().buscarNotaPorId(Integer.valueOf(idGrade));
			RequestDispatcher dispatcher = request.getRequestDispatcher("alterarNota.jsp");
			request.setAttribute("nota", nota);
			dispatcher.forward(request, response);
		} else if (salvaalt != null && idGrade != null &&
				name != null && !name.isEmpty() && 
				idCourse != null && !idCourse.isEmpty()) {
			Nota nota = new Nota(Integer.valueOf(idGrade), idCourse, name, grade, idUser);
			nota.alterarNota();
			RequestDispatcher dispatcher = request.getRequestDispatcher("buscarNota.jsp");
			request.setAttribute("mensagem", "Nota alterada com sucesso!");
			dispatcher.forward(request, response);			
		}	
	}

}
