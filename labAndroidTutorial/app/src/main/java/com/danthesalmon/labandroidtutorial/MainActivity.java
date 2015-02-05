package com.danthesalmon.labandroidtutorial;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    TextView mainTextView;
    Button mainButton;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();

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

        // Initialize the EditText element mainEditText
        mainEditText = (EditText) findViewById(R.id.main_edittext);

        // Initialize the ListView
        mainListView = (ListView) findViewById(R.id.main_listview);

        //Create an ArrayAdapter for the ListView
        mArrayAdapter = new ArrayAdapter(this,
                                        android.R.layout.simple_list_item_1,
                                        mNameList);

        // Set the ListView to use the ArrayAdapter
        mainListView.setAdapter(mArrayAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    // Event fired with button main_button is pressed.
    public void onClick(View v) {
       // Change the value of the textView
        mainTextView.setText(mainEditText.getText().toString()
                + " is learning Android development!");

        // Also, when the button is clicked add the name to the list
        mNameList.add(mainEditText.getText().toString());
        // Update the list with the new data.
        mArrayAdapter.notifyDataSetChanged();
    }
}
