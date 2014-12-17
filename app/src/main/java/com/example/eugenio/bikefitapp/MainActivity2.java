package com.example.eugenio.bikefitapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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

//facebook part

class FacebookActivity extends MainActivity2 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        ImageButton f = (ImageButton)findViewById(R.id.button_facebook);
        f.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View arg0)
            {
                // Get the intent
                Intent intent = getFBIntent(FacebookActivity.this, "1412890208976177");

                // Start the activity
                if (intent != null)
                    startActivity(intent);
            }
        });
    }

    /**
     * Get the facebook intent for the given facebook
     * profile id. If the facebook app is installed, then
     * it will open the facebook app. Otherwise, it will
     * open the facebook profile page in browser.
     *
     * @return - the facebook intent
     */
    private Intent getFBIntent(Context context, String facebookId) {

        try {
            // Check if FB app is even installed
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);

            String facebookScheme = "fb://profile/" + facebookId;
            return new Intent(Intent.ACTION_VIEW, Uri.parse(facebookScheme));
        }
        catch(Exception e) {

            // Cache and Open a url in browser
            String facebookProfileUri = "https://www.facebook.com/" + facebookId;
            return new Intent(Intent.ACTION_VIEW, Uri.parse(facebookProfileUri));
        }

        return null;
    }
}