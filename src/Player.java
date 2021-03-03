import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class Player {
	
	private int x = 32, y = 32;
	
	private final int SCALE = Main.SCALE;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	private Image imagePlayerDown;
    private Image imagePlayerRight;
    private Image imagePlayerLeft;
    private Image imagePlayerUp;
    private Image currentImage;
    
    public Player() {
    	initImages();
    }
    
    void initImages() {
        ImageIcon player1DownImage = new ImageIcon("player1down.png");
        imagePlayerDown = player1DownImage.getImage();
        currentImage = imagePlayerDown;

        ImageIcon player1RightImage = new ImageIcon("player1right.png");
        imagePlayerRight = player1RightImage.getImage();

        ImageIcon Player1UpImage = new ImageIcon("player1up.png");
        imagePlayerUp = Player1UpImage.getImage();

        ImageIcon Player1LeftImage = new ImageIcon("player1left.png");
        imagePlayerLeft = Player1LeftImage.getImage();
    }
    
    public Image getCurrImage() {
    	return currentImage;
    }
    
    public void setCurrImage(Image image) {
    	currentImage = image;
    }
    
	public void up(){
		setCurrImage(imagePlayerUp);
		y -= 32;
	}
	
	public void down() {
		setCurrImage(imagePlayerDown);
		y += 32;
	}
	
	public void left() {
		//System.out.println(x);
		setCurrImage(imagePlayerLeft);
		x -= 32;
		//System.out.println(x);
	}
	
	public void right() {
		setCurrImage(imagePlayerRight);
		x += 32;
	}
}
