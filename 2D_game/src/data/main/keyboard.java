package data.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keyboard extends KeyAdapter{
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		System.out.println(key);
		
		
	}
	
	public void keyReleased(KeyEvent e) {
		
	}

}
