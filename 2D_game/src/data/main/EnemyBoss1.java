package data.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemyBoss1 extends GameObject{
	
	private Handler handler;

	public EnemyBoss1(float x, float y, ID id, Handler handler) {
		super((int)x, (int)y, id);
		
		this.handler = handler;
		
		velX = 0;
		velY = 5;
	}
	
	  public Rectangle getBounds() {
		  return new Rectangle((int)x, (int)y, 16, 16);
	  }



	public void tick() {
		x += velX;
		y += velY;
		
		if( y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if( x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.green, 16, 16, 0.05f, handler));
		
	}



	public void render(Graphics g) {
		
		g.setColor(Color.green);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

}