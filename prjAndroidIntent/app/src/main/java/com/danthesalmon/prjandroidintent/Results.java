package com.danthesalmon.prjandroidintent;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;


public class Results extends ActionBarActivity {

    // Declare variables
    String randPool = "";
    private static final int PASSWORD_LENGTH = 10; //TODO Hardcode this for now but make option

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Get the intent that spawned this activity.
        Intent mainActivityIntent = getIntent();
        // Get the information from sent to us through the intent from MainActivity
        randPool = mainActivityIntent.getStringExtra("pool");
        // Log it to see if we get the right data sent through
        Log.d(MainActivity.TAG,"[Results] Pool: " + randPool);
        Log.d(MainActivity.TAG, "[Results] Random Password: " + generateRandStr(PASSWORD_LENGTH,randPool));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // Reference our textview so we can change the properties of it.
        final TextView tvPassword = (TextView) findViewById(R.id.tvPassword);

        // Set the text of tvPassword to the result of generating a new random string
        tvPassword.setText(generateRandStr(PASSWORD_LENGTH, randPool));
    }




    static Random rndGen = new Random();
    /**
     *  generateRandStr() - The function that does the generating.
     *  @param length - How many characters long we want the string to be.
     *  @param charList - The allowed charactes to generate the string from.
     * @return randStr - The random string at the specified length.
     *
     */
    public String generateRandStr(int length,String charList) {

        // Create a new StringBuffer with capacity @param:length
        StringBuffer sbRandString = new StringBuffer(length);

        // Until the StringBuffer is filled to capacity, do the following
        for (int i=0; i<length; i++) {
            // Get the character from charList at location specified by a random number
            char randChar = charList.charAt(rndGen.nextInt(charList.length()));
            // Add this random char to the StringBuffer
            sbRandString.append(randChar);
        }
        // Return the randomly generated string.
        return sbRandString.toString();
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
