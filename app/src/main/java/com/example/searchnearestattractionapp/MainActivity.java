package com.example.searchnearestattractionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.mapview.MapView;

public class MainActivity extends AppCompatActivity
{
    private Button btnOpenMap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        MapKitFactory.setApiKey("d58a2804-a32b-4d6d-800c-a0f26eede847");
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews()
    {
        btnOpenMap = findViewById(R.id.btn_open_map);
        btnOpenMap.setOnClickListener(v -> {
            Intent intent = new Intent(this, MapAct.class);
            startActivity(intent);
        });
    }


}