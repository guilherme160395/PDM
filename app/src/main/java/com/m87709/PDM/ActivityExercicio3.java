package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityExercicio3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio3);
    }

    public void questao_1(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityExercicio3_2.class);
        startActivity(intent);
    }

    public void questao_2(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityExercicio3_3.class);
        startActivity(intent);
    }

    public void questao_3(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityExercicio3_4.class);
        startActivity(intent);
    }

    public void questao_4(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityExercicio3_5.class);
        startActivity(intent);
    }

}
