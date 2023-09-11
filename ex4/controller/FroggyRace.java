package controller;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class FroggyRace extends Thread {
	
	Random random = new Random();
	
	//Variáveis da main
	private static AtomicInteger froggyChamps = new AtomicInteger(1);; //Mostra a posição dos sapos que passaram da distancia máxima
	private int distanciaMax; //Distancia máxima que o sapo deve percorrer
	private int froggyNum; //Número atribuido ao sapo
	
	//Variáveis que podem ser modificadas
	private int puloMax = 4; //Pulo máximo do sapo
	private int froggyPos; //Posição atual do sapo
	private int froggyJump; //Pulo que o sapo deu no momento
	
	public FroggyRace(int froggyNum, int distanciaMax) {
		this.froggyNum = froggyNum;
		this.distanciaMax = distanciaMax;
		
	}
	
	@Override
	public void run() {
		
		
		while (froggyPos < distanciaMax) {
			froggyPos += froggyJump;
			System.out.println(getId()+" : "+froggyJump+" : "+froggyPos);
			froggyJump = froggyJump();
			if (this.froggyPos > distanciaMax) {
				interrupt();
			}
		}
		int posicaoChegada = froggyChamps.getAndIncrement();
		System.out.println("Sapo número "+froggyNum+" (thread: "+getId()+")"+" chegou em "+froggyPos+
				" metros  ["+posicaoChegada+"° lugar]");
	}
	
	public int froggyJump() {
		return random.nextInt(puloMax);
	}
	
	
	
}
