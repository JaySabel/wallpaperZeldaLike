package com.sabel.livewallpaper.LesClass;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;

/**
 * Created by sabel on 3/20/2017.
 */

public class chuteEau {

    private Bitmap laSpriteS;
    private Bitmap coteG;
    private Bitmap coteD;
    private ArrayList<Bitmap>lstEau;
    private ArrayList<Bitmap>lstEauBas;

    private int cntChute=0;
    private int cnteauBas=0;

    private int saPosX;
    private int saPosY;
    private int saWidth;
    private int saHeight;


    public chuteEau(Bitmap SprtSheet) {

        lstEau=new ArrayList<>();
        lstEauBas=new ArrayList<>();

        setLaSpriteS(SprtSheet);

        createcoteGD();
        createEau();
        createEauBas();

        setSaWidth(32*5);
        setSaHeight(32*5);
    }

    protected void createcoteGD(){

        coteG=Bitmap.createBitmap(getLaSpriteS(),9*32,17*32,32,3*32);
        coteD=Bitmap.createBitmap(getLaSpriteS(),10*32,17*32,32,3*32);
    }

    protected void createEau(){

        Bitmap cases;
        lstEau.add(cases=Bitmap.createBitmap(getLaSpriteS(),18*32+1,6*32,32,3*32));
        lstEau.add(cases=Bitmap.createBitmap(getLaSpriteS(),19*32,6*32,32,3*32));
        lstEau.add(cases=Bitmap.createBitmap(getLaSpriteS(),20*32,6*32,32,3*32));
    }

    protected void createEauBas(){

        Bitmap cases;

        //anime bas de la premiere rangee
        lstEauBas.add(cases=Bitmap.createBitmap(getLaSpriteS(),17*32,9*32,2*32,31));
        lstEauBas.add(cases=Bitmap.createBitmap(getLaSpriteS(),17*32,10*32,2*32,31));
        lstEauBas.add(cases=Bitmap.createBitmap(getLaSpriteS(),18*32,11*32,2*32,31));
        //anime bas de la deuxieme rangee
        lstEauBas.add(cases=Bitmap.createBitmap(getLaSpriteS(),18*32,9*32,32,31));
        lstEauBas.add(cases=Bitmap.createBitmap(getLaSpriteS(),18*32,10*32,32,31));
        lstEauBas.add(cases=Bitmap.createBitmap(getLaSpriteS(),19*32,11*32,32,31));
        //anime bas de la troisieme rangee
        lstEauBas.add(cases=Bitmap.createBitmap(getLaSpriteS(),18*32,9*32,2*32-2,31));
        lstEauBas.add(cases=Bitmap.createBitmap(getLaSpriteS(),18*32,10*32,2*32-2,31));
        lstEauBas.add(cases=Bitmap.createBitmap(getLaSpriteS(),19*32,11*32,2*32-2,31));
    }

    public void drawChute(Canvas leCanvas,int posX,int posY){

        setSaPosX(posX);
        setSaPosY(posY);

        leCanvas.drawBitmap(coteG,posX,posY,null);
        leCanvas.drawBitmap(coteD,posX+32*4,posY,null);
        //premiere rangee
        leCanvas.drawBitmap(lstEau.get(cntChute),posX+32,posY,null);
        leCanvas.drawBitmap(lstEau.get(cntChute),posX+32,posY,null);
        leCanvas.drawBitmap(lstEau.get(cntChute),posX+32,posY,null);

        leCanvas.drawBitmap(lstEauBas.get(cnteauBas),posX,posY+3*32,null);

        //deuxieme rangee
        leCanvas.drawBitmap(lstEau.get(cntChute),posX+32*2,posY,null);
        leCanvas.drawBitmap(lstEau.get(cntChute),posX+32*2,posY,null);
        leCanvas.drawBitmap(lstEau.get(cntChute),posX+32*2,posY,null);

        leCanvas.drawBitmap(lstEauBas.get(cnteauBas+3),posX+32*2,posY+3*32,null);

        //troisieme rangee
        leCanvas.drawBitmap(lstEau.get(cntChute),posX+32*3,posY,null);
        leCanvas.drawBitmap(lstEau.get(cntChute),posX+32*3,posY,null);
        leCanvas.drawBitmap(lstEau.get(cntChute),posX+32*3,posY,null);

        leCanvas.drawBitmap(lstEauBas.get(cnteauBas+6),posX+32*3,posY+3*32,null);


        setCntChute();
        setCnteauBas();

    }
    //counter for the animation of the waterfall
    //le compteur sert pour l animation de la chute et pour le bas de la chute
    private void setCntChute(){
        if(cntChute<2){
            cntChute++;
        }
        else{
            cntChute=0;
        }
    }

    private void setCnteauBas(){
        if(cnteauBas<2){
            cnteauBas++;
        }
        else{
            cnteauBas=0;
        }
    }

    public int getSaPosX() {
        return saPosX;
    }

    public void setSaPosX(int saPosX) {
        this.saPosX = saPosX;
    }

    public int getSaPosY() {
        return saPosY;
    }

    public void setSaPosY(int saPosY) {
        this.saPosY = saPosY;
    }

    public int getSaWidth() {
        return saWidth;
    }

    public void setSaWidth(int saWidth) {
        this.saWidth = saWidth;
    }

    public int getSaHeight() {
        return saHeight;
    }

    public void setSaHeight(int saHeight) {
        this.saHeight = saHeight;
    }

    public Bitmap getLaSpriteS() {
        return laSpriteS;
    }

    public void setLaSpriteS(Bitmap laSpriteS) {
        this.laSpriteS = laSpriteS;
    }
}
