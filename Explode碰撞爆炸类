package P01;

import java.awt.Graphics;
import java.awt.Image;

public class explode {
	static Image[] c=new Image[16];
	static {
		for(int z=0;z<16;z++) {
			c[z]=GameUtil.getImage("images/explode/e"+(z+1)+".gif");
			c[z].getWidth(null);
		}		
	}
	int i;int x;int y;
	public void drawboom(Graphics g) {
		if(i<=15) {
			g.drawImage(c[i], x, y, null);
			i++;
		}
	}

	public explode(int x,int y) {
		this.x=x;
		this.y=y;
	}

}
