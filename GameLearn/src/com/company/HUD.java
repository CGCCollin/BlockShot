package com.company;

import java.awt.*;

public class HUD{


    private int hp = 0;



    public void tick() {
        hp = Player.getHP();
    }


    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(20,20,300,32);
        g.setColor(new Color(100,230,100));
        g.fillRect(20,20,hp*3,32);
        g.setColor(Color.DARK_GRAY);
        g.drawRect(20,20,300,32);
    }

    public  void  isAlive(int hp){
        if(hp <=0){
            System.out.println("you died!");
            //MaGame.stop();
        }
    }
}
