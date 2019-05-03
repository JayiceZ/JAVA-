package P01;

import java.awt.Color;
import java.awt.Graphics;

public class Shell extends Plane{
	int width,height;
	double degree;
	public Shell() {
		x=300;
		y=300;
		width=10;
		height=10;              	
		degree=2*Math.random()*Math.PI;		
		speed=5;
	}
	public void color(Graphics g) {
		Color c=g.getColor();
		g.setColor(Color.yellow);
		g.fillOval(x, y, width, height);
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		g.setColor(c);
		if(x<0-width||x>800-width) {
			degree=Math.PI-degree;
		}
		if(y<0-height||y>600-height) {
			degree=-degree;
		}
	}
}
