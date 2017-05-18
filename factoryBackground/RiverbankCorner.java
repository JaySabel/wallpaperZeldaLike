package com.sabel.livewallpaper.factoryBackground;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

/**
 * Created by sabel on 3/28/2017.
 */

public class RiverbankCorner implements Background {

    private Bitmap sprtSheet;
    private Bitmap herbeauCoin;
    private float angle;

    public RiverbankCorner(Bitmap sprtSheet, float angle) {

        this.sprtSheet = sprtSheet;
        this.angle=angle;
        create();
    }

    public void create() {

        Matrix laMatrix = new Matrix();
        laMatrix.setRotate(angle);
        herbeauCoin= Bitmap.createBitmap(sprtSheet,2*32,10*32,32,32,laMatrix,true);//basgauche

    }
    @Override
    public void draw(Canvas LeCanvas, int posX, int posY) {
        LeCanvas.drawBitmap(herbeauCoin,posX,posY,null);
    }
}
