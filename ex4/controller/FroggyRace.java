package controller;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class FroggyRace extends Thread {
	
	Random random = new Random();
	
	//Variáveis da main
	private static AtomicInteger froggyChamps = new AtomicInteger(1);; //Mostra a posição dos sapos que passaram da distancia máxima
	private int distanciaMax; //Distancia máxima que o sapo deve percorrer
	private int froggyNum; //Número atribuido ao sapo
	private int puloMax; //Pulo máximo do sapo
	private int froggyPos; //Posição atual do sapo
	private int froggyJump; //Pulo que o sapo deu no momento
	
	public FroggyRace(int froggyNum, int distanciaMax, int puloMax) {
		this.froggyNum = froggyNum;
		this.distanciaMax = distanciaMax;
		this.puloMax = puloMax;
	}
	
	@Override
	public void run() {
		
		while (froggyPos < distanciaMax) {
			froggyPos += froggyJump;
			System.out.println(getId()+" : "+froggyJump+" : "+froggyPos);
			froggyJump = froggyPulo();
			if (this.froggyPos > distanciaMax) {
				interrupt();
			}
		}
		int posicaoChegada = froggyChamps.getAndIncrement();
		System.out.println("Sapo número "+froggyNum+" (thread: "+getId()+")"+" chegou em "+froggyPos+
				" metros  ["+posicaoChegada+"° lugar]");
	}
	
	public int froggyPulo() {
		int jump = random.nextInt(puloMax+1);
		return jump;
	}
	
	//  Mecânicas novas dos sapos. 
	//     [UNDER CONSTRUCTION]
	
	
	//Sabotagem = O sapo vai sabotar a próxima thread, podendo até ser ela mesma.
	public int froggySabotagem() {
		int sabotagem = random.nextInt(puloMax);
		sabotagem = sabotagem - (sabotagem*2);
		return sabotagem;
	}
	
	//Boost = O sapo vai ganhar um boost.
	public int froggyBoost(int jump) {
		int boost = random.nextInt(puloMax);
		return boost;
	}
	
	
}
