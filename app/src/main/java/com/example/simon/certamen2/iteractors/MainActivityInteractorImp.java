package com.example.simon.certamen2.iteractors;

import com.example.simon.certamen2.interfaces.MainActivityInteractor;
import com.example.simon.certamen2.interfaces.OnMainActivityFinishListener;

/**
 * Created by simon on 02-11-2016.
 */

public class MainActivityInteractorImp implements MainActivityInteractor {

    @Override
    public void validarDatos(String username, OnMainActivityFinishListener listener) {
        if(!username.equals("")){
            listener.exitoOperacion();
        }
        else{
            listener.usernameError();
        }
    }
}
