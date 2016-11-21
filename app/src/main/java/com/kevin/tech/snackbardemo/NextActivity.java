package com.kevin.tech.snackbardemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.CollapsibleActionView;
import android.view.View;
import android.widget.Button;

/**
 * Created by Kevin on 2016/11/21.
 * Blog:http://blog.csdn.net/student9128
 * Describe：the NextActivity
 */
public class NextActivity extends AppCompatActivity {
    private CoordinatorLayout mCoordinatorLayout;
    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coorinator_layout);
        mButton = (Button) findViewById(R.id.btn_snack_bar);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(mCoordinatorLayout, "Click the Button", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
