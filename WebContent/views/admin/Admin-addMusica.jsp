<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<link rel="stylesheet" type="text/css" href="../../css/cssAdmin.css">
		<title>Adicionar Música</title>
		<!--<link rel="shortcut icon" href="http://www.achetudoeregiao.com.br/mg/iturama/gifs/Brasaoiturama.jpg">-->
		<meta charset="utf-8">
		<meta name="description" content="Adicionar M�sica">
		<meta name="keywords" content="Adicionar M�sica">
		<meta name="author" content="Grupo">
	</head>
	<body>
		<div class="menuAdmin">
			<nav id="menu">
					<ul>
						<li><a href="Admin-editMusica.jsp">M�sica</a></li>
						<li><a href="Admin-editArtista.jsp">Artista</a></li>
						<li><a href="Admin-editGenero.jsp">G�nero</a></li>
						<li><a href="indexAdmin.jsp">Sair</a></li>
					</ul>
			</nav>
		</div><!--menuAdmin-->
		<br><br>
		<div class="formMusica">
				<form method = "POST" action = "Admin-editMusica.jsp">
				<p>T�tulo: <input type="text" name="titulo" style="width:300px; font-family:arial"></p>
				<p>Artista: <select name="artista" size="1">
						   <option value="selecione"> Selecione</option>
						   <option value="rionegroesolimoes"> Rio Negro e Solim�es</option>
						 </select>				
				G�nero: <select name="genero" size="1">
						   <option value="selecione"> Selecione</option>
						   <option value="sertanejo"> Sertanejo</option>
							</select>
				<p>URL do vídeo: <input type="text" name="url" style="width:240px; font-family:arial"></p>
				<p>Letra: <textarea name="letra" rows="20" cols="40"></textarea></p>
				<input type="submit" value="Salvar" >
			</form>
		</div><!--formMusica-->
	</body>
</html>