package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
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

        lista.setClickable(true);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long arg3) {
                String id = String.valueOf(carros.get(position).get("id"));
                Intent intent = new Intent(getApplicationContext(), ActivityExercicio11_3.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

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
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        carros = new ArrayList<Map<String,Object>>();

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Map<String, Object> item = new HashMap<String, Object>();
                    int id = cursor.getInt(cursor.getColumnIndex("id"));
                    String modelo = cursor.getString(cursor.getColumnIndex("modelo"));
                    String ano = cursor.getString(cursor.getColumnIndex("ano"));
                    double valor = cursor.getDouble(cursor.getColumnIndex("valor"));
                    item.put("id", id);
                    item.put("modelo", modelo);
                    item.put("ano", ano);
                    item.put("valor", String.format("R$ %.2f", valor));
                    carros.add(item);
                    cursor.moveToNext();
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        return carros;
    }

    public void create(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityExercicio11_2.class);
        startActivity(intent);
    }
}
