package com.kevin.tech.snackbardemo;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mToast, mSnackBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToast = (Button) findViewById(R.id.btn_toast);
        mSnackBar = (Button) findViewById(R.id.btn_sanck_bar);
        mToast.setOnClickListener(this);
        mSnackBar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_toast:
                Toast.makeText(this, "Click the Toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_sanck_bar:
                final Snackbar snackbar = Snackbar.make(mSnackBar, "Click the SnackBar", Snackbar.LENGTH_SHORT);
                snackbar.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.orange));
                setSnackbarActionTextColor(snackbar, R.color.colorAccent);
                snackbar.setAction("hello", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        if (snackbar != null && snackbar.isShown()) {
//                            snackbar.dismiss();
//                        }
                        Snackbar snackbar1 = Snackbar.make(mSnackBar, "Click Cancel", Snackbar.LENGTH_SHORT);
                        setSnackbarMessageTextColor(snackbar1, ContextCompat.getColor(MainActivity.this, R.color.orange));
                        snackbar1.show();
                    }
                })
                        .setText("Hello")
                        .setActionTextColor(ContextCompat.getColor(this, R.color.colorAccent))
                        .show();
                break;
        }
    }

    public static void setSnackbarMessageTextColor(Snackbar snackbar, int color) {
        View view = snackbar.getView();
        TextView textView = (TextView) view.findViewById(R.id.snackbar_text);
        textView.setTextColor(color);
    }

    public static void setSnackbarActionTextColor(Snackbar snackbar, int color) {
        View view = snackbar.getView();
        TextView textView = (TextView) view.findViewById(R.id.snackbar_action);
        textView.setAllCaps(false);
        textView.setTextColor(color);
    }
}
