package view;

import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawRoad extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//top
		g.drawLine(40, 30, (540/2), 30);
		g.drawLine((540/2)+45, 30, 540, 30);	

		//left
		g.drawLine(40, (530/2)-10, 40, 30);
		g.drawLine(40, 530, 40, (530/2)+35);	
		
		//right
		g.drawLine(540, (530/2)-10, 540, 30);
		g.drawLine(540, 530, 540,(530/2)+35);
		
		//bottom
		g.drawLine(40, 530, (540/2), 530);
		g.drawLine((540/2)+45, 530, 540, 530);
		
	
		//middle-horizontal
		g.drawLine((540/2)+45, (530/2)+35, 540, (530/2)+35);
		g.drawLine(40, (530/2)+35, (540/2), (530/2)+35);
		
		g.drawLine((540/2)+45, (530/2)-10, 540, (530/2)-10);
		g.drawLine(40, (530/2)-10, (540/2), (530/2)-10);
		
		//middle-vertical
		g.drawLine((540/2), (530/2)-10, (540/2), 30);
		g.drawLine((540/2)+45, (530/2)-10, (540/2)+45, 30);
		
		g.drawLine((540/2), 530, (540/2), (540/2)+30);	
		g.drawLine((540/2)+45, 530, (540/2)+45, (540/2)+30);	
	
	}
}
