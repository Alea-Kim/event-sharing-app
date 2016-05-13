/*
 * Copyright (C) Lenon, Bacister (BackUP)
 *
 * 2016 Watudu: An Event Sharing Android Mobile App
 *
 *This is a course requirement for CS 192 Software Engineering II
 *under the supervision of Asst. Prof. Ma. Rowena C. Solamo of the
 *Department of Computer Science, College of Engineering, University
 *of the Philippines, Diliman for the AY 2015-2016.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://github.com/alea-kim/event-sharing-app
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
* DEVELOPED BY: BACK UP
* CLIENT: MAAM ANNETTE (ITDC)
* Main activity is used as the homepage of the app. It is used to search for the events.
*/

package com.eventsharing.watudu;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bsearch, bsignup, bsignin;
    String[] name = new String[1];
    String[] desc = new String[1];
    String[] images = new String[1];

    List<String> where = new ArrayList<String>();
    List<String> where2 = new ArrayList<String>();
    List<String> where3 = new ArrayList<String>();

    ImageButton imageButton;
    EditText etSpace;
    TextView tvloginlink; //tvprofile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etSpace = (EditText) findViewById(R.id.etSpace);
        bsearch = (Button) findViewById(R.id.bsearch);
        bsignin = (Button) findViewById(R.id.bsignin);
        bsignup = (Button) findViewById(R.id.bsignup);
      //  imageButton = (ImageButton) findViewById(R.id.imageButton);

        bsearch.setOnClickListener(this);
        bsignin.setOnClickListener(this);
        bsignup.setOnClickListener(this);
        // imageButton.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    @Override
    /* if button clicked this will take place*/

    /*this switch gets the ID of the view which notified the
    * onClick button and then the cases will redirects where it will be going. *
    *
    * StartActivity means that this is the next tab that will be displayed
    * after clicking the button.*/


    public void onClick(View v) {
        switch(v.getId()){
    /* will notify the onclick methos*/
            case R.id.bsearch:
                if(etSpace.getText().toString().equals("")) {
                    Intent i = new Intent(this, EVENTS.class);
                    startActivity(i);
                    break;
                }


                try {
                    FileInputStream fileIn=openFileInput("event.txt");
                    InputStreamReader InputRead= new InputStreamReader(fileIn);

                    char[] inputBuffer= new char[1];
                    String s = "";
                    int charRead;
                    while ((charRead = InputRead.read(inputBuffer)) > 0) {
                        // char to string conversion
                        String readstring = String.copyValueOf(inputBuffer, 0, charRead);
                        if(readstring.equals("{")){
                            s = "";
                        }
                        else if(readstring.equals("}")){
                            where.add(s);
                            s = "";
                        }
                        else if(readstring.equals("`")){
                            where2.add(s);
                            s = "";
                        }
                        else{
                            s += readstring;
                        }
                    }

                    name = new String[where.size()];
                    where.toArray(name);

                    desc = new String[where2.size()];
                    where2.toArray(desc);
                    InputRead.close();
                    //Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //GETTING IMAGES
                try {
                    FileInputStream fileIn=openFileInput("images.txt");
                    InputStreamReader InputRead= new InputStreamReader(fileIn);

                    char[] inputBuffer= new char[1];
                    String s="";
                    int charRead;
                    while ((charRead = InputRead.read(inputBuffer)) > 0) {
                        // char to string conversion
                        String readstring = String.copyValueOf(inputBuffer, 0, charRead);
                        if(readstring.equals("\n")){
                            where3.add(s);
                            s = "";
                        }
                        else{
                            s += readstring;
                        }

                        Log.d("readstring be like...", readstring);
                        Log.d("size...", Integer.toString(where.size()));

                    }

                    images = new String[where3.size()];
                    where3.toArray(images);
                    InputRead.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                int index = -1;

                for(int m = 0; m < name.length; m++){
                    Log.d("read this...", etSpace.getText().toString());
                    Log.d("read this2...", name[m]);

                    if(etSpace.getText().toString().equals(name[m])){
                        index = m;
                        Log.d("read this3...", Integer.toString(index));
                        break;
                    }

                }
                if(index == -1){
                    Toast.makeText(getBaseContext(), "NO EVENT FOUND.", Toast.LENGTH_SHORT).show();
                }
                else{
                    String one = name[index];
                    String two = desc[index];
                    String three = images[index];
                    Intent i = new Intent(this, EVENTDESC.class);
                    i.putExtra("Title", one);
                    i.putExtra("Desc", two);
                    i.putExtra("Img", three);

                    startActivity(i);
                }

                break;

            case R.id.bsignin:
                startActivity(new Intent(this, ActivityLogin.class));
                break;

            case R.id.bsignup:
                startActivity(new Intent(this, ActivityRegister.class));
                break;

          //  case R.id.imageButton:
           //     startActivity(new Intent(this, ActivityLogin.class));
            //    break;

        }
    }
}
