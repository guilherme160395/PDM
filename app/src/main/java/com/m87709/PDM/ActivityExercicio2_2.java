package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityExercicio2_2 extends AppCompatActivity {

    private TextView temperaturaFarenheit;
    private final String tag = "Guilherme Activity2_2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio2_2);

        temperaturaFarenheit = findViewById(R.id.tvTemperaturaFarenheit);

        Bundle extra = getIntent().getExtras();

        if(extra != null) {
            String temperaturaAntiga = String.valueOf(extra.getString("tempC")) ;

            Double temperaturaNova = Double.parseDouble(temperaturaAntiga);
            temperaturaNova = (temperaturaNova * 9)/5 + 32;
            temperaturaFarenheit.setText(String.valueOf(temperaturaNova));
        }
    }
}
