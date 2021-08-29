package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.io.IOException;

public class Background extends GameObject{
    private Image img;

    Background(int x, int y, ID id) {
        super(x, y, id);

        try {
            img = new ImageIcon("res\\goodBG.png").getImage();
        }catch(Exception e){
            System.out.println("missing file");
        }



        velX = -4;

    }


    public Rectangle hitbox() {
        return new Rectangle(0,0,0,0);
    }

    @Override
    public void tick() {
        x += velX;
        if(x == -1280){
            x = 0;
        }

    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);
        g2D.drawImage(img,x,y,null);
        if(redraw()){
            g2D.drawImage(img,x+1280,y,null);
        }

    }
    public boolean redraw(){
        if(x < 0){
            return true;
        }

        else{
            return false;
        }
    }
}
