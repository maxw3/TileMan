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
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.*;

public class PlayField extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private int x, y;
	
	public Random random = new Random();
	
	private Image image;
	private Timer timer;
	
	public PlayField() {
		initializeBoard();
	}
	
	public void initializeBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        images();
        initializeGame();
	}
	
	private void images() {
		ImageIcon playerImage = new ImageIcon("player01.png");
		image = playerImage.getImage();
	}
	
	private void initializeGame() {
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
	
	public void paint(Graphics g) {
	    rand(g);
	}
	
	public boolean forColor(Color forward) {
		if(forward == Color.WHITE) {
			return true;
		}
		return false;
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,x,y,this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public void up(){
		y -= 25;
	}
	
	public void down() {
		y += 25;
	}
	
	public void left() {
		x -= 25;
	}
	
	public void right() {
		x += 25;
	}
	
	private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent keyEvent) {

            int key = keyEvent.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
            	left();
            }

            if (key == KeyEvent.VK_RIGHT) {
                right();
            }

            if (key == KeyEvent.VK_UP) {
            	up();
            }

            if (key == KeyEvent.VK_DOWN) {
            	down();
            }
        }
    }
}
