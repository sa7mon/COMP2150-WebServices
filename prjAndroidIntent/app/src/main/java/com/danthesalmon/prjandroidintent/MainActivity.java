package com.danthesalmon.prjandroidintent;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.content.Intent;



public class MainActivity extends ActionBarActivity {

    // Setup my variables
    final String LOWER_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    final String UPPER_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final String NUMBERS = "01234567989";
    final String SYMBOLS = "!@#$%^&*()-_=+[]{}|<>,.?";

    public static final String TAG = "PWDGEN";

    String strPool = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    //------------------------------ MY FUNCTIONS ----------------------------------
    public void onCheckboxClicked(View view) {
        // Check the state of the checkbox
        boolean isChecked = ((CheckBox) view).isChecked();

        // Figure out which checkbox was clicked
        switch(view.getId()) {
            case R.id.chkLowercase:
                if (isChecked) {
                    // Checkbox is checked.
                    Log.d(TAG, "chkLowercase: checked.");
                    strPool = strPool.concat(LOWER_LETTERS);
                } else {
                    //Checkbox is not checked.
                    Log.d(TAG,"chkLowercase: unchecked.");
                    strPool = strPool.replace(LOWER_LETTERS, "");
                }
                Log.d(TAG,"strPool: " + strPool);
                break;
            case R.id.chkUppercase:
                if (isChecked) {
                    // chkUppercase has been checked.
                    Log.d(TAG,"chkUppercase: checked.");
                    strPool = strPool.concat(UPPER_LETTERS);
                } else {
                    Log.d(TAG,"chkUppercase: unchecked.");
                    strPool = strPool.replace(UPPER_LETTERS, "");
                }
                Log.d(TAG,"strPool: " + strPool);
                break;
            case R.id.chkNumbers:
                if (isChecked) {
                    // chkNumbers has been checked.
                    Log.d(TAG,"chkNumbers: checked.");
                    strPool = strPool.concat(NUMBERS);
                } else {
                    // chkNumbers has been unchecked.
                    Log.d(TAG,"chkNumbers: unchecked");
                    strPool = strPool.replace(NUMBERS, "");
                }
                Log.d(TAG,"strPool: " + strPool);
                break;
            case R.id.chkSymbols:
                if (isChecked) {
                    // chkSymbols has been checked.
                    Log.d(TAG,"chkSymbols: checked.");
                    strPool = strPool.concat(SYMBOLS);
                } else {
                    // chkSymbols has been unchecked
                    Log.d(TAG,"chkSymbols: unchecked");
                    strPool = strPool.replace(SYMBOLS, "");
                }
                Log.d(TAG,"strPool: " + strPool);
                break;
        }
    }

    public void clickGenerate(View view) {
        // Tell Java which activity we want to launch
        Intent generateIntent = new Intent(this,Results.class);

        // Send the strPool string along to the other activity (Results).
        generateIntent.putExtra("pool",strPool);

        // Switch screens just like we told it above.
        startActivity(generateIntent);
    }
}
