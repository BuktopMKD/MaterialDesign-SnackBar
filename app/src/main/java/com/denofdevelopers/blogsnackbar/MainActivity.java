package com.denofdevelopers.blogsnackbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rootLayout)
    ViewGroup rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.simpleSnackBar})
    public void onSimpleSnackBarClick() {
        Snackbar.make(rootLayout, "This is simple SnackBar", Snackbar.LENGTH_SHORT).show();
    }

    @OnClick({R.id.buttonSnackBar})
    public void onButtonSnackBarClick() {
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

    @OnClick({R.id.customSnackBar})
    public void onCustomSnackBarClick() {
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
}
