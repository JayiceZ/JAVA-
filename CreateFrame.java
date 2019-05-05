 package P01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JFrame;

public class CreateFrame extends Frame{
	
	Image planeImg=GameUtil.getImage("images/hero0.png");
	Image bg=GameUtil.getImage("images/background.png");
	Plane a=new Plane(planeImg,450,250);
	Shell[] b=new Shell[50];
	explode bao;
	Date startTime=new Date();
	Date endTime;
	int period;  //定义游戏时间
	
	

	public void paint(Graphics g) {
		g.drawImage(bg, 0, 35, null);
		a.drawSelf(g);
		for(int i=0;i<b.length;i++) {
			b[i].color(g);
			boolean boom=b[i].getRect().intersects(a.getRect());
			if(boom) {
				a.live=false;
				if(bao==null) {
					bao=new explode(a.x,a.y);
					endTime=new Date();
					period=(int)((endTime.getTime()-startTime.getTime())/1000);
					
				}bao.drawboom(g);
				
			}
			if(!a.live) {
				g.setColor(Color.red);
				g.drawString("游戏时间为"+period+"秒", a.x, a.y);
				
			}
		}
		
		
	}
	
	public class PaintThread extends Thread{
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(40);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	class keymonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			a.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			a.minusDirection(e);
		}
		
	}
	
	public void launchFrame() {
		this.setTitle("MyFirstPro:PlaneGame");
		this.setVisible(true);
		this.setSize(800, 600);
		this.setLocation(600, 200);

		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		new PaintThread().start();
		addKeyListener(new keymonitor());
		for(int i=0;i<b.length;i++) {
			b[i]=new Shell();
		}
				
	}
	   
	public static void main(String[] args) {
		CreateFrame a=new CreateFrame();
		
		a.launchFrame();
	}
	private Image offScreenImage = null;
	 
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(800,600);//这是游戏窗口的宽度和高度
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}  
}

