import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Robot;
import java.awt.geom.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.*;

public class PlayField extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private int x, y;
	
	Room rooms[] = new Room[3];
	Corridor cor = new Corridor();
	
	Enemy enemy = new Enemy();

	public Random random = new Random();
	
	private Timer timer;
	
	private Image imagePlayerDown;
    private Image imagePlayerRight;
    private Image imagePlayerLeft;
    private Image imagePlayerUp;
    private Image currentImage; 
    

	public PlayField() {
		initializeBoard();
	}
	
	//k
	public void initializeBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        
        this.setBackground(new Color(69,69,180));
        
        images();
        initializeGame();
	}
	
	private void images() {
        ImageIcon player1DownImage = new ImageIcon("player1down.png");
        imagePlayerDown = player1DownImage.getImage();
        currentImage = imagePlayerDown;

        ImageIcon player1RightImage = new ImageIcon("player1right.png");
        imagePlayerRight = player1RightImage.getImage();

        ImageIcon Player1UpImage = new ImageIcon("player1up.png");
        imagePlayerUp = Player1UpImage.getImage();

        ImageIcon Player1LeftImage = new ImageIcon("player1left.png");
        imagePlayerLeft = Player1LeftImage.getImage();
        
//        ImageIcon spritesIcon = new ImageIcon("charSpriteSheet.png");
//        spriteSheet = spritesIcon.getImage();
    }
	
	private void initializeGame() {
		
		//temp code
		rooms[0] = new Room(1,1,5,7);
		rooms[1] = new Room(7,1,3,10);
		rooms[2] = new Room(11,7,7,5);
		
		cor.start = rooms[0].center;
		cor.end = rooms[2].center;
		
        timer = new Timer(100, this);
        timer.start();
    }
	
	public void rand(Graphics g) {
		for(int i = 0; i < 1000; i += 25) {
	        for(int j = 0; j < 1000; j += 25){
	        	boolean randBool = random.nextBoolean();
	        	Color col;
	        	if(randBool) {
	        		col = Color.white;
	        	}else {
	        		col = Color.black;
	        	}
	            g.setColor(col);
	            g.fillRect(j, i, 25, 25);
	        }
	    }
	}
	
	@Override
    public void paintComponent(Graphics g) {
		
		g.setColor(Color.WHITE);
		
        super.paintComponent(g);
        
        for(Room r: rooms) {
        	r.paint(g);
        }
        
        cor.paint(g);
        
        g.drawImage(enemy.image2, enemy.enemyx, enemy.enemyy, this);
        
        g.drawImage(currentImage,x,y,this); 
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		enemy.setRandomDirection();
		repaint();
	}

	public void up(){
		y -= 32;
	}
	
	public void down() {
		y += 32;
	}
	
	public void left() {
		x -= 32;
	}
	
	public void right() {
		x += 32;
	}
	
	private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent keyEvent) {

            int key = keyEvent.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                left();
                currentImage = imagePlayerLeft; //change I made 
            }

            if (key == KeyEvent.VK_RIGHT) {
                right();
                currentImage = imagePlayerRight;//change I made 
            }

            if (key == KeyEvent.VK_UP) {
                up();
                currentImage = imagePlayerUp;//change I made 
            }

            if (key == KeyEvent.VK_DOWN) {
                down();
                currentImage = imagePlayerDown;//change I made 
            }
        }
    }
	
	
}
