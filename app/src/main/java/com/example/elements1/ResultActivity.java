package com.example.elements1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private int Size;
    private int Color;
    private int qty_H;
    private int qty_V;

    private TextView txtViewAllData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtViewAllData = findViewById(R.id.txtView_AllData);

        Intent intent = getIntent();
        if (intent.hasExtra(getString(R.string.key_QtyVertical))
            && intent.hasExtra(getString(R.string.key_QtyHorizontal))
            && intent.hasExtra(getString(R.string.key_Color))
            && intent.hasExtra(getString(R.string.key_Size)))
        {
            Size = intent.getIntExtra(getString(R.string.key_Size), 0);
            Color = intent.getIntExtra(getString(R.string.key_Color), 0);
            qty_H = intent.getIntExtra(getString(R.string.key_QtyHorizontal), 0);
            qty_V = intent.getIntExtra(getString(R.string.key_QtyVertical), 0);
        }

        String s = String.format(getString(R.string.txtAllData), Size, Color, qty_H, qty_V);
        txtViewAllData.setText(s);
        int ColorWithAlfa = 0xFF000000 + Color;
        txtViewAllData.setBackgroundColor(ColorWithAlfa);
    }
}