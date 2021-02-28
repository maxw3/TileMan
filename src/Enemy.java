import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Clock;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Enemy implements ActionListener{

		public int enemyx=300,enemyy=300,dx,dy;
		
		Timer wait = new Timer(1000, this);
		
		private Image imageEnemyDown;
	    private Image imageEnemyRight;
	    private Image imageEnemyLeft;
	    private Image imageEnemyUp;
	    private Image currentImage; 

		Random randomGen = new Random();
		int theRandomNumber = randomGen.nextInt(4);
		
		Enemy(){
			images();
			wait.start();
		}
		
		private void images(){
			ImageIcon enemyDownImage = new ImageIcon("enemyDown.png");
	        imageEnemyDown = enemyDownImage.getImage();
	        currentImage = imageEnemyDown;

	        ImageIcon enemyRightImage = new ImageIcon("enemyRight.png");
	        imageEnemyRight = enemyRightImage.getImage();

	        ImageIcon enemyUpImage = new ImageIcon("enemyUp.png");
	        imageEnemyUp = enemyUpImage.getImage();

	        ImageIcon enemyLeftImage = new ImageIcon("enemyLeft.png");
	        imageEnemyLeft = enemyLeftImage.getImage();
			
		}
		public void paint(Graphics g) {
			
		}
		
		public Image getCurrImage() {
			return currentImage;
			
		}
		
		public void setRandomDirection() {
			wait.start();
		     switch(randomGen.nextInt(4)) {
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
			enemyy -= 32;
			currentImage = imageEnemyUp;
			
		}
		public void moveDown() {
			enemyy += 32;
			currentImage = imageEnemyDown;
			
		}
		public void moveRight() {
			enemyx += 32;
			currentImage = imageEnemyRight;
		}
		public void moveLeft() {
			enemyx -= 32;
			currentImage = imageEnemyLeft;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			setRandomDirection();
		}
}
