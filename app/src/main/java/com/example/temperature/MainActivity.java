package com.example.temperature;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.temperature.R;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTemperature;
    private Button buttonConvert;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTemperature = findViewById(R.id.editTextTemperature);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        String temperatureStr = editTextTemperature.getText().toString();
        if (!temperatureStr.isEmpty()) {
            double temperature = Double.parseDouble(temperatureStr);
            double celsius = (temperature - 32) * 5 / 9;
            double kelvin = celsius + 273.15;
            textViewResult.setText("Celsius: " + celsius + "\nKelvin: " + kelvin);
        } else {
            textViewResult.setText("Please enter a temperature.");
        }
    }
}
