package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityExercicio2 extends AppCompatActivity {

    private final String tag = "Log Guilherme";
    private Button botao;
    private EditText texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio2);

        Log.d(tag, "onCreate");

        botao = (Button) findViewById(R.id.btnConverter);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto = (EditText) findViewById(R.id.etTemperaturaCelsius);
                String temperaturaCelsius = texto.getText().toString();
                Log.d(tag, "temperaturaCelsius = " + temperaturaCelsius);

                Intent intent = new Intent(getApplicationContext(), ActivityExercicio2_2.class);
                intent.putExtra("tempC", temperaturaCelsius);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(tag, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(tag, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(tag, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(tag, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(tag, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(tag, "onDestroy");
    }
}
