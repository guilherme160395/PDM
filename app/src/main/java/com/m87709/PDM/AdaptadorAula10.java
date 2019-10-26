package com.m87709.PDM;

import android.content.Context;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class AdaptadorAula10 extends SimpleAdapter {

    public AdaptadorAula10(Context ctx, List<Map<String, Object>> lista, int layout, String[] de, int[] para) {
        super(ctx, lista, layout, de, para);
    }
}
