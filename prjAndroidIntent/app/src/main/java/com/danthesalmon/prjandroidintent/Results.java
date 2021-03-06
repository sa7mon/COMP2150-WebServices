package com.danthesalmon.prjandroidintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class Results extends ActionBarActivity {

    // Declare variables
    String randPool = "";
    private static final int PASSWORD_LENGTH = 10; //TODO Hardcode this for now but make option
    EditText etUrl;
    Button btnNavigate;

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
        final TextView etPassword = (TextView) findViewById(R.id.etPassword);

        // Set the text of tvPassword to the result of generating a new random string
        etPassword.setText(generateRandStr(PASSWORD_LENGTH, randPool));

        // Make connection to the editText and button so later we can get the value.
        etUrl = (EditText)findViewById(R.id.etUrl);
        etUrl.setText("http://www.google.com/");
        btnNavigate = (Button)findViewById(R.id.btnNavigate);

        btnNavigate.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        // Do something on click.

                        // 1. Create intent
                        Intent iNavigate = new Intent(Intent.ACTION_VIEW);
                        // 2. Give it the data it needs (url)
                        iNavigate.setData(Uri.parse(etUrl.getText().toString()));
                        // 3. Start the activity
                        startActivity(iNavigate);
                    }
                }
        );
    }

    /**
     *  generateRandStr() - The function that does the generating.
     *  @param length - How many characters long we want the string to be.
     *  @param charList - The allowed charactes to generate the string from.
     * @return randStr - The random string at the specified length.
     *
     */
    private String generateRandStr(int length,String charList) {

        // Instantiate a new Random object. It will give us random ints with a specified ceiling.
        Random rndGen = new Random();

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
