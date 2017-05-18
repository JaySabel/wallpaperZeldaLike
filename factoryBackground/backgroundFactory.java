package com.sabel.livewallpaper.factoryBackground;

import android.graphics.Bitmap;

/**
 * Created by sabel on 3/27/2017.
 */

public class backgroundFactory {

    private Bitmap sprtSheet;

    public backgroundFactory(Bitmap sprtSheet){

        this.sprtSheet = sprtSheet;
    }

    public Background getBackground (int backgroundType){

        switch (backgroundType){
            case 0:
                return new Grass(sprtSheet);
            case 1:
                return new Water(sprtSheet);
            case 3:
                return new Earth(sprtSheet);
            case 4:
                return new Riverbank(sprtSheet,0);
            case 5:
                return new Riverbank(sprtSheet,90);
            case 6:
                return new Riverbank(sprtSheet,180);
            case 7:
                return new Riverbank(sprtSheet,270);
            case 8:
                return new RiverbankCorner(sprtSheet,0);
            case 9:
                return new RiverbankCorner(sprtSheet,90);
            case 10:
                return new RiverbankCorner(sprtSheet,180);
            case 11:
                return new RiverbankCorner(sprtSheet,270);
            default:
                return null;

        }
    }
}
