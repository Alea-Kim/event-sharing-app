/*   Author:  Camille Bacister | Date: Feb 19, 2016  */

/*
* DEVELOPED BY: BACK UP
* CLIENT: MAAM ANNETTE (ITDC)
* Tab is used to create the bottom tab used to navigate through the app
*/

package com.eventsharing.watudu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class TAB extends AppCompatActivity {

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        TabHost host = (TabHost) findViewById(R.id.tabHost);
        host.setup();


        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("HOME");
        spec.setContent(R.id.tab1);
        spec.setIndicator("HOME");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("MY EVENT");
        spec.setContent(R.id.tab2);
        spec.setIndicator("MY EVENT");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("CREATE EVENT");
        spec.setContent(R.id.tab3);
        spec.setIndicator("CREATE EVENT");
        host.addTab(spec);

        //Tab 4
        spec = host.newTabSpec("OTHERS");
        spec.setContent(R.id.tab3);
        spec.setIndicator("OTHERS");
        host.addTab(spec);
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.tab3) {
            //startActivity(new Intent(this, CreateEvent.class));
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
}

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost host = (TabHost) findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Tab One");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Tab Two");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Tab Three");
        host.addTab(spec);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}*/