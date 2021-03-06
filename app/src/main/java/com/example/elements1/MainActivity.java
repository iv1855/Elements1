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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        setFromSavedData();

    }

    public void showSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
   }

    public void showResult(View view) {

        Intent intent = new Intent(this, ResultActivity.class);
        Pattern pattern = Pattern.compile("\\d+");
        String s;
        int i;

        Matcher matcher = pattern.matcher(txtSize.getText().toString());
        if (matcher.find()) {
            s = matcher.group();
        }else {
            s = "0";
        }
        i = Integer.parseInt(s);
        intent.putExtra(getString(R.string.key_Size), i);

        matcher = pattern.matcher(txtColor.getText().toString());
        if (matcher.find()) {
            s = matcher.group();
        } else {
            s = "0";
        }
        i = Integer.parseInt(s);
        intent.putExtra(getString(R.string.key_Color), i);

        matcher = pattern.matcher(lblQtyHorizontal.getText().toString());
        if (matcher.find()) {
            s = matcher.group();
        } else {
            s = "0";
        }
        i = Integer.parseInt(s);
        intent.putExtra(getString(R.string.key_QtyHorizontal), i);

        matcher = pattern.matcher(lblQtyVertical.getText().toString());
        if (matcher.find()) {
            s = matcher.group();
        } else {
            s = "0";
        }
        i = Integer.parseInt(s);
        intent.putExtra(getString(R.string.key_QtyVertical), i);

        startActivity(intent);
    }

    private void setFromSavedData() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        int i = preferences.getInt(getString(R.string.key_QtyHoriz), 0);
        lblQtyHorizontal.setText(String.format(getString(R.string.qty_Horizontal), i));

        i = preferences.getInt(getString(R.string.key_QtyVert), 0);
        lblQtyVertical.setText(String.format(getString(R.string.qty_Vertical), i));

        i = preferences.getInt(getString(R.string.key_Size), 0);
        txtSize.setText(String.format(getString(R.string.title_Size), i));

        i = preferences.getInt(getString(R.string.key_Color), 0);
        txtColor.setText(String.format(getString(R.string.title_Color), i));
        txtColor.setBackgroundColor(i);

    }


}