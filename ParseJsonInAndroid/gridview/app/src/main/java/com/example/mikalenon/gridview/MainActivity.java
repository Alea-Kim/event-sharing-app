package com.example.mikalenon.gridview;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends Activity {

    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String[] prgmNameList = {"Let Us C", "c++", "JAVA", "Jsp", "Microsoft .Net", "Android", "PHP", "Jquery", "JavaScript"};
    //STATIC PICTURES TO
    public static int[] prgmImages = {R.drawable.images, R.drawable.images1, R.drawable.images2, R.drawable.images3, R.drawable.images4, R.drawable.images5, R.drawable.images6, R.drawable.images7, R.drawable.images8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new CustomAdapter(this, prgmNameList, prgmImages));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}