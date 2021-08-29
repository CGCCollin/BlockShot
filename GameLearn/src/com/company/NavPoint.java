package com.company;

import java.awt.*;

public class NavPoint extends GameObject{
    NavPoint(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public Rectangle hitbox() {
        return new Rectangle(x,y,30,30);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
