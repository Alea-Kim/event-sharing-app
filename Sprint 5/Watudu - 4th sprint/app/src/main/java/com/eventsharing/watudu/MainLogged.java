package com.eventsharing.watudu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainLogged extends AppCompatActivity implements View.OnClickListener{

    Button bsearch;
    EditText etSpace;
  //  TextView tvprofile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logged_main);

        etSpace = (EditText) findViewById(R.id.etSpace);
        bsearch = (Button) findViewById(R.id.bsearch);
      //  tvprofile = (TextView) findViewById(R.id.tvprofile);

        bsearch.setOnClickListener(this);
       // tvprofile.setOnClickListener(this);
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
