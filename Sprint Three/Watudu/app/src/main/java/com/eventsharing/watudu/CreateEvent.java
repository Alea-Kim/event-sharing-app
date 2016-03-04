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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Date;


public class CreateEvent extends AppCompatActivity{

    Button bCreate;
    EditText etEventName, etEventSubtitle, etVenue, etDescription, etEntranceFee;
    DatePicker datePicker;
    TimePicker timePicker;
    Date etDate;
    EditText textmsg;
    static final int READ_BLOCK_SIZE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        etEventName = (EditText) findViewById(R.id.etEventName);
        etEventSubtitle = (EditText) findViewById(R.id.etEventSubtitle);
        etVenue = (EditText) findViewById(R.id.etVenue);
        etDescription = (EditText) findViewById(R.id.etDescription);
        etEntranceFee = (EditText) findViewById(R.id.etEntranceFee);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        //bCreate.setOnClickListener(this);
    }

    // write text to file
    public void WriteBtn(View v) {
        // add-write text into file
        try {
            FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(etEventName.getText().toString());
            outputWriter.write(etEventSubtitle.getText().toString());
            outputWriter.write(etVenue.getText().toString());
            outputWriter.write(etDescription.getText().toString());
            outputWriter.write(etEntranceFee.getText().toString());
            etDate = new Date(datePicker.getCalendarView().getDate());
            outputWriter.write(etDate.toString());
            //outputWriter.write(datePicker.getText().toString());
            //outputWriter.write(timePicker.getText().toString());
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read text from file
    public void ReadBtn(View v) {
        //reading text from file
        try {
            FileInputStream fileIn=openFileInput("mytextfile.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;

            }
            InputRead.close();
            Toast.makeText(getBaseContext(), s,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
