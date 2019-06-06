package data.main;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >= 250) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			
			if(hud.getLevel() == 1) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			System.out.println("hud.getlevel == 1");
			}
			else if(hud.getLevel() == 2){
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
				//handler.addObject(new EnemyBoss1(r.nextInt((Game.WIDTH / 2) - 48), r.nextInt(Game.HEIGHT - 96), ID.EnemyBoss1, handler));
				System.out.println("hud.getlevel == 2");
			}
			else if(hud.getLevel() == 3) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
				System.out.println("hud.getlevel == 3");
			}
			else if(hud.getLevel() == 4) {
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
				System.out.println("hud.getlevel == 4");
			}
		}
		
	}

}
