package data.main;

import java.awt.Canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{
  

  private static final long serialVersionUID = -3216200918829229977L;

  
  public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
  private Thread thread;
  private boolean running = false;
  private Random r;

  
  private Handler handler; //instance of handler
  
  public Game() {
	  
	handler = new Handler(); 
	this.addKeyListener(new KeyInput());

    new Window(WIDTH, HEIGHT, "Let's Build a Game !", this);
    
    r = new Random();
    
    for(int i = 0; i < 50; i++) {
      //handler.addObject(new Player(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Player));
      handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player));


    }
    
    //handler.addObject(new Player(100, 100, ID.Player));
    //handler.addObject(new Player(200, 200, ID.Player));

    
  }
  

  public synchronized void start(){
    thread = new Thread(this);
    thread.start();
    running = true; //Call our method running to enable the game
    
    //Start our Thread
  }
  
  public synchronized void stop(){
    try { //If we can, so do it !
      thread.join();
      running = false;
    }catch(Exception e) { //e run a bug in our console
      e.printStackTrace();
    }
    
  }
  
  
  public void run() {
    long lastTime = System.nanoTime();
    double amountOfTicks = 60.0;
    double ns = 1000000000 / amountOfTicks;
    double delta = 0;
    long timer = System.currentTimeMillis();
    int frames = 0;
    while(running) {
      long now = System.nanoTime();
      delta += (now - lastTime) / ns;
      lastTime = now;
      while(delta >= 1) {
        tick();
        delta--;
      }
      if(running)
        render();
      frames++;
      
      if(System.currentTimeMillis() - timer > 1000) {
        timer += 1000;
        System.out.println("FPS: " + frames);
        frames = 0;
      }
    }
    stop();
    
  }
  
  private void tick() {
    handler.tick();
    
  }
  
  private void render() {
    BufferStrategy bs = this.getBufferStrategy();
    if(bs == null) {
      this.createBufferStrategy(3);
      return;
    }
    
    Graphics g = bs.getDrawGraphics();
    
    g.setColor(Color.black);
    g.fillRect(0, 0, WIDTH, HEIGHT);
    
    handler.render(g);
    
    g.dispose();
    bs.show();
  }
  
  public static void main(String args[]) {
    new Game();
    
  }

}