package com.sabel.livewallpaper.factoryBackground;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

/**
 * Created by sabel on 3/28/2017.
 */

public class Riverbank implements Background {

    private Bitmap sprtSheet;
    private Bitmap herbeauG;
    private float angle;

    public Riverbank(Bitmap sprtSheet, float angle) {

        this.sprtSheet = sprtSheet;
        this.angle=angle;
        create();
    }

    public void create() {

        Matrix laMatrix = new Matrix();
        laMatrix.setRotate(angle);
        herbeauG = Bitmap.createBitmap(sprtSheet, 2 * 32, 7 * 32, 32, 32,laMatrix,true);

    }
    @Override
    public void draw(Canvas LeCanvas, int posX, int posY) {
        LeCanvas.drawBitmap(herbeauG,posX,posY,null);
    }
}
