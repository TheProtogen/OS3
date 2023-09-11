package view;

import controller.FroggyRace;

public class Main4_view {

	public static void main(String[] args) {
		
		//5 sapos - 5 threads
		//Pulo máximo = 5
		//Tamanho da pista = 100
		//Narrar tudo pelo console
		//Quando o sapo alcançar a linha de chegada, mostrar posição
		
		//Variáveis que podem ser modificadas
		int froggyNum = 5;
		int pistaTamanho = 100;
		//===================================

		Thread[] sapos = new Thread[froggyNum];
		
		for (int i = 0; i < froggyNum; i++) {
			sapos[i] = new FroggyRace(i+1,pistaTamanho);
			sapos[i].start();
		}
	}

}