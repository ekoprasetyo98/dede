package com.example.dedee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().hide();

        WebView admin = (WebView)findViewById(R.id.web_view);
        admin.loadUrl("https://admindede.000webhostapp.com/");
        admin.setWebChromeClient(new WebChromeClient());
    }
}
