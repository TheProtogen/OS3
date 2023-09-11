package view;

public class ThreadVetor extends Thread {
	
	//Receber parâmetros do vetor aqui
	//Se par: use "for"
	//Se ímpar: use "for each
	//Contar o tempo para percorrer o vetor
	
	private int[] linha;
	private int threadNumero;

	
	public ThreadVetor(int[] linha, int threadNumero) {
		this.linha = linha;
		this.threadNumero = threadNumero;
	}
	
	
	@Override
	public void run() {
		long tempoStart = System.nanoTime();
		
		if (threadNumero % 2 == 0) {
			for (int i = 0; i < linha.length; i++ ) {
				//Aqui não se faz nada, só percorre o vetor
			}
		} else {
			for (int i : linha) {
				//Aqui não se faz nada, só percorre o vetor
			}
		}
		
		long tempoFim = System.nanoTime();
        double tempoTotal = (tempoFim - tempoStart) / 1e9;
		
        System.out.println("Tempo total = "+tempoTotal+" segundos :" + "Thread ID = "+getId());
		
	}
}
