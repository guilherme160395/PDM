package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityExercicio11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio11);
    }

    public void retrieve(View view) {

    }

    public void create(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityExercicio11_2.class);
        startActivity(intent);
    }
}
