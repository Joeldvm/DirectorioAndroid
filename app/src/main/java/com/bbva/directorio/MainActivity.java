package com.bbva.directorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class MainActivity<calendario> extends AppCompatActivity {

    CalendarView calendario;
    TextView textfecha;
    TextView txtnombre;
    TextView txtEmail;
    TextView txtDescrip;
    TextView txtPhone;
    Button siguiente;

    String Nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendario = (CalendarView) findViewById(R.id.calendario);
        textfecha = (TextView) findViewById(R.id.textfecha);
        siguiente =(Button) findViewById(R.id.siguiente);
        txtnombre = (TextView) findViewById(R.id.txtnombre);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        txtDescrip = (TextView) findViewById(R.id.txtDescrip);

        Bundle retorno = getIntent().getExtras();
        if (retorno != null){
            txtnombre.setText(retorno.getString("rtnNombre"));
            textfecha.setText(retorno.getString("rtnFecnac"));
            txtEmail.setText(retorno.getString("rtnCorreo"));
            txtPhone.setText(retorno.getString("rtnTelefono"));
            txtDescrip.setText(retorno.getString("rtnDescrip"));
        }

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String fechaN = dayOfMonth + "/" + (month+1) + "/" + year;
                textfecha.setText(fechaN);
                                               }
                                           }

        );

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent llamado = new Intent(MainActivity.this, Confirma.class);

                llamado.putExtra("Nombre",txtnombre.getText().toString());
                llamado.putExtra("Fechnac",textfecha.getText().toString());
                llamado.putExtra("Mail",txtEmail.getText().toString());
                llamado.putExtra("Telefono",txtPhone.getText().toString());
                llamado.putExtra("Descripcion",txtDescrip.getText().toString());

                startActivity(llamado);
            }
        });
    }






}