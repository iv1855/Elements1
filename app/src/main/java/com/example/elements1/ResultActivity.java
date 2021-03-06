package com.example.elements1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ResultActivity extends AppCompatActivity {

    private int Size;
    private int Color;
    private int qty_H;
    private int qty_V;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        if (intent.hasExtra(getString(R.string.key_QtyVertical))
            && intent.hasExtra(getString(R.string.key_QtyHorizontal))
            && intent.hasExtra(getString(R.string.key_Color))
            && intent.hasExtra(getString(R.string.key_Size))) {
            Size = intent.getIntExtra(getString(R.string.key_Size), 0);
            Color = intent.getIntExtra(getString(R.string.key_Color), 0);
            qty_H = intent.getIntExtra(getString(R.string.key_QtyHorizontal), 0);
            qty_V = intent.getIntExtra(getString(R.string.key_QtyVertical), 0);
        }
    }
}