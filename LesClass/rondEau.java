package com.sabel.livewallpaper.LesClass;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;

/**
 * Created by sabel on 3/23/2017.
 */

public class rondEau {

    private Bitmap sprtSheet;
    private ArrayList<Bitmap> lstimg;
    private int cntRond;

    public rondEau(Bitmap sprtSheet){

        this.sprtSheet=sprtSheet;
        lstimg= new ArrayList<>();
        createRond();
    }

    private void createRond(){

        Bitmap cases;

        lstimg.add(cases=Bitmap.createBitmap(sprtSheet,3*32,3*32,32,32));
        lstimg.add(cases=Bitmap.createBitmap(sprtSheet,4*32,3*32,32,32));
        lstimg.add(cases=Bitmap.createBitmap(sprtSheet,5*32,3*32,32,32));
        lstimg.add(cases=Bitmap.createBitmap(sprtSheet,3*32,4*32,32,32));
        lstimg.add(cases=Bitmap.createBitmap(sprtSheet,4*32,4*32,32,32));
        lstimg.add(cases=Bitmap.createBitmap(sprtSheet,5*32,4*32,32,32));
    }

    public void draw(Canvas leCanvas,int posX,int posY){

        leCanvas.drawBitmap(lstimg.get(cntRond),posX,posY,null);
        setCntRond();

    }

    private void setCntRond(){

        if(cntRond<5){
            cntRond++;
        }
        else{
            cntRond=0;
        }

    }
}
