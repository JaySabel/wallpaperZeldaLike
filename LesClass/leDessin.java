package com.sabel.livewallpaper.LesClass;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.sabel.livewallpaper.factoryDetail.Detail;
import com.sabel.livewallpaper.factoryDetail.detailFactory;

import com.sabel.livewallpaper.factoryBackground.Background;
import com.sabel.livewallpaper.factoryBackground.backgroundFactory;

/**
 * Created by sabel on 3/21/2017.
 */

public class leDessin {

    private Bitmap leSpriteSheet;

    private backgroundFactory Usine;
    private detailFactory Fleuriste;

    private chuteEau laChute;
    private falaise laFalaise;
    private home laMaison;
    private arbres unArbre;

    private int ScreenW;
    private int ScreenH;
    private int carreau=31;

    public leDessin(Bitmap SprtSheet,int W,int H){

        ScreenW=W;
        ScreenH=H;
        leSpriteSheet=SprtSheet;

        Usine = new backgroundFactory(leSpriteSheet);
        Fleuriste = new detailFactory(leSpriteSheet);

        laChute = new chuteEau(leSpriteSheet);
        laFalaise = new falaise(leSpriteSheet);
        laMaison = new home(leSpriteSheet);
        unArbre= new arbres(leSpriteSheet);

    }

    public void paintObject(Canvas leCanvas){


        laFalaise.DrawFalaise(leCanvas,0,carreau*9-1);
        laFalaise.DrawFalaise(leCanvas,laFalaise.getW(),carreau*9-1);
        laFalaise.DrawFalaise(leCanvas,laFalaise.getW()*2,carreau*9-1);
        laFalaise.DrawFalaise(leCanvas,laFalaise.getW()*3,carreau*9-1);
        laFalaise.DrawFalaise(leCanvas,laFalaise.getW()*4,carreau*9-1);

        laChute.drawChute(leCanvas,carreau*5,carreau*10-1);

        laFalaise.DrawFalaise(leCanvas,carreau*10,carreau*9-1);
        laFalaise.DrawFalaise(leCanvas,carreau*11,carreau*9-1);
        laFalaise.DrawFalaise(leCanvas,carreau*12,carreau*9-1);
        laFalaise.DrawFalaise(leCanvas,carreau*13,carreau*9-1);
        laFalaise.DrawFalaise(leCanvas,carreau*14,carreau*9-1);
        laFalaise.DrawFalaise(leCanvas,carreau*15,carreau*9-1);
        laFalaise.DrawFalaise(leCanvas,carreau*16,carreau*9-1);
        laFalaise.DrawFalaise(leCanvas,carreau*17,carreau*9-1);
        laFalaise.DrawFalaise(leCanvas,carreau*18,carreau*9-1);
        laFalaise.DrawFalaise(leCanvas,carreau*19,carreau*9-1);
        laFalaise.DrawFalaise(leCanvas,carreau*20,carreau*9-1);
        laFalaise.DrawFalaise(leCanvas,carreau*21,carreau*9-1);
        laFalaise.DrawFalaise(leCanvas,carreau*22,carreau*9-1);
        laFalaise.DrawFalaise(leCanvas,carreau*23,carreau*9-1);

        unArbre.drawArbre(leCanvas,carreau*19,carreau*0);
        unArbre.drawArbre(leCanvas,carreau*20,carreau*1);
        unArbre.drawArbre(leCanvas,carreau*22,carreau*1);
        unArbre.drawArbre(leCanvas,carreau*21,carreau*2);
        unArbre.drawArbre(leCanvas,carreau*20,carreau*6);
        unArbre.drawArbre(leCanvas,carreau*21,carreau*7);
        unArbre.drawArbre(leCanvas,carreau*17,carreau*4);
        unArbre.drawArbre(leCanvas,carreau*18,carreau*6+16);
        unArbre.drawArbre(leCanvas,carreau*15,carreau*8+16);
        unArbre.drawArbre(leCanvas,carreau*19,carreau*8+16);

        laMaison.onDraw(leCanvas,carreau*18,carreau*14);

        unArbre.drawSouche(leCanvas,carreau*18,carreau*26);
        unArbre.drawSouche(leCanvas,carreau*16,carreau*23);

    }

    public void paintBackground(int id,Canvas leCanvas,int col,int lig){

        Background laCase = Usine.getBackground(id);
        laCase.draw(leCanvas,col*31,lig*31);

    }

    public void paintDetail(Canvas leCanvas,int col,int lig,int id){

        Detail laCase = Fleuriste.getDetail(id);
        laCase.draw(leCanvas,col*31,lig*31);

    }
}
