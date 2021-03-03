import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class Player {
	
	int x,y;
	
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
		y -= 32;
		setCurrImage(imagePlayerUp);
	}
	
	public void down() {
		y += 32;
		setCurrImage(imagePlayerDown);
	}
	
	public void left() {
		x -= 32;
		setCurrImage(imagePlayerLeft);
	}
	
	public void right() {
		x += 32;
		setCurrImage(imagePlayerRight);
	}
}
