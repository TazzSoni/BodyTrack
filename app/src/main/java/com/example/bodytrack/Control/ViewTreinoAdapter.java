package com.example.bodytrack.Control;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bodytrack.Model.Atividade;

import java.util.List;

public class ViewTreinoAdapter extends BaseAdapter {
    private Context context;
    private List<Atividade> atividades;

    public ViewTreinoAdapter(Context context, List<Atividade> atividades) {
        this.context = context;
        this.atividades = atividades;
    }

    @Override
    public int getCount() {
        return this.atividades.size();
    }

    @Override
    public Object getItem(int position) {
        return atividades.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        TextView texto = new TextView(context);
        Atividade atividade = atividades.get(position);
        texto.setText(
                atividade.getNome()
        );
        texto.setTextSize(16);
        return texto;
    }
}
