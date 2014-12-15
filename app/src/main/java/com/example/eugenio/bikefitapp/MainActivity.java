package com.example.eugenio.bikefitapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;




public class MainActivity extends ActionBarActivity {


//http://www.sanfoundry.com/java-android-program-demonstrate-tip-calculator


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText cav = (EditText) findViewById(R.id.valor_cavalo);
        final TextView tamanho_mtb = (TextView) findViewById(R.id.valor_mtb);
        final TextView tamanho_speed = (TextView) findViewById(R.id.valor_speed);

        Button calc = (Button) findViewById(R.id.button_calc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double cavalo = Double.parseDouble(cav.getText().toString());
                double tam_mtb = cavalo * 0.226;
                double  tam_spd = cavalo * 0.665;


                tamanho_mtb.setText("Tamanho MTB: " + Double.toString(tam_mtb));
                tamanho_speed.setText("Tamanho Speed: " + Double.toString(tam_spd));

            }
        });

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
