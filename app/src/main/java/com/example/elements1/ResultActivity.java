package com.example.elements1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class ResultActivity extends AppCompatActivity {

    private int size;
    private int color;
    private int qty_H;
    private int qty_V;

    private TextView txtViewAllData;
    private ConstraintLayout mainConstrLayout;
    private View view3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtViewAllData = findViewById(R.id.txtView_AllData);
        mainConstrLayout = findViewById(R.id.MainConstraintLayout);
        view3 = findViewById(R.id.view3 );

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
        txtViewAllData.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
//                Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show();
//                makeAllElements(size, color, qty_H, qty_V);
                makeOneElement();
            }
        });

        txtViewAllData.setText(s);
        int colorWithAlfa = 0xFF000000 + color;
        txtViewAllData.setBackgroundColor(colorWithAlfa);
    }

    private void makeAllElements(int size, int color, int qtyH, int qtyV) {

        int colorWithAlfa = 0xFF000000 + color;
        ConstraintSet set = new ConstraintSet();

//        Creation
        Button myBtn = new Button(this);

//        SetProperties
//        id
        myBtn.setId(100 * 1 + 1);
//        backgrColor
        myBtn.setBackgroundColor(colorWithAlfa + 10000 * 1);
//        text
        myBtn.setText("1");





//        Toast.makeText(getApplicationContext(), "MakeElements!", Toast.LENGTH_SHORT).show();
//        Configuration configuration = this.getResources().getConfiguration();
//        int width = configuration.screenWidthDp;
//        int height = configuration.screenHeightDp;
//
//        View[][] arrViews = new View[qtyH][qtyV];
//        Context context = getApplicationContext();
//        ConstraintSet constraintSet = new ConstraintSet();
//
//        for (int i = 0; i < qtyH; i++) {
//            for (int j = 0; j < qtyV; j++) {
//                View v = new View(context);
//                int currID = i * 100 + j;
//                v.setId(currID);
//                v.setBackgroundColor(0xFF000000 + color + currID * 10000);
//                ViewGroup.LayoutParams layoutParams = new LayoutParams(size, size);
//                //LayoutParams layoutParams = v.getLayoutParams();
////                layoutParams.width = size;
////                layoutParams.height = size;
//                v.setLayoutParams(layoutParams);
//                arrViews[i][j] = v;
//                mainConstrLayout.addView(v);
//          }
//       }
//
//        //сделаем привязки
//        ConstraintSet set = new ConstraintSet();
//
//        for (int i = 0; i <= arrViews.length; i++) {
//            for (int j = 0; j <= arrViews[0].length; j++) {
//                if (i == 0 && j == 0) {
//                    set.connect(arrViews[i][j].getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
//                }
//            }
//        }
//        set.applyTo(mainConstrLayout);
    }

    private void makeOneElement() {
//        Context context = getApplicationContext();
//
//        View view4 = new View(context);
//        view4.setBackgroundColor(Color.RED);
//
//        mainConstrLayout.addView(view4);

        Button myBtn = new Button(this);
        View v1 = new View(this);

        mainConstrLayout.addView(myBtn);
        mainConstrLayout.addView(v1);


        v1.setId(22);


        myBtn.setId(R.id.myBtnId);
        myBtn.setText("Press me!");
        myBtn.setBackgroundColor(Color.YELLOW);

        ConstraintSet set = new ConstraintSet();
        set.constrainHeight(myBtn.getId(), ConstraintSet.WRAP_CONTENT);
        set.constrainWidth(myBtn.getId(), ConstraintSet.WRAP_CONTENT);

        set.connect(myBtn.getId(), ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
        set.connect(myBtn.getId(), ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
        set.connect(myBtn.getId(), ConstraintSet.TOP,
                ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0);
        set.connect(myBtn.getId(), ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);

        set.applyTo(mainConstrLayout);




    }


}