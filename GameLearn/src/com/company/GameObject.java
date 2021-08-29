package com.company;

import java.awt.*;

public abstract class GameObject { //basses for all game objects
    protected int x, y;
    protected int velX, velY;
    protected ID id;


    protected boolean destroy;

        GameObject(int x, int y, ID id){
            this.x = x;
            this.y = y;
            this.id = id;
        }

        public abstract Rectangle hitbox();

    public abstract void tick();

        public abstract void render(Graphics g);



        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }

        public int getVelX(){
            return velX;
        }

        public int getVelY(){
            return velY;
        }

        public ID getId(){
            return id;
        }

        public void setX(int x){
            this.x = x;
        }

        public void setY(int y){
            this.y = y;
        }

        public void setVelX(int velX){
            this.velX = velX;
        }

        public void setVelY(int velY){
            this.velY = velY;
        }

        public void setId(ID id){

        }
    public boolean isDestroy() {
        return destroy;
    }

    public void setDestroy(boolean destroy) {
        this.destroy = destroy;
    }



}
