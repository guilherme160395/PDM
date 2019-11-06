package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityExercicio11_2 extends AppCompatActivity {

    private DatabaseHelper helper;
    private EditText modelo, valor, ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio11_2);

        modelo = (EditText) findViewById(R.id.editTextModelo);
        ano = (EditText) findViewById(R.id.editTextAno);
        valor = (EditText) findViewById(R.id.editTextValor);

        helper = new DatabaseHelper(getApplicationContext());
    }

    public void salvarCarro(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("modelo", modelo.getText().toString());
        values.put("ano", Integer.parseInt(ano.getText().toString()));
        values.put("valor", Double.parseDouble(valor.getText().toString()));

        long resultado = db.insert("carro", null, values);
    }
}
