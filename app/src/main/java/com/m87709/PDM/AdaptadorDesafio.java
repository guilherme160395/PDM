package com.m87709.PDM;

import android.content.Context;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.List;

class AdaptadorDesafio extends SimpleAdapter {

    public AdaptadorDesafio(Context ctx, List<HashMap<String, Object>> items, int res, String[] from, int[] to) {
        super(ctx, items, res, from, to);
    }

}
