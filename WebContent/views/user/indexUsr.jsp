<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<link rel="stylesheet" type="text/css" href="../../css/cssEstilo.css">
		<title>Lyric's Searcher</title>
		<!--<link rel="shortcut icon" href="http://www.achetudoeregiao.com.br/mg/iturama/gifs/Brasaoiturama.jpg">-->
		<meta charset="utf-8">
		<meta name="description" content="Lyric's Searcher">
		<meta name="keywords" content="Lyric's Searcher">
		<meta name="author" content="Grupo">
	</head>
	<body>
		<div class=imagemIndex>
			<img src="../../images/logo.jpg" width="400" alt="Lyric's Searcher">
		</div>
		
		<div class="txtBuscar">
			Buscar por:
		</div><!--txtBuscar-->
		<div class="btnradio">	
			<form action="">
				<input type="radio" checked name="tipo" value="musica">Música
				<input type="radio" name="tipo" value="cantor">Cantor
				<input type="radio" name="tipo" value="trecho">Trecho
			</form>
		</div><!--btnradio_index-->
	
		<div class="campoBusca">
			<input type="search" placeholder="Search" style="width:320px"><br><br>			
		</div><!--busca-->
		
		<div class="btnBusca">
			<form method = "POST" action = "resultado1.jsp">
			<input type="submit" value="Buscar" >
			<input type="submit" value="Estou com Sorte!" >
			</form>
		</div><!--btnBusca-->
	</body>
</html>