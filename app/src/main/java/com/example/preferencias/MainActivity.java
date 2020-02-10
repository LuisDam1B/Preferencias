package com.example.preferencias;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CargarFragment(new Botones());


    }

    public void CargarFragment(Fragment fragment){

        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.contenedor,fragment).commit();
    }
}
