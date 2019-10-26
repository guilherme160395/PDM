package com.m87709.PDM;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

public class ActivityExercicio10 extends AppCompatActivity {

    private ListView listView;
    private List<Map<String,Object>> lista;
    private AdaptadorAula10 adapter;
    private String[] de = {"temperatura", "humidade", "pressao_atm", "data_hora"};
    private int[] para = {R.id.txTemperatura, R.id.txHumidade, R.id.txPressao, R.id.txData_Hora};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio10);
    }

    public void buscar_web_service(View view) {

        listView = findViewById(R.id.list_view_aula10);
        lista = new ArrayList<>();
        Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_LONG).show();

        // código a seguir rereferente ao loopj
        Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_LONG).show();

        String url = "http://ghelfer.net/la/weather.json";

        AsyncHttpClient client = new AsyncHttpClient();
        Toast.makeText(getApplicationContext(), "3", Toast.LENGTH_SHORT).show();

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Toast.makeText(getApplicationContext(), "sucesso", Toast.LENGTH_LONG).show();
                try {
                    String data = new String(responseBody, "UTF-8");

                    JSONObject res = new JSONObject(data);
                    JSONArray array = res.getJSONArray("weather");
                    /*for (int i = 0; i < array.length(); i++) {
                        JSONObject json = array.getJSONObject(i);
                        String temperatura = json.get("temperature").toString();
                        String humidade = json.get("humidity").toString();
                        String pressao = json.get("pressure").toString();
                        String data_hora = json.get("datetime").toString();
                    }*/
                    for (int i = 0; i < array.length(); i++) {
                        Map<String,Object> itens = new HashMap<>();

                        JSONObject json = array.getJSONObject(i);

                        itens.put("temperatura", "Temperatura: " + json.get("temperature").toString());
                        itens.put("humidade", "Humidade: " + json.get("humidity").toString());
                        itens.put("pressao_atm", "Pressão Atm: " + json.get("pressure").toString());
                        itens.put("data_hora", "Data/Hora: " + json.get("datetime").toString());
                        lista.add(itens);
                    }

                    adapter = new AdaptadorAula10(getApplicationContext(), lista, R.layout.linha_clima, de, para);
                    listView.setAdapter(adapter);

                    //Toast.makeText(getApplicationContext(), array.getJSONObject(2).getString("temperature"), Toast.LENGTH_LONG).show();



                }catch (Exception ex){
                    Log.e("URL", ex.getMessage());
                };
            };

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), "fracasso", Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        });


    }
}
