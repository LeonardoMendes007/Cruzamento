package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ThreadDrive;
import model.Carro;

public class Estrada extends JFrame{
	
	private JPanel drawRoad;
	private Semaphore sema = new Semaphore(1);
	public Carro car; 
	private Semaphore sema1 = new Semaphore(1);
	private Semaphore sema2 = new Semaphore(1);
	private Semaphore sema3 = new Semaphore(1);
	private Semaphore sema4 = new Semaphore(1);
	private Semaphore sema5 = new Semaphore(1);
	
	public Estrada() {
		drawRoad = new DrawRoad();
		setLayout(null);
		setContentPane(drawRoad);
		drawRoad.setLayout(null);
		setResizable(false);
		
		
		
		JButton addCarro = new JButton("Add Carro");
		addCarro.setBounds(70,100,170,40);
		drawRoad.add(addCarro);
		
		addCarro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				chamarCarro(e);
				
			}
		});
		
		
	}
	
	private void chamarCarro(ActionEvent e) {
		car = new Carro(10, 450);
		drawRoad.add(car.getDesenho());
		Thread rodar = new ThreadDrive(car, sema1, sema2, sema3, sema4, sema5);
		rodar.start();
		
	}

}
