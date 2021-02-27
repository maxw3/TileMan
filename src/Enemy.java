import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Enemy{
	
	//enemy
		private int enemyx=300,enemyy=300,dx,dy;
	//enemyImage
		private Image image2;
	//random
		Random randomGen = new Random();
		int theRandomNumber = randomGen.nextInt(4);
		
		private void images(){
			//enemy
			ImageIcon enemyImage = new ImageIcon("enemy.png");
			image2 = enemyImage.getImage();
		}
		public void paintComponent(Graphics g) {
			
			g.fillRect(enemyx,enemyy,25,25);
			
		}
		
		public void setRandomDirection() {
		     switch(theRandomNumber) {
		     case 0:
		         moveUp();
		         break;
		     case 1:
		         moveLeft();
		         break;
		     case 2:
		         moveRight();
		         break;
		     case 3:
		         moveDown();
		         break;
		     }
		}
		
		//enemy move
		public void moveUp() {
			dy=-5;
			enemyy+=dy;
			dx=0;
			
		}
		public void moveDown() {
			dy=5;
			enemyy+=dy;
			dx=0;
			
		}
		public void moveRight() {
			dy=0;
			dx=5;
			enemyx+=dx;
		}
		public void moveLeft() {
			dy=0;
			dx=-5;
			enemyx+=dx;
		}
}
