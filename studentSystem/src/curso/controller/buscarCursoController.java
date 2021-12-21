package curso.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.model.Curso;

/**
 * Servlet implementation class buscarCursoController
 */
@WebServlet("/buscarCursoController")
public class buscarCursoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buscarCursoController() {
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
		response.setContentType("text/html); charset=UTF-8");
		String name = request.getParameter("name");
		String idUser = request.getParameter("idUser");
		ArrayList<Curso> cursos = new Curso().BuscarCursosPorNome(name, idUser);
		
		request.setAttribute("cursos", cursos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("buscarCurso.jsp");
		dispatcher.forward(request, response);
		
	}

}
