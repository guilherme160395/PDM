package com.m87709.PDM;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listDataHeader;
    private HashMap<String, List<Calculo>> listHashMap;

    private String data;
    private Double v1;
    private Double v2;
    private String o;

    public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<Calculo>> listHashMap) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listHashMap.get(listDataHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listDataHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return listHashMap.get(listDataHeader.get(i)).get(i1); // i = Group Item, i1 = Child Item
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean isExpanded, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            LayoutInflater inflater =
                    (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.list_group, null);
        }
        TextView txt1 = (TextView) view.findViewById(R.id.data_hora);
        TextView txt2 = (TextView) view.findViewById(R.id.resultado);

        Calculo teste = listHashMap.get("conta " + i).get(0);
        txt1.setText(teste.getData_hora());
        txt2.setText(String.valueOf(teste.getResultado()));

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        if (view == null)
        {
            LayoutInflater inflater =
                    (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.list_item, null);

        }
        TextView txt1 = (TextView) view.findViewById(R.id.valor1);
        TextView txt2 = (TextView) view.findViewById(R.id.valor2);
        TextView op = (TextView) view.findViewById(R.id.operacao);

        Calculo teste = (Calculo) getChild(i, i1);
        txt1.setText(String.valueOf(teste.getValor1()));
        txt2.setText(String.valueOf(teste.getValor2()));
        op.setText(String.valueOf(teste.getOperacao()));

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
