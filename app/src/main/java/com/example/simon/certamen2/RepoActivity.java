package com.example.simon.certamen2;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simon on 30-09-2016.
 */

public class RepoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adaptador;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repo_activity);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        Bundle bundle = this.getIntent().getExtras();
        final String url =  "https://api.github.com/users/" + bundle.getString("USER") + "/repos";

        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPreExecute() {

            }

            @Override
            protected String doInBackground(Void... params) {
                //DESCOMENTAR URL Y BORRAR EL STRING
                String resultado = new HttpServerConnection().connectToServer("http://www.mocky.io/v2/57eee3822600009324111202"/*url*/, 15000);
                return resultado;
            }

            @Override
            protected void onPostExecute(final String result) {
                if (result != null) {
                    System.out.println(result);

                    // specify an adapter (see also next example)
                    adaptador = new RepoAdaptador(getLista(result));
                    recyclerView.setAdapter(adaptador);

                }
            }
        };
        task.execute();
    }

    private List<User> getLista(String result){
        List<User> listaRepo = new ArrayList<User>();
        try {
            JSONArray lista = new JSONArray(result);

            int size = lista.length();
            for(int i = 0; i < size; i++){
                User repo = new User();
                JSONObject objeto = lista.getJSONObject(i);

                repo.setName(objeto.getString("name"));
                repo.setDescription(objeto.getString("description"));
                repo.setUpdated_at(objeto.getString("updated_at"));
                repo.setHtmlUrl(objeto.getString("html_url"));

                listaRepo.add(repo);
            }
            return listaRepo;
        } catch (JSONException e) {
            e.printStackTrace();
            return listaRepo;
        }

    }
}
