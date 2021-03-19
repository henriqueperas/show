package view;

import java.util.concurrent.Semaphore;

import controller.ThreadP;

public class Principal {

public static void main(String[] args) {
		
		int permissoes = 300;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idCompra = 0; idCompra < 300; idCompra++) {
			Thread tCalculo = new ThreadP(idCompra, semaforo);
			tCalculo.start();
		}
		
	}
	
}
