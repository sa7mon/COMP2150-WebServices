package com.danthesalmon.labandroidtutorial;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    TextView mainTextView;
    Button mainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Access the TextView defined in activity_main.xml
        mainTextView = (TextView) findViewById(R.id.main_textview);
        mainTextView.setText("Set in the code!");

        //Access the Button defined in activity_main.xml and list for presses
        mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        mainTextView.setText("Button presssed!");
    }
}
