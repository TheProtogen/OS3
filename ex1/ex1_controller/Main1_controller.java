package ex1_controller;

public class Main1_controller extends Thread{
	
	private int idThread;
	
	public Main1_controller(int idThread) {
		this.idThread = idThread;
	}
	
	@Override
	public void run() {
		System.out.println(idThread);
	}
}
