package com.m87709.PDM;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

class MeuAdaptador extends SimpleAdapter {

    public MeuAdaptador(Context ctx, List<HashMap<String, Object>> items, int res, String[] from, int[] to) {
        super(ctx, items, res, from, to);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = super.getView(position, convertView, parent);

        if(position <= 3) {

            view.setBackgroundColor(Color.YELLOW);
        }

        return view;
    }
}
