package com.sabel.livewallpaper.factoryBackground;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by sabel on 3/27/2017.
 */

public class Grass implements Background {

    private Bitmap grass;
    private Bitmap leSprite;

    public Grass(Bitmap sprtSheet){

        leSprite=sprtSheet;
        create();
    }

    public void create() {
        grass= Bitmap.createBitmap(leSprite,0,0,32,32);
    }

    @Override
    public void draw(Canvas LeCanvas,int posX,int posY){
        LeCanvas.drawBitmap(grass,posX,posY,null);
    }
}
