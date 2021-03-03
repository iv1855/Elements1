package com.example.elements1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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



    }
}