/*package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ActivityExercicio6_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio6_3);
    }
}*/
package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class ActivityExercicio6_3 extends AppCompatActivity {

    TextView tv;
    Spinner spinnerEstados;
    ListView listViewCidades;
    String[] estados = {"RS", "SC", "PR"};

    String[] cidades_RS = {"Lajeado", "Santa Rosa", "Santa Maria"};
    String[] cidades_SC = {"Joinville", "Itapema", "Brusque"};
    String[] cidades_PR = {"Foz do Iguaçu", "Londrina", "Cascavel"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio6_3);

        /*Alterando o texto do topo da ActivitySpinner
        para Activity Spinner*/
        setTitle("Activity Spinner");

        tv = findViewById(R.id.Nome);

        Bundle extras = getIntent().getExtras();

        //Toast.makeText(getApplicationContext(), (String) extras.get("nomeSelecionado"), Toast.LENGTH_SHORT).show();

        tv.setText((String) extras.get("nomeSelecionado"));

        spinnerEstados = findViewById(R.id.spinnerEstado);
        listViewCidades = findViewById(R.id.listViewCidade);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, estados);
        spinnerEstados.setAdapter(adapter);

        spinnerEstados.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String estadoSelecionado = estados[position];
                //Toast.makeText(getApplicationContext(), estadoSelecionado, Toast.LENGTH_SHORT).show();

                ArrayAdapter<String> adapterCidade;

                if(estadoSelecionado == "RS") {
                    adapterCidade = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Arrays.asList(cidades_RS));
                    listViewCidades.setAdapter(adapterCidade);
                }
                else if(estadoSelecionado == "SC") {
                    adapterCidade = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Arrays.asList(cidades_SC));
                    listViewCidades.setAdapter(adapterCidade);
                }
                else if(estadoSelecionado == "PR") {
                    adapterCidade = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Arrays.asList(cidades_PR));
                    listViewCidades.setAdapter(adapterCidade);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
