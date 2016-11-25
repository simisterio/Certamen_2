package com.example.simon.certamen2.interfaces;

import com.example.simon.certamen2.presenters.MainActivityPresenterImp;

/**
 * Created by simon on 02-11-2016.
 */

public interface MainActivityInteractor {
    void validarDatos(String username,
                    OnMainActivityFinishListener listener);

}
