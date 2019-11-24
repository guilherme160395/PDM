package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ActivityExercicio9 extends AppCompatActivity {

    private String[] operacoes = {"+", "-", "*", "/"};
    private String operacao_selecionada;
    private EditText valor1;
    private EditText valor2;
    private TextView resultado;
    private Double double_valor1;
    private Double double_valor2;
    private String data_completa;

    //expandable list view
    private ExpandableListView list_view;
    private ExpandableListAdapter list_adapter;
    private List<String> list_data_header = new ArrayList<>();
    private HashMap<String, List<Calculo>> list_hash_map = new HashMap<>();

    private int acumulador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio9);

        valor1 = findViewById(R.id.valor1);
        valor2 = findViewById(R.id.valor2);
        resultado = findViewById(R.id.resultado);
        Spinner spinner_operacao = (Spinner) findViewById(R.id.operacao);

        ArrayAdapter<String> adapter_spinner =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, operacoes);

        spinner_operacao.setAdapter(adapter_spinner);

        spinner_operacao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                operacao_selecionada = operacoes[position];
                Toast.makeText(getApplicationContext(),
                        "operacao_selecionada = " + operacao_selecionada,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //...
            }
        });

        /*list_view = findViewById(R.id.lvExp);

        //initData();

        list_adapter = new ExpandableListAdapter(getApplicationContext(), list_data_header,
                list_hash_map);

        list_view.setAdapter(list_adapter);*/

    }

    public void calcular(View view) {
        Calculo c = new Calculo();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date data = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        Date data_atual = cal.getTime();
        data_completa = dateFormat.format(data_atual);

        c.setData_hora(data_completa);

        double_valor1 = Double.parseDouble(valor1.getText().toString());

        c.setValor1(double_valor1);

        double_valor2 = Double.parseDouble(valor2.getText().toString());

        c.setValor2(double_valor2);

        if(operacao_selecionada == "+") {
            resultado.setText(String.valueOf(double_valor1 + double_valor2));
            c.setResultado(double_valor1 + double_valor2);
            c.setOperacao("Soma");
        } else if(operacao_selecionada == "-") {
            resultado.setText(String.valueOf(double_valor1 - double_valor2));
            c.setResultado(double_valor1 - double_valor2);
            c.setOperacao("Subtração");
        } else if(operacao_selecionada == "*") {
            resultado.setText(String.valueOf(double_valor1 * double_valor2));
            c.setOperacao("Multiplicação");
            c.setResultado(double_valor1 * double_valor2);
        } else if(operacao_selecionada == "/") {
            resultado.setText(String.valueOf(double_valor1 / double_valor2));
            c.setResultado(double_valor1 / double_valor2);
            c.setOperacao("Divisão");
        }

        //Toast.makeText(getApplicationContext(), String.valueOf(acumulador), Toast.LENGTH_LONG).show();

        list_data_header.add("conta " + String.valueOf(acumulador));

        List<Calculo> lista1 = new ArrayList<>();

        lista1.add(c);

        list_hash_map.put(list_data_header.get(acumulador), lista1);

        //...
        list_view = findViewById(R.id.lvExp);

        list_adapter = new ExpandableListAdapter(getApplicationContext(), list_data_header,
                list_hash_map);

        list_view.setAdapter(list_adapter);

        acumulador++;

    }
}
