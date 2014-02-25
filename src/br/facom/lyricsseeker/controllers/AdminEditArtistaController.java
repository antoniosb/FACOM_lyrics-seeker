package br.facom.lyricsseeker.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.facom.lyricsseeker.DAO.ArtistaDAO;
import br.facom.lyricsseeker.models.Artista;

/**
 * Servlet implementation class AdminEditArtistaController
 */
@WebServlet("/AdminEditArtistaController")
public class AdminEditArtistaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LIST_ARTISTA = "/views/admin/Admin-editArtista.jsp";
	private static final String INSERT_OR_EDIT = "/views/admin/Admin-addArtista.jsp";
    private ArtistaDAO dao;   
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditArtistaController() {
        super();
        dao = new ArtistaDAO();
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
				int id = Integer.valueOf(request.getParameter("id_artista"));
				dao.delete(id);
				forward = LIST_ARTISTA;
				session.setAttribute("artistas", dao.getAll());
				
			}else if(action.equalsIgnoreCase("edit")){
				int id = Integer.valueOf(request.getParameter("id_artista"));
				Artista artista = dao.getOne(id);
				session.setAttribute("artista", artista);
				forward = INSERT_OR_EDIT;
				
			}else if(action.equalsIgnoreCase("listArtista")){
				forward = LIST_ARTISTA;
				session.setAttribute("artistas", dao.getAll());
			}else{
				forward = INSERT_OR_EDIT;
				session.setAttribute("artista", null);
			}
			
		}else{
			forward = LIST_ARTISTA;
			session.setAttribute("artistas", dao.getAll());
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Artista artista = new Artista();
		HttpSession session = request.getSession();
		
		String flag = request.getParameter("flag");
		
		if(flag.equalsIgnoreCase("add")){
			
//			artista.setIdArtista(Integer.valueOf(request.getParameter("id_artista")));
			artista.setNomeArtista(request.getParameter("nomeArtista"));
			artista.setIdGenero(Integer.valueOf(request.getParameter("id_genero")));
			artista.setUrlFoto(request.getParameter("urlFoto"));
			artista.setBiografia(request.getParameter("biografia"));
			try{
				artista.setDataNascimento(ArtistaDAO.PATTERN.parse(request.getParameter("dataNascimento")));
			}catch(ParseException e){
				artista.setDataNascimento(new Date());
			}
			
			if(dao.existeArtista(artista.getIdArtista())){
				dao.edit(artista.getIdArtista(), artista);
			}else{
				dao.add(artista);
			}
			
			session.setAttribute("artistas", dao.getAll());
			
		}else if(flag.equalsIgnoreCase("search")){
			String artistaNome = request.getParameter("search");
			session.setAttribute("artistas", dao.getSome(artistaNome));
		}
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_ARTISTA);
		view.forward(request, response);
	
	}

}
