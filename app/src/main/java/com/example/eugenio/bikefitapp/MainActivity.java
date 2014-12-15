package com.example.eugenio.bikefitapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

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


                // para fazer o aplicativo nao dar erro e exibir o toast

                String text = cav.getText().toString();

                if(text.equals("")) {

                    Toast.makeText(MainActivity.this, getResources().getString(R.string.erro), Toast.LENGTH_LONG).show();
                    return;
                }

                // continuando o calculo

                double cavalo = Double.parseDouble(cav.getText().toString());
                double tam_mtb = cavalo * 0.226; // fator da mbt
                double tam_spd = cavalo * 0.665; // fator da speed

                tamanho_mtb.setText("MTB: " + Double.toString(Math.round(tam_mtb))); //exibiçao do resultado ARREDONDADO
                tamanho_speed.setText("Speed: " + Double.toString(Math.round(tam_spd))); // exibiçao do resultado ARREDONDADO
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
