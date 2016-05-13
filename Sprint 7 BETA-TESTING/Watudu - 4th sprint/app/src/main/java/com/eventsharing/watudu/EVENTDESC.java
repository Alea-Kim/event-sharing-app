package com.eventsharing.watudu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


/**
 * Created by bcamillegrace on 16/03/2016.
 * Updated by aleakim on 25/04/2016
 */
public class EVENTDESC extends AppCompatActivity {
    static final int READ_BLOCK_SIZE = 100;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_design);

        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("Title");
        String desc = bundle.getString("Desc");
        String img = bundle.getString("Img");

        TextView ename = (TextView) findViewById(R.id.event_name);
        TextView edesc = (TextView) findViewById(R.id.full_desc);
        ImageView eimg = (ImageView) findViewById(R.id.user_profile_photo);

        ename.setText(title); //leave this line to assign a specific text
        edesc.setText(desc); //leave this line to assign a specific text

        Uri uri;
        uri= Uri.parse(img);
        eimg.setImageURI(uri);

    }
}