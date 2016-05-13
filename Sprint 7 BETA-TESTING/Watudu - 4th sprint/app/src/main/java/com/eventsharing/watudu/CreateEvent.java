/*   Author:  Mika Lenon | Date: Feb 18, 2016     */

/*
* DEVELOPED BY: BACK UP
* CLIENT: MAAM ANNETTE (ITDC)
* Creates event for the app.
*/

/*Update for SPRINT 3: Save file to a txt file, then to internal. I import new packages in oder to write and read*/
package com.eventsharing.watudu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Date;


public class CreateEvent extends AppCompatActivity  implements View.OnClickListener{

    ImageView imageView;
    Button bCreate, bImage;
    EditText etEventName, etVenue, etDescription, etEntranceFee, etTime;
    DatePicker datePicker;
    Date etDate;
    static final int READ_BLOCK_SIZE = 100;
    private static final int PICK_IMAGE = 0;
    String stringUri;
    Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        imageView = (ImageView) findViewById(R.id.imageView);
        etEventName = (EditText) findViewById(R.id.etEventName);
        etVenue = (EditText) findViewById(R.id.etVenue);
        etDescription = (EditText) findViewById(R.id.etDescription);
        etEntranceFee = (EditText) findViewById(R.id.etEntranceFee);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        etTime = (EditText) findViewById(R.id.etTime);
        bCreate = (Button) findViewById(R.id.bCreate);
        bImage = (Button) findViewById(R.id.bImage);

        bCreate.setOnClickListener(this);
        bImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent (Intent.ACTION_PICK,  MediaStore.Images.Media.EXTERNAL_CONTENT_URI  );
                startActivityForResult(gallery, PICK_IMAGE);

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            imageUri = data.getData();
            stringUri = imageUri.toString();
            imageView.setImageURI(imageUri);

            try {

                FileOutputStream fileout=openFileOutput("images.txt", MODE_APPEND);
                OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                outputWriter.write(stringUri);
                outputWriter.write("\n");
                outputWriter.close();

                //display file saved message
                Toast.makeText(getBaseContext(), "Uploaded.",
                        Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    public void onClick(View v) {
        int error = 0;
        switch(v.getId()){
    /* will notify the onclick method*/
            case R.id.bCreate:
                try {
                    if( imageView.getDrawable() == null ){
                        Toast.makeText(getBaseContext(), "Please add a photo.",
                                Toast.LENGTH_SHORT).show();
                        error = 1;
                    }
                    if( etEventName.getText().toString().trim().equals("")){
                        error = 1;
                        etEventName.setError( "Event Name is required!" );
                        Toast.makeText(getBaseContext(), "Please write on every field.",
                                Toast.LENGTH_SHORT).show();
                    }
                    if( etDescription.getText().toString().trim().equals("")) {
                        etDescription.setError("Description is required!");
                        Toast.makeText(getBaseContext(), "Please write on every field.",
                                Toast.LENGTH_SHORT).show();
                        error = 1;
                    }
                    if( etVenue.getText().toString().trim().equals("")) {
                        etVenue.setError("Venue or Place is required!");
                        Toast.makeText(getBaseContext(), "Please write on every field.",
                                Toast.LENGTH_SHORT).show();
                        error = 1;
                    }
                    if( etTime.getText().toString().trim().equals("")) {
                        etTime.setError("Time is required!");
                        Toast.makeText(getBaseContext(), "Please write on every field.",
                                Toast.LENGTH_SHORT).show();
                        error = 1;
                    }
                    if( etEntranceFee.getText().toString().trim().equals("")) {
                        error = 1;
                        etEntranceFee.setError("Entrance Fee is required!");
                        Toast.makeText(getBaseContext(), "Please write on every field.",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if (error == 0){

                        FileOutputStream fileout=openFileOutput("event.txt", MODE_APPEND);
                        OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                        outputWriter.write("{");
                        outputWriter.write(etEventName.getText().toString());
                        outputWriter.write("}");
                        outputWriter.write("Details: ");
                        outputWriter.write(etDescription.getText().toString());
                        outputWriter.write("\nVenue: ");
                        outputWriter.write(etVenue.getText().toString());
                        outputWriter.write("\nDate/Time: ");
                        etDate = new Date(datePicker.getCalendarView().getDate());
                        outputWriter.write(etDate.toString());
                        outputWriter.write(", ");
                        outputWriter.write(etTime.getText().toString());
                        outputWriter.write("\nEntrance Fee: ");
                        outputWriter.write(etEntranceFee.getText().toString());
                        outputWriter.write("`");
                        outputWriter.close();
                        Toast.makeText(getBaseContext(), "File saved successfully!",
                                Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(this, TabLayout.class);
                        startActivity(i);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void ReadBtn(View v) {
        //reading text from file
        try {
            FileInputStream fileIn=openFileInput("event.txt");
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
