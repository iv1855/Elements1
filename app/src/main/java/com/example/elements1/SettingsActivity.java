package com.example.elements1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    private EditText txt_Color;
    private EditText txt_Size;
    private EditText txt_QtyHorizontal;
    private EditText txt_QtyVertical;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        txt_Color = findViewById(R.id.editText_Color);
        txt_Size = findViewById(R.id.editText_Size);
        txt_QtyHorizontal = findViewById(R.id.editText_QtyHorizontal);
        txt_QtyVertical = findViewById(R.id.editText_QtyVertical);
    }

    public void saveSettings(View view) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        int i = Integer.parseInt(txt_Color.getText().toString());
        preferences.edit().putInt(getString(R.string.key_Color), i).apply();

        i = Integer.parseInt(txt_Size.getText().toString());
        preferences.edit().putInt(getString(R.string.key_Size), i).apply();

        i = Integer.parseInt(txt_QtyVertical.getText().toString());
        preferences.edit().putInt(getString(R.string.key_QtyVert), i).apply();

        i = Integer.parseInt(txt_QtyHorizontal.getText().toString());
        preferences.edit().putInt(getString(R.string.key_QtyHoriz), i).apply();


    }
}