package data.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
  
  protected float x;
  protected float y;
  protected ID id;
  protected float velX;
  protected float velY;
  
  //Les objets du jeu, tous les objets du jeu
  
  public GameObject(int x, int y, ID id) {
    this.x = x;
    this.y = y;
    this.id = id;
  }
  
  public abstract void tick();
  public abstract void render(Graphics g);
  public abstract Rectangle getBounds(); 
  
  public void setX(int x) {
    this.x = x;
  }
  public void setY(int y) {
    this.y = y;
  }
  public float getX() {
    return x;
  }
  public float GetY() {
    return y;
  }
  public void setId(ID id) {
    this.id = id;
  }
  public ID getId() {
    return id;
  }
  public void setVelX(float velX) {
    this.velX = velX;
  }
  public void setVelY(float velY) {
    this.velY = velY;
  }
  public float getVelX() {
    return velX;
  }
  public float getVelY() {
    return velY;
  }
  

}