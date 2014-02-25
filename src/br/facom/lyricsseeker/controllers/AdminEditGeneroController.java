package br.facom.lyricsseeker.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.facom.lyricsseeker.DAO.GeneroDAO;
import br.facom.lyricsseeker.models.Genero;

/**
* Servlet implementation class AdminEditGeneroController
*/
@WebServlet("/AdminEditGeneroController")
public class AdminEditGeneroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LIST_GENERO = "/views/admin/Admin-editGenero.jsp";
	private static final String INSERT_OR_EDIT = "/views/admin/Admin-addGenero.jsp";
    private GeneroDAO dao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditGeneroController() {
        super();
        dao = new GeneroDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		if(action != null ){
			
			if(action.equalsIgnoreCase("delete")){
				String nome = request.getParameter("nomeGenero");
				dao.delete(nome);
				forward = LIST_GENERO;
				//request.setAttribute("generos", dao.getAll());
				session.setAttribute("generos", dao.getAll());
				
			}else if(action.equalsIgnoreCase("edit")){
				String nome = request.getParameter("nomeGenero");
				Genero genero = dao.getOne(nome);
				//request.setAttribute("genero", genero);
				session.setAttribute("genero", genero);
				forward = INSERT_OR_EDIT;
				
			}else if(action.equalsIgnoreCase("listGenero")){
				forward = LIST_GENERO;
				session.setAttribute("generos", dao.getAll());
			}else{
				forward = INSERT_OR_EDIT;
				session.setAttribute("genero", null);
			}
			
		}else{
			forward = LIST_GENERO;
			session.setAttribute("generos", dao.getAll());
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Genero genero = new Genero();
		HttpSession session = request.getSession();
		
		String flag = request.getParameter("flag");
		
		if(flag.equalsIgnoreCase("add")){
			
			genero.setNomeGenero(request.getParameter("nomeGenero"));
			genero.setDescricao(request.getParameter("descricaoGenero"));
			
			if(dao.existeGenero(genero.getNomeGenero())){
				dao.edit(genero.getNomeGenero(), genero);
			}else{
				dao.add(genero);
			}
			
			session.setAttribute("generos", dao.getAll());
			
		}else if(flag.equalsIgnoreCase("search")){
			String generoNome = request.getParameter("search");
			session.setAttribute("generos", dao.getSome(generoNome));
		}
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_GENERO);
		view.forward(request, response);
	}

}
