package com.sabel.livewallpaper.LesClass;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

/**
 * Created by sabel on 3/21/2017.
 */

public class falaise {

    private Bitmap SprSheet;
    private Bitmap laFalaise;
    private int W;
    private int H;

    public falaise(Bitmap SprSheet){

        this.SprSheet=SprSheet;
        setW(31);
        setH(4*32);
        createFalaise();
    }

    private void createFalaise(){

        laFalaise= Bitmap.createBitmap(SprSheet,5*32,10*32,getW(),getH());
    }

    public void DrawFalaise(Canvas leCanvas,int posX,int posY){

        leCanvas.drawBitmap(laFalaise,posX,posY,null);
    }

    public int getW() {
        return W;
    }

    public void setW(int w) {
        W = w;
    }

    public int getH() {
        return H;
    }

    public void setH(int h) {
        H = h;
    }
}
