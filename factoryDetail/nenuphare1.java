package com.sabel.livewallpaper.factoryDetail;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by sabel on 3/30/2017.
 */

public class nenuphare1 implements Detail {

    private Bitmap nenuphare;
    private Bitmap leSprite;

    public nenuphare1(Bitmap sprtSheet){

        leSprite=sprtSheet;
        create();
    }

    public void create() {
        nenuphare=Bitmap.createBitmap(leSprite,2*32,0*32,32,32);;
    }

    @Override
    public void draw(Canvas LeCanvas, int posX, int posY){
        LeCanvas.drawBitmap(nenuphare,posX,posY,null);
    }
}
