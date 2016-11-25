package com.example.simon.certamen2.iteractors;

import com.example.simon.certamen2.interfaces.RepoInteractor;
import com.example.simon.certamen2.interfaces.RepoPresenter;
import com.example.simon.certamen2.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simon on 03-11-2016.
 */

public class RepoInteractorImpl implements RepoInteractor {
    private RepoPresenter presenter;
    private String resultado;
    public RepoInteractorImpl(RepoPresenter presenter){
        this.presenter = presenter;
    }


    @Override
    public void initRecycler() {
        List<User> users;
        users = getLista(resultado);
        presenter.initRecycler(users);
    }

    @Override
    public void reciveString(String resultado) {
        this.resultado = resultado;
    }

    private List<User> getLista(String result) {
        List<User> listaRepo = new ArrayList<User>();
        try {
            if(result != null) {
                JSONArray lista = new JSONArray(result);

                int size = lista.length();
                for (int i = 0; i < size; i++) {
                    User repo = new User();
                    JSONObject objeto = lista.getJSONObject(i);

                    repo.setName(objeto.getString("name"));
                    repo.setDescription(objeto.getString("description"));
                    repo.setUpdated_at(objeto.getString("updated_at"));
                    repo.setHtmlUrl(objeto.getString("html_url"));

                    listaRepo.add(repo);
                }
            }
            return listaRepo;
        } catch (JSONException e) {
            e.printStackTrace();
            return listaRepo;
        }
    }
}
