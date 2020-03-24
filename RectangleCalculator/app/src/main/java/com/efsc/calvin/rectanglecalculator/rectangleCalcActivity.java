package com.efsc.calvin.rectanglecalculator;

import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class rectangleCalcActivity extends AppCompatActivity
        implements OnEditorActionListener {

    private TextView widthTextView;
    private TextView heightTextView;
    private TextView areaTextView;
    private TextView perimeterTextView;
    private EditText widthEditText;
    private EditText heightEditText;
    private TextView areaCalcTextView;
    private TextView perimeterCalcTextView;
    private String widthString = "";
    private String heightString = "";

    private SharedPreferences savedValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle_calc);

        widthTextView = (TextView) findViewById(R.id.widthTextView);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        areaTextView = (TextView) findViewById(R.id.areaTextView);
        perimeterTextView = (TextView) findViewById(R.id.perimeterTextView);
        widthEditText = (EditText) findViewById(R.id.widthEditText);
        heightEditText = (EditText) findViewById(R.id.heightEditText);
        areaCalcTextView = (TextView) findViewById(R.id.areaCalcTextView);
        perimeterCalcTextView = (TextView) findViewById(R.id.perimeterCalcTextView);

        heightEditText.setOnEditorActionListener(this);
        widthEditText.setOnEditorActionListener(this);

        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

    @Override
    public void onPause() {
        Editor editor = savedValues.edit();
        editor.putString("widthString", widthString);
        editor.putString("heightString", heightString);
        editor.commit();

        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        widthString = savedValues.getString("widthString", "");
        heightString = savedValues.getString("heightString", "");

        heightEditText.setText(heightString);
        widthEditText.setText(widthString);

        area_Perimeter_Calculation();
    }

    public void area_Perimeter_Calculation() {

        widthString = widthEditText.getText().toString();
        float width;
        if (widthString.equals("")) {
            width = 0;
        }
        else {
            width = Float.parseFloat (widthString);
        }
        heightString = heightEditText.getText().toString();
        float height;
        if (heightString.equals("")) {
            height = 0;
        }
        else {
            height = Float.parseFloat (heightString);
        }

        float area = width * height;
        float perimeter = (width * 2) + (height * 2);

        DecimalFormat decimal = new DecimalFormat("#.00");
        areaCalcTextView.setText(decimal.format(area));
        perimeterCalcTextView.setText(decimal.format(perimeter));
    }

    @Override
    public boolean onEditorAction (TextView v, int actionId, KeyEvent event) {

        if (actionId == EditorInfo.IME_ACTION_DONE)
        {
            area_Perimeter_Calculation();
        }
        return false;
    }

}
