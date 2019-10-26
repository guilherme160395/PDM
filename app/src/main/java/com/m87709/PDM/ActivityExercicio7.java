package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActivityExercicio7 extends ListActivity implements AdapterView.OnItemClickListener {

    String[] de = {"escudoTime", "nomeTime", "pontuacaoTime"};
    int[] para = {R.id.escudoTime, R.id.nomeTime, R.id.pontosTime};
    List<HashMap<String, Object>> dados = new ArrayList<>();
    String tag = "LOG GUILHERME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MeuAdaptador adapter = new MeuAdaptador(getApplicationContext(), dadosBrasileirinho(), R.layout.linha_campeonato, de, para);

        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        HashMap<String, Object> item = dados.get(position);
        String nome = (String) item.get("nomeTime");
        //Log.d(tag, nome);
        String pontos = String.valueOf(item.get("pontuacaoTime"));
        //Log.d(tag, pontos);
        Toast.makeText(getApplicationContext(),
                    "Nome do time: " + nome + " Pontos: " + pontos,
                             Toast.LENGTH_SHORT).show();
    }

    private List<HashMap<String, Object>> dadosBrasileirinho() {

        int[] img = {R.drawable.inter, R.drawable.sao, R.drawable.pal, R.drawable.fla, R.drawable.gre, R.drawable.cam, R.drawable.cru, R.drawable.san, R.drawable.flu, R.drawable.cor, R.drawable.ame, R.drawable.vit, R.drawable.bah, R.drawable.cap, R.drawable.bot, R.drawable.vas, R.drawable.spt, R.drawable.cea, R.drawable.cha, R.drawable.par};
        String[] clubes = {"Internacional","São Paulo","Palmeiras","Flamengo","Grêmio","Atlético-MG","Cruzeiro","Santos","Fluminense","Corinthians","América-MG","Vitória","Bahia","Atlético-PR","Botafogo","Vasco","Sport","Ceará","Chapecoense","Paraná Clube"};
        int[] pontos = {49,49,46,44,41,38,33,31,31,30,30,29,28,27,26,24, 24,24,22,16};

        //List<HashMap<String, Object>> dados = new ArrayList<>();
        HashMap<String, Object> itens;
        for(int i = 0; i < img.length; i++) {
            itens = new HashMap<String, Object>();

            itens.put("escudoTime", img[i]);
            itens.put("nomeTime", clubes[i]);
            itens.put("pontuacaoTime", pontos[i]);
            dados.add(itens);

        }

        return dados;

    }

}
