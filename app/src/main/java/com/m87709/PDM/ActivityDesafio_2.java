package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityDesafio_2 extends AppCompatActivity {

    private String matricula;
    private String nome;
    private String email;
    private String estado;
    private String cidade;
    private TextView tv_matricula;
    private TextView tv_nome;
    private TextView tv_email;
    private TextView tv_estado;
    private TextView tv_cidade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafio_2);

        Bundle extras = getIntent().getExtras();
        matricula = (String) extras.get("matricula");
        nome = (String) extras.get("nome");
        email = (String) extras.get("email");
        estado = (String) extras.get("estado");
        cidade = (String) extras.get("cidade");
        tv_matricula = (TextView) findViewById(R.id.matricula);
        tv_nome = (TextView) findViewById(R.id.nome);
        tv_email = (TextView) findViewById(R.id.email);
        tv_estado = (TextView) findViewById(R.id.estado);
        tv_cidade = (TextView) findViewById(R.id.cidade);
        tv_matricula.setText("Matrícula: " + matricula);
        tv_nome.setText("Nome: " + nome);
        tv_email.setText("Email: " + email);
        tv_estado.setText("Estado: " + estado);
        tv_cidade.setText("Cidade: " + cidade);

    }
}
