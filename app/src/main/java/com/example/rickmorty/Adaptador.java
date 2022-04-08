package com.example.rickmorty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private Context context;
    private ArrayList<Personajes> listItems;

    public Adaptador (Context context,ArrayList<Personajes> listItems){
        this.context = context;
        this.listItems = listItems;

    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Personajes nom = (Personajes) getItem(i);
        View convertview = LayoutInflater.from(context).inflate(R.layout.personaje, null);
        TextView nombre = (TextView) convertview.findViewById(R.id.tVNombre);
        TextView especie = (TextView) convertview.findViewById(R.id.tVEspecie);
        TextView estatus = (TextView) convertview.findViewById(R.id.tVStatus);
        ImageView img = (ImageView) convertview.findViewById(R.id.imageView);

        especie.setText(nom.getEspecie());
        estatus.setText(nom.getStatus());
        nombre.setText(nom.getNombre());
        Glide.with(context).load(nom.getImagen()).into(img);
        return convertview;
    }
}

