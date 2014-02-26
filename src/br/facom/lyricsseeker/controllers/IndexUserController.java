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

import br.facom.lyricsseeker.DAO.ArtistaDAO;
import br.facom.lyricsseeker.DAO.GeneroDAO;
import br.facom.lyricsseeker.DAO.MusicaDAO;
import br.facom.lyricsseeker.models.Artista;
import br.facom.lyricsseeker.models.Musica;

/**
 * Servlet implementation class IndexUserController
 */
@WebServlet("/IndexUserController")
public class IndexUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SEARCH_RESULT = "/views/user/resultado1.jsp";
	private ArtistaDAO aDao;
	private GeneroDAO gDao;
	private MusicaDAO mDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexUserController() {
        super();
        aDao = new ArtistaDAO();
        gDao = new GeneroDAO();
        mDao = new MusicaDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		removeSessionAttrs(session);
		
		String tipoBusca = request.getParameter("tipo");
		String termoBusca = request.getParameter("termoBusca");
		
		if(request.getParameter("searchList") != null){
			if(tipoBusca.equalsIgnoreCase("musica")){
				
				List<Musica> musicas = mDao.getSome(termoBusca);
				session.setAttribute("musicas", musicas);
				
			}else if(tipoBusca.equalsIgnoreCase("artista")){
				
				List<Artista> artistas = aDao.getSome(termoBusca);
				session.setAttribute("artistas", artistas);
				
			}else if(tipoBusca.equalsIgnoreCase("trecho")){
				
				List<Musica> musicas = mDao.getSomeByLyrics(termoBusca);
				session.setAttribute("musicas", musicas);
				
			}else{
				response.sendRedirect("user");
			}
		}else if(request.getParameter("searchOne") != null){
			if(tipoBusca.equalsIgnoreCase("musica")){
				
				Musica musica = mDao.getOneNameLike(termoBusca);
				session.setAttribute("musica", musica);
				
				
			}else if(tipoBusca.equalsIgnoreCase("artista")){
				
				Artista artista = aDao.getOneNameLike(termoBusca);
				session.setAttribute("artista", artista);
				
				
			}else if(tipoBusca.equalsIgnoreCase("trecho")){
				
				Musica musica = mDao.getOneByLyrics(termoBusca);
				session.setAttribute("musica", musica);
				
			}else{
				response.sendRedirect("user");
			}
		}else{
			response.sendRedirect("user");
		}
	
		RequestDispatcher view = request.getRequestDispatcher("/views/user/resultado1.jsp");
		view.forward(request, response);
	}

	private void removeSessionAttrs(HttpSession session) {
		session.removeAttribute("artista");
		session.removeAttribute("musica");
		session.removeAttribute("artistas");
		session.removeAttribute("musicas");
		
	}

}
