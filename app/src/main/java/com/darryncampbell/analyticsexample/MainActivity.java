package com.darryncampbell.analyticsexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Logged event for floating button", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Bundle bundle = new Bundle();
                mFirebaseAnalytics.logEvent("click_action_button", bundle);
            }
        });

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1: {
                Bundle bundle = new Bundle();
                bundle.putString("button_property_1", "fred");
                mFirebaseAnalytics.logEvent("click_button_1", bundle);
                Toast.makeText(this, "Logged event for Button 1", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.button2:
            {
                Bundle bundle = new Bundle();
                mFirebaseAnalytics.logEvent("click_button_2", bundle);
                Toast.makeText(this, "Logged event for Button 2", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.button3:
            {
                Bundle bundle = new Bundle();
                mFirebaseAnalytics.logEvent("click_button_3", bundle);
                Toast.makeText(this, "Logged event for Button 3", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
