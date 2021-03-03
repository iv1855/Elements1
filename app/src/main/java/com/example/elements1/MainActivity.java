package com.example.elements1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView lblQtyHorizontal;
    private TextView lblQtyVertical;
    private TextView txtColor;
    private TextView txtSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblQtyHorizontal = findViewById(R.id.txt_QtyHorizontal);
        lblQtyVertical = findViewById(R.id.txt_QtyVertical);
        txtColor = findViewById(R.id.txt_Color);
        txtSize = findViewById(R.id.txt_Size);

    }

    public void showSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
   }

    public void showResult(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

    private void setFromSavedData() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        Integer i = preferences.getInt("qtyHorizontal", 0);
        lblQtyHorizontal.setText(String.format(getString(R.string.qty_Horizontal), i));

        i = preferences.getInt("qtyVertical", 0);
        lblQtyVertical.setText(String.format(getString(R.string.qty_Vertical), i));

        i = preferences.getInt("Size", 0);
        txtSize.setText(String.format(getString(R.string.title_Size), i));

        i = preferences.getInt("Color", 0);
        txtColor.setText(String.format(getString(R.string.title_Color), i));








    }


}