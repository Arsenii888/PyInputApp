package com.antutu.ABenchMark;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import android.database.sqlite.SQLiteDatabase;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PyInput extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    EditText etx;
    int alpha=100;
    TextView txx;
    int triggerMode=-1;
    String enter="";
    ScrollView sk;
    String pathOfImage=" ";
    EditText ProfileName;
    Spinner dropdown;
    String UsingProfile="Profile1";
    LinearLayout ll;
    Button bs=null;
    bbutons bbs=null;
    ArrayList<bbutons> bbss=new ArrayList<>();
    SQLiteDatabase db = null;
    EditText x1;
    EditText y1;
    int top=250;
    int left=200;
    static String saver = "";
    int id=0;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_py_input);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.button_visibility), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        SeekBar seek=new SeekBar(this);
        ConstraintLayout.LayoutParams params = new  ConstraintLayout.LayoutParams(200,100);
        //layoutParams.setMargins(0, 0, 0, 0); // left, top, right, bottom
        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        params.bottomToBottom= ConstraintLayout.LayoutParams.PARENT_ID;
        params.leftMargin = 4; // Установите необходимое значение для координаты X
        params.bottomMargin=200; // Установите необходимое значение для координаты Y
        seek.setMax(100);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            seek.setMin(0);
        }
        seek.setLayoutParams(params);
        seek.setOnSeekBarChangeListener(this);
        ConstraintLayout c=findViewById(R.id.button_visibility);
        c.addView(seek);

        txx=new TextView(this);
        txx.setText("0");
        params = new  ConstraintLayout.LayoutParams(200,100);
        //layoutParams.setMargins(0, 0, 0, 0); // left, top, right, bottom
        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        params.bottomToBottom= ConstraintLayout.LayoutParams.PARENT_ID;
        params.leftMargin = 4; // Установите необходимое значение для координаты X
        params.bottomMargin=250; // Установите необходимое значение для координаты Y
        txx.setLayoutParams(params);
        c.addView(txx);
        /*etx = new EditText(this);
        etx.setText("100");
        params = new  ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT);
        //layoutParams.setMargins(0, 0, 0, 0); // left, top, right, bottom
        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        params.bottomToBottom= ConstraintLayout.LayoutParams.PARENT_ID;
        params.leftMargin = 4; // Установите необходимое значение для координаты X
        params.bottomMargin=200; // Установите необходимое значение для координаты Y
        etx.setLayoutParams(params);
        c=findViewById(R.id.button_visibility);
        c.addView(etx);*/

        params = new  ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT);
        //layoutParams.setMargins(0, 0, 0, 0); // left, top, right, bottom
        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        params.bottomToBottom= ConstraintLayout.LayoutParams.PARENT_ID;
        params.leftMargin = 4; // Установите необходимое значение для координаты X
        params.bottomMargin=100; // Установите необходимое значение для координаты Y
        Button bb9=new Button(this);
        bb9.setText("Set alpha");
        bb9.setId(-10);
        bb9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInvisible();
            }
        });
        bb9.setLayoutParams(params);
        c.addView(bb9);

        ll= new LinearLayout(this);
        params = new  ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT);
        //layoutParams.setMargins(0, 0, 0, 0); // left, top, right, bottom
        params.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        params.rightMargin = 35; // Установите необходимое значение для координаты X
        params.topMargin = 50; // Установите необходимое значение для координаты Y
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setLayoutParams(params);
        c.addView(ll);

        params = new  ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT);
        //layoutParams.setMargins(0, 0, 0, 0); // left, top, right, bottom
        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        params.leftMargin = 4; // Установите необходимое значение для координаты X
        params.topMargin = 50; // Установите необходимое значение для координаты Y
        Button bb=new Button(this);
        bb.setText("Create");
        bb.setId(-5);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create();
            }
        });
        bb.setLayoutParams(params);
        c.addView(bb);
        Button bb5=new Button(this);
        bb5.setText("Save");
        bb5.setId(-1);
        bb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
        //bb4.setLayoutParams(params);
        ll.addView(bb5);

        LinearLayout ll1= new LinearLayout(this);
        ll1.setOrientation(LinearLayout.HORIZONTAL);
        ll.addView(ll1);
        x1 = new EditText(this);
        x1.setText("150");
        ll1.addView(x1);
        y1 = new EditText(this);
        y1.setText("150");
        ll1.addView(y1);
        Button bb4=new Button(this);
        bb4.setText("Set size");
        bb4.setId(-2);
        bb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetSize();
            }
        });
        //bb4.setLayoutParams(params);
        ll.addView(bb4);

        Button bb6=new Button(this);
        bb6.setText("Read");
        bb6.setId(-6);
        bb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                read();
            }
        });
        //bb4.setLayoutParams(params);
        ll.addView(bb6);


        ProfileName = new EditText(this);
        ProfileName.setText("Profile1");
        ll.addView(ProfileName );

        Button bb7=new Button(this);
        bb7.setText("Use profile");
        bb7.setId(-1);
        bb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                use();
            }
        });
        //bb4.setLayoutParams(params);
        ll.addView(bb7);
        Button bb10=new Button(this);
        bb10.setText("set image");
        bb10.setId(-11);
        bb10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImage();
            }
        });
        //bb4.setLayoutParams(params);
        ll.addView(bb10);

        dropdown=new Spinner(this);
        bb6.setId(-9);
        String[] items = new String[]{"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "w" +
                "c", "v", "b", "n", "m", "esc", "ctrl", "space", "alt","F1","F2","F3","F4","F5","F6","F7","F8","F9","F10","F11","F12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",",","'",";",":","*"
                ,"!","@","#","$","%","^","&","(",")","-","=","+","|"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                enter=(String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        params = new  ConstraintLayout.LayoutParams(270,ConstraintLayout.LayoutParams.WRAP_CONTENT);
        //layoutParams.setMargins(0, 0, 0, 0); // left, top, right, bottom
        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        params.leftMargin = 5; // Установите необходимое значение для координаты X
        params.topMargin = 120; // Установите необходимое значение для координаты Y
        dropdown.setLayoutParams(params);
        c.addView(dropdown);

        Button ch=new Button(this);
        ch.setTextColor(Color.RED);
        ch.setText("Trigger Mode");
        ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                triggerMode*=-1;
                if(triggerMode==1) {
                    ch.setTextColor(Color.GREEN);
                } else {
                    ch.setTextColor(Color.RED);
                }
            }
        });
        params = new  ConstraintLayout.LayoutParams(270,ConstraintLayout.LayoutParams.WRAP_CONTENT);
        //layoutParams.setMargins(0, 0, 0, 0); // left, top, right, bottom
        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        params.leftMargin = 5; // Установите необходимое значение для координаты X
        params.topMargin = 190; // Установите необходимое значение для координаты Y
        ch.setLayoutParams(params);
        c.addView(ch);
    }

    public void get(View w)
    {
        /*EditText etx=findViewById(R.id.idx);
        bs=findViewById(Integer.parseInt(etx.getText().toString()));*/
    }
    @SuppressLint("ClickableViewAccessibility")
    public void create(){
        Button b=new Button(this);
        b.setText(enter);
        ConstraintLayout c=findViewById(R.id.button_visibility);
        id+=1;
        b.setId(id);
        Button b1 = new Button(this.getApplicationContext());
        bbss.add(new bbutons(id, 100,100,Integer.parseInt(x1.getText().toString()),Integer.parseInt(y1.getText().toString()),alpha,pathOfImage,b,findViewById(R.id.button_visibility),triggerMode));
        if(triggerMode==1){
            b.setTextColor(Color.RED);
        }
        b1.setText(enter);
        b1.setVisibility(View.GONE);
        c.addView(b1);

        b.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int dist=0;
                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    dist= (int) event.getX();
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (Math.abs(event.getX() - dist) < 50) {

                    } else if(event.getEventTime() - event.getDownTime() > 550){
                        bbs=bbss.get(b.getId()-1);
                        bbss.get(b.getId()-1).setCoords(-0, -0);
                        b.setVisibility(View.INVISIBLE);
                        b1.setVisibility(View.VISIBLE);
                        Log.e("Coords:", event.getX() + " " + event.getY());
                        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(Integer.parseInt(x1.getText().toString()), Integer.parseInt(y1.getText().toString()));
                        //layoutParams.setMargins(0, 0, 0, 0); // left, top, right, bottom
                        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
                        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
                        params.leftMargin = (int) event.getX()-Integer.parseInt(x1.getText().toString())/2; // Установите необходимое значение для координаты X
                        params.topMargin = (int) event.getY()-Integer.parseInt(y1.getText().toString())/2; // Установите необходимое значение для координаты Y
                        b1.setLayoutParams(params);
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                    bbs=bbss.get(b.getId()-1);
                    if (Math.abs(event.getX() - dist) < 50) {
                        bbs=bbss.get(b.getId()-1);
                        //Toast.makeText(b.getContext().getApplicationContext(), "Long preess", Toast.LENGTH_SHORT).show();
                    } else if(event.getEventTime() - event.getDownTime() > 550){
                        b.setVisibility(View.VISIBLE);
                        b1.setVisibility(View.GONE);
                        bbss.get(b.getId()-1).setCoords((int) (event.getX()-Integer.parseInt(x1.getText().toString())/2), (int) (event.getY()-Integer.parseInt(y1.getText().toString())/2));
                    }
                }
                return true;
            }
        });
        c.addView(b);
    }
    void SetSize(){
        bbs.setSize(Integer.parseInt(x1.getText().toString()), Integer.parseInt(y1.getText().toString()));
    }
    void setInvisible(){
        bbs.setInvisible(alpha);
    }
    void setInvisible(int inv){
        bbs.setInvisible(inv);
    }
    @SuppressLint("ClickableViewAccessibility")
    public void create(String text, int left, int top, int sizex, int sizey, float invisible, String imagePath, int tmode){
        if(imagePath.equals(" ")) {
            Button b = new Button(this);
            ConstraintLayout c = findViewById(R.id.button_visibility);
            b.setText(text);
            if(tmode==1){
                b.setTextColor(Color.RED);
            }
            id += 1;
            Button b1 = new Button(this.getApplicationContext());
            bbss.add(new bbutons(id, top, left, sizex, sizey, (int) invisible, imagePath, b, findViewById(R.id.button_visibility),tmode));

            b1.setText(b.getText().toString().toUpperCase());
            b1.setVisibility(View.GONE);
            c.addView(b1);
            b.setId(id);
            b.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int dist = 0;
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        dist = (int) event.getX();
                    }
                    if (event.getAction() == MotionEvent.ACTION_MOVE) {
                        if (Math.abs(event.getX() - dist) < 50) {

                        } else if (event.getEventTime() - event.getDownTime() > 100) {
                            bbs = bbss.get(b.getId() - 1);
                            bbss.get(b.getId() - 1).setCoords(-0, -0);
                            b.setVisibility(View.INVISIBLE);
                            b1.setVisibility(View.VISIBLE);
                            Log.e("Coords:", event.getX() + " " + event.getY());
                            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(Integer.parseInt(x1.getText().toString()), Integer.parseInt(y1.getText().toString()));
                            //layoutParams.setMargins(0, 0, 0, 0); // left, top, right, bottom
                            params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
                            params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
                            params.leftMargin = (int) event.getX() - Integer.parseInt(x1.getText().toString()) / 2; // Установите необходимое значение для координаты X
                            params.topMargin = (int) event.getY() - Integer.parseInt(y1.getText().toString()) / 2; // Установите необходимое значение для координаты Y
                            b1.setLayoutParams(params);
                        }
                    }
                    if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                        bbs = bbss.get(b.getId() - 1);
                        if (Math.abs(event.getX() - dist) < 50) {
                            bbs = bbss.get(b.getId() - 1);
                            //Toast.makeText(b.getContext().getApplicationContext(), "Long preess", Toast.LENGTH_SHORT).show();
                        } else if (event.getEventTime() - event.getDownTime() > 100) {
                            b.setVisibility(View.VISIBLE);
                            b1.setVisibility(View.GONE);
                            bbss.get(b.getId() - 1).setCoords((int) (event.getX() - Integer.parseInt(x1.getText().toString()) / 2), (int) (event.getY() - Integer.parseInt(y1.getText().toString()) / 2));
                        }
                    }
                    return true;
                }
            });

            c.addView(b);
        } else {
            Button b = new Button(this);
            ConstraintLayout c = findViewById(R.id.button_visibility);
            b.setText(text);
            id += 1;
            Button b1 = new Button(this.getApplicationContext());
            bbutons bbuton;
            bbss.add(new bbutons(id, top, left, sizex, sizey, (int) invisible, imagePath, b, findViewById(R.id.button_visibility),tmode));
            bbuton=bbss.get(bbss.size()-1);
            bbuton.path=imagePath;
            ImageView mgb=bbuton.setImage();
            c.addView(mgb);
            b1.setText(b.getText().toString().toUpperCase());
            b1.setVisibility(View.GONE);
            c.addView(b1);
            b.setId(id);
            b.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int dist = 0;
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        dist = (int) event.getX();
                    }
                    if (event.getAction() == MotionEvent.ACTION_MOVE) {
                        if (Math.abs(event.getX() - dist) < 50) {

                        } else if (event.getEventTime() - event.getDownTime() > 100) {
                            bbs = bbss.get(b.getId() - 1);
                            bbss.get(b.getId() - 1).setCoords(-0, -0);
                            b.setVisibility(View.INVISIBLE);
                            b1.setVisibility(View.VISIBLE);
                            mgb.setVisibility(View.INVISIBLE);
                            Log.e("Coords:", event.getX() + " " + event.getY());
                            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(Integer.parseInt(x1.getText().toString()), Integer.parseInt(y1.getText().toString()));
                            //layoutParams.setMargins(0, 0, 0, 0); // left, top, right, bottom
                            params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
                            params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
                            params.leftMargin = (int) event.getX() - Integer.parseInt(x1.getText().toString()) / 2; // Установите необходимое значение для координаты X
                            params.topMargin = (int) event.getY() - Integer.parseInt(y1.getText().toString()) / 2; // Установите необходимое значение для координаты Y
                            b1.setLayoutParams(params);
                        }
                    }
                    if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                        bbs = bbss.get(b.getId() - 1);
                        if (Math.abs(event.getX() - dist) < 50) {
                            bbs = bbss.get(b.getId() - 1);
                            //Toast.makeText(b.getContext().getApplicationContext(), "Long preess", Toast.LENGTH_SHORT).show();
                        } else if (event.getEventTime() - event.getDownTime() > 100) {
                            b.setVisibility(View.VISIBLE);
                            b1.setVisibility(View.GONE);
                            mgb.setVisibility(View.VISIBLE);
                            bbss.get(b.getId() - 1).setCoords((int) (event.getX() - Integer.parseInt(x1.getText().toString()) / 2), (int) (event.getY() - Integer.parseInt(y1.getText().toString()) / 2));
                            bbss.get(b.getId() - 1).setImageCoords((int) (event.getX() - Integer.parseInt(x1.getText().toString()) / 2), (int) (event.getY() - Integer.parseInt(y1.getText().toString()) / 2));
                        }
                    }
                    return true;
                }
            });

            c.addView(b);
        }
    }
    public void moveUp() { bbs.setCoords(bbs.getLeft(),bbs.getTop()-20); }
    public void moveDown(){
        bbs.setCoords(bbs.getLeft(),bbs.getTop()+20);
    }
    public void moveLeft(){
        bbs.setCoords(bbs.getLeft()-20,bbs.getTop());
    }
    public void moveRight() { bbs.setCoords(bbs.getLeft()+20,bbs.getTop()); }
    public void save(){
        saver="";
        for(int i=0; i<bbss.size(); i++){

            if(bbss.get(i).getText().equals("shift")){
                saver+="ª";
            } else if(bbss.get(i).getText().equals("ctrl")){
                saver+="ŝ";
            }else if(bbss.get(i).getText().equals("esc")){
                saver+="Ĺ";
            }else if(bbss.get(i).getText().equals("alt")){
                saver+="Ĝ";
            }else if(bbss.get(i).getText().equals("space")){
                saver+="Đ";
            }else if(bbss.get(i).getText().equals("F1")){
                saver+="й";
            }else if(bbss.get(i).getText().equals("F2")){
                saver+="ц";
            }else if(bbss.get(i).getText().equals("F3")){
                saver+="у";
            } else if(bbss.get(i).getText().equals("F4")){
                saver+="к";
            }else if(bbss.get(i).getText().equals("F5")){
                saver+="е";
            }else if(bbss.get(i).getText().equals("F6")){
                saver+="н";
            }else if(bbss.get(i).getText().equals("F7")){
                saver+="г";
            }else if(bbss.get(i).getText().equals("F8")){
                saver+="ш";
            }else if(bbss.get(i).getText().equals("F9")){
                saver+="щ";
            }else if(bbss.get(i).getText().equals("F10")){
                saver+="з";
            }else if(bbss.get(i).getText().equals("F11")){
                saver+="х";
            }else if(bbss.get(i).getText().equals("F12")){
                saver+="ф";
            } else {
                saver+=bbss.get(i).getText();
            }
            saver+="=";
            saver+=""+bbss.get(i).getLeft();
            saver+=",";
            saver+=""+bbss.get(i).getTop();
            saver+=",";
            saver+=""+bbss.get(i).getSizeX();
            saver+=",";
            saver+=""+bbss.get(i).getSizeY();
            saver+=",";
            saver+=""+bbss.get(i).getInvisible();
            saver+=",";
            saver+=""+bbss.get(i).getImage();
            saver+=",";
            saver+=""+bbss.get(i).getTrigger();
            saver+=";";
        }
        write(ProfileName.getText().toString());
        use();
        //write("File.txt");
    }
    void use(){
        UsingProfile = ProfileName.getText().toString();
        List strs= null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            try {
                File f=new File(this.getFilesDir().getAbsolutePath()+"/"+UsingProfile);
                if(f.exists()){
                    strs = Files.readAllLines(Paths.get(this.getFilesDir().getAbsolutePath()+"/"+UsingProfile));
                    assert strs != null;
                    for(Object sts:strs){
                        String st=sts.toString();
                        saver="";
                        saver+=st;
                    }
                    write("File.txt");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void write(String Profile){
        File f=new File(this.getFilesDir().getAbsolutePath()+"/"+Profile);
        try{
            f.createNewFile();
        } catch(IOException io){

        }
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(Profile, MODE_PRIVATE);
            fos.write(saver.getBytes());
            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void read(){ //ЧТЕНИЕ, КОД НИЖЕ РАБОТАЕТ НА МАГИИ
        if(!bbss.isEmpty()) {
            for (int i = 0; i < bbss.size(); i++) {
                bbss.get(i).remove();
                //bbss.remove(i);
            }
        }
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
                int trigger=-1;
                String pathOfIcon="";
                float invisible=0;
                int element=0;
                String emulationButton="";
                for(int i = 0; i< st.length(); i++){
                    if(st.charAt(i)=='='||st.charAt(i)==','){
                        String str1="";
                        boolean isTop=false;
                        if(st.charAt(i)==','&&st.charAt(i+1)!='=') {
                            for (int ii = i+1; ii < st.length(); ii++) {

                                if (st.charAt(ii) == ',' || st.charAt(ii) == ';') {
                                    if(element==0) {
                                        top = Integer.parseInt(str1);
                                    }else if(element==1) {
                                        sizex = Integer.parseInt(str1);
                                    } else if(element==2){
                                        sizey = Integer.parseInt(str1);
                                    }else if(element==3){
                                        invisible = Integer.parseInt(str1);
                                    } else if(element==4){
                                        pathOfIcon=str1;
                                        Log.i("TAG",pathOfIcon);
                                    }
                                    else if(element==5){
                                        trigger=Integer.parseInt(str1);
                                        Log.i("TAG",""+Integer.parseInt(str1));
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
                            if(emulationButton.equals("ª")){
                                emulationButton= "shift";
                            }else if(emulationButton.equals("Ĺ")){
                                emulationButton= "ctrl";
                            }else if(emulationButton.equals("ŝ")){
                                emulationButton= "esc";
                            }else if(emulationButton.equals("Ĝ")){
                                emulationButton= "alt";
                            }else if(emulationButton.equals("Đ")){
                                emulationButton= "space";
                            }else if(emulationButton.equals("й")){
                                emulationButton= "F1";
                            } else if(emulationButton.equals("ц")){
                                emulationButton= "F2";
                            }else if(emulationButton.equals("у")){
                                emulationButton= "F3";
                            }else if(emulationButton.equals("к")){
                                emulationButton= "F4";
                            }else if(emulationButton.equals("е")){
                                emulationButton= "F5";
                            }else if(emulationButton.equals("н")){
                                emulationButton= "F6";
                            }else if(emulationButton.equals("г")){
                                emulationButton= "F7";
                            }else if(emulationButton.equals("ш")){
                                emulationButton= "F8";
                            }else if(emulationButton.equals("щ")){
                                emulationButton= "F9";
                            }else if(emulationButton.equals("з")){
                                emulationButton= "F10";
                            }else if(emulationButton.equals("х")){
                                emulationButton= "F11";
                            }else if(emulationButton.equals("ф")){
                                emulationButton= "F12";
                            }else {
                                for(int z = 0; z< bbss.size(); z++) {
                                    saver += bbss.get(z).getText();
                                }
                            }
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
                        create(emulationButton,left, top,sizex,sizey,invisible,pathOfIcon,trigger);
                    }
                }
            }
        } catch(IOException io){

        }
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //setInvisible(50);
        //alpha=progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        alpha=seekBar.getProgress();
        txx.setText(""+seekBar.getProgress());
    }
    ArrayList<String> oldPath=new ArrayList<>();
    LinearLayout ll1;
    void getImage(){
        for(int i=0; i<oldPath.size(); i++){
            oldPath.set(i,"");
        }
        String path="";
        for(int i=0; i<oldPath.size(); i++){
            path+=oldPath.get(i);
            path+="/";
        }
        Log.i("tag", String.valueOf(oldPath));
        sk=new ScrollView(this);
        ConstraintLayout c=findViewById(R.id.button_visibility);
        File f= new File(Environment.getExternalStorageDirectory().getPath()+"/"+path);
        File[] fs=f.listFiles();
        ll1=new LinearLayout(this);
        ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll1.setOrientation(LinearLayout.VERTICAL);
        ll1.addView(ll);
        sk.addView(ll1);
        if (fs != null) {
            for(File fd: fs){
                Button tx=new Button(this);
                tx.setText(fd.getName());
                if(fd.isDirectory()){
                    tx.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //ll1.removeAllViews();
                            ll1.removeView(ll);
                            oldPath.add(tx.getText().toString());
                            //ll1.setVisibility(View.GONE);
                            Log.i("TAG", String.valueOf(oldPath));
                            getPathFiles();
                        }
                    });
                }else {
                    tx.setOnClickListener(new View.OnClickListener() {
                        @SuppressLint("ClickableViewAccessibility")
                        @Override
                        public void onClick(View v) {
                            for(int i=0; i<oldPath.size(); i++){
                                oldPath.remove(i);
                            }
                            bbs.path=fd.getAbsolutePath();
                            bbs.setImage();
                            bbs.remove();
                            Button b = new Button(tx.getContext());
                            ConstraintLayout c = findViewById(R.id.button_visibility);
                            b.setText(bbs.getText());
                            id += 1;
                            Button b1 = new Button(tx.getContext());
                            bbutons bbuton;
                            bbss.add(new bbutons(bbs.id, bbs.top, bbs.left,  bbs.sizeX,  bbs.sizeY,  bbs.invisible,  bbs.path, b, findViewById(R.id.button_visibility),triggerMode));
                            bbuton=bbss.get(bbss.size()-1);
                            bbuton.path=fd.getAbsolutePath();
                            ImageView mgb=bbuton.setImage();
                            c.addView(mgb);
                            b1.setText(b.getText().toString().toUpperCase());
                            b1.setVisibility(View.GONE);
                            c.addView(b1);
                            b.setId(id);
                            b.setOnTouchListener(new View.OnTouchListener() {
                                @Override
                                public boolean onTouch(View v, MotionEvent event) {
                                    int dist = 0;
                                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                        dist = (int) event.getX();
                                    }
                                    if (event.getAction() == MotionEvent.ACTION_MOVE) {
                                        if (Math.abs(event.getX() - dist) < 50) {

                                        } else if (event.getEventTime() - event.getDownTime() > 100) {
                                            bbs = bbss.get(b.getId() - 1);
                                            bbss.get(b.getId() - 1).setCoords(-0, -0);
                                            b.setVisibility(View.INVISIBLE);
                                            b1.setVisibility(View.VISIBLE);
                                            mgb.setVisibility(View.INVISIBLE);
                                            Log.e("Coords:", event.getX() + " " + event.getY());
                                            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(Integer.parseInt(x1.getText().toString()), Integer.parseInt(y1.getText().toString()));
                                            //layoutParams.setMargins(0, 0, 0, 0); // left, top, right, bottom
                                            params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
                                            params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
                                            params.leftMargin = (int) event.getX() - Integer.parseInt(x1.getText().toString()) / 2; // Установите необходимое значение для координаты X
                                            params.topMargin = (int) event.getY() - Integer.parseInt(y1.getText().toString()) / 2; // Установите необходимое значение для координаты Y
                                            b1.setLayoutParams(params);
                                        }
                                    }
                                    if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                                        bbs = bbss.get(b.getId() - 1);
                                        if (Math.abs(event.getX() - dist) < 50) {
                                            bbs = bbss.get(b.getId() - 1);
                                            //Toast.makeText(b.getContext().getApplicationContext(), "Long preess", Toast.LENGTH_SHORT).show();
                                        } else if (event.getEventTime() - event.getDownTime() > 100) {
                                            b.setVisibility(View.VISIBLE);
                                            b1.setVisibility(View.GONE);
                                            mgb.setVisibility(View.VISIBLE);
                                            bbss.get(b.getId() - 1).setCoords((int) (event.getX() - Integer.parseInt(x1.getText().toString()) / 2), (int) (event.getY() - Integer.parseInt(y1.getText().toString()) / 2));
                                            bbss.get(b.getId() - 1).setImageCoords((int) (event.getX() - Integer.parseInt(x1.getText().toString()) / 2), (int) (event.getY() - Integer.parseInt(y1.getText().toString()) / 2));
                                        }
                                    }
                                    return true;
                                }
                            });

                            c.addView(b);
                            //pathOfImage = fd.getAbsolutePath();
                        }
                    });
                }
                Log.i("TAG",fd.getName());
                ll.addView(tx);
            }
        }
        ConstraintLayout.LayoutParams params = new  ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,500);
        //layoutParams.setMargins(0, 0, 0, 0); // left, top, right, bottom
        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        params.topToTop= ConstraintLayout.LayoutParams.PARENT_ID;
        params.leftMargin = 200; // Установите необходимое значение для координаты X
        params.topMargin=10; // Установите необходимое значение для координаты Y
        sk.setLayoutParams(params);
        c.addView(sk);
    }
    void getPathFiles(){
        String path="";
        for(int i=0; i<oldPath.size(); i++){
            path+=oldPath.get(i);
            path+="/";
        }
        ConstraintLayout c=findViewById(R.id.button_visibility);
        //sk=new ScrollView(this);
        File f= new File(Environment.getExternalStorageDirectory().getPath()+"/"+path);
        File[] fs=f.listFiles();
        //LinearLayout ll1=new LinearLayout(this);
        //ll1.setOrientation(LinearLayout.VERTICAL);
        //sk.addView(ll);
        ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll1.addView(ll);
        for(File fd: fs){
            Button tx=new Button(this);
            tx.setText(fd.getName());
            if(fd.isDirectory()){
                tx.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //ll1.removeAllViews();
                        ll1.removeView(ll);
                        oldPath.add(tx.getText().toString());
                        //ll1.setVisibility(View.GONE);
                        Log.i("TAG", String.valueOf(oldPath));
                        getPathFiles();
                    }
                });
            }else {
                tx.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("ClickableViewAccessibility")
                    @Override
                    public void onClick(View v) {
                        c.removeView(sk);
                        bbs.path=fd.getAbsolutePath();
                        bbs.setImage();
                        Button b = new Button(tx.getContext());
                        ConstraintLayout c = findViewById(R.id.button_visibility);
                        b.setText(bbs.getText());
                        id += 1;
                        Button b1 = new Button(tx.getContext());
                        bbutons bbuton;
                        bbss.add(new bbutons(bbs.id, bbs.top, bbs.left,  bbs.sizeX,  bbs.sizeY,  bbs.invisible,  bbs.path, b, findViewById(R.id.button_visibility),triggerMode));
                        bbuton=bbss.get(bbss.size()-1);
                        bbuton.path=fd.getAbsolutePath();
                        ImageView mgb=bbuton.setImage();
                        c.addView(mgb);
                        b1.setText(b.getText().toString().toUpperCase());
                        b1.setVisibility(View.GONE);
                        c.addView(b1);
                        b.setId(id);
                        b.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                int dist = 0;
                                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                    dist = (int) event.getX();
                                }
                                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                                    if (Math.abs(event.getX() - dist) < 50) {

                                    } else if (event.getEventTime() - event.getDownTime() > 100) {
                                        bbs = bbss.get(b.getId() - 1);
                                        bbss.get(b.getId() - 1).setCoords(-0, -0);
                                        b.setVisibility(View.INVISIBLE);
                                        b1.setVisibility(View.VISIBLE);
                                        mgb.setVisibility(View.INVISIBLE);
                                        Log.e("Coords:", event.getX() + " " + event.getY());
                                        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(Integer.parseInt(x1.getText().toString()), Integer.parseInt(y1.getText().toString()));
                                        //layoutParams.setMargins(0, 0, 0, 0); // left, top, right, bottom
                                        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
                                        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
                                        params.leftMargin = (int) event.getX() - Integer.parseInt(x1.getText().toString()) / 2; // Установите необходимое значение для координаты X
                                        params.topMargin = (int) event.getY() - Integer.parseInt(y1.getText().toString()) / 2; // Установите необходимое значение для координаты Y
                                        b1.setLayoutParams(params);
                                    }
                                }
                                if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                                    bbs = bbss.get(b.getId() - 1);
                                    if (Math.abs(event.getX() - dist) < 50) {
                                        bbs = bbss.get(b.getId() - 1);
                                        //Toast.makeText(b.getContext().getApplicationContext(), "Long preess", Toast.LENGTH_SHORT).show();
                                    } else if (event.getEventTime() - event.getDownTime() > 100) {
                                        b.setVisibility(View.VISIBLE);
                                        b1.setVisibility(View.GONE);
                                        mgb.setVisibility(View.VISIBLE);
                                        bbss.get(b.getId() - 1).setCoords((int) (event.getX() - Integer.parseInt(x1.getText().toString()) / 2), (int) (event.getY() - Integer.parseInt(y1.getText().toString()) / 2));
                                        bbss.get(b.getId() - 1).setImageCoords((int) (event.getX() - Integer.parseInt(x1.getText().toString()) / 2), (int) (event.getY() - Integer.parseInt(y1.getText().toString()) / 2));
                                    }
                                }
                                return true;
                            }
                        });
                        bbs.remove();
                        c.addView(b);
                        //pathOfImage = fd.getAbsolutePath();
                    }
                });
            }
            Log.i("TAG",fd.getName());
            ll.addView(tx);
        }
    }
}