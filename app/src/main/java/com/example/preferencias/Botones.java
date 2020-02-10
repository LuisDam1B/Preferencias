package com.example.preferencias;

import android.Manifest;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

public class Botones extends Fragment {
    Button botonguardar,botonrecuperar;
    TextView texto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.botones,container,false);


        botonguardar = (Button) view.findViewById(R.id.buttonGuardar);
        botonrecuperar = (Button) view.findViewById(R.id.buttonRecuperar);
        texto=(TextView) view.findViewById(R.id.textView);

        botonguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MainActivity)getActivity()).CargarFragment(new Preferencias());


            }
        });

        botonrecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences gestionarPreferencias = PreferenceManager.getDefaultSharedPreferences (getActivity().getBaseContext());//getDefaSharedPreferences("menu_preferencias", MainActivity.this.MODE_PRIVATE);
                boolean usarPreferencias=gestionarPreferencias.getBoolean("checkBox", true);

                if(usarPreferencias) {
                    String color = gestionarPreferencias.getString("listacolores", "Negro");
                    String textopref=gestionarPreferencias.getString("texto","Introduce un texto");
                    String tamaño=gestionarPreferencias.getString("listatamaño","10");
                    if (color.equals("roj")) {
                        texto.setTextColor(Color.RED);
                    }
                    else if(color.equals("azu")){
                        texto.setTextColor(Color.BLUE);
                    }else if(color.equals("ama")){
                        texto.setTextColor(Color.YELLOW);
                    }
                    if (tamaño.equals("12")) {
                        texto.setTextSize(12);

                    } else if (tamaño.equals("16")) {
                        texto.setTextSize(16);

                    } else if (tamaño.equals("20")) {
                        texto.setTextSize(20);

                    } else {
                        texto.setTextSize(10);

                    }
                    texto.setText(textopref);
                }
            }


        });



        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
