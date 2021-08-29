package com.company;

import java.awt.*;

public class SpawnPoint extends GameObject{
    private long timer;
    private long wait;



    private boolean unitSpawned;
    SpawnPoint(int x, int y, ID id) {
        super(x, y, id);
        unitSpawned = false;
    }

    @Override
    public Rectangle hitbox() {
        return null;
    }

    @Override
    public void tick() {




    }

    @Override
    public void render(Graphics g) {

    }



    public boolean isUnitSpawned() {
        return unitSpawned;
    }

    public void setUnitSpawned(boolean unitSpawned) {
        this.unitSpawned = unitSpawned;
    }
    public boolean canSpawn(){
        if(unitSpawned){
            unitSpawned = false;
            return false;
        }
        else{
            return true;
        }
    }
}
