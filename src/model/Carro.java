package model;

import java.awt.Font;

import javax.swing.JLabel;

public class Carro {
	
	private JLabel desenho;
    private int height;
    private int width;
    
	public Carro(int x, int y) {
		super();
		this.height = 120;
		this.width = 30;
		
		desenho = new JLabel(".");
		desenho.setLayout(null);
		desenho.setBounds(x,y,width,height);
		desenho.setFont(new Font("arial", 1, 120));

		
	}

	
	
	public JLabel getDesenho() {
		return desenho;
	}



	public void setDesenho(JLabel desenho) {
		this.desenho = desenho;
	}



	public int getX() {
		return desenho.getX();
	}

	public void setX(int x) {
		this.desenho.setLocation(x, getY());
	}

	public int getY() {
		return desenho.getY();
	}

	public void setY(int y) {
		this.desenho.setLocation(getX(), y);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
    
    

}
