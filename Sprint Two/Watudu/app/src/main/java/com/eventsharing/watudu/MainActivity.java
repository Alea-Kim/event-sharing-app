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
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button blogout;
    EditText etName, etAge, etEmail;
    TextView tvloginlink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etEmail = (EditText) findViewById(R.id.etEmail);
        blogout = (Button) findViewById(R.id.blogout);
        tvloginlink = (TextView) findViewById(R.id.tvloginlink);


        blogout.setOnClickListener(this);
        tvloginlink.setOnClickListener(this);
    }
/*
    @Override
    protected void onStart(){
        super.onStart();
        if(authenticate() == true){
            displayUserDetails();
        }
    }

*/
    /*method: authentication if the user is logged in*/
    /*private boolean authenticate(){
        return userLocalStore.getUserLoggedIn();  /*Return true if loggged in*/
    //}

    /*private void displayUserDetails(){
        User user = userLocalStore.getLoggedInUser();
        etEmail.setText(user.email);
        etName.setText(user.name);
        etAge.setText(user.age);

    }
    */

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
            case R.id.blogout:
               // userLocalStore.clearUserData();
               // userLocalStore.setUserLoggedIn(false);
                startActivity(new Intent(this, Listview.class));
                break;

            case R.id.tvloginlink:
                startActivity(new Intent(this, LOGIN.class));
                break;
        }
    }
}
