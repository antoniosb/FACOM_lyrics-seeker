<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<link rel="stylesheet" type="text/css" href="../../css/cssAdmin.css">
		<title>Editar Gênero</title>
		<!--<link rel="shortcut icon" href="http://www.achetudoeregiao.com.br/mg/iturama/gifs/Brasaoiturama.jpg">-->
		<meta charset="utf-8">
		<meta name="description" content="Editar G�nero">
		<meta name="keywords" content="Editar G�nero">
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
		<div class="btnadd">
			<form method = "POST" action = "Admin-addGenero.jsp">
			<input type="submit" value="Adicionar G�nero" >
			</form>
		</div><!--btnaddMusica-->
		<div class="campoBusca">
			<input type="search" placeholder="Search" style="width:320px">
			<input type="submit" value="Buscar" >			
		</div><!--busca-->
	</body>
</html>