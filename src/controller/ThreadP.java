package controller;

import java.util.concurrent.Semaphore;

public class ThreadP extends Thread{
	
	private int idCompra;
	private static int posLogin;
	private static int posProcesso;
	private Semaphore semaforo;
	
	public int qntIgreR;
	public int qntIgre;
	public boolean show = true;

	public ThreadP(int idCompra, Semaphore semaforo) {
		this.idCompra = idCompra;
		this.semaforo = semaforo;
	}
	
	public void run() {
		
		Login();
		try {
			semaforo.acquire();
			Processo();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
			Validacao();
		}
		
	}

	private void Validacao() {
		
		int capacidade = 0;
		if((int) qntIgre >= capacidade) {
			System.out.println("o show esta lotado");
			show = false;
		}else {
			System.out.println("o show foi cancelado");
		}
		
	}

	private void Processo() {
		
		if(show == true) {
			int tempo = (int)((Math.random() * 2000) + 1000);
			while(tempo > 2500) {
				System.out.println("#" + idCompra + " foi cancelado");
			}
			posProcesso++;
			System.out.println("#" + idCompra + " foi o " + posProcesso + " o. a terminar o processo");
		}
		
	}

	private void Login() {

		if(show == true) {
			qntIgreR = (int)((Math.random() * 3) + 1);
			qntIgre += qntIgreR;
			int tempo = (int)((Math.random() * 1950) + 50);
			while(tempo > 50) {
				System.out.println("#" + idCompra + " foi cancelado");
			}
			posLogin++;
			System.out.println("#" + idCompra + " foi o " + posLogin + " o. a terminar o login");
		}
	}
	
}
