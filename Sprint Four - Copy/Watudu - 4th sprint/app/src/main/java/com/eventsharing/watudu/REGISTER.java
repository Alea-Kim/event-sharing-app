/*   Author:  Camille Bacister | SPRINT 1 */

/*
* DEVELOPED BY: BACK UP
* CLIENT: MAAM ANNETTE (ITDC)
* Register is used t create an event and publish an event.
*/


package com.eventsharing.watudu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class REGISTER extends AppCompatActivity implements View.OnClickListener{

    Button bregister;
    EditText etName, etAge, etEmail, etpassword;
            //etRPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etpassword = (EditText) findViewById(R.id.etpassword);
        //etRPassword = (EditText) findViewById(R.id.etRPassword);
        bregister = (Button) findViewById(R.id.bregister);

        bregister.setOnClickListener(this);
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
            case R.id.bregister:

                startActivity(new Intent(this, TabLayout.class)); /*HOMEPAGE NA SYA MAPUPUNTA*/
                break;
        }
    }
}
