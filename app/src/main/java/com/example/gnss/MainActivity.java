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
                TextView t = findViewById(R.id.i_value);

                Integer x = Integer.parseInt(t.getText().toString());
                x +=1;
                t.setText(Integer.toString(x));

                TextView f = findViewById(R.id.fib);
                f.setText(fib(x).toString());
            }
        });

        // onClick for button2 (down)
        Button bt2 = (Button)findViewById(R.id.button3);
        bt2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView t = findViewById(R.id.i_value);

                Integer x = Integer.parseInt(t.getText().toString());
                x -=1;
                t.setText(Integer.toString(x));

                TextView f = findViewById(R.id.fib);
                f.setText(fib(x).toString());
            }
        });
    }

    // Fibonacci sequence implementation
    public Integer fib(Integer i) {
        if (i < 1)
            return 0;
        if (i == 1)
            return 1;
        return fib(i - 2) + fib(i -1);
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
