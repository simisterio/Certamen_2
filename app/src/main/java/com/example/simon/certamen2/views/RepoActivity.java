package com.example.simon.certamen2.views;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.simon.certamen2.HttpServerConnection;
import com.example.simon.certamen2.R;
import com.example.simon.certamen2.Adapter.RepoAdaptador;
import com.example.simon.certamen2.interfaces.RepoPresenter;
import com.example.simon.certamen2.interfaces.RepoView;
import com.example.simon.certamen2.models.User;
import com.example.simon.certamen2.presenters.RepoPresenterImpl;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simon on 30-09-2016.
 */

public class RepoActivity extends AppCompatActivity implements RepoView {
    private RecyclerView recyclerView;
    private RepoAdaptador adaptador;
    private RecyclerView.LayoutManager layoutManager;
    private RepoPresenter repoPresenter;
    private String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repo_activity);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        repoPresenter = new RepoPresenterImpl(this);

        Bundle bundle = this.getIntent().getExtras();
        final String url = "https://api.github.com/users/" + bundle.getString("USER") + "/repos";

        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPreExecute() {

            }

            @Override
            protected String doInBackground(Void... params) {
                //DESCOMENTAR URL Y BORRAR EL STRING
                resultado = new HttpServerConnection().connectToServer("http://www.mocky.io/v2/57eee3822600009324111202"/*url*/, 15000);
                return resultado;
            }

            @Override
            protected void onPostExecute(final String resultado) {
                if (resultado != null) {
                    System.out.println(resultado);

                    // specify an adapter (see also next example)
                    adaptador = new RepoAdaptador();
                    repoPresenter.loadListUser();
                    recyclerView.setAdapter(adaptador);
                }
            }
        };
        task.execute();
    }

    @Override
    public void initRecycler(List<User> user) {
        adaptador.setDataSet(user);
    }

    public void setString(View v) {
        repoPresenter.stringServer(resultado);
    }
}
