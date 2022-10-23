package com.example.tarea_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tarea_2.Clases.persona;

public class Send_Activity extends AppCompatActivity {

    private EditText txtNameM, txtApelM, txtAgeM, txtEmailM;
    private Button btnSendM;
    private Intent intent;
    private persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        chargeObj();
        intent = new Intent(getApplicationContext(), Show_Activity.class);
        persona = new persona();

        btnSendM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtNameM.getText().toString().isEmpty())
                    Toast.makeText(Send_Activity.this, "!!Aviso " + "\n no puede dejar campos vacios : Nombres", Toast.LENGTH_SHORT).show();
                else if(txtApelM.getText().toString().isEmpty())
                    Toast.makeText(Send_Activity.this, "!!Aviso " + "\n no puede dejar campos vacios : Apellidos", Toast.LENGTH_SHORT).show();
                else if(txtAgeM.getText().toString().isEmpty())
                    Toast.makeText(Send_Activity.this, "!!Aviso " + "\n no puede dejar campos vacios : Edad", Toast.LENGTH_SHORT).show();
                else if(txtEmailM.getText().toString().isEmpty())
                    Toast.makeText(Send_Activity.this, "!!Aviso " + "\n no puede dejar campos vacios : Correo", Toast.LENGTH_SHORT).show();
                else{
                    intent = sendData(intent);
                    startActivity(intent);
                }
            }
        });
    }

    private Intent sendData(Intent inte){
        persona.setNombres(txtNameM.getText().toString());
        persona.setApellidos(txtApelM.getText().toString());
        persona.setEdad(Double.parseDouble(txtAgeM.getText().toString()));
        persona.setCorreo(txtEmailM.getText().toString());
        inte.putExtra("nombres", persona.getNombres());
        inte.putExtra("apellidos", persona.getApellidos());
        inte.putExtra("edad", persona.getEdad());
        inte.putExtra("email", persona.getCorreo());
        return inte;
    }

    private void chargeObj(){
        txtNameM = (EditText) findViewById(R.id.txtNameM);
        txtApelM = (EditText) findViewById(R.id.txtApelM);
        txtAgeM = (EditText) findViewById(R.id.txtAgeM);
        txtEmailM = (EditText) findViewById(R.id.txtEmailM);
        btnSendM = (Button) findViewById(R.id.btnSendM);
    }
}