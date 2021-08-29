package com.company;


import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

public class Spawner {
    //Point[] powerUpP = new Point2D[4];
    SpawnPoint[] enemySpawn = {new SpawnPoint(1200, - 100, ID.SpawnPoint), new SpawnPoint(1200,  820, ID.SpawnPoint), new SpawnPoint(1500,  320, ID.SpawnPoint), new SpawnPoint(1500,  550, ID.SpawnPoint)};
    Random r = new Random();
    Handler handler;
    private int difficulty;
    private int waveCount;
    int enemiesSpawned;
    private long wait;
    private int last;
    private int index;
    private boolean completeCheck;


    public Spawner(int Difficulty, Handler handler){
        //vars first
        this.handler = handler;
        this.difficulty = difficulty;
        waveCount = 1;
        enemiesSpawned = 0;
        completeCheck = false;
        wait = System.currentTimeMillis();
        last = 10;

        //then lists
        handler.addObj(enemySpawn[0]);
        handler.addObj(enemySpawn[1]);
        handler.addObj(enemySpawn[2]);
        handler.addObj(enemySpawn[3]);



        //methods last
        waveRun(waveCount);







    }


    public void tick(){
        waveRun(1);
       // System.out.println(enemiesSpawned);
    }

    public void waveRun(int waveCount){

        index = indexer(last);
        SpawnPoint temp = enemySpawn[index];
        if(enemiesSpawned <= 5) {
            if (System.currentTimeMillis() - wait >= 1000 && temp.canSpawn()) {
                spawnEnemy(temp);
                enemiesSpawned++;
                temp.setUnitSpawned(true);
                wait += 1000;
            }
        }

        else{
            checkComplete();
        }


    }


    public void checkComplete(){
        if(enemiesSpawned >=1 && handler.getEnemyCount() == 0 && !completeCheck){
            System.out.println("Congratulations!");
            completeCheck = true;
            PowerUpSpawn();
        }
    }

    public void PowerUpSpawn(){
        handler.addObj(new PowerUp(600,350,ID.PowerUp,30,30, handler));
    }

    public void spawnEnemy(SpawnPoint temp){
        handler.addObj(new BasicEnemy(temp.x,temp.y,ID.Enemy,handler));

    }
    public int indexer(int last){
        int temp = r.nextInt(3);
        if(temp == last){

            System.out.println("had to try again");
            return indexer(last);

        }
        else{
            return temp;
        }
    }






}
