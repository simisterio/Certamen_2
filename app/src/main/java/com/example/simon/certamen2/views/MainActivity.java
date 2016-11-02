package com.example.simon.certamen2.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.simon.certamen2.R;
import com.example.simon.certamen2.interfaces.MainActivityPresenter;
import com.example.simon.certamen2.interfaces.MainActivityView;
import com.example.simon.certamen2.presenters.MainActivityPresenterImp;

public class MainActivity extends AppCompatActivity implements MainActivityView{
    private EditText userName;
    private Button btnBuscar;
    private MainActivityPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.txtUsername);
        btnBuscar = (Button) findViewById(R.id.btnBuscar);

        presenter = new MainActivityPresenterImp(this);
        /*btnBuscar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Creamos el Intent
                        Intent intent = new Intent(MainActivity.this, RepoActivity.class);

                        //Creamos la información a pasar entre actividades
                        Bundle b = new Bundle();
                        b.putString("USER", userName.getText().toString());

                        //Añadimos la información al intent
                        intent.putExtras(b);

                        //Iniciamos la nueva actividad
                        startActivity(intent);
                    }
                }
        );*/
    }

    @Override
    public void navigateTo() {
        Intent intent = new Intent(MainActivity.this, RepoActivity.class);
        Bundle b = new Bundle();
        b.putString("USER", userName.getText().toString());
        intent.putExtras(b);
        startActivity(intent);
    }

    @Override
    public void setErrorUsername() {
        userName.setError("Campo obligatorio");
    }

    public void validar(View v){
        presenter.validarUserName(userName.getText().toString());
    }
}
