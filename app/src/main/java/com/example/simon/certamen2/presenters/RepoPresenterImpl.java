package com.example.simon.certamen2.presenters;

import com.example.simon.certamen2.interfaces.RepoInteractor;
import com.example.simon.certamen2.interfaces.RepoPresenter;
import com.example.simon.certamen2.interfaces.RepoView;
import com.example.simon.certamen2.iteractors.RepoInteractorImpl;
import com.example.simon.certamen2.models.User;

import java.util.List;

/**
 * Created by simon on 03-11-2016.
 */

public class RepoPresenterImpl implements RepoPresenter{
    private RepoView view;
    private RepoInteractor interactor;

    public RepoPresenterImpl(RepoView view){
        this.view=view;
        interactor = new RepoInteractorImpl(this);
    }

    @Override
    public void initRecycler(List<User> user) {

        view.initRecycler(user);
    }

   @Override
    public void loadListUser() {
        interactor.initRecycler();
    }

    @Override
    public void stringServer(String resultado) {

        interactor.reciveString(resultado);
    }
}

