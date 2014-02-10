package br.facom.lyricsseeker.models;

public class Model {
	public int square(int x){
		return x*x;
	}
	
	public int factorial(int x){
		if(x < 0) return 0;
		int fact = 1;
		for (int i=1; i<=x; i++)
			fact *= i;
		return fact;
	}

}
