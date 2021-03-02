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
import java.lang.reflect.Array;
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
	
	Enemy enemy = new Enemy();

	public Random random = new Random();
	
	private Timer timer;
	
	private Image imagePlayerDown;
    private Image imagePlayerRight;
    private Image imagePlayerLeft;
    private Image imagePlayerUp;
    private Image currentImage; 
    
    public ArrayList<Tile> tiles = new ArrayList<Tile>();

	public PlayField() {
		initBoard();
	}
	
	//k
	public void initBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        
        this.setBackground(new Color(69,69,180));
        
        initImages();

        initGame();
	}
	
	private void initImages() {
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
	
	private void initGame() {
        timer = new Timer(100, this);
        timer.start();
    }
	
	@Override
    public void paintComponent(Graphics g) {
		MapGen.paintMap(g);
		
		g.setColor(Color.WHITE);
        
        g.drawImage(enemy.getCurrImage(), enemy.enemyx, enemy.enemyy, this);
        
        g.drawImage(currentImage,x,y,this); 
    }

	@Override
	public void actionPerformed(ActionEvent e) {
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
