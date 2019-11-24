package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdaptadorDesafio extends SimpleAdapter {

    List<HashMap<String, Object>> lista;

    String tag = "log Guilherme";

    public AdaptadorDesafio(Context ctx, List<HashMap<String, Object>> lista, int uma_linha, String[] de, int[] para) {
        super(ctx, lista, uma_linha, de, para);
        this.lista = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);

        Map<String, Object> mapa = lista.get(position);
        Bitmap bmp = (Bitmap) mapa.get("foto");
        String nome = (String) mapa.get("nome");
        String matr = (String) mapa.get("matricula");

        ImageView iv = v.findViewById(R.id.foto_lista);
        iv.setImageBitmap(bmp);

        TextView tv1 = v.findViewById(R.id.nome_lista);
        //Log.d(tag,"setar nome "+ tv1.getText());
        tv1.setText("Nome: "+nome);

        TextView tv2 = v.findViewById(R.id.matricula_lista);
        //Log.d(tag,"setar matricula "+ tv2.getText());
        tv2.setText("Matrícula: " + matr);

        return v;

    }
}
