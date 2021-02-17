package com.bbva.directorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirma extends AppCompatActivity {

    Button edita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma);

        edita = (Button) findViewById(R.id.edita);

        Bundle parametros = getIntent().getExtras();
        String Nombre = parametros.getString("Nombre");
        String FecNac = parametros.getString("Fechnac");
        String Mail = parametros.getString("Mail");
        String Telefono = parametros.getString("Telefono");
        String Descrip = parametros.getString("Descripcion");

        TextView tvnombre = (TextView) findViewById(R.id.tvnombre);
        TextView tvtelefono = (TextView) findViewById(R.id.tvtelefono);
        TextView tvcorreo = (TextView) findViewById(R.id.tvcorreo);
        TextView tvfecNac = (TextView) findViewById(R.id.tvfecNac);
        TextView tvdescrip = (TextView) findViewById(R.id.tvdescrip);

        tvnombre.setText(Nombre);
        tvtelefono.setText("Tel: " + Telefono);
        tvcorreo.setText("Email: " + Mail);
        tvfecNac.setText("Fecha Nacimiento: " + FecNac);
        tvdescrip.setText("Descripcion: " + Descrip);

        edita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regresa = new Intent(Confirma.this, MainActivity.class);
                regresa.putExtra("rtnNombre",Nombre.toString());
                regresa.putExtra("rtnTelefono",Telefono.toString());
                regresa.putExtra("rtnCorreo",Mail.toString());
                regresa.putExtra("rtnFecnac",FecNac.toString());
                regresa.putExtra("rtnDescrip",Descrip.toString());
                startActivity(regresa);
                }

        });



    }
}