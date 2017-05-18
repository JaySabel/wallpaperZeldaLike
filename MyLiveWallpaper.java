package com.sabel.livewallpaper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.sabel.livewallpaper.LesClass.leDessin;

/**
 * Created by sabel on 3/19/2017.
 */

public class MyLiveWallpaper extends WallpaperService {
    @Override
    public Engine onCreateEngine() {
        return new LiveWallpaperEngine();
    }


    private class LiveWallpaperEngine extends Engine {

        private final Handler handler = new Handler();
        private final Runnable drawer = new Runnable() {
            @Override
            public void run() {
                draw();
            }
        };

        private boolean visible = true;
        private int width;
        private int height;

        private Bitmap spriteSheet;
        private leDessin Dessin;
        private  int [][]leTabBackground;
        private  int [][] leTabDetail;

        public LiveWallpaperEngine() {
            handler.post(drawer);
            spriteSheet = BitmapFactory.decodeResource(getResources(), R.drawable.overworld);
            Dessin = new leDessin(spriteSheet,width,height);

            // define a array for draw the background
            // definis un tableau pour dessiner l arriere plan
            settabBackground();
            // define a array for draw the detail
            // definis un tableau pour dessiner les details
            settabDetail();
        }

        @Override
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);

            setTouchEventsEnabled(true);
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            handler.removeCallbacks(drawer);
        }

        @Override
        public void onSurfaceCreated(SurfaceHolder holder) {
            super.onSurfaceCreated(holder);
        }

        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            this.width = width;
            this.height = height;
            super.onSurfaceChanged(holder, format, width, height);
        }

        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);
            this.visible = false;
            handler.removeCallbacks(drawer);
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            this.visible = visible;
            if (visible) {
                handler.post(drawer);
            } else {
                handler.removeCallbacks(drawer);
            }
        }

        @Override
        public void onTouchEvent(MotionEvent event) {
            super.onTouchEvent(event);
        }

        private void draw(){
            SurfaceHolder holder = getSurfaceHolder();
            Canvas leCanvas =null;
            try{
                leCanvas=holder.lockCanvas();
                if(leCanvas!=null){

                    DrawBackground(leCanvas);
                    Dessin.paintObject(leCanvas);
                    DrawDetail(leCanvas);

                }
            }finally {
                if(leCanvas!=null)
                    holder.unlockCanvasAndPost(leCanvas);
            }
            handler.removeCallbacks(drawer);
            if(visible){
                handler.postDelayed(drawer,1000/6);
            }

        }

        private void DrawBackground(Canvas leCanvas){
            int nbrCol=width/31;//24
            int nbrLigne=height/31;//42

            if(leTabBackground!=null) {
                for (int col = 0; col <= nbrCol; col++) {
                    for (int lig = 0; lig <= nbrLigne; lig++) {
                        Dessin.paintBackground(leTabBackground[lig][col],leCanvas,col,lig);
                    }
                }
            }
            else{
                //error;
            }
        }

        private void DrawDetail(Canvas leCanvas){
            int nbrCol=width/31;//24
            int nbrLigne=height/31;//42

            if(leTabDetail !=null) {
                for (int col = 0; col <= nbrCol; col++) {
                    for (int lig = 0; lig <= nbrLigne; lig++) {
                        if (leTabDetail[lig][col] != 0 && leTabDetail[lig][col]!=1) {
                            Dessin.paintDetail(leCanvas, col, lig, leTabDetail[lig][col]);
                        }
                    }
                }
            }
            else{
                //error;
            }
        }

        // for see what are the number look backgroundFactory class in factoryBackground
        //pour voir ce que les nombres veulent dire voir la class backgroundFactory dans le factoryBackground
        private void settabBackground(){
            leTabBackground= new int[][]
                    {       {1,1,1,1,1,1,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0},//1
                            {1,1,1,1,1,1,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0},//2
                            {1,1,1,1,1,1,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0},//3
                            {1,1,1,1,1,1,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0},//4
                            {7,7,7,7,10,1,1,1,1,1,9,0,0,0,0,0,0,0,0,0,0,0,0,0},//5
                            {0,0,0,0,4,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0,0},//6
                            {0,0,0,0,4,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0,0},//7
                            {0,0,0,0,4,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0,0},//8
                            {0,0,0,0,4,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0,0},//9
                            {0,0,0,0,4,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0,0},//10
                            {0,0,0,0,4,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0,0},//11
                            {0,0,0,0,4,0,0,0,0,0,6,0,0,0,0,0,0,0,0,0,0,0,0,0},//12
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//13
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//14
                            {0,0,0,0,4,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0,0},//15
                            {0,0,0,0,4,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0,0},//16
                            {0,0,0,0,4,1,1,1,1,1,6,0,3,3,3,3,3,0,0,0,0,0,0,0},//17
                            {0,0,0,0,4,1,1,1,1,1,6,0,3,3,3,3,3,0,0,0,0,0,0,0},//18
                            {0,0,0,0,4,1,1,1,1,1,6,0,3,3,3,3,3,0,0,0,0,0,0,0},//19
                            {0,0,0,0,4,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0,0},//20
                            {0,0,0,0,4,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0,0},//21
                            {0,0,0,0,4,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0,0},//22
                            {0,0,0,0,4,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0,0},//23
                            {0,0,0,0,4,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0,0},//24
                            {0,0,0,0,4,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0,0},//25
                            {0,0,0,0,4,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0,0},//26
                            {0,0,0,0,4,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,0,0},//27
                            {0,0,0,0,4,1,1,1,1,1,8,0,0,0,0,0,0,0,0,0,0,0,0,0},//28
                            {0,0,0,0,4,1,1,1,1,1,1,8,0,0,0,0,0,0,0,0,0,0,0,0},//29
                            {0,0,0,0,4,1,1,1,1,1,1,1,8,0,0,0,0,0,0,0,0,0,0,0},//30
                            {0,0,0,0,4,1,1,1,1,1,1,1,1,8,0,0,0,0,0,0,0,0,0,0},//31
                            {0,0,0,0,4,1,1,1,1,1,1,1,1,1,8,5,5,5,5,5,5,5,5,5},//32
                            {0,0,0,0,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//33
                            {0,0,0,0,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//34
                            {0,0,0,0,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//35
                            {0,0,0,0,0,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},//36
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//37
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//38
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//39
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//40
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//41
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//42
                    };
        }

        // for see what are the number look detailFactory class in factoryDetail
        //pour voir ce que les nombres veulent dire voir la class detailFactory dans le factoryDetail
        private void settabDetail(){
            leTabDetail = new int[][]
                    {       {1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},//1
                            {1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},//2
                            {1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},//3
                            {1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},//4
                            {0,0,0,0,0,100,1,102,103,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//5
                            {0,0,0,0,0,1,103,1,103,102,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//6
                            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//7
                            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//8
                            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//9
                            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//10
                            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//11
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//12
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//13
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//14
                            {0,0,0,0,0,103,1,101,1,103,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//15
                            {0,0,0,0,0,1,102,1,100,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//16
                            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//17
                            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//18
                            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//19
                            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//20
                            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//21
                            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//22
                            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//23
                            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//24
                            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//25
                            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//26
                            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//27
                            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//28
                            {0,0,0,0,0,1,1,1,1,1,107,0,0,0,0,0,0,0,0,0,0,0,0,0},//29
                            {0,0,0,0,0,1,1,1,1,1,1,104,0,0,0,0,0,0,0,0,0,0,0,0},//30
                            {0,0,0,0,0,1,1,1,1,1,1,104,106,0,0,0,0,0,0,0,0,0,0,0},//31
                            {0,0,0,0,0,1,1,1,1,1,1,1,1,107,0,0,0,0,0,0,0,0,0,0},//32
                            {0,0,0,0,0,1,1,1,1,1,1,1,105,1,1,1,1,1,1,1,1,1,1,1},//33
                            {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//34
                            {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//35
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//36
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//37
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//38
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//39
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//40
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//41
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//42
                    };
        }
    }
}
