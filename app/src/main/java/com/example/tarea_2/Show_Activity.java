package com.example.tarea_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tarea_2.Clases.persona;

public class Show_Activity extends AppCompatActivity {

    private persona person;
    TextView txtNameS, txtApelS, txtAgeS, txtemailS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        person = new persona();
        Bundle bundle = getIntent().getExtras();
        person.setNombres(bundle.getString("nombres"));
        person.setApellidos(bundle.getString("apellidos"));
        person.setEdad(bundle.getDouble("edad"));
        person.setCorreo(bundle.getString("email"));
        chargeObj();
    }

    private void chargeObj(){
        txtNameS = (TextView) findViewById(R.id.txtNameS);
        txtNameS.setText(person.getNombres());
        txtApelS = (TextView) findViewById(R.id.txtApelS);
        txtApelS.setText(person.getApellidos());
        txtAgeS = (TextView) findViewById(R.id.txtAgeS);
        txtAgeS.setText(Double.toString(person.getEdad()));
        txtemailS = (TextView) findViewById(R.id.txtemailS);
        txtemailS.setText(person.getCorreo());
    }
}