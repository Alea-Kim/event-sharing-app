/*   Author:  Mika Lenon | Date: Feb 18, 2016     */

/*
* DEVELOPED BY: BACK UP
* CLIENT: MAAM ANNETTE (ITDC)
* Creates event for the app.
*/
package com.eventsharing.watudu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


public class CreateEvent extends AppCompatActivity{

   /* Button blogin;
    EditText etEventName, etEventSubtitle;
    TextView tvregisterlink;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

       // etEventName = (EditText) findViewById(R.id.etEventName);
      //  etEventSubtitle = (EditText) findViewById(R.id.etEventSubtitle);

    }
/*
    // write text to file
    public void WriteBtn(View v) {
        // add-write text into file
        try {
            FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(textmsg.getText().toString());
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
