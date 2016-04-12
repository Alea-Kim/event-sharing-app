package com.eventsharing.watudu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ML on 3/18/2016.
 */

public class EVENTS extends AppCompatActivity implements View.OnClickListener{
    Button bclickableevent;
    TextView tvdesc1, tvdesc2, tvdesc3, tvdesc4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);
        tvdesc1 = (TextView) findViewById(R.id.tvdesc1);
        tvdesc2 = (TextView) findViewById(R.id.tvdesc2);
        tvdesc3 = (TextView) findViewById(R.id.tvdesc3);
        tvdesc4 = (TextView) findViewById(R.id.tvdesc4);

        tvdesc1.setOnClickListener(this);
        tvdesc2.setOnClickListener(this);
        tvdesc3.setOnClickListener(this);
        tvdesc4.setOnClickListener(this);
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
            case R.id.tvdesc1:
                // userLocalStore.clearUserData();
                // userLocalStore.setUserLoggedIn(false);
                startActivity(new Intent(this, EVENTDESC.class));
                break;

            case R.id.tvdesc2:
                // userLocalStore.clearUserData();
                // userLocalStore.setUserLoggedIn(false);
                startActivity(new Intent(this, EVENTDESC.class));
                break;

            case R.id.tvdesc3:
                // userLocalStore.clearUserData();
                // userLocalStore.setUserLoggedIn(false);
                startActivity(new Intent(this, EVENTDESC.class));
                break;

            case R.id.tvdesc4:
                // userLocalStore.clearUserData();
                // userLocalStore.setUserLoggedIn(false);
                startActivity(new Intent(this, EVENTDESC.class));
                break;
        }
    }


}
