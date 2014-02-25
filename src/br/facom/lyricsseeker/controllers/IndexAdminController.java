package br.facom.lyricsseeker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.facom.lyricsseeker.DAO.GeneroDAO;
import br.facom.lyricsseeker.DAO.LoginDAO;
import br.facom.lyricsseeker.models.Genero;
import br.facom.lyricsseeker.models.Login;

/**
* Servlet implementation class IndexAdminController
*/
@WebServlet("/IndexAdminController")
public class IndexAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexAdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();

		String username = String.valueOf(request.getParameter("usuario"));
		String password = String.valueOf(request.getParameter("senha"));

		Login usuario = new Login();
		usuario.setUsuario(username);
		usuario.setSenha(password);
		
		if( LoginDAO.authenticate(usuario) ){
			GeneroDAO dao = new GeneroDAO();
			List<Genero> generos = dao.getAll();
			session.setAttribute("generos", generos);
			
			dispatcher = request
					.getRequestDispatcher("/views/admin/Admin-editGenero.jsp");
			dispatcher.forward(request, response);
			
		}else{
			response.sendRedirect("admin");
		}

	}

}
