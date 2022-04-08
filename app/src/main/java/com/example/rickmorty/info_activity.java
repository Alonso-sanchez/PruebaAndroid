package com.example.rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class info_activity extends AppCompatActivity {

    private TextView nombreTV,origenTV,generoTV,estatusTV,especieTV;
    private ImageView fotoIV;
    private Button cerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        nombreTV = (TextView) findViewById(R.id.tvNombre);
        generoTV = (TextView) findViewById(R.id.tvGenero);
        estatusTV = (TextView) findViewById(R.id.tvStatus);
        especieTV = (TextView) findViewById(R.id.tvEspecie);
        fotoIV = (ImageView) findViewById(R.id.ivFoto);
        origenTV = (TextView) findViewById(R.id.tvOrigen);

        String nombre = getIntent().getStringExtra("nombre");
        String genero = getIntent().getStringExtra("genero");
        String especie = getIntent().getStringExtra("especie");
        String estatus = getIntent().getStringExtra("estatus");
        String imagen = getIntent().getStringExtra("imagen");
        String origen = getIntent().getStringExtra("origen");
        nombreTV.setText(nombre);
        generoTV.setText(genero);
        estatusTV.setText(estatus);
        especieTV.setText(especie);
        origenTV.setText(origen);

        Glide.with(this).load(imagen).into(fotoIV);
        cerrar = (Button)  findViewById(R.id.btnOk);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}