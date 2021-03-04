import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Clock;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Enemy implements ActionListener{

		public int enemyX=32,enemyY=32,dx,dy;
		private final int SCALE = Main.SCALE;
		
		Timer wait = new Timer(1000, this);
		
		private Image imageEnemyDown;
	    private Image imageEnemyRight;
	    private Image imageEnemyLeft;
	    private Image imageEnemyUp;
	    private Image currentImage; 

		Random randomGen = new Random();
		int theRandomNumber = randomGen.nextInt(4);
		
		Enemy(){
			initImages();
			wait.start();
		}
		
		public int getX() {
			return enemyX;
		}
		public int getY() {
			return enemyY;
		}
		
		private void initImages(){
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
		    	 if(checkUp()) {
		    		 moveUp();
		    		 break;
		    	 }
		     case 1:
		    	 if(checkLeft()) {
		    		 moveLeft();
		    		 break;
		    	 }
		     case 2:
		    	 if(checkRight()) {
		    		moveRight();
		         	break;
		    	 }
		     case 3:
		    	 if(checkDown()) {
		    		moveDown();
		         	break;
		    	 }
		     }
		}
		
		//enemy move
		public void moveUp() {
			enemyY -= 32;
			currentImage = imageEnemyUp;
			
		}
		public void moveDown() {
			enemyY += 32;
			currentImage = imageEnemyDown;
			
		}
		public void moveRight() {
			enemyX += 32;
			currentImage = imageEnemyRight;
		}
		public void moveLeft() {
			enemyX -= 32;
			currentImage = imageEnemyLeft;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			setRandomDirection();
		}
		
		public boolean checkLeft() {
			
			int goToX = this.getX() - SCALE;
			int goToY = this.getY();
			
			for(Tile t: MapGen.tiles) {
				if(t.getX() == goToX) {
					if(t.getY() == goToY) {
						if(t.isWall) {
							return false;
						}
					}
				}
			}
			
			return true;
		}
		
		public boolean checkRight() {
			
			int goToX = this.getX() + SCALE;
			int goToY = this.getY();
			
			for(Tile t: MapGen.tiles) {
				if(t.getX() == goToX) {
					if(t.getY() == goToY) {
						if(t.isWall) {
							return false;
						}
					}
				}
			}
			
			return true;
		}
		
		public boolean checkUp() {
			
			int goToX = this.getX();
			int goToY = this.getY() - SCALE;
			
			for(Tile t: MapGen.tiles) {
				if(t.getX() == goToX) {
					if(t.getY() == goToY) {
						if(t.isWall) {
							return false;
						}
					}
				}
			}
			
			return true;
		}
		
		public boolean checkDown() {
			
			int goToX = this.getX();
			int goToY = this.getY() + SCALE;
			
			for(Tile t: MapGen.tiles) {
				if(t.getX() == goToX) {
					if(t.getY() == goToY) {
						if(t.isWall) {
							return false;
						}
					}
				}
			}
			
			return true;
		}
}
