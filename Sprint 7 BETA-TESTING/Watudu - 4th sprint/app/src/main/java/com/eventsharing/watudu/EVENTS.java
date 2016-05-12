package com.eventsharing.watudu;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.GridView;
import android.widget.Toast;

import java.util.AbstractCollection;
import java.util.List;

public class EVENTS extends Activity {

    GridView gv;
    //Context context;
    //ArrayList prgmName;

    //ArrayList<String> prgmNameList = new ArrayList<String>();
    //STATIC PICTURES TO
    static final int READ_BLOCK_SIZE = 1;


    //public static String[] prgmNameList = {"Subscribe to ACM", "Subscribe to Broad", "Subscribe to CS", "Subscribe to CS", "Subscribe to Rep", "Subscribe to Stat", "Subscribe to Tomo-Kai", "Subscribe to CE"};
    //public static int[] prgmImages = {R.drawable.images, R.drawable.images1, R.drawable.images2, R.drawable.images3, R.drawable.images4, R.drawable.images5, R.drawable.images6, R.drawable.images7};
    //public static String[] prgmDesc =

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] prgmNameList = new String[1];
        String[] prgmDesc = new String[1];
        String[] prgmImages = new String[1];

        List<String> where = new ArrayList<String>();
        List<String> where2 = new ArrayList<String>();
        List<String> where3 = new ArrayList<String>();

        try {
            FileInputStream fileIn=openFileInput("event.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;
            while ((charRead = InputRead.read(inputBuffer)) > 0) {
                // char to string conversion
                String readstring = String.copyValueOf(inputBuffer, 0, charRead);
                if(readstring.equals("{")){
                    s = "";
                }
                else if(readstring.equals("}")){
                    where.add(s);
                    s = "";
                }
                else if(readstring.equals("`")){
                    where2.add(s);
                    s = "";
                }
                else{
                    s += readstring;
                }
            }
            prgmNameList = new String[where.size()];
            where.toArray(prgmNameList);

            prgmDesc = new String[where2.size()];
            where2.toArray(prgmDesc);

            InputRead.close();
            Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
            //PASTE END
        //GETTING IMAGES
        try {
            FileInputStream fileIn=openFileInput("images.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;
            while ((charRead = InputRead.read(inputBuffer)) > 0) {
                // char to string conversion
                String readstring = String.copyValueOf(inputBuffer, 0, charRead);
                if(readstring.equals("\n")){
                    where3.add(s);
                    s = "";
                }
                else{
                    s += readstring;
                }

                Log.d("readstring be like...", readstring);
                Log.d("size...", Integer.toString(where.size()));

            }

            prgmImages = new String[where3.size()];
            where3.toArray(prgmImages);
            InputRead.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        super.onCreate(savedInstanceState);

        setContentView(R.layout.events);
        gv = (GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new CustomAdapter(this, prgmNameList, prgmImages, prgmDesc));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}