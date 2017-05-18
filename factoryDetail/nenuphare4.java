package com.sabel.livewallpaper.factoryDetail;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by sabel on 3/30/2017.
 */

public class nenuphare4 implements Detail {

    private Bitmap nenuphare;
    private Bitmap leSprite;

    public nenuphare4(Bitmap sprtSheet){

        leSprite=sprtSheet;
        create();
    }

    public void create() {
        nenuphare=Bitmap.createBitmap(leSprite,5*32,0*32,32,32);;
    }

    @Override
    public void draw(Canvas LeCanvas, int posX, int posY){
        LeCanvas.drawBitmap(nenuphare,posX,posY,null);
    }
}
