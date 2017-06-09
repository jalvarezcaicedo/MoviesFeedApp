package com.example.jhonatanalvarezcaicedo.moviesfeedapp.view.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jhonatanalvarezcaicedo.moviesfeedapp.R;

/**
 * Created by jhonatanalvarezcaicedo on 8/06/17.
 */

public class InfoActivity extends AppCompatActivity {

    private FrameLayout container;
    private ImageView iPoster;
    private TextView desc;
    private TextView voteCount;
    private TextView isAdult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_layout);

        initComponents();
    }

    private void initComponents() {
        container = (FrameLayout) findViewById(R.id.container_info);
        iPoster = (ImageView) findViewById(R.id.poster_info);
        desc = (TextView) findViewById(R.id.desc_info);
        voteCount = (TextView) findViewById(R.id.votecount_info);
        isAdult = (TextView) findViewById(R.id.isadult_info);

        Glide.with(this)
                .load(getIntent().getStringExtra("poster"))
                .override(80, 150)
                .placeholder(R.color.colorAccent)
                .into(iPoster);

        desc.setText(getIntent().getStringExtra("desc"));
        voteCount.setTypeface(null, Typeface.BOLD);
        voteCount.setText("Vote count? " + getIntent().getIntExtra("votecount", 0));

        isAdult.setTypeface(null, Typeface.BOLD);
        isAdult.setText("is Adult content? " + String.valueOf(getIntent().getBooleanExtra("adult", true)));
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
