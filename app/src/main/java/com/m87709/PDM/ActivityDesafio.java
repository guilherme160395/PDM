package com.m87709.PDM;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActivityDesafio extends AppCompatActivity {

    private String[] estados = {"Rio Grande do Sul", "Santa Catarina", "Paraná"};

    private String[] cidades = {"Santa Cruz do Sul", "Porto Alegre", "Erechim", "Florianópolis", "Balneário Camboriú", "Joinville", "Curitiba", "Foz do Iguaçu", "Londrina"};

    String[] de = {"foto","matricula", "nome"};

    int[] para = {R.id.foto, R.id.matricula, R.id.nome};

    List<HashMap<String, Object>> dados = new ArrayList<>();

    HashMap<String, Object> itens = new HashMap<String, Object>();

    AdaptadorDesafio adapter_desafio = new AdaptadorDesafio(getApplicationContext(), dados, R.layout.linha_desafio, de, para);

    Bitmap bm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafio);

        Spinner est = (Spinner) findViewById(R.id.spnEstados);
        ArrayAdapter<String> adapter_est = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, estados);
        est.setAdapter(adapter_est);

        Spinner cid = (Spinner) findViewById(R.id.spnCidades);
        ArrayAdapter<String> adapter_cid = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cidades);
        cid.setAdapter(adapter_cid);

        AdaptadorDesafio adapter_desafio = new AdaptadorDesafio(getApplicationContext(), (List<HashMap<String, Object>>) itens, R.layout.linha_desafio, de, para);

    }

    private List<HashMap<String, Object>> recuperarDados() {
        /*int[] img = {R.drawable.inter, R.drawable.sao, R.drawable.pal, R.drawable.fla, R.drawable.gre, R.drawable.cam, R.drawable.cru, R.drawable.san, R.drawable.flu, R.drawable.cor, R.drawable.ame, R.drawable.vit, R.drawable.bah, R.drawable.cap, R.drawable.bot, R.drawable.vas, R.drawable.spt, R.drawable.cea, R.drawable.cha, R.drawable.par};
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

        return dados;*/
        HashMap<String, Object> itens = new HashMap<String, Object>();

        itens.put("foto", bm);
        itens.put("matricula", findViewById(R.id.matriculaAluno));
        itens.put("nome", findViewById(R.id.nomeAluno));
        dados.add(itens);

        return dados;

    }

    public void tirarFoto(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 123 && resultCode == RESULT_OK) {
            super.onActivityResult(requestCode, resultCode, data);

            ImageView iv = (ImageView) findViewById(R.id.foto);

            if(requestCode == 123 && resultCode == RESULT_OK) {
                bm = (Bitmap) data.getExtras().get("data");
                iv.setImageBitmap(bm);
                iv.setScaleType(ImageView.ScaleType.FIT_XY);
            }
        }

    }

    public void inserirItem(View view) {
        itens.put("foto", bm);
        itens.put("matricula", findViewById(R.id.matriculaAluno));
        itens.put("nome", findViewById(R.id.nomeAluno));
        dados.add(itens);
    }

}
