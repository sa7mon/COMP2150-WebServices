package com.danthesalmon.prjandroidintent;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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
                    System.out.println("chkLowercase: checked.");
                    strPool = strPool.concat(LOWER_LETTERS);
                } else {
                    //Checkbox is not checked.
                    System.out.println("chkLowercase: unchecked.");
                    strPool = strPool.replace(LOWER_LETTERS, "");
                }
                System.out.println("strPool: " + strPool);
                break;
            case R.id.chkUppercase:
                if (isChecked) {
                    // chkUppercase has been checked.
                    System.out.println("chkUppercase: checked.");
                    strPool = strPool.concat(UPPER_LETTERS);
                } else {
                    System.out.println("chkUppercase: unchecked.");
                    strPool = strPool.replace(UPPER_LETTERS, "");
                }
                System.out.println("strPool: " + strPool);
                break;
            case R.id.chkNumbers:
                if (isChecked) {
                    // chkNumbers has been checked.
                    System.out.println("chkNumbers: checked.");
                    strPool = strPool.concat(NUMBERS);
                } else {
                    // chkNumbers has been unchecked.
                    System.out.println("chkNumbers: unchecked");
                    strPool = strPool.replace(NUMBERS, "");
                }
                System.out.println("strPool: " + strPool);
                break;
            case R.id.chkSymbols:
                if (isChecked) {
                    // chkSymbols has been checked.
                    System.out.println("chkSymbols: checked.");
                    strPool = strPool.concat(SYMBOLS);
                } else {
                    // chkSymbols has been unchecked
                    System.out.println("chkSymbols: unchecked");
                    strPool = strPool.replace(SYMBOLS, "");
                }
                System.out.println("strPool: " + strPool);
                break;
        }
    }

    public void clickGenerate(View view) {
        // Tell Java which activity we want to launch
        Intent generateIntent = new Intent(this,Results.class);
        // Switch screens just like we told it above.
        startActivity(generateIntent);
    }
}
