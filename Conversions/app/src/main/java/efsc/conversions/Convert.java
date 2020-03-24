package efsc.conversions;

import java.text.DecimalFormat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;



public class Convert extends AppCompatActivity
{

    private Spinner convertSpinner;
    private EditText convertEdit;
    private TextView descriptA;
    private TextView descriptB;
    private TextView converted;

    private String convertedString;
    private double convertedDouble;
    private double convertedFinal;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        addItemsOnConvertSpinner();
        addListenerToConvertSpinner();
        convertEdit = (EditText) findViewById(R.id.convertEdit);
        descriptA = (TextView) findViewById(R.id.descriptA);
        descriptB = (TextView) findViewById(R.id.descriptB);
        converted = (TextView) findViewById(R.id.converted);



    }

    public void addItemsOnConvertSpinner() {
        Spinner convertSpinner = (Spinner) findViewById(R.id.convertSpinner);

        ArrayAdapter<CharSequence> convertSpinnerAdapter =
                ArrayAdapter.createFromResource(this,
                        R.array.conv_Types,
                        android.R.layout.simple_spinner_item);

        convertSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        convertSpinner.setAdapter(convertSpinnerAdapter);
    }

    public void addListenerToConvertSpinner()
    {
        convertSpinner = (Spinner) findViewById(R.id.convertSpinner);

        convertSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l)
            {
                DecimalFormat decimal = new DecimalFormat("#.0000");

                String itemSelectedSpinner = parent.getItemAtPosition(position).toString();
                switch (position) {
                    case 0:

                        descriptA.setText("Miles");
                        descriptB.setText("Kilometers");
                        convertedString = convertEdit.getText().toString();
                        if (convertedString.equals("")) {
                            convertedDouble = 0;
                        } else {
                            convertedDouble = Double.parseDouble(convertedString);
                        }

                        convertedFinal = convertedDouble * 1.6093;

                        converted.setText(decimal.format(convertedFinal));
                        break;

                    case 1:
                        descriptA.setText("Kilometers");
                        descriptB.setText("Miles");
                        convertedString = convertEdit.getText().toString();
                        if (convertedString.equals("")) {
                            convertedDouble = 0;
                        } else {
                            convertedDouble = Double.parseDouble(convertedString);
                        }

                        convertedFinal = convertedDouble * 0.6214;

                        converted.setText(decimal.format(convertedFinal));
                        break;
                    case 2:
                        descriptA.setText("Inches");
                        descriptB.setText("Centimeters");
                        convertedString = convertEdit.getText().toString();
                        if (convertedString.equals("")) {
                            convertedDouble = 0;
                        } else {
                            convertedDouble = Double.parseDouble(convertedString);
                        }

                        convertedFinal = convertedDouble * 2.5400;

                        converted.setText(decimal.format(convertedFinal));
                        break;
                    case 3:
                        descriptA.setText("Centimeters");
                        descriptB.setText("Inches");
                        convertedString = convertEdit.getText().toString();
                        if (convertedString.equals("")) {
                            convertedDouble = 0;
                        } else {
                            convertedDouble = Double.parseDouble(convertedString);
                        }

                        convertedFinal = convertedDouble * 0.3937;

                        converted.setText(decimal.format(convertedFinal));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
