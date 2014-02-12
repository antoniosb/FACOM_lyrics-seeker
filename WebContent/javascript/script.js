function alertIt(){
};

document.getElementById('form').onsubmit = function() {
	input = document.getElementById("value").value;
	if (input == "" || input == null){
		alert("Parabéns, você sabe clicar em um botão! ***FERA***");
		return false;
	}else return true;
};