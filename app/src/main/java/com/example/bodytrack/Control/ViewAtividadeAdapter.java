package com.example.bodytrack.Control;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.Serie;

import java.util.List;

public class ViewAtividadeAdapter extends BaseAdapter {
    private Context context;
    private List<Serie> series;

    public ViewAtividadeAdapter(Context context, List<Serie> series) {
        this.context = context;
        this.series = series;
    }

    @Override
    public int getCount() {
        return this.series.size();
    }

    @Override
    public Object getItem(int position) {
        return series.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        TextView texto = new TextView(context);
        Serie serieAtual = series.get(position);
        texto.setText(
                serieAtual.getNumSerie() + "                     " + serieAtual.getPeso() + "                       " + serieAtual.getRepeticao()
        );
        texto.setTextSize(16);
        return texto;
    }
}