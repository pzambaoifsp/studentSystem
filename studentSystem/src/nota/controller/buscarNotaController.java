package nota.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nota.model.Nota;

/**
 * Servlet implementation class buscarNotaController
 */
@WebServlet("/buscarNotaController")
public class buscarNotaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buscarNotaController() {
        super();
        // TODO Auto-generated constructor stub
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
		ArrayList<Nota> Notas = new Nota().BuscarNotasPorNome(name, idUser);
		
		request.setAttribute("notas", Notas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("buscarNota.jsp");
		dispatcher.forward(request, response);
		
	}
}