package data.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemyBoss1 extends GameObject{
	
	private Handler handler;
	private int timer = 80;
	private int timer2 = 50;

	public EnemyBoss1(float x, float y, ID id, Handler handler) {
		super((int)x, (int)y, id);
		
		this.handler = handler;
		
		velX = 0;
		velY = 2;
	}
	
	  public Rectangle getBounds() {
		  return new Rectangle((int)x, (int)y, 96, 96);
	  }



	public void tick() {
		x += velX;
		y += velY;
		
		if(timer <= 0) velY = 0;
		else timer--;
		
		if(timer <= 0) timer2--;
		if(timer2 <= 0)
		{
			if(velX == 0) velX = 2;
		}
		
		
		//if( y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if( x <= 0 || x >= Game.WIDTH - 96) velX *= -1;
		
		
		//handler.addObject(new Trail(x, y, ID.Trail, Color.red, 96, 96, 0.008f, handler));
		
	}



	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 96, 96);
		
	}

}
