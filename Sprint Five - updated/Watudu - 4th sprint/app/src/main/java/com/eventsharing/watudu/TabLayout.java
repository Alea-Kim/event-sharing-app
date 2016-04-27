package com.eventsharing.watudu;

/**
 * Created by bcamillegrace on 25/03/2016.
 */

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabLayout extends TabActivity {
/*
    private void CreateTab(Type activityType, string tag, string label, int drawableId )
    {
        var intent = new Intent(this, activityType);
        intent.AddFlags(ActivityFlags.NewTask);

        var spec = TabHost.NewTabSpec(tag);
        var drawableIcon = Resources.GetDrawable(drawableId);
        spec.SetIndicator(label, drawableIcon);
        spec.SetContent(intent);

        TabHost.AddTab(spec);
    }
*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout);

        TabHost tabHost = getTabHost();

        // Tab for Home
        TabSpec homespec = tabHost.newTabSpec("Home");
        // setting Title and Icon for the Tab
        homespec.setIndicator("Home", getResources().getDrawable(R.drawable.logo));
        Intent homeIntent = new Intent(this, MainLogged.class);
        homespec.setContent(homeIntent);

        // Tab for My Events
        TabSpec myeventspec = tabHost.newTabSpec("My Events");
        // setting Title and Icon for the Tab
        myeventspec.setIndicator("My Events", getResources().getDrawable(R.drawable.logo));
        Intent myeventIntent = new Intent(this, EVENTS.class);
        myeventspec.setContent(myeventIntent);

        // Tab for Creatw Events
        TabSpec createeventspec = tabHost.newTabSpec("Create Event");
        // setting Title and Icon for the Tab
        createeventspec.setIndicator("Create Events", getResources().getDrawable(R.drawable.logo));
        Intent createeventIntent = new Intent(this, CreateEvent.class);
        createeventspec.setContent(createeventIntent);

        // Tab for Others
        TabSpec otherspec = tabHost.newTabSpec("Others");
        // setting Title and Icon for the Tab
        otherspec.setIndicator("Others", getResources().getDrawable(R.drawable.logo));
        Intent otherIntent = new Intent(this, MainLogged.class);
        otherspec.setContent(otherIntent);


        tabHost.addTab(homespec);
        tabHost.addTab(myeventspec);
        tabHost.addTab(createeventspec);
        tabHost.addTab(otherspec);
    }
}
