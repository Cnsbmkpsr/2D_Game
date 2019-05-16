package data.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		System.out.println(key);

	}

	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
