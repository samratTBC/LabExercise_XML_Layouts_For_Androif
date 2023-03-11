package com.example.labexercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button calculate_btn;
    private RadioGroup selected_rg;
    private EditText value_et;

    private TextView resultMeasurement;
    private Switch switch_option_one, switch_option_two, switch_option_three, switch_option_four;
    private RadioButton option_one, option_two, option_three, option_four;

    private boolean checked_one = false, checked_two=false, checked_three=false, checked_four =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value_et = findViewById(R.id.measurement_et);
        selected_rg=findViewById(R.id.measurement_options_rg);
        calculate_btn = findViewById(R.id.calculate_btn);
        resultMeasurement = findViewById(R.id.result_measurement_tv);

        switch_option_one = findViewById(R.id.switch_option_one);
        switch_option_two = findViewById(R.id.switch_option_two);
        switch_option_three = findViewById(R.id.switch_option_three);
        switch_option_four = findViewById(R.id.switch_option_four);

        option_one = findViewById(R.id.ml_fluid_ounces_option);
        option_two = findViewById(R.id.grams_to_cups_option);
        option_three = findViewById(R.id.cups_to_tbsp_option);
        option_four = findViewById(R.id.cups_to_ml_option);

        CompoundButton.OnCheckedChangeListener switchListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    if (compoundButton == switch_option_one) {
                        switch_option_two.setChecked(false);
                        switch_option_three.setChecked(false);
                        switch_option_four.setChecked(false);

                        checked_one=true;
                        option_one.setText(R.string.ml_fluid_ounces_option);
                    }
                    else if (compoundButton == switch_option_two) {
                        switch_option_one.setChecked(false);
                        switch_option_three.setChecked(false);
                        switch_option_four.setChecked(false);

                        checked_two=true;
                        option_two.setText(R.string.cups_to_grams_option);
                    }
                    else if (compoundButton == switch_option_three) {
                        switch_option_one.setChecked(false);
                        switch_option_two.setChecked(false);
                        switch_option_four.setChecked(false);

                        checked_three=true;
                        option_three.setText(R.string.tbsp_to_cups_option);
                    }
                    else {
                        switch_option_one.setChecked(false);
                        switch_option_two.setChecked(false);
                        switch_option_three.setChecked(false);

                        checked_four=true;
                        option_four.setText(R.string.ml_to_cups_option);
                    }
                }
                else
                {
                    if (compoundButton == switch_option_one) {
                        option_one.setText(R.string.ounces_fluid_ml_option);
                        checked_one=false;
                    } else if (compoundButton == switch_option_two) {
                        option_two.setText(R.string.grams_to_cups_option);
                        checked_two=false;
                    } else if (compoundButton == switch_option_three) {
                        checked_three=false;
                        option_three.setText(R.string.cups_to_tbsp_option);
                    } else {
                        checked_four =false;
                        option_four.setText(R.string.cups_to_ml_option);
                    }
                }
            }
        };

        switch_option_one.setOnCheckedChangeListener(switchListener);
        switch_option_two.setOnCheckedChangeListener(switchListener);
        switch_option_three.setOnCheckedChangeListener(switchListener);
        switch_option_four.setOnCheckedChangeListener(switchListener);
        calculate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioChecked = selected_rg.getCheckedRadioButtonId();

                try {
                    switch (radioChecked) {
                        case R.id.cups_to_ml_option:
                            if(checked_one)
                                resultMeasurement.setText(String.valueOf(Double.parseDouble(value_et.getText().toString())*29.57));
                            else
                                resultMeasurement.setText(String.valueOf(Double.parseDouble(value_et.getText().toString())/29.57));
                            break;
                        case R.id.cups_to_tbsp_option:
                            if(checked_one)
                                resultMeasurement.setText(String.valueOf(Double.parseDouble(value_et.getText().toString())*16));
                            else
                                resultMeasurement.setText(String.valueOf(Double.parseDouble(value_et.getText().toString())/16));
                            break;
                        case R.id.grams_to_cups_option:
                            if(checked_one)
                                resultMeasurement.setText(String.valueOf(Double.parseDouble(value_et.getText().toString())*250));
                            else
                                resultMeasurement.setText(String.valueOf(Double.parseDouble(value_et.getText().toString())/250));
                            break;
                        case R.id.ml_fluid_ounces_option:
                            if(checked_one)
                                resultMeasurement.setText(String.valueOf(Double.parseDouble(value_et.getText().toString())*0.033814));
                            else
                                resultMeasurement.setText(String.valueOf(Double.parseDouble(value_et.getText().toString())/0.033814));
                            break;
                    }
                }catch(Exception e)
                {
                    Toast.makeText(MainActivity.this, "Please enter measurement.", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}