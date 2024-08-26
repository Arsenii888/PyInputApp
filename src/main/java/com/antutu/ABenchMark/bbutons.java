package com.antutu.ABenchMark;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import java.io.File;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

public class bbutons {
    Button bs;
    ImageView mgb;
    int id;
    int sizeX, sizeY;
    boolean goneFlag = false;
    int top;
    int invisible;
    String path;
    int left;
    int mode;

    @SuppressLint("ClickableViewAccessibility")
    bbutons(int ids, int tops, int lefts, int sizex, int sizey, int invisible1, String path1, Button but, ConstraintLayout layout, int modes) {
        id = ids;
        top = tops;
        left = lefts;
        path = path1;
        mode=modes;
        invisible = invisible1;
        sizeX = sizex;
        sizeY = sizey;
        bs = but;
        bs.setAlpha((float) invisible / 100);
        // bs=buttons;
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(sizex, sizey);
        //layoutParams.setMargins(0, 0, 0, 0); // left, top, right, bottom
        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        params.leftMargin = left; // Установите необходимое значение для координаты X
        params.topMargin = top; // Установите необходимое значение для координаты Y
        bs.setLayoutParams(params);

    }

    public void setCoords(int x, int y) {
        top = y;
        left = x;
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(sizeX, sizeY);
        //layoutParams.setMargins(0, 0, 0, 0); // left, top, right, bottom
        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        params.leftMargin = left; // Установите необходимое значение для координаты X
        params.topMargin = top; // Установите необходимое значение для координаты Y
        bs.setLayoutParams(params);
        /*if(path.length()>0){
            mgb.setLayoutParams(params);
            bs.setAlpha(0.1f);
        }*/
    }

    void setImageCoords(int x, int y) {
        top = y;
        left = x;
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(sizeX, sizeY);
        //layoutParams.setMargins(0, 0, 0, 0); // left, top, right, bottom
        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        params.leftMargin = left; // Установите необходимое значение для координаты X
        params.topMargin = top; // Установите необходимое значение для координаты Y
        mgb.setLayoutParams(params);
    }

    public int getTop() {
        return top;
    }

    public int getLeft() {
        return left;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getInvisible() {
        return invisible;
    }

    public void setInvisible(int transperent) {
        invisible = transperent;
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(sizeX, sizeY);
        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        params.leftMargin = left; // Установите необходимое значение для координаты X
        params.topMargin = top; // Установите необходимое значение для координаты Y
        bs.setAlpha((float) transperent / 100);
        bs.setLayoutParams(params);
    }

    public void setSize(int x, int y) {
        this.sizeX = x;
        this.sizeY = y;
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(sizeX, sizeY);
        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        params.leftMargin = left; // Установите необходимое значение для координаты X
        params.topMargin = top; // Установите необходимое значение для координаты Y
        bs.setLayoutParams(params);
    }

    public void remove() {
        sizeX = 0;
        sizeY = 0;
        top = 0;
        left = 0;
        bs.setVisibility(View.GONE);
        if (mgb != null) {
            mgb.setVisibility(View.GONE);
        }
    }

    public String getImage() {
        return path;
    }

    public ImageView setImage() {
        File f = new File(path);
        Bitmap bmp = BitmapFactory.decodeFile(f.getAbsolutePath());
        mgb = new ImageView(bs.getContext());
        mgb.setImageBitmap(bmp);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(sizeX, sizeY);
        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        params.leftMargin = left; // Установите необходимое значение для координаты X
        params.topMargin = top; // Установите необходимое значение для координаты Y
        mgb.setLayoutParams(params);
        bs.setAlpha(0.1F);
        return mgb;
    }

    public bbutons get(int idi) {
        if (idi == id) {
            return this;
        }
        return null;
    }

    public int getTrigger() {
        return mode;
    }

    public String getText(){
        return bs.getText().toString();
    }
    public String ImagegetText(){
        return bs.getText().toString();
    }
}
