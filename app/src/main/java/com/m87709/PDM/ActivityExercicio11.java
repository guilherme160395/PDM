package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class ActivityExercicio11 extends AppCompatActivity {

    private DatabaseHelper helper;
    private EditText editTextAno;
    private ListView lista;
    List<Map<String, Object>> carros;
    String[] de = {"id", "modelo", "ano", "valor"};
    int[] para = {R.id.textViewId, R.id.textViewModelo, R.id.textViewAno, R.id.textViewValor};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio11);

        editTextAno = (EditText) findViewById(R.id.editTextAno);
        lista = (ListView) findViewById(R.id.lista_carros);
        helper = new DatabaseHelper(getApplicationContext());

    }

    public void retrieve(View view) {
        String busca = editTextAno.getText().toString();
        String query = "";
        if(busca.isEmpty()) {
            query = "SELECT * FROM carro";
        } else {
            query = "SELECT * FROM carro WHERE ano = " + busca;
        }
        carros = listarCarros(query);
        SimpleAdapter adaptador = new SimpleAdapter(getApplicationContext(), carros, R.layout.linha_carros, de, para);
        lista.setAdapter(adaptador);
    }

    private List<Map<String, Object>> listarCarros(String query) {
    }

    public void create(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityExercicio11_2.class);
        startActivity(intent);
    }
}
