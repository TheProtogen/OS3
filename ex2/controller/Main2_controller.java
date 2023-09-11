package controller;

public class Main2_controller extends Thread {

	private int[] linha;
	private int linhaShow;
	
	public Main2_controller(int[] linha, int linhaShow) {
		this.linha = linha;
		this.linhaShow = linhaShow;
	}
	
	@Override
	public void run() {
		
		int somaThread = 0;
		for (int value : linha) {
            somaThread += value;
        }
		
		//Isso aqui é só para a thread sair na ordem, pode transformar isso em comentário de boas.	
		try {
			sleep(linhaShow*100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread - "+getId()+" : Linha - "+linhaShow+" : Soma = "+somaThread);
		
	}

	
}
