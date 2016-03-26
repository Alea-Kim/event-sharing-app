package com.eventsharing.watudu;

/**
 * Created by bcamillegrace on 26/03/2016.
 */

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Tablayout_Main extends TabActivity  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_main);

        TabHost tabHost = getTabHost();

        // Tab for Home
        TabSpec homespec = tabHost.newTabSpec("Home");
        // setting Title and Icon for the Tab
        homespec.setIndicator("Home", getResources().getDrawable(R.drawable.logo));
        Intent homeIntent = new Intent(this, MainActivity.class);
        homespec.setContent(homeIntent);

        // Tab for Log In
        TabSpec loginspec = tabHost.newTabSpec("Log In");
        // setting Title and Icon for the Tab
        loginspec.setIndicator("Log In", getResources().getDrawable(R.drawable.logo));
        Intent loginIntent = new Intent(this, ActivityLogin.class);
        loginspec.setContent(loginIntent);


        tabHost.addTab(homespec);
        tabHost.addTab(loginspec);

    }
}
