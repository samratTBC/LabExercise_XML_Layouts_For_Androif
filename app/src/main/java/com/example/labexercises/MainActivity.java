package com.example.labexercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText costOfService;
    private RadioGroup radiogroup;
    private Switch round_tip_switch;
    private Button calculate_button;

    private TextView tip_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        costOfService = findViewById(R.id.cost_of_service);
        radiogroup = findViewById(R.id.tip_options);
        calculate_button = findViewById(R.id.calculate_button);
        round_tip_switch = findViewById(R.id.round_up_switch);
        tip_text = findViewById(R.id.tip_result);

        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(costOfService.getText().toString()==null)
                {
                    Toast.makeText(MainActivity.this, "Enter tip to proceed.", Toast.LENGTH_LONG);
                }
                else
                {
                    int checkedId = radiogroup.getCheckedRadioButtonId();
                    double tip=0.0;
                    double costService= Double.parseDouble(costOfService.getText().toString());

                    switch (checkedId)
                    {
                        case R.id.option_eighteen_percent:
                            tip= 0.18 * costService;
                            break;
                        case R.id.option_fifteen_percent:
                            tip = 0.15 * costService;
                            break;
                        case R.id.option_twenty_percent:
                            tip= 0.20 * costService;
                            break;
                    }

                    Boolean isOn = round_tip_switch.isChecked();
                    if(isOn)
                        tip_text.setText(Integer.toString((int) Math.ceil(tip)));
                    else
                        tip_text.setText(Double.toString(tip));

                }
            }
        });

    }
}