package com.denofdevelopers.blogsnackbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    ViewGroup rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootLayout = findViewById(R.id.rootLayout);
        ButterKnife.bind(this);

        Button simpleSnackBar = findViewById(R.id.simpleSnackBar);
        simpleSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(rootLayout, "This is simple SnackBar", Snackbar.LENGTH_SHORT).show();
            }
        });

        Button buttonSnackBar = findViewById(R.id.buttonSnackBar);
        buttonSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(rootLayout, "This is SnackBar with button", Snackbar.LENGTH_LONG).setAction("Button", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Do your stuff
                        // Automatic dismiss when button clicked
                        // Default color of the button text is your colorAccent
                        Toast.makeText(MainActivity.this, "Button clicked!", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

        Button customSnackBar = findViewById(R.id.customSnackBar);
        customSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(rootLayout, "This is custom SnackBar", Snackbar.LENGTH_LONG)
                        .setAction("Button", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                // Do your stuff
                                // Automatic dismiss when button clicked
                                Toast.makeText(MainActivity.this, "Button clicked!", Toast.LENGTH_SHORT).show();
                            }
                        });
                snackbar.setActionTextColor(Color.WHITE);
                View snackBarView = snackbar.getView();
                TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        });
    }
}
