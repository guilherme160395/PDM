package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityExercicio11_3 extends AppCompatActivity {

    private String id;
    private DatabaseHelper helper;
    private TextView tvId;
    private EditText modelo, valor, ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio11_3);

        tvId = (TextView) findViewById(R.id.textViewId);
        modelo = (EditText) findViewById(R.id.editTextModelo);
        valor  = (EditText) findViewById(R.id.editTextValor);
        ano    = (EditText) findViewById(R.id.editTextAno);

        Bundle extras = getIntent().getExtras();
        id =  extras.getString("id");

        helper = new DatabaseHelper(this);

        //preencher os campos com a informação selecionada
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(String.format("SELECT * FROM carro WHERE id = %s", id), null);
        cursor.moveToFirst();
        tvId.setText(String.valueOf(cursor.getInt(0)));
        modelo.setText(cursor.getString(1));
        ano.setText(String.valueOf(cursor.getInt(2)));
        valor.setText(String.valueOf(cursor.getInt(3)));
        cursor.close();
    }

    public void alterarCarro(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("modelo", modelo.getText().toString());
        values.put("ano",Integer.parseInt(ano.getText().toString()));
        values.put("valor", Double.parseDouble(valor.getText().toString()));

        String where [] = new String[]{id};
        long resultado = db.update("carro", values, "id = ?", where);
        if (resultado != -1){
            Toast.makeText(this,"Registro Alterado com Sucesso", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }else {
            Toast.makeText(this,"Fracasso ao Alterar", Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(getApplicationContext(), ActivityExercicio11.class);
        startActivity(intent);
    }

    public void excluirCarro(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String where [] = new String[] {id};

        long resultado = db.delete("carro", "id = ?", where);
        if (resultado != -1){
            Toast.makeText(this, "Registro Excluído com Sucesso", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }else{
            Toast.makeText(this, "Fracasso ao Excluir", Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(getApplicationContext(), ActivityExercicio11.class);
        startActivity(intent);
    }
}
