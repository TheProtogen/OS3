package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Linux extends Thread {

	
	private int threadID;
	public Linux(int threadID) {
		this.threadID = threadID;
	}
	
	
	@Override
	public void run() {
		System.out.println(threadID);
		
		switch(threadID) {
		case 0:
			imprimirPing("www.uol.com.br","UOL");
			break;
		case 1:
			imprimirPing("www.terra.com.br","Terra");
			break;
		case 2:
			imprimirPing("www.google.com.br","Google");
			break;
		}
	}
	
	public void imprimirPing(String site, String siteNome) {
		
		// Windows "-n"  |  Linux "-c"
		String nomeOperacao = " ping -4 -n 10 ";
		
		String pingResult = "";
		
		try {
			Process p = Runtime.getRuntime().exec(nomeOperacao+site);
			InputStream pInput = p.getInputStream();
			InputStreamReader pReader = new InputStreamReader(pInput);
			BufferedReader pBuffer = new BufferedReader(pReader);
			
			String pLinha = pBuffer.readLine();
			while (pLinha != null) {
				
				if(pLinha.contains("Resposta")) {
					pingResult = pingResult.concat(pLinha+" : "+siteNome+"\n");
				} else {
					pingResult = pingResult.concat(pLinha+"\n");
				}
				
				
				pLinha = pBuffer.readLine();
			
			}
			pingResult = pingResult.concat("\nThread: "+Long.toString(getId()));
			
			JOptionPane.showMessageDialog(null, pingResult);
			
		} catch (IOException e) {
			
			System.err.println(e.getMessage());
		}
	}
}
