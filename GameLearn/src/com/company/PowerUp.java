package com.company;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class PowerUp extends GameObject{
    private boolean up;
    private boolean down;
    private int width, height;
    private Timer timer;
    private TimerTask task;
    long time;
    long timeLater;
    int delay = 10;
    Handler handler;

    PowerUp(int x, int y, ID id, int width, int height, Handler handler) {
        super(x, y, id);
        up = true;
        down = false;
        this.width = width;
        this.height = height;
        this.handler = handler;
        velX = -2;
        time = System.currentTimeMillis();
        timeLater = time + delay;


    }

    @Override
    public Rectangle hitbox() {
        return new Rectangle(x,y,30,30);
    }

    @Override
    public void tick() {

        x+=velX;
        y+=velY;
        y = MaGame.clamp(y,0,MaGame.getWindowHeight()-2*height);
        movement();
        playerCollects();


    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x,y,width,height);
    }

    public void movement() {


        if (time >= timeLater) {
            if (up) {
                velY--;
                if (velY <= -10) {
                    down = true;
                    up = false;
                }
            }

            if (down) {
                velY++;
                if (velY >= 10) {
                    up = true;
                    down = false;
                }
            }
            time = System.currentTimeMillis();
            timeLater = time + delay;
        } else
            {
                time = System.currentTimeMillis();
            }

    }

    public void playerCollects(){
        for(int i = handler.objList.size() - 1; i > 0; i--){
            GameObject temp = handler.objList.get(i);
            if(temp.getId() == ID.Player){
                Player p = (Player) temp;
                if(this.hitbox().intersects(p.hitbox())){
                    p.setTrishot(true);
                }
            }
        }
    }




}


