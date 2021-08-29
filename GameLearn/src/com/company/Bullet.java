package com.company;

import java.awt.*;


public class Bullet extends GameObject{
    private Handler handler;

    Bullet(int x, int y, ID id,Handler handler,int velX,int velY) {
        super(x, y, id);
        this.handler = handler;
        this.velX = velX;
        this.velY = velY;
    }

    @Override
    public Rectangle hitbox() {
        return new Rectangle(x-20,y,20,5);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        destroy();
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        g.setColor(Color.red);

        g2D.fillRect(x,y,5,2);
    }



    public void destroy(){
        if(x >= MaGame.getWindowWidth() + 10){
            handler.removeObj(this);

        }
    }
}
