package com.eventsharing.watudu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.PopupWindow;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Date;

/**
 * Created by ML on 3/18/2016.
 */

public class EVENTS extends Activity implements View.OnClickListener{

    String[] DayOfWeek = {"EDIT", "DELETE"};

    Button bclickableevent;
    TextView tvdesc1, tvdesc2, tvdesc3, tvdesc4;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);


        final Button btnOpenPopup = (Button) findViewById(R.id.openpopup);
        btnOpenPopup.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                LayoutInflater layoutInflater =
                        (LayoutInflater)getBaseContext()
                                .getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.popup, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

                Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);

                Spinner popupSpinner = (Spinner)popupView.findViewById(R.id.popupspinner);

                ArrayAdapter<String> adapter =
                        new ArrayAdapter<String>(EVENTS.this,
                                android.R.layout.simple_spinner_item, DayOfWeek);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                popupSpinner.setAdapter(adapter);

                btnDismiss.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }});

                popupWindow.showAsDropDown(btnOpenPopup, 50, -30);
            }

        });

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
                try {
                    FileOutputStream fileout=openFileOutput("index.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                    outputWriter.write("1");
                    outputWriter.close();

                    //display file saved message
                   // Toast.makeText(getBaseContext(), "Index saved.",
                     //       Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
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
       /* try {
            FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(index.toString());
            outputWriter.write("\n");
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }


}
