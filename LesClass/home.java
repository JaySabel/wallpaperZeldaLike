package com.sabel.livewallpaper.LesClass;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by sabel on 3/18/2017.
 */

public class home {

    private Bitmap Home;
    private Bitmap Maison;

    public home(Bitmap sprSheet) {

        Home = sprSheet;
        createMaison();

    }

    private void createMaison(){

        Maison= Bitmap.createBitmap(Home,6*32,0,5*32,5*32);
    }

    protected void onDraw(Canvas LeCanvas,int posX,int posY){

        LeCanvas.drawBitmap(Maison,posX,posY,null);
    }
}
