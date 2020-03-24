package project1.rectanglecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;


public class RectangleCalcActivity extends Activity
 implements OnEditorActionListener {

    private EditText weightAmountEditText;
    private EditText heightAmountEditText;
    private TextView weightTextView;
    private TextView heightTextView;
    private TextView areaTextView;
    private TextView perimeterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle_calc);

        weightAmountEditText = (EditText) findViewById(R.id.weightAmountEditText);
        heightAmountEditText = (EditText) findViewById(R.id.heightAmountEditText);
        weightTextView = (TextView) findViewById(R.id.weightTextView);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        areaTextView = (TextView) findViewById(R.id.areaTextView);
        perimeterTextView = (TextView) findViewById(R.id.perimeterTextView);

        weightAmountEditText.setOnEditorActionListener(this);
        heightAmountEditText.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEdtorAction(TextView v, int actionId, KeyEvent event) {

        if (actionId == EditorInfo.IME_ACTION_DONE ||
            actionId == EditorInfo.IME_ACTION_UNSPECIFIED)
        {

        }
    }
}
