/*package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ActivityExercicio6_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio6_2);
    }
}*/
package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class ActivityExercicio6_2 extends ListActivity
        implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio6_2);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listarNomes()));

        ListView listView = getListView();

        listView.setOnItemClickListener(this);
    }

    private List<String> listarNomes() {
        return Arrays.asList("Guido", "Taís", "Guilherme", "Anderson", "Sabrina", "Graziele", "Kelly", "Dioser", "Matheus");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView) view;
        String mensagem = "Nome selecionado: " + textView.getText();

        //Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), ActivityExercicio6_3.class);
        intent.putExtra("nomeSelecionado", textView.getText());
        startActivity(intent);
    }
}
