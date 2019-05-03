package P01;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Plane {
	int speed=8;
	boolean right,left,up,down;
	Image imgs;
	int x,y;
	int width=12;
	int heigth=12;
	
	boolean live=true;

	public void drawSelf(Graphics g) {
		if(live) {
			g.drawImage(imgs, x, y, null);
			if(left) {
				x-=speed;
			}
			if(right) {
				x+=speed;
			}
			if(up) {
				y-=speed;
			}
			if(down) {
				y+=speed;
			}
		}else {
			
		}
		
	}
	public Plane(Image imgs,int x,int y) {
		this.imgs=imgs;
		this.x=x;
		this.y=y;
		
	}

	public Plane(){
		
	}
	public void addDirection(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		left=true;
		break;
		case KeyEvent.VK_UP:
		up=true;
		break;
		case KeyEvent.VK_RIGHT:
		right=true;
		break;
		case KeyEvent.VK_DOWN:
		down=true;
		break;
		
		}
	}
	public void minusDirection(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		left=false;
		break;
		case KeyEvent.VK_UP:
		up=false;
		break;
		case KeyEvent.VK_RIGHT:
		right=false;
		break;
		case KeyEvent.VK_DOWN:
		down=false;
		break;
		
		}
	}
	public Rectangle getRect() {
		return new Rectangle(x,y,width,heigth);
	}
}
