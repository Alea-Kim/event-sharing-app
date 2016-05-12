package com.eventsharing.watudu;

/**
 * Created by bcamillegrace on 25/03/2016.
 */

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import butterknife.ButterKnife;
import butterknife.Bind;

public class ActivityRegister extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";
    private static final int REQUEST_REG = 0;

    @Bind(R.id.etName)
    EditText _nameText;

    @Bind(R.id.etAge)
    EditText _ageText;

    @Bind(R.id.etEmail)
    EditText _emailText;

    @Bind(R.id.etpassword)
    EditText _passwordText;

    @Bind(R.id.bregister)
    Button _registerButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        _registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                register();
            }
        });

        @Override
        public void onClick(View v) {
        //    switch(v.getId()){
                //case R.id.bregister:
                    try {
                        FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                        outputWriter.write(_nameText.getText().toString());
                        outputWriter.write("\n");

                        // outputWriter.write(etAge.getText().toString());
                        outputWriter.write(_emailText.getText().toString());
                        outputWriter.write( _passwordText.getText().toString());
                        outputWriter.close();

                        //display file saved message
                        Toast.makeText(getBaseContext(), "Account saved.",
                                Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    startActivity(new Intent(this, TabLayout.class)); /*HOMEPAGE NA SYA MAPUPUNTA*/
                    break;
          //  }
        }
    }

    public void register() {
        Log.d(TAG, "Register");

        if (!validate()) {
            onRegisterFailed();
            onRegisterFailed();
            return;
        }

        else {
            startActivity(new Intent(this, TabLayout.class));
        }

        _registerButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(ActivityRegister.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onRegisterSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_REG) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }


    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onRegisterSuccess() {
        _registerButton.setEnabled(true);
        Toast.makeText(getBaseContext(), "Register success", Toast.LENGTH_LONG).show();

        finish();
    }

    public void onRegisterFailed() {
        Toast.makeText(getBaseContext(), "Register failed", Toast.LENGTH_LONG).show();

        _registerButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (name.isEmpty()){
            _nameText.setError("enter a valid name");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }
}
