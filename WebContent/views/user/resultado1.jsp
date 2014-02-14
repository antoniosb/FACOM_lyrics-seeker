<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<link rel="stylesheet" type="text/css" href="../../css/cssEstilo.css">
		<title>Resultado da Busca</title>
		<!--<link rel="shortcut icon" href="http://www.achetudoeregiao.com.br/mg/iturama/gifs/Brasaoiturama.jpg">-->
		<meta charset="utf-8">
		<meta name="description" content="Resultado da Busca">
		<meta name="keywords" content="Resultado da Busca">
		<meta name="author" content="Grupo">
	</head>
	<body>
		<div class="backResult1">
			<div class=imagemTop>
				<img src="../../images/logoCinza.jpg" width="150" alt="Lyric's Searcher">
			</div>
		
			<div class="txtTopPage">
				Buscar por:
			</div><!--txtTopPage-->
			<div class="radioTopPage">
				<form action="">				
					<input type="radio" name="tipo" value="musica">Música
					<input type="radio" name="tipo" value="cantor">Cantor
					<input type="radio" name="tipo" value="trecho">Trecho
				</form>
			</div><!--radioTopPage-->
			<div class="buscaTopPage">
				<form method = "POST" action = "resultado1.jsp">
					<input type="search" placeholder="Buscar" style="width:320px; font-family:arial; font-size:15px">
					<input type="submit" value="Buscar" style="font-family:arial">
					<input type="submit" value="Estou com Sorte!" >
				</form>
			</div><!--buscaTopPage-->
		</div><!--backResult1-->
		<div class="menuTop">
			<nav id="menu">
				<ul>
					<li><a href="#">Cantores A-Z</a></li>
					<li><a href="#">Gêneros</a></li>
					<li><a href="#">Top 10 Cantores</a></li>
					<li><a href="#">Top 10 Músicas</a></li>
					<li><a href="#">Novas Músicas</a></li>
				</ul>
			</nav>
		</div><!--menuTop-->
	</body>
</html>