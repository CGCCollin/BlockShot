package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Player extends GameObject{
    private static final int pWidth = 32;
    private static final int pHeight = 32;
    private Handler handler;
    private static int HP;



    private boolean trishot;

    Player(int x, int y, ID id, Handler handler) {
        super(x,y,id);
        this.handler = handler;
        System.out.println(MaGame.getWindowHeight());
        HP = 100;
        trishot = false;
    }

    @Override
    public Rectangle hitbox() {
        return new Rectangle(x,y,pWidth,pHeight);
    }

    @Override
    public void tick() {



        x += velX;
        y += velY;
        x = MaGame.clamp(x , 0, MaGame.getWindowWidth() - (5 + 43));
        y = MaGame.clamp(y, 0, MaGame.getWindowHeight() -(5 + 2*pHeight));
        takeDamage();
        HP = MaGame.clamp(HP,0,100);
        shoot(KeyInput.isFire());




    }

    @Override
    public void render(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;

        g.setColor(Color.red);
        g.fillRect(x,y,pWidth,pHeight);


    }

    public void takeDamage(){
        for(GameObject o: handler.objList){
            if(o.getId() == ID.Enemy){
                if(hitbox().intersects(o.hitbox())){
                    HP--;
                }
            }
        }

    }

    public void shoot(Boolean bool){
        if(bool && trishot) {
            handler.addObj(new Bullet(x + 40, y + 18, ID.Bullet, handler, 5 , 0));
            handler.addObj(new Bullet(x + 40, y + 18, ID.Bullet, handler, 5, 2));
            handler.addObj(new Bullet(x + 40, y + 18, ID.Bullet, handler, 5, -2));

        }

        else if(bool) {
            handler.addObj(new Bullet(x + 40, y + 18, ID.Bullet, handler, 20 , 0));
            System.out.println("fire");

        }
        KeyInput.setFire(false);

    }

    public boolean isTrishot() {
        return trishot;
    }

    public void setTrishot(boolean trishot) {
        this.trishot = trishot;
    }

    public static int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }





}
