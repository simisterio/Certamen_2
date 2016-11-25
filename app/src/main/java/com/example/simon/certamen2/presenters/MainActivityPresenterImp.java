package com.example.simon.certamen2.presenters;

import com.example.simon.certamen2.interfaces.MainActivityInteractor;
import com.example.simon.certamen2.interfaces.MainActivityPresenter;
import com.example.simon.certamen2.interfaces.MainActivityView;
import com.example.simon.certamen2.interfaces.OnMainActivityFinishListener;
import com.example.simon.certamen2.iteractors.MainActivityInteractorImp;

/**
 * Created by simon on 02-11-2016.
 */

public class MainActivityPresenterImp implements MainActivityPresenter, OnMainActivityFinishListener {
    private MainActivityView view;
    private MainActivityInteractor interactor;

    public MainActivityPresenterImp(MainActivityView view){
        this.view = view;
        interactor = new MainActivityInteractorImp();
    }

    @Override
    public void validarUserName(String username){
        interactor.validarDatos(username,this);
    }

    @Override
    public void exitoOperacion() {
       if(view != null) {
           view.navigateTo();
       }
    }

    @Override
    public void usernameError() {
        if (view != null){
            view.setErrorUsername();
        }
    }
}
