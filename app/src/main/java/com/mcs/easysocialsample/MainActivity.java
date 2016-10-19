package com.mcs.easysocialsample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.mcs.easysocial.RateDialog;

import static com.mcs.easysocial.RateDialog.DIALOG_ONCLICK_NEGATIVE;
import static com.mcs.easysocial.RateDialog.DIALOG_ONCLICK_NEUTRAL;
import static com.mcs.easysocial.RateDialog.DIALOG_ONCLICK_POSITIVE;

public class MainActivity extends AppCompatActivity implements RateDialog.RateDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = MainActivity.this.getSupportFragmentManager();
                RateDialog rateDialog = RateDialog.newInstance(
                        R.style.AppCompatAlertDialogStyle,
                        "My title!",
                        "Please rate my app on google play!",
                        "no internet connection...bummer.",
                        "Okay",
                        "NO!",
                        "dismiss"
                );
                rateDialog.show(fm, "rateDialog!");
            }
        });
    }

    @Override
    public void handleRateDialogListener(String onClick) {

        if(onClick.equals(DIALOG_ONCLICK_POSITIVE)){
            Log.w("rateDialog: ", "positive button was clicked!");
        }
        else if(onClick.equals(DIALOG_ONCLICK_NEGATIVE)){
            Log.w("rateDialog: ", "negative button was clicked!");
        }
        else if(onClick.equals(DIALOG_ONCLICK_NEUTRAL)){
            Log.w("rateDialog: ", "neutral button was clicked!");
        }
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
}
