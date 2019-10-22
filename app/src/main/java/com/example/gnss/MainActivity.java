package com.example.gnss;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // onClick for button2 (up)
        Button bt1 = (Button)findViewById(R.id.button2);
        bt1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                setN(getN() + 1);

                calc();
            }
        });

        // onClick for button2 (down)
        Button bt2 = (Button)findViewById(R.id.button3);
        bt2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                if (getN()>1) {

                    setN(getN() - 1);

                    calc();
                }
            }
        });
    }

    private Integer getN() {
        TextView t = findViewById(R.id.i_value);

        return Integer.parseInt(t.getText().toString());
    }

    private void setN(Integer n) {
        TextView t = findViewById(R.id.i_value);
        t.setText(Integer.toString(n));
    }


    public boolean calc() {

        Integer n = Integer.parseInt(((TextView)findViewById(R.id.i_value)).getText().toString());

        FibAsyncTaskRunner fib = new FibAsyncTaskRunner();
        fib.debug = findViewById(R.id.debug);
        fib.pb = findViewById(R.id.progressBar2);
        fib.result = findViewById(R.id.fib);

        // Run the actual fibonacci calculation
        fib.execute(n);

        return true;
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
