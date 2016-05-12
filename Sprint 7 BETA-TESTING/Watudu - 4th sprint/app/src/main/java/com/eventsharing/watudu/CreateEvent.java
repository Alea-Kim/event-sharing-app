/*   Author:  Mika Lenon | Date: Feb 18, 2016     */

/*
* DEVELOPED BY: BACK UP
* CLIENT: MAAM ANNETTE (ITDC)
* Creates event for the app.
*/

/*Update for SPRINT 3: Save file to a txt file, then to internal. I import new packages in oder to write and read*/
package com.eventsharing.watudu;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Date;


public class CreateEvent extends AppCompatActivity  implements View.OnClickListener{

    Button bCreate;
    EditText etEventName, etVenue, etDescription, etEntranceFee, etTime;
    DatePicker datePicker;
    //TimePicker timePicker;
    Date etDate;
    EditText textmsg;
    static final int READ_BLOCK_SIZE = 100;
    private String selectedImagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        etEventName = (EditText) findViewById(R.id.etEventName);
        etVenue = (EditText) findViewById(R.id.etVenue);
        etDescription = (EditText) findViewById(R.id.etDescription);
        etEntranceFee = (EditText) findViewById(R.id.etEntranceFee);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        etTime = (EditText) findViewById(R.id.etTime);
        bCreate = (Button) findViewById(R.id.bCreate);

        bCreate.setOnClickListener(this);

        //bCreate.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch(v.getId()){
    /* will notify the onclick method*/
            case R.id.bCreate:
                try {

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


                    //outputWriter.write(datePicker.getText().toString());
                    //outputWriterwrite(timePicker.getText().toString());
                    outputWriter.close();

                    //display file saved message
                    Toast.makeText(getBaseContext(), "File saved successfully!",
                            Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                startActivity(new Intent(this, TabLayout.class));
                break;
        }
    }

    public void uploadImage(View v){
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String pictureDirectoryPath = pictureDirectory.getPath();

        //get URI representation
        Uri data = Uri.parse(pictureDirectoryPath);

        photoPickerIntent.setDataAndType(data, "image/*");

        startActivityForResult(photoPickerIntent, 20);

    }

    /* PLAYING WITH IMAGES
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 20) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);

                try {

                    FileOutputStream fileout=openFileOutput("posterpath.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(selectedImagePath);
                    outputWriter.close();

                    //display file saved message
                    Toast.makeText(getBaseContext(), "Image added",
                            Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }
    }

    /**
     * helper to retrieve the path of an image URI
     */
    public String getPath(Uri uri) {
        // just some safety built in
        if( uri == null ) {
            // TODO perform some logging or show user feedback
            return null;
        }
        // try to retrieve the image from the media store first
        // this will only work for images selected from gallery
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        if( cursor != null ){
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        // this is our fallback here
        return uri.getPath();
    }
    */


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
