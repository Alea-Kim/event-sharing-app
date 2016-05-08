package com.eventsharing.watudu;

import android.content.Intent;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainLogged extends AppCompatActivity implements View.OnClickListener{

    Button bsearch;
    EditText etSpace;


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
                startActivity(new Intent(this, EVENTS.class));
                break;


          //  case R.id.tvprofile:
            //    startActivity(new Intent(this, Profile.class));
             //   break;
        }
    }
}
