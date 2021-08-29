package com.company;

import java.awt.*;
import java.util.Random;

public class BasicEnemy extends GameObject{
    private Random r;
    private Handler handler;
    private long accelTimer;
    private long lastAccel;
    //private

    BasicEnemy(int x, int y, ID id, Handler handler) {

        super(x, y, id);
        this.handler = handler;
        velX = 5;
        velY = 5;
        r = new Random();
        accelTimer = System.currentTimeMillis();
    }

    @Override
    public Rectangle hitbox() {
        return new Rectangle(x,y,20,20);
    }

    @Override
    public void tick() {
        acceleration(500,300);
        combust();
        x += velX;
        y += velY;
        clamp();
        x = MaGame.clamp(x,0,MaGame.getWindowWidth()- 40);
        y = MaGame.clamp(y,0,MaGame.getWindowHeight()-40);
        velX = MaGame.clamp(velX,-5,5);
        velY = MaGame.clamp(velY,-5,5);
        NavLine();


        //handler.addObj(new Trail(x,y,ID.Trail,handler,0.1f,20,20,Color.white));


    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x,y,20,20);

    }

    public void combust(){
        for( int i = handler.objList.size()-1; i >= 0; i--){// Must use reverse for loop as removing objects shortens list, causes i to skip over indexes , moving backwards you remove the lastest index so there's nothing to slide forwards and nothing gets skipped
            GameObject temp = handler.objList.get(i);
            if(temp.id == ID.Bullet){
                if(temp.hitbox().intersects(hitbox())){
                    temp.setDestroy(true);
                    destroy = true;

                }
            }
        }

    }

    public void NavLine(){

    }

    public void clamp(){

        if(x <= 0){
            velX = 3;
        }

        else if(x >= MaGame.getWindowWidth() - 60){
            velX = -(r.nextInt(3)+1);

        }
        else if (y <= 0){
            velY = r.nextInt(3)+1;
        }
        else if(y >= MaGame.getWindowHeight() - 60){
            velY = -(r.nextInt(3)+1);
        }
    }

    public void acceleration(int x, int y) {

        if (accelTimer > lastAccel + 100) {
            lastAccel = accelTimer;
            System.out.println("active");
            if (this.x >= x) {
                velX--;
            } else if (this.x <= x) {
                velX++;
            }

            if (this.y >= y) {
                velY--;
            } else if (this.y <= y) {
                velY++;
            }

        } else {
            accelTimer = System.currentTimeMillis();
        }
    }



}
