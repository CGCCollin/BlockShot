package com.company;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class MaGame extends Canvas implements Runnable {

    private static final int WIDTH = 1280, HEIGHT = WIDTH / 16 * 9;// /16 * 9 creates 16 by 9 aspect ratio

    private boolean running = false;
    private Thread thread;
    private Handler handle;
    Player player;
    Random r;
    HUD hud;
    Spawner spawner;

    public MaGame(){

        r = new Random();
        handle = new Handler();
        spawner = new Spawner(3, handle);


        Display display = new Display(WIDTH,HEIGHT,"Block Shot development", this);

        hud = new HUD();

        handle.addObj(new Background(0,0,ID.Bullet));
        handle.addObj(new Player(300,300,ID.Player, handle));

        this.addKeyListener(new KeyInput(handle));
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();//stops thread
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running){
                render();
                frames ++;
            }

            if(System.currentTimeMillis()- timer > 1000){
                timer += 1000;
                System.out.println(handle.getEnemyCount() + " poop" + spawner.enemiesSpawned);
               /* System.out.println(String.format("FPS: %d", frames));
                frames = 0;
                System.out.println(handle.objList.size());
                System.out.println(handle.getEnemyCount());*/

            }
        }
        stop();


    }

    private void tick() {
        handle.tick();
        hud.tick();
        spawner.tick();

    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);

        handle.render(g);
        hud.render(g);

        g.dispose();
        bs.show();


    }

    public static void main(String[] args){
        MaGame game = new MaGame();
    }
    public static int getWindowHeight(){
        return  HEIGHT;
    }

    public static int getWindowWidth(){
        return WIDTH;
    }

    public static int clamp(int var, int min, int max){
        if(var <= min){
            return min;
        }

        if(var >= max){

            return max;
        }

        else{
            return var;
        }

    }

    public static boolean clampBool(int var, int min, int max){
        if(var <= min){
            return true;
        }

        if(var >= max){

            return true;
        }

        else{
            return false;
        }
    }

}
