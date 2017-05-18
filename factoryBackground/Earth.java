package com.sabel.livewallpaper.factoryBackground;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by sabel on 3/27/2017.
 */

public class Earth implements Background {
    private Bitmap earth;
    private Bitmap leSprite;

    public Earth(Bitmap sprtSheet){

        leSprite=sprtSheet;
        create();
    }

    public void create() {
        earth= Bitmap.createBitmap(leSprite,32,35*32,32,32);
    }

    @Override
    public void draw(Canvas LeCanvas, int posX, int posY){
        LeCanvas.drawBitmap(earth,posX,posY,null);
    }
}
