/*package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ActivityExercicio6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio6);
    }
}*/
package com.m87709.PDM;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class ActivityExercicio6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Alterando o texto do topo da MainActivity
        para Main Activity*/
        setTitle("Exercício Aula 6");
    }

    /*Código necessário para adicionar menus em uma
    tela de uma aplicação Android*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_guilherme, menu);
        return true;
    }

    /*O código abaixo é necessário para tratar o evento
    caso algum item do menu seja selecionado*/

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            /*O código abaixo será executado caso o item de menu
            Lista seja selecionado*/

            case R.id.item_menu_lista:
                //Toast.makeText(this, "Lista", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), ActivityExercicio6_2.class);
                startActivity(intent);

                return true;

        }
        return false;
    }
}
