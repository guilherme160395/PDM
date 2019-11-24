package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exercicio_1(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityExercicio1.class);
        startActivity(intent);
    }

    public void exercicio_2(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityExercicio2.class);
        startActivity(intent);
    }

    public void exercicio_3(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityExercicio3.class);
        startActivity(intent);
    }

    public void exercicio_4(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityExercicio4.class);
        startActivity(intent);
    }

    public void exercicio_7(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityExercicio7.class);
        startActivity(intent);

    }

    public void desafio(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityDesafio.class);
        startActivity(intent);
    }

    public void exercicio_10(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityExercicio10.class);
        startActivity(intent);
    }

    public void exercicio_11(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityExercicio11.class);
        startActivity(intent);
    }

}
