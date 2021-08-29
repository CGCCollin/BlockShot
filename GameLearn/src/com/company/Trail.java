package com.company;

import java.awt.*;

public class Trail extends GameObject
{
    private Handler handler;
    private float alpha = 1.0f, life;
    private int width, height;
    private Color color;

    Trail(int x, int y, ID id, Handler handler, float life, int width, int height, Color color) {
        super(x, y, id);

        this.handler = handler;
        this.width = width;
        this.height = height;
        this.life = life;
        this.color = color;


    }

    @Override
    public Rectangle hitbox() {
        return null;
    }

    @Override
    public void tick() {
        if(alpha > life){
            alpha -= 0.01;
        }
        else{
            handler.removeObj(this);
        }
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setComposite(transparency(alpha));

        g2D.setColor(color);
        g2D.fillRect(x,y,width,height);

        g2D.setComposite(transparency(1));

    }

    public AlphaComposite transparency(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);// type is the rule for composite and alpha is the opacity float 0 = 0, 1 = 100
    }
}
