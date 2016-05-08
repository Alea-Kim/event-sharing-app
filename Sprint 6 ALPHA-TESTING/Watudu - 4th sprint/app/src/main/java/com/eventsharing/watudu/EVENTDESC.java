package com.eventsharing.watudu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


/**
 * Created by bcamillegrace on 16/03/2016.
 * Updated by aleakim on 25/04/2016
 */
public class EVENTDESC extends AppCompatActivity {
    static final int READ_BLOCK_SIZE = 100;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_design);

        //read the ith event to open!
        String s = "";
        int charRead, i, ctr;
        String[] title = new String[10];
        String[] description = new String[10];

        try {
            FileInputStream fileIn=openFileInput("index.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;

            }
            InputRead.close();
            //Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }

        i = Integer.parseInt(s);



        //FILE READING PROPER
        // Read text from file
        try {
            FileInputStream fileIn=openFileInput("event.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            s="";
            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                if(readstring.equals("\n")){
                    //Toast.makeText(getBaseContext(), "hoy!",Toast.LENGTH_SHORT).show();
                }
                s +=readstring;

            }
            InputRead.close();
            Toast.makeText(getBaseContext(), s,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    //end of file reading...

        TextView ename = (TextView) findViewById(R.id.event_name);
            TextView edesc = (TextView) findViewById(R.id.full_desc);

        ename.setText("SPACE BAR"); //leave this line to assign a specific text
            edesc.setText("Experience a new kind of universe. With free flowing drinks, neon lights, and a wide range of party activities, SPACE BAR takes you to a whole new world this April 29 at 8/F Torre Venezia Suites, 170 Timog Ave., Quezon City. \n" +
                    "\n" +
                    "Doors open at 7:30 PM. \n" +
                    "\n" +
                    "Ticket selling price: 70 PHP\n" +
                    "Door price: 120 PHP. \n" +
                    "\n" +
                    "Get your tickets now at bit.ly/CSPartySpaceBar  \n" +
                "For inquiries, you may contact Abbey (0927 406 1944)"); //leave this line to assign a specific text


    }
}