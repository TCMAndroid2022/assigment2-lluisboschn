package cat.tecnocampus.mobileapps.practica2.LluisBoschNadal.IvanCarolNavas.MaricelNavarroSagarra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ranking extends AppCompatActivity {
    TextView textView;
    PlayerController playerController;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    PlayerAdapter playerAdapter;
    ArrayList<PlayerGlobal> dataSet;
    ArrayList<PlayerGlobal> dataSet_aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView = findViewById(R.id.titulo);
        playerController = new PlayerController(getApplication());
        recyclerView = (RecyclerView) findViewById(R.id.rv_items);

        if(savedInstanceState == null) {
            dataSet = new ArrayList<>();
            dataSet_aux = new ArrayList<>();
            playerAdapter = new PlayerAdapter(dataSet);
            recyclerView.setAdapter(playerAdapter);
        }

        layoutManager = new LinearLayoutManager((this));
        recyclerView.setLayoutManager(layoutManager);

        //mostra correctament a la base de dades i les mostra per consola
        List<Player> players = playerController.listPlayers();

        for(int i=0; i< players.size(); i++) {
            Player getPlayer = players.get(i);
            PlayerGlobal playerGlobal = new PlayerGlobal(getPlayer.getNickname(), getPlayer.getPuntuacio(), getPlayer.getPartides());
            if(!dataSet_aux.contains(playerGlobal)){
                dataSet_aux.add(playerGlobal);
            }else{
                PlayerGlobal p  = dataSet_aux.get(i);
                p.setPuntuacio(p.getPuntuacio()+playerGlobal.getPuntuacio());
                p.setPartides(p.getPartides()+playerGlobal.getPartides());
                dataSet_aux.set(i, p);
            }
        }

        dataSet.addAll(dataSet_aux);
        playerAdapter.notifyDataSetChanged();
        printData();
    }

    private void printData(){
        for(int i = 0; i < dataSet_aux.size(); i++) {
            Log.v("AUX", dataSet_aux.get(i).getNickname());
        }
        for(int i = 0; i < dataSet.size(); i++) {
            Log.v("SET", dataSet.get(i).getNickname());
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


    //preguntar com vol que surti quan estigui en orientatio landscape
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            layoutManager = new LinearLayoutManager(this);
        }else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            layoutManager = new LinearLayoutManager(this);
        }
        recyclerView.setLayoutManager(layoutManager);
    }
}