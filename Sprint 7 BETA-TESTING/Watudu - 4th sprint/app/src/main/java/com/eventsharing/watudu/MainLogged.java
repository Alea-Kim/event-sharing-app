package com.eventsharing.watudu;

import android.content.Intent;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.HttpUrl;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainLogged extends AppCompatActivity implements View.OnClickListener{

    Button bsearch;
    EditText etSpace;
    String[] name = new String[1];
    String[] desc = new String[1];
    String[] images = new String[1];

    List<String> where = new ArrayList<String>();
    List<String> where2 = new ArrayList<String>();
    List<String> where3 = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logged_main);
        etSpace = (EditText) findViewById(R.id.etSpace);
        bsearch = (Button) findViewById(R.id.bsearch);

        bsearch.setOnClickListener(this);

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
        /* will notify the onclick method*/
            case R.id.bsearch:

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

        }
    }
}
