package com.example.rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Personajes> personajes = new ArrayList<>();
    private ListView personajesLV;
    private Adaptador adap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personajes = getPersonajes();
        adap = new Adaptador(this,personajes);
        personajesLV = findViewById(R.id.listViewPersonajes);

        Intent intent = new Intent(this,info_activity.class);
        personajesLV.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent.putExtra("nombre", personajes.get(i).getNombre());
                intent.putExtra("especie",personajes.get(i).getEspecie());
                intent.putExtra("genero",personajes.get(i).getGenero());
                intent.putExtra("imagen",personajes.get(i).getImagen());
                intent.putExtra("estatus",personajes.get(i).getStatus());
                intent.putExtra("origen",personajes.get(i).getOrigen());
                startActivity(intent);
            }
        });

    }

    public ArrayList getPersonajes() {
        ArrayList<Personajes> lista = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        //llamada a interfaz
        PersonajesAPI personajesAPI = retrofit.create(PersonajesAPI.class);
        for(int i=1; i<101; i++) {
            Call<Results> call = personajesAPI.getPersonaje(i);
            call.enqueue(new Callback<Results>() {
                @Override
                public void onResponse(Call<Results> call, Response<Results> response ) {
                    if(response.isSuccessful()){
                        Results r = response.body();
                        lista.add(new Personajes(r.getName(),r.getSpecies(),r.getStatus(),r.getGender(),r.getOrigin().toString(), r.getImage()));
                        personajesLV.setAdapter(adap);
                    }
                }
                @Override
                public void onFailure(Call<Results> call, Throwable t) {
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            }
        return lista;
    }

}