package com.imbang.beta;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class buatakun2 extends AppCompatActivity {

    ImageView iv;
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ba2);

        iv = (ImageView) findViewById(R.id.login_google);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(buatakun2.this, g_login.class);
                startActivity(i);
            }
        });

        tv = (TextView) findViewById(R.id.mari_masuk);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(buatakun2.this, buatakun.class);
                startActivity(i);
            }
        });

        btn = (Button) findViewById(R.id.buttonLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(buatakun2.this, loading1.class);
                startActivity(i);
            }
        });
    }
}
