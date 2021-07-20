package com.example.bodytrack.Control;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bodytrack.Model.Serie;
import com.example.bodytrack.Model.Treino;

import java.util.List;

public class HomeAdapter  extends BaseAdapter {

    private Context context;
    private List<Treino> treinos;

    public HomeAdapter(Context context, List<Treino> treinos) {
        this.context = context;
        this.treinos = treinos;
    }

    @Override
    public int getCount() {
        return this.treinos.size();
    }

    @Override
    public Object getItem(int position) {
        return treinos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        TextView texto = new TextView(context);
        Treino treino = treinos.get(position);
        texto.setText(
                treino.getNome()
        );
        texto.setTextSize(16);
        return texto;
    }
}
