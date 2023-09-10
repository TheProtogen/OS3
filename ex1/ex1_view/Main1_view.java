package ex1_view;

import ex1_controller.Main1_controller;

public class Main1_view {

	public static void main(String[] args) {
		for(int thread = 0; thread < 5; thread++) {
			Thread control1 = new Main1_controller(thread);
			control1.start();
		}
	}
}