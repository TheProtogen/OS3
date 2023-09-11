package controller;

import java.util.Random;

import view.ThreadVetor;

public class Main3_controller {

	public static void main(String[] args) {
		Random random = new Random();
		
		//Area das declarações
		int[] vetor = new int[1000];
		int vetorLenght = vetor.length;
		
		for (int i = 0; i < vetorLenght; i++) {
			vetor[i] = random.nextInt(101);
		}
		
		
		//Area das Thread
		for (int i = 0; i < 2; i++) {
			Thread threadsImpar = new ThreadVetor(vetor,1);
			Thread threadsPar = new ThreadVetor(vetor,2);
			
			threadsImpar.start();
			threadsPar.start();
		}
		
	}

}
