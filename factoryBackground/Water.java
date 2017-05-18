package com.sabel.livewallpaper.factoryBackground;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by sabel on 3/27/2017.
 */

public class Water implements Background {

    private Bitmap water;
    private Bitmap leSprite;

    public Water(Bitmap sprtSheet){

        leSprite=sprtSheet;
        create();
    }

    public void create() {
        water= Bitmap.createBitmap(leSprite,3*32,7*32,32,32);
    }

    @Override
    public void draw(Canvas LeCanvas,int posX,int posY){
        LeCanvas.drawBitmap(water,posX,posY,null);
    }
}
