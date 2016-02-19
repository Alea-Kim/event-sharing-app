/*   Author:  Camille Bacister | SPRINT 1 */

/*
* DEVELOPED BY: BACK UP
* CLIENT: MAAM ANNETTE (ITDC)
* Allows the used to Log in in order to explore the app.
*/


package com.eventsharing.watudu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//import android.content.Context;

public class LOGIN extends AppCompatActivity implements View.OnClickListener{

    Button blogin;
    EditText etEmail, etpassword;
    TextView tvregisterlink;

   // UserLocalStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etpassword = (EditText) findViewById(R.id.etpassword);
        blogin = (Button) findViewById(R.id.blogin);
        tvregisterlink = (TextView) findViewById(R.id.tvregisterlink);


        blogin.setOnClickListener(this);
        tvregisterlink.setOnClickListener(this);

        //userLocalStore = new UserLocalStore(this);
        //userLocalStore = new UserLocalStore();
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
            case R.id.blogin:
                startActivity(new Intent(this, CreateEvent.class));
                break;
                /*log in succssfull so true as new user then store data from new user*/
              /*  User user =  new User(null, null);
                userLocalStore.storeUserData(user);
                userLocalStore.setUserLoggedIn(true);
               */
            case R.id.tvregisterlink:
                startActivity(new Intent(this, REGISTER.class));
                break;
        }
    }

}
