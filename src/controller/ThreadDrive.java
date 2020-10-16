package controller;

import java.util.concurrent.Semaphore;

import model.Carro;
import view.Estrada;

public class ThreadDrive extends Thread {
	
	private Semaphore semaCentro;
	private Semaphore semaBaixo;
	private Semaphore semaDireita;
	private Semaphore semaEsquerda;
	private Semaphore semaCima;
	private Carro carro;
	private int metade = 530 / 2;
	private String sinal = "esquerda";
	private int time = 5;

	

	public ThreadDrive(Carro carro, Semaphore semaCentro, Semaphore semaBaixo, Semaphore semaDireita, Semaphore semaEsquerda,
			Semaphore semaCima) {
		super();
		this.semaCentro = semaCentro;
		this.semaBaixo = semaBaixo;
		this.semaDireita = semaDireita;
		this.semaEsquerda = semaEsquerda;
		this.semaCima = semaCima;
		this.carro = carro;
	}

	@Override
	public void run() {
		int x = carro.getX();
		for (int i = carro.getX(); i <= x + metade; i++) {

			carro.getDesenho().setLocation(i, carro.getY());
			
			try {
				sleep(time);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		for (int i = 0; i < 500; i++) {
			movimento();
		}

		super.run();
	}

	private void movimento() {

		if (carro.getX() == 275 && carro.getY() == 450) {
			
			try {
				if (waze() && sinal != "baixo" && sinal != "cima") {
					andarCima(metade);

				} else {
					if(sinal == "direita" || sinal == "esquerda") {
						if (sinal == "direita") {
							andarEsquerda(metade);
		                    andarCima(metade);
						}
						else{
		                    andarDireita(metade);
							andarCima(metade);
						}	
					}else {
						if(waze()) {
							andarDireita(metade);
							andarCima(metade);
						}else {
							andarEsquerda(metade);
		                    andarCima(metade);
						}
					}	
				}
				
			}catch (Exception e) {
				System.err.println("erro");
			}finally {
			}
			
			
			sinal = "baixo";
			System.err.println(sinal);
		}

		if (carro.getX() == 540 && carro.getY() == 185) {

			try {
				if (waze() && sinal != "direita" && sinal != "esquerda") {
					andarEsquerda(metade);
				} else {
					
					if(sinal == "cima" || sinal == "baixo") {
						if(sinal == "cima") {
							andarBaixo(metade);
							andarEsquerda(metade);
						}
						else{
							andarCima(metade);
							andarEsquerda(metade);
						}
						
					}
				    else {
						if(waze()) {
							andarCima(metade);
							andarEsquerda(metade);
						}else {
							andarBaixo(metade);
							andarEsquerda(metade);
						}
					}	
				}
			}catch (Exception e) {
				System.err.println("erro");
			}finally {
			}
			
			sinal = "direita";
			System.err.println(sinal);
		}

		if (carro.getX() == 275 && carro.getY() == -80) {

			try {
				if (waze() && sinal != "cima" && sinal != "baixo") {
					andarBaixo(metade);

				} else {
					if(sinal == "esquerda" || sinal == "direita") {
						if(sinal == "esquerda") {
							andarDireita(metade);
							andarBaixo(metade);
						}
						else{
							andarEsquerda(metade);
							andarBaixo(metade);
						}
					}else {
						if(waze()) {
							andarEsquerda(metade);
							andarBaixo(metade);
						}else {
							andarDireita(metade);
							andarBaixo(metade);
						}
						
					}
					
					
				}
			}catch (Exception e) {
				System.err.println("erro");
			}finally {
			}
			
			

			sinal = "cima";
			System.err.println(sinal);
		}

		if (carro.getX() == 10 && carro.getY() == 185) {

			try {
				if (waze() && sinal != "esquerda" && sinal != "direita") {
					andarDireita(metade);

				} else {
					if(sinal == "baixo" || sinal == "cima") {
						if(sinal == "baixo") {
							andarCima(metade);
							andarDireita(metade);
						}else {
							andarBaixo(metade);
							andarDireita(metade);
						}
					}else {
						if(waze()) {
							andarCima(metade);
							andarDireita(metade);
						}else {
							andarBaixo(metade);
							andarDireita(metade);
						}
					}
					
				}
			}catch (Exception e) {
				System.err.println("erro");
			}finally {
			}
			
			sinal = "esquerda";
			System.err.println(sinal);
		}

		if (carro.getX() == 275 && carro.getY() == 185) {

            try {
				while (true) {
					int sorte = (int) ((Math.random() * 4) + 1);
					
					if (sorte == 1 && sinal !=  "esquerda") {
						andarEsquerda(metade);
						sinal = "esquerda";
						System.err.println(sinal);
						break;
					}
					if (sorte == 2 && sinal !=  "direita") {
						andarDireita(metade);
						sinal = "direita";
						System.err.println(sinal);
						break;
					}
					if (sorte == 3 && sinal != "cima") {
						andarCima(metade);
						sinal = "cima";
						System.err.println(sinal);
						break;
					}
					if (sorte == 4 && sinal != "baixo"){
						andarBaixo(metade);
						sinal = "baixo";
						System.err.println(sinal);
						break;
					}
				}
			}catch (Exception e) {
				System.err.println("erro");
			}finally {
			}
			

		}

	}

	private void andarDireita(int tamanho) {
		int x = carro.getX();
		for (int i = carro.getX(); i <= x + tamanho; i++) {

			carro.getDesenho().setLocation(i, carro.getY());
			try {
				sleep(time);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

	private void andarCima(int tamanho) {

		int y = carro.getY();
		for (int i = carro.getY(); i >= y - tamanho; i--) {
			carro.getDesenho().setLocation(carro.getX(), i);

			try {
				sleep(time);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

	private void andarEsquerda(int tamanho) {
		int x = carro.getX();

		for (int i = carro.getX(); i >= x - tamanho; i--) {

			carro.getDesenho().setLocation(i, carro.getY());

			try {
				sleep(time);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

	private void andarBaixo(int tamanho) {
		int y = carro.getY();
		for (int i = carro.getY(); i <= y + tamanho; i++) {

			carro.getDesenho().setLocation(carro.getX(), i);

			try {
				sleep(time);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	private boolean waze() {

		int ra = (int) ((Math.random() * 11));

		if (ra > 5) {
			return true;
		} else {
			return false;
		}

	}
}
