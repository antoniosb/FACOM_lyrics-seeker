<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<link rel="stylesheet" type="text/css" href="../../css/cssAdmin.css">
		<title>Adicionar Gênero</title>
		<!--<link rel="shortcut icon" href="http://www.achetudoeregiao.com.br/mg/iturama/gifs/Brasaoiturama.jpg">-->
		<meta charset="utf-8">
		<meta name="description" content="Adicionar G�nero">
		<meta name="keywords" content="Adicionar G�nero">
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
		<div class="formGenero">
			<form method = "POST" action = "Admin-editGenero.jsp">
				<p>G�nero: <input type="text" name="genero" style="width:300px; font-family:arial"></p>
				<p>Letra: <textarea name="letra" rows="20" cols="40"></textarea></p>
				<input type="submit" value="Salvar" >
			</form>
		</div><!--formArtista-->
	</body>
</html>