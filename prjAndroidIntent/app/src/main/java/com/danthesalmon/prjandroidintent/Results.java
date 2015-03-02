package com.danthesalmon.prjandroidintent;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class Results extends ActionBarActivity {

    // Declare variables
    String randPool = "";
    private static final int PASSWORD_LENGTH = 10; //TODO Hardcode this for now but make option

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // Get the intent that spawned this activity.
        Intent mainActivityIntent = getIntent();
        // Get the information from sent to us through the intent from MainActivity
        randPool = mainActivityIntent.getStringExtra("pool");
        // Log it to see if we get the right data sent through
        Log.d(MainActivity.TAG,"[Results] Pool: " + randPool);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results, menu);
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
}
