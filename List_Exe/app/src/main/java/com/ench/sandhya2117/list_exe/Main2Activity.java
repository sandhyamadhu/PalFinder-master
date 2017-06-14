package com.ench.sandhya2117.list_exe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv=(TextView) findViewById(R.id.textView2) ;

        String ab=getIntent().getStringExtra("abc");
        String abb=getIntent().getStringExtra("acb");
        tv.setText(ab+" "+abb);


    }

}
