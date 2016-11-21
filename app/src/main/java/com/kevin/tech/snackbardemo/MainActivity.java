package com.kevin.tech.snackbardemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Kevin on 2016/11/21.
 * Blog:http://blog.csdn.net/student9128
 * Describe：SnackBarDemo
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mToast, mSnackBar, mBtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToast = (Button) findViewById(R.id.btn_toast);
        mSnackBar = (Button) findViewById(R.id.btn_snack_bar);
        mBtnNext = (Button) findViewById(R.id.btn_next);
        mToast.setOnClickListener(this);
        mSnackBar.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_toast:
                Toast.makeText(this, "Click the Toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_snack_bar:
                final Snackbar snackbar = Snackbar.make(mSnackBar, "Click the SnackBar", Snackbar.LENGTH_SHORT);
                snackbar.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.orange));
                setSnackbarActionTextAllCaps(snackbar, false);
                snackbar.setAction("Cancel", new View.OnClickListener() {
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
                        .setText("Hello")//set the message text
                        .setActionTextColor(ContextCompat.getColor(this, R.color.colorAccent))
                        .show();
                break;
            case R.id.btn_next:
                startActivity(new Intent(this, NextActivity.class));
                break;
            default:
                break;
        }
    }

    /**
     * set the message text color
     *
     * @param snackbar
     * @param color    the text color
     */
    public static void setSnackbarMessageTextColor(Snackbar snackbar, int color) {
        View view = snackbar.getView();
        TextView textView = (TextView) view.findViewById(R.id.snackbar_text);
        textView.setTextColor(color);
    }

    /**
     * set the action text whether all caps
     *
     * @param snackbar the sanckbar
     * @param allCaps  boolean allCaps,true or false
     */
    public static void setSnackbarActionTextAllCaps(Snackbar snackbar, boolean allCaps) {
        View view = snackbar.getView();
        TextView textView = (TextView) view.findViewById(R.id.snackbar_action);
        textView.setAllCaps(allCaps);
    }
}
