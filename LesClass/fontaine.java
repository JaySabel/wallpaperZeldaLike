package com.sabel.livewallpaper.LesClass;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;

/**
 * Created by sabel on 3/18/2017.
 */

public class fontaine {

    private Bitmap laFontaine;
    private ArrayList<Bitmap> lstimg;
    private int cntAnime=0;
    private int W;
    private int H;

    public fontaine(Bitmap SprtSheet){


        lstimg = new ArrayList<>();
        laFontaine = SprtSheet;
        setW(laFontaine.getWidth()/40);
        setH(laFontaine.getHeight()/36);
        createFontaine();
    }

    protected void createFontaine(){

        Bitmap cases;
        int w=this.getW();
        int h=this.getH();

        lstimg.add(cases=Bitmap.createBitmap(laFontaine,22*w,9*h+1,3*w,3*h-1));
        lstimg.add(cases=Bitmap.createBitmap(laFontaine,25*w,9*h+1,3*w,3*h-1));
        lstimg.add(cases=Bitmap.createBitmap(laFontaine,28*w,9*h+1,3*w,3*h-1));
    }

    public void onDraw(Canvas C,int posX,int posY){

        C.drawBitmap(lstimg.get(cntAnime),posX,posY,null);
        setCntAnime();
        //C.drawBitmap(lstimg.get(0),100,50,null);
        //C.drawBitmap(lstimg.get(1),100,150,null);
        //C.drawBitmap(lstimg.get(2),100,250,null);
    }

    public void setCntAnime(){

        if (cntAnime < 2) {
            cntAnime++;
        } else {
            cntAnime = 0;
        }
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
