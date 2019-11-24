package com.m87709.PDM;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityDesafio extends AppCompatActivity {

    String tag = "Log Guilherme";
    private ListView lv;
    List<HashMap<String, Object>> lista;
    AdaptadorDesafio adapter_desafio;

    String[] de = {"foto", "matricula", "nome"};
    int[] para = {R.id.foto, R.id.matricula_lista, R.id.nome_lista};

    private String[] estados = {"Rio Grande do Sul", "Santa Catarina", "Paraná"};
    private String[] cidades;

    private TextView textMatriclula;
    private TextView textNome;
    private TextView textEmail;
    private Spinner est;
    private Spinner cid;

    private String estadoSelecionado;
    private String cidadeSelecionada;


    HashMap<String, Object> item;

    Bitmap bm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafio);

        textMatriclula = findViewById(R.id.matriculaAluno);
        textNome = findViewById(R.id.nomeAluno);
        textEmail = findViewById(R.id.emailAluno);
        est = (Spinner) findViewById(R.id.spnEstados);
        cid = (Spinner) findViewById(R.id.spnCidades);

        //codigo list view
        lv = findViewById(R.id.list_view);
        lista = new ArrayList<>();
        //adapter_desafio = new AdaptadorDesafio(getApplicationContext(), lista, R.layout.linha_desafio, de, para);
        //lv.setAdapter(adapter_desafio);

        //codigo spinner estados
        ArrayAdapter<String> adapter_est = new ArrayAdapter<>(ActivityDesafio.this, android.R.layout.simple_list_item_1, estados);
        est.setAdapter(adapter_est);

        //codigo spinner cidades
        est.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                estadoSelecionado = estados[position];
                if (estadoSelecionado == "Rio Grande do Sul") {
                    cidades = new String[]{"Santa Cruz do Sul", "Porto Alegre", "Erechim"};
                    ArrayAdapter<String> adapter_cid = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, cidades);
                    cid.setAdapter(adapter_cid);
                } else if (estadoSelecionado == "Santa Catarina") {
                    cidades = new String[]{"Florianópolis", "Balneário Camboriú", "Joinville"};
                    ArrayAdapter<String> adapter_cid = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, cidades);
                    cid.setAdapter(adapter_cid);
                } else if (estadoSelecionado == "Paraná") {
                    cidades = new String[]{"Curitiba", "Foz do Iguaçu", "Londrina"};
                    ArrayAdapter<String> adapter_cid = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, cidades);
                    cid.setAdapter(adapter_cid);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //...
            }
        });

        cid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cidadeSelecionada = cidades[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //...
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String,Object> item = lista.get(position);
                String matricula = (String) item.get("matricula");
                String nome = (String) item.get("nome");
                String email = (String) item.get("email");
                String estado = (String) item.get("estado");
                String cidade = (String) item.get("cidade");
                Intent intent = new Intent(getApplicationContext(), ActivityDesafio_2.class);
                intent.putExtra("matricula", matricula);
                intent.putExtra("nome", nome);
                intent.putExtra("email", email);
                intent.putExtra("estado", estado);
                intent.putExtra("cidade", cidade);
                startActivity(intent);
            }
        });

    }

    public void tirarFoto(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 123 && resultCode == RESULT_OK) {
            super.onActivityResult(requestCode, resultCode, data);

            ImageView iv = (ImageView) findViewById(R.id.foto);

            if (requestCode == 123 && resultCode == RESULT_OK) {
                bm = (Bitmap) data.getExtras().get("data");
                iv.setImageBitmap(bm);
                iv.setScaleType(ImageView.ScaleType.FIT_XY);
            }
        }

    }

    public void inserirItem(View view) {

        //item = new HashMap<String, Object>();
        final Map<String,Object> item = new HashMap<>();

        ImageView iv = (ImageView) findViewById(R.id.foto);
        //recupero o Drawable da ImageView
        Drawable drawable = iv.getDrawable();
        //faço o casting de Drawable para BitmapDrawable
        BitmapDrawable bd = (BitmapDrawable) drawable;
        //recupero o Bitmap do BitmapDrawable
        Bitmap bitmap = bd.getBitmap();
        //adiciono o Bitmap na variável itens
        item.put("foto", bitmap);

        //EditText textNome = (EditText) findViewById(R.id.nomeAluno);
        //String n = textNome.getText().toString();
        item.put("nome", textNome.getText().toString());
        Log.d(tag,"valor nome: "+ textNome.getText().toString());

        //EditText textMatriclula = (EditText) findViewById(R.id.matriculaAluno);
        item.put("matricula", textMatriclula.getText().toString());
        Log.d(tag,"valor matrícula: "+ textMatriclula.getText().toString());

        item.put("email", textEmail.getText().toString());
        Log.d(tag,"valor email: "+ textEmail.getText().toString());

        item.put("estado", estadoSelecionado);
        item.put("cidade", cidadeSelecionada);

        lista.add((HashMap<String, Object>) item);

        adapter_desafio = new AdaptadorDesafio(getApplicationContext(), lista, R.layout.linha_desafio, de, para);
        lv.setAdapter(adapter_desafio);

    }

}
