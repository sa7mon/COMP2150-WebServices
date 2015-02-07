package com.danthesalmon.labandroidtutorial;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    TextView mainTextView;
    Button mainButton;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();
    ShareActionProvider mShareActionProvider;

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

        // Do something when items in the list are clicked
        mainListView.setOnItemClickListener(this);

        // The text you'd like to share has changed and you need to update
        setShareIntent();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Access the Share item defined in menu XML
        MenuItem shareItem = menu.findItem(R.id.menu_item_share);

        // Access the object responsible for putting together the sharing submenu
        if(shareItem != null){
            mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        }

        // Create an Intent to share your content
        setShareIntent();

        return true;
    }

    private void setShareIntent() {
        if(mShareActionProvider != null) {

            //Create an Intent with the contents of the TextView
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Android Development");
            shareIntent.putExtra(Intent.EXTRA_TEXT, mainTextView.getText());

            // Make sure the provider knows it should work with that intent\
            mShareActionProvider.setShareIntent(shareIntent);
        }
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Log the item's position and contents to the console in Debug
        Log.d("omg android", position + ":" + mNameList.get(position));
    }
}
