package com.sabel.livewallpaper.factoryDetail;

import android.graphics.Bitmap;

/**
 * Created by sabel on 3/30/2017.
 */

public class detailFactory {

    private Bitmap sprtSheet;

    public detailFactory(Bitmap sprtSheet){

        this.sprtSheet = sprtSheet;
    }

    public Detail getDetail(int detailType){

        switch (detailType){
            case 100:
                return new roche1(sprtSheet);
            case 101:
                return new roche2(sprtSheet);
            case 102:
                return new roche3(sprtSheet);
            case 103:
                return new roche4(sprtSheet);
            case 104:
                return new nenuphare1(sprtSheet);
            case 105:
                return new nenuphare2(sprtSheet);
            case 106:
                return new nenuphare3(sprtSheet);
            case 107:
                return new nenuphare4(sprtSheet);

            default:
                return null;

        }
    }
}
