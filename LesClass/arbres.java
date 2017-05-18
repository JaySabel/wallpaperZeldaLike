package com.sabel.livewallpaper.LesClass;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

/**
 * Created by sabel on 3/23/2017.
 */

public class arbres {

    private Bitmap sprtSheet;
    private Bitmap unArbre;
    private Bitmap uneSouche;

    public arbres(Bitmap sprtSheet){

        this.sprtSheet=sprtSheet;
        createunArbre();
        createuneSouche();
    }

    private void createunArbre(){

        unArbre =  Bitmap.createBitmap(sprtSheet,5*32,16*32,64,64);
    }

    private void createuneSouche(){

        uneSouche = Bitmap.createBitmap(sprtSheet,31*32,3*32,64,64);
    }

    public void drawArbre(Canvas leCanvas,int posX,int posY){

        leCanvas.drawBitmap(unArbre,posX,posY,null);
    }

    public void drawSouche(Canvas leCanvas,int posX,int posY){

        leCanvas.drawBitmap(uneSouche,posX,posY,null);
    }
}
