package com.example.elements1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class ResultActivity extends AppCompatActivity {

    private int size;
    private int color;
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
                && intent.hasExtra(getString(R.string.key_Size))) {
            size = intent.getIntExtra(getString(R.string.key_Size), 0);
            color = intent.getIntExtra(getString(R.string.key_Color), 0);
            qty_H = intent.getIntExtra(getString(R.string.key_QtyHorizontal), 0);
            qty_V = intent.getIntExtra(getString(R.string.key_QtyVertical), 0);
        }

        String s = String.format(getString(R.string.txtAllData), size, color, qty_H, qty_V);
        txtViewAllData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
//                Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show();
                makeAllElements(size, color, qty_H, qty_V);
            }
        });

        txtViewAllData.setText(s);
        int colorWithAlfa = 0xFF000000 + color;
        txtViewAllData.setBackgroundColor(colorWithAlfa);
    }

    private void makeAllElements(int size, int color, int qtyH, int qtyV) {

        Toast.makeText(getApplicationContext(), "MakeElements!", Toast.LENGTH_SHORT).show();



    }




}