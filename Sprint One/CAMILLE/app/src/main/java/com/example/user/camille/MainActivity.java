package com.example.user.camille;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button blogout;
    EditText etName, etAge, etEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etEmail = (EditText) findViewById(R.id.etEmail);
        blogout = (Button) findViewById(R.id.blogout);


        blogout.setOnClickListener(this);
    }


    @Override
    /* if button clicked this will take place*/
    public void onClick(View v) {
        switch(v.getId()){
    /* wil notify the onclick methos*/
            case R.id.blogout:
                startActivity(new Intent(this, LOGIN.class));
                break;
        }
    }
}
