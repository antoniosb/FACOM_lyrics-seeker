<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<link rel="stylesheet" type="text/css" href="./css/cssAdmin.css">
		<title>Área Exclusiva</title>
		<meta charset="utf-8">
		<meta name="description" content="Área Exclusiva">
		<meta name="keywords" content="Área Exclusiva">
	</head>
	<body>
		<div class="areaExclusiva">
			ÁREA EXCLUSIVA!
		</div><!--areaExclusiva-->
	<form method="POST" action="IndexAdminController">
		<div class="loginAdmin">
			Usuário: <input type="text" name="usuario" value=""><br>
			<br> Senha: <input type="password" name="senha" value="">
		</div>
		<!--loginAdmin-->
		<div class="btnLoginAdmin">
			<input type="submit" value="Login">
		</div>
	</form>
	</body>
</html>