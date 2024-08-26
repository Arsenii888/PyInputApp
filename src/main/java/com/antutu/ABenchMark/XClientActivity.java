package com.antutu.ABenchMark;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class XClientActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.xclient);
        Button b=new Button(this);
        b.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        FrameLayout c=findViewById(R.id.frame);
        c.addView(b);
        Button b1=new Button(this);
        b1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        c.addView(b1);
        Button b2=new Button(this);
        b2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        c.addView(b2);
        Button b3=new Button(this);
        b3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        c.addView(b3);
        Button b4=new Button(this);
        b4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        c.addView(b4);
        Button b5=new Button(this);
        b5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        c.addView(b5);
        Button b6=new Button(this);
        b6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        c.addView(b6);


    }
    public void edit(View w){
        Intent i = new Intent(this, PyInput.class);
        startActivity(i);
    }
    @SuppressLint("ClickableViewAccessibility")
    public void create(String text, int left, int top, int sizex, int sizey, int invisible, String pathOf,int trigger) {
        // Создание новой кнопки
        Button b = new Button(getApplicationContext());
        if(text.equals("ª")){
            b.setText("shift");
        } else if(text.equals("ŝ")){
            b.setText("ctrl");
        }else if(text.equals("Ĺ")){
            b.setText("esc");
        }else if(text.equals("Ĝ")){
            b.setText("alt");
        }else if(text.equals("Đ")){
            b.setText("space");
        }else if(text.equals("й")){
            b.setText("F1");
        }else if(text.equals("ц")){
            b.setText("F2");
        }else if(text.equals("у")){
            b.setText("F3");
        }else if(text.equals("к")){
            b.setText("F4");
        }else if(text.equals("е")){
            b.setText("F5");
        }else if(text.equals("н")){
            b.setText("F6");
        }else if(text.equals("г")){
            b.setText("F7");
        }else if(text.equals("ш")){
            b.setText("F8");
        }else if(text.equals("щ")){
            b.setText("F9");
        }else if(text.equals("з")){
            b.setText("F10");
        }else if(text.equals("х")){
            b.setText("F11");
        }else if(text.equals("ф")){
            b.setText("F12");
        }else {
            b.setText(text);
        }
        ImageView mgb=null;
        if(!pathOf.equals(" ")){
            mgb=new ImageView(this);
            File f=new File(pathOf);
            Bitmap bmp = BitmapFactory.decodeFile(f.getAbsolutePath());
            mgb.setImageBitmap(bmp);
        }
        // Уникальный ID для каждой кнопки (например, с помощью системного времени)
        b.setId(View.generateViewId());

        // Установка параметров расположения для ConstraintLayout
        Toolbar.LayoutParams params = new Toolbar.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        );
        params.setMargins(0, 0, 0, 0); // Установка отступов

        // Установка LayoutParams для кнопки
        b.setLayoutParams(params);

        b.setOnTouchListener(new View.OnTouchListener() {
            Handler handler = new Handler();

            boolean pressed=false;
            Runnable runnable = new Runnable() { //ОТСЫЛАЕТ КОМАНДЫ НА СЕРВЕР
                @Override
                public void run() {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            if(b.getText().equals("shift")||b.getText().equals("esc")||b.getText().equals("space")||b.getText().equals("ctrl")||b.getText().equals("alt")||b.getText().equals("F1")||b.getText().equals("F2")||b.getText().equals("F3")||b.getText().equals("F4")||b.getText().equals("F5")||b.getText().equals("F6")||b.getText().equals("F7")||b.getText().equals("F8")||b.getText().equals("F9")||b.getText().equals("F10")||b.getText().equals("F11")||b.getText().equals("F12")){
                                byte[] bs=new byte[2];
                                if(b.getText().equals("shift")){
                                    bs[0] = (byte) 'ª';
                                    send(bs);
                                }
                                if(b.getText().equals("esc")) {
                                    bs[0] = (byte) 'Ĺ';
                                    send(bs);
                                }
                                if(b.getText().equals("ctrl")) {
                                    bs[0] = (byte) 'ŝ';
                                    send(bs);
                                }
                                if(b.getText().equals("alt")) {
                                    bs[0] = (byte) 'Ĝ';
                                    send(bs);
                                }
                                if(b.getText().equals("space")) {
                                    bs[0] = (byte) 'Đ';
                                    send(bs);
                                }
                                if(b.getText().equals("F1")) {
                                    bs[0] = (byte) 0;
                                    bs[1] = (byte) 1;
                                    send(bs);
                                }
                                if(b.getText().equals("F2")) {
                                    bs[0] = (byte) 0;
                                    bs[1] = (byte) 2;
                                    send(bs);
                                }
                                if(b.getText().equals("F3")) {
                                    bs[0] = (byte) 0;
                                    bs[1] = (byte) 3;
                                    send(bs);
                                }
                                if(b.getText().equals("F4")) {
                                    bs[0] = (byte) 0;
                                    bs[1] = (byte) 4;
                                    send(bs);
                                }
                                if(b.getText().equals("F5")) {
                                    bs[0] = (byte) 0;
                                    bs[1] = (byte) 5;
                                    send(bs);
                                }
                                if(b.getText().equals("F6")) {
                                    bs[0] = (byte) 0;
                                    bs[1] = (byte) 6;
                                    send(bs);
                                }
                                if(b.getText().equals("F7")) {
                                    bs[0] = (byte) 0;
                                    bs[1] = (byte) 7;
                                    send(bs);
                                }
                                if(b.getText().equals("F8")) {
                                    bs[0] = (byte) 0;
                                    bs[1] = (byte) 8;
                                    send(bs);
                                }
                                if(b.getText().equals("F9")) {
                                    bs[0] = (byte) 0;
                                    bs[1] = (byte) 9;
                                    send(bs);
                                }
                                if(b.getText().equals("F10")) {
                                    bs[0] = (byte) 0;
                                    bs[1] = (byte) 10;
                                    send(bs);
                                }
                                if(b.getText().equals("F11")) {
                                    bs[0] = (byte) 0;
                                    bs[1] = (byte) 11;
                                    send(bs);
                                }
                                if(b.getText().equals("F12")) {
                                    bs[0] = (byte) 0;
                                    bs[1] = (byte) 12;
                                    send(bs);
                                }
                            } else {
                                byte[] bs = {(byte) b.getText().charAt(0)};
                                send(bs);
                            }

                        }
                    }).start();
                    handler.postDelayed(this, 50);
                }
            };
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int runn=1;
                if(trigger!=1) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        if (!pressed) {
                            handler.post(runnable);
                            pressed = true;
                        } else {
                            //handler.removeCallbacks(runnable);
                        }

                        return true;
                    } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                        // Останавливаем отправку клавиш.
                        handler.post(runnable);
                        pressed = false;
                        handler.removeCallbacks(runnable);
                        return true;
                    }
                    return false;
                } else {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        if (!pressed) {
                            if(b.getCurrentTextColor()==Color.GREEN) {
                                b.setTextColor(Color.RED);
                                handler.post(runnable);
                                handler.removeCallbacks(runnable);
                            } else {
                                b.setTextColor(Color.GREEN);
                                handler.post(runnable);
                            }
                            //handler.post(runnable);
                            pressed = true;
                        }
                        return true;
                    } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                        // Останавливаем отправку клавиш.

                            if(b.getCurrentTextColor()==Color.GREEN) {
                                b.setTextColor(Color.RED);
                                handler.post(runnable);
                                handler.removeCallbacks(runnable);
                            } else {
                                b.setTextColor(Color.GREEN);
                                handler.post(runnable);
                            }
                       }
                       return true;
                    }
                }
            });

        // Получение ConstraintLayout и добавление кнопки
        RelativeLayout c = new RelativeLayout(getApplicationContext());
        params = new Toolbar.LayoutParams(
                sizex, sizey
        );
        params.setMargins(left, top, 0, 0); // Установка отступов
        FrameLayout ll = (FrameLayout) findViewById(R.id.frame);
        c.setLayoutParams(params);
        ll.addView(c);
        b.setAlpha((float) invisible /100);
        if(mgb!=null) {
            b.setAlpha(0.1f);
            c.addView(mgb);
        }
        c.addView(b);
    }
    void send(byte[] b){ //ВЫСЫЛАЕМ НА СЕРВЕР
        Connection c = new Connection("localhost",5050);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.sendData(b);
                    c.finalize();
                } catch (Exception e) {

                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
    public void read(View w){ //ЧТЕНИЕ, КОД НИЖЕ РАБОТАЕТ НА МАГИИ
        try{
            List strs= null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                strs = Files.readAllLines(Paths.get(this.getFilesDir().getAbsolutePath()+"/File.txt"));
            }
            assert strs != null;
            for(Object sts:strs){
                String st=sts.toString();
                //Toast.makeText(this, st.toString(), Toast.LENGTH_SHORT).show();
                int top=0;
                int left=0;
                int sizex=0;
                int sizey=0;
                int element=0;
                int invisible=0;
                int trigger=0;
                String pathOf=" ";
                String emulationButton="";
                for(int i = 0; i< st.length(); i++){
                    if(st.charAt(i)=='='||st.charAt(i)==','){
                        String str1="";
                        boolean isTop=false;
                        if(st.charAt(i)==',') {
                            for (int ii = i+1; ii < st.length(); ii++) {
                                if (st.charAt(ii) == ',' || st.charAt(ii) == ';') {
                                    if(element==0) {
                                        top = Integer.parseInt(str1);
                                    }else if(element==1) {
                                        sizex = Integer.parseInt(str1);
                                    } else if(element==2){
                                        sizey = Integer.parseInt(str1);
                                    } else if(element==3){
                                        invisible = Integer.parseInt(str1);
                                    } else if(element==4){
                                        pathOf=str1;
                                    } else if(element==5){
                                        trigger = Integer.parseInt(str1);
                                    }
                                    Toast.makeText(this, left + " " + top, Toast.LENGTH_SHORT).show();
                                    // Toast.makeText(this, st.toString(), Toast.LENGTH_SHORT).show();
                                    ii = st.length();
                                    element+=1;
                                } else {
                                    str1 += Character.toString(st.charAt(ii));
                                }
                            }
                        }
                        if(st.charAt(i)=='=') {
                            emulationButton=Character.toString(st.charAt(i-1));
                            for (int ii = i+1; ii < st.length(); ii++) {
                                if (st.charAt(ii) == ',' || st.charAt(ii) == ';') {
                                    element=0;
                                    left = Integer.parseInt(str1);
                                    Toast.makeText(this, left + " " + top+" "+sizex+" "+sizey, Toast.LENGTH_SHORT).show();
                                    // Toast.makeText(this, st.toString(), Toast.LENGTH_SHORT).show();
                                    ii = st.length();
                                } else {
                                    str1 += Character.toString(st.charAt(ii));
                                }
                            }
                        }
                    }
                    if(st.charAt(i)==';'){
                        create(emulationButton,left, top,sizex,sizey,invisible,pathOf,trigger);
                    }
                }
            }
        } catch(IOException io){

        }
    }
}
