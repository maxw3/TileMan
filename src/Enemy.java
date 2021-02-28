import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.ImageIcon;

public class Enemy{

		public int enemyx=300,enemyy=300,dx,dy;
		
		Image image2;

		Random randomGen = new Random();
		int theRandomNumber = randomGen.nextInt(4);
		
		Enemy(){
			images();
		}
		
		private void images(){
			ImageIcon enemyImage = new ImageIcon("enemy.png");
			image2 = enemyImage.getImage();
		}
		public void paint(Graphics g) {
			
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
			dy=-25;
			enemyy+=dy;
			dx=0;
			
		}
		public void moveDown() {
			dy=25;
			enemyy+=dy;
			dx=0;
			
		}
		public void moveRight() {
			dy=0;
			dx=25;
			enemyx+=dx;
		}
		public void moveLeft() {
			dy=0;
			dx=-25;
			enemyx+=dx;
		}
}
