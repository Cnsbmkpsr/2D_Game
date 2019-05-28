package data.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	private boolean[] KeyDown = new boolean[4];
	
	public KeyInput(Handler handler) {
		this.handler = handler; 
		
		KeyDown[0] = false;
		KeyDown[1] = false;
		KeyDown[2] = false;
		KeyDown[3] = false;
		
		
	}

	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				//key events for player 1
				
				if(key == KeyEvent.VK_Z) { tempObject.setVelY(-5); KeyDown[0] = true; }
				if(key == KeyEvent.VK_S) { tempObject.setVelY(5); KeyDown[1] = true; }
				if(key == KeyEvent.VK_Q) { tempObject.setVelX(-5); KeyDown[2] = true; }
				if(key == KeyEvent.VK_D) { tempObject.setVelX(5); KeyDown[3] = true; }
			}
			
			/*
			if(tempObject.getId() == ID.Player2) {
				//key events for player 2
				
				if(key == KeyEvent.VK_UP) tempObject.setVelY(-5);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(5);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
			}
			*/
		}
		

	}



	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				//key events for player 1
				
				if(key == KeyEvent.VK_Z) KeyDown[0] = false;//tempObject.setVelY(0);
				if(key == KeyEvent.VK_S) KeyDown[1] = false;//tempObject.setVelY(0);
				if(key == KeyEvent.VK_Q) KeyDown[2] = false;//tempObject.setVelX(0);
				if(key == KeyEvent.VK_D) KeyDown[3] = false;//tempObject.setVelX(0);
			}
			
// 		==== Vertical Mouvement ====
			if(!KeyDown[0] && !KeyDown[1]) tempObject.setVelY(0);
			
//		==== Horizon Mouvement ====
			if(!KeyDown[2] && !KeyDown[3]) tempObject.setVelX(0);
			
			/*
			if(tempObject.getId() == ID.Player2) {
				//key events for player 2
				
				if(key == KeyEvent.VK_UP) tempObject.setVelY(0);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
			}
			*/
		}
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);

	}

}
