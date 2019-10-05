package com.m87709.PDM;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.List;

class MeuAdaptador extends SimpleAdapter {

    public MeuAdaptador(Context ctx, List<HashMap<String, Object>> items, int res, String[] from, int[] to) {
        super(ctx, items, res, from, to);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = super.getView(position, convertView, parent);

        if (position <= 5) {
            view.setBackgroundColor(Color.YELLOW);
        } else if (position >= 16) {
            view.setBackgroundColor(Color.RED);
        } else {
            if(position %2 == 0) {
                view.setBackgroundColor(Color.GRAY);
            } else {
                view.setBackgroundColor(Color.WHITE);
            }
        }

        return view;
    }

}
