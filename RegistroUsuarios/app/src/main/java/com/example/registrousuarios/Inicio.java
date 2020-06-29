package com.example.registrousuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.registrousuarios.BD.ConexionBDHelper;
import com.example.registrousuarios.BD.Utiles_BD;
import com.example.registrousuarios.Clientes.Clientes_AD;
import com.example.registrousuarios.Clientes.Clientes_Inicio;
import com.example.registrousuarios.Locales.Locales_AD;
import com.example.registrousuarios.Locales.Locales_Inicio;

public class Inicio extends AppCompatActivity {

    Button IniciarSesion, Listar, Registarse;
    EditText Correo, Contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Correo= findViewById(R.id.edtContraseñaInicioSesion);
        Contraseña=findViewById(R.id.edtContraseñaInicioSesion);
        IniciarSesion = findViewById(R.id.btnIniciarSesion);
        Listar = findViewById(R.id.btnListarUsuarios);
        Registarse = findViewById(R.id.btnRegistrarse);


        Registarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Inicio.this, Registro.class);
                startActivity(intent);
            }
        });

        Listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        IniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IniciarSesion();
            }
        });

    }


    private void IniciarSesion() {
        //Buscar contraseña y correo por separado

        Long  IdUsuario = Clientes_AD.Corroborar(getApplicationContext(),Correo.getText().toString(),Contraseña.getText().toString());

        if (IdUsuario  != null){

            Long IdLocal= Locales_AD.BuscarLocal(getApplicationContext(),IdUsuario);

            if (IdLocal != null ){

                Intent intent = new Intent(Inicio.this, Locales_Inicio.class);
                startActivity(intent);
                Toast.makeText(this, "INICIO CORRECTO COMO LOCAL ID: "+ IdLocal, Toast.LENGTH_SHORT).show();

            }else{
                Intent intent = new Intent(Inicio.this, Clientes_Inicio.class);
                startActivity(intent);
                Toast.makeText(this, "INICIO CORRECTO COMO USUARIO ID: " + IdUsuario, Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "El correo no existe", Toast.LENGTH_SHORT).show();
        }
    }


}