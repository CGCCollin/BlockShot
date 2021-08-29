package com.company;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    public LinkedList<GameObject> objList = new LinkedList<>();
    private int EnemyCount;



    public Handler(){
        EnemyCount = 0;
    }



    public void tick(){
        for(int i = 0; i < objList.size(); i++){
            GameObject tempObj = objList.get(i);
            tempObj.tick();
            Destroy(tempObj);

        }


    }

    public void render(Graphics g){
        for(int i = 0; i < objList.size(); i++){
            GameObject tempObj = objList.get(i);
            tempObj.render(g);
        }
    }

    public void addObj(GameObject obj){
        if(obj.id == ID.Enemy){
            objList.add(obj);
            EnemyCount++;
        }
        else{
            objList.add(obj);
        }

    }

    public void removeObj(GameObject obj){

        objList.remove(obj);

    }

    public void Destroy(GameObject temp){
        if(temp.destroy){
            if(temp.id == ID.Enemy){
                EnemyCount--;
                objList.remove(temp);
            }
            else{objList.remove(temp);}

        }

    }

    public int getEnemyCount() {
        return EnemyCount;
    }



}
