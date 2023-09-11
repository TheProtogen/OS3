package view;

import java.util.Random;

import controller.Main2_controller;

public class Main2_view {

	public static void main(String[] args) {
		int[][] matriz = new int[3][5];
		Random random = new Random();
		
		//Números aleatórios de 0-100
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				matriz[i][j] = random.nextInt(101);
			}
		}
		
		for(int i = 0; i < 3; i++) {
			Thread controller = new Main2_controller(matriz[i],i);
			controller.start();
		}
	}

}
