package com.company;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Handler handler;
    private static boolean up = false;
    private static boolean down = false;
    private static boolean left = false;
    private static boolean right = false;
    private static boolean fire = false;



    public KeyInput(Handler handler){
                this.handler = handler;

            }

    public void keyTyped(KeyEvent e){

    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() ==  KeyEvent.VK_O){
            System.out.println("test");
        }
        int key = e.getKeyCode();
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        for (int i = 0; i < handler.objList.size(); i++) {
            GameObject o = handler.objList.get(i);
            if(o.getId() == ID.Player){
                if(key == KeyEvent.VK_W){
                    up = true;

                }
                if(key == KeyEvent.VK_S){
                    down = true;

                }
                if(key == KeyEvent.VK_A){
                    left = true;

                }
                if(key == KeyEvent.VK_D){
                    right = true;

                }
                move(o);

                if(e.getKeyCode() == KeyEvent.VK_SPACE){

                    fire = true;
                }



            }
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for (int i = 0; i < handler.objList.size(); i++) {
            GameObject o = handler.objList.get(i);
            if(o.getId() == ID.Player){
                if(key == KeyEvent.VK_W){

                    up = false;

                }
                if(key == KeyEvent.VK_S){
                    down = false;

                }
                if(key == KeyEvent.VK_A){
                    left = false;

                }
                if(key == KeyEvent.VK_D){
                    right = false;

                }
                move(o);
    
                if(key == KeyEvent.VK_SPACE){
                    fire = false;
                }








            }
        }
    }

    public void move(GameObject player){
                if(up){
                    player.setVelY(-8);

                }


                if(down){
                    player.setVelY(8);

                }

                if(!up && !down){
                    player.setVelY(0);
                }


                if(left){
                    player.setVelX(-8);

                }

                if(right){
                    player.setVelX(8);

                }

                if(!left && !right){
                    player.setVelX(0);
                }




    }


    public static boolean isFire() {
        return fire;
    }

    public static void setFire(boolean fire) {
        KeyInput.fire = fire;
    }


}
