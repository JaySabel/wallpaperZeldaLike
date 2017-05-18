package com.sabel.livewallpaper.factoryDetail;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by sabel on 3/30/2017.
 */

public class roche4 implements Detail {

    private Bitmap roche;
    private Bitmap leSprite;

    public roche4(Bitmap sprtSheet){

        leSprite=sprtSheet;
        create();
    }

    public void create() {
        roche=Bitmap.createBitmap(leSprite,14*32,10*32,32,32);;
    }

    @Override
    public void draw(Canvas LeCanvas, int posX, int posY){
        LeCanvas.drawBitmap(roche,posX,posY,null);
    }
}
