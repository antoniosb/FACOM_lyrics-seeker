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

import br.facom.lyricsseeker.DAO.MusicaDAO;
import br.facom.lyricsseeker.models.Musica;

/**
 * Servlet implementation class AdminEditMusicaController
 */
@WebServlet("/AdminEditMusicaController")
public class AdminEditMusicaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LIST_MUSICA = "/views/admin/Admin-editMusica.jsp";
	private static final String INSERT_OR_EDIT = "/views/admin/Admin-addMusica.jsp";
    private MusicaDAO dao;   
           
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditMusicaController() {
        super();
        dao = new MusicaDAO();
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
				int id = Integer.valueOf(request.getParameter("id_musica"));
				dao.delete(id);
				forward = LIST_MUSICA;
				session.setAttribute("musicas", dao.getAll());
				
			}else if(action.equalsIgnoreCase("edit")){
				int id = Integer.valueOf(request.getParameter("id_musica"));
				Musica musica = dao.getOne(id);
				session.setAttribute("musica", musica);
				forward = INSERT_OR_EDIT;
				
			}else if(action.equalsIgnoreCase("listMusica")){
				forward = LIST_MUSICA;
				session.setAttribute("musicas", dao.getAll());
			}else{
				forward = INSERT_OR_EDIT;
				session.setAttribute("musica", null);
			}
			
		}else{
			forward = LIST_MUSICA;
			session.setAttribute("musicas", dao.getAll());
		}

		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Musica musica = new Musica();
		HttpSession session = request.getSession();
		
		String flag = request.getParameter("flag");
		
		if(flag.equalsIgnoreCase("add")){
			
//			musica.setIdMusica();
			musica.setNomeMusica(request.getParameter("nomeMusica"));
			musica.setIdArtista(Integer.valueOf(request.getParameter("id_artista")));
			musica.setIdGenero(Integer.valueOf(request.getParameter("id_genero")));
			musica.setUrlVideo(request.getParameter("urlVideo"));
			musica.setLetra(request.getParameter("letra"));
			
			try{
				musica.setDataCriacao(MusicaDAO.PATTERN.parse(request.getParameter("dataCriacao")));
			}catch(ParseException e){
				musica.setDataCriacao(new Date());
			}
			
			if(dao.existeMusica(musica.getIdMusica())){
				dao.edit(musica.getIdMusica(), musica);
			}else{
				dao.add(musica);
			}
			
			session.setAttribute("musicas", dao.getAll());
			
		}else if(flag.equalsIgnoreCase("search")){
			String musicaNome = request.getParameter("search");
			session.setAttribute("musicas", dao.getSome(musicaNome));
		}
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_MUSICA);
		view.forward(request, response);
	
	}

}
