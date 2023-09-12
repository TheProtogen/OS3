package view;

import controller.Linux;

public class Main5_view {

	public static void main(String[] args) {
		
		
		for(int i = 0; i < 3; i++) {
			Thread linux = new Linux(i);
			linux.start();
		}
		
	}

}
