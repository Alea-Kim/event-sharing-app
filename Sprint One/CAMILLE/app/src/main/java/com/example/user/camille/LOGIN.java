package com.example.user.camille;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LOGIN extends AppCompatActivity implements View.OnClickListener{

    Button blogin;
    EditText etEmail, etpassword;
    TextView tvregisterlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etpassword = (EditText) findViewById(R.id.etpassword);
        blogin = (Button) findViewById(R.id.blogin);
        tvregisterlink = (TextView) findViewById(R.id.tvregisterlink);

        blogin.setOnClickListener(this);
        tvregisterlink.setOnClickListener(this);
    }
    @Override
    /* if button clicked this will take place*/
    public void onClick(View v) {
        switch(v.getId()){
    /* wil notify the onclick methos*/
            case R.id.blogin:

                break;
            case R.id.tvregisterlink:
                startActivity(new Intent(this, REGISTER.class));
                break;
        }
    }
}
