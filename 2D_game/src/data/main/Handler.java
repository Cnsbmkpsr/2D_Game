package data.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
  
  //maintain or update all object of the game
  //Loop all object and individual uptade them
  
  LinkedList<GameObject> object = new LinkedList<GameObject>();
  
  public void tick() {
    for (int i = 0; i < object.size(); i++) {
      GameObject tempObject = object.get(i); //Give id in our list  for all object
      
      tempObject.tick();
    }
  }
  
  public void render(Graphics g) {
    for(int i = 0; i < object.size(); i++) {
      GameObject tempObject = object.get(i);
      
      tempObject.render(g);
    }
  }
  
  public void addObject(GameObject object) {
    this.object.add(object);
  }
  
  public void removeObject(GameObject object) {
    this.object.remove(object);
  }

}