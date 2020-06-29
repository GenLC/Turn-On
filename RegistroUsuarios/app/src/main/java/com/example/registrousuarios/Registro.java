package com.example.registrousuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.registrousuarios.Clientes.Clientes_AD;
import com.example.registrousuarios.Locales.Locales_AD;

public class Registro extends AppCompatActivity {
    EditText Nombre, Correo, Contra1, Contra2, NombreLocal, Rubro,NombreRegistro;
    CheckBox chkLcoal;
    Button Aceptar, Salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        NombreRegistro = findViewById(R.id.edtNombreRegistro);
        Correo = findViewById(R.id.edtCorreoRegistro);
        Contra1 = findViewById(R.id.edtContraseña1);
        Contra2= findViewById(R.id.edtContraseña2);
        NombreLocal= findViewById(R.id.edtNombreLocal);
        Rubro= findViewById(R.id.edtRubro);
        chkLcoal= findViewById(R.id.checkBox);
        Aceptar= findViewById(R.id.btnAceptarRegistro);
        Salir= findViewById(R.id.btnSalir);



        Salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        Aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarCliente();
            }
        });
    }

    private void RegistrarCliente() {
        //ConexionBDHelper conn = new ConexionBDHelper(this, Utiles_BD.BD_Nombre,null);
        //SQLiteDatabase db= conn.getReadableDatabase();


        Integer TipoUsuario;// 100 para cliente, 101 paar Local


        if (chkLcoal.isChecked()) {
            //local
            TipoUsuario = 101;
            Long IdCliente = Clientes_AD.InsertarUsuario(getApplicationContext(),TipoUsuario,NombreRegistro.getText().toString(),Contra1.getText().toString(),Correo.getText().toString());

            Long IdLocal = Locales_AD.InsertarLocal(getApplicationContext(), IdCliente, NombreLocal.getText().toString(), Rubro.getText().toString());
            Toast.makeText(this, "Registro Local Completo su codigo es: "+ IdLocal, Toast.LENGTH_SHORT).show();

        }else{
            // Usuario
            TipoUsuario= 100;
            Long IdCliente = Clientes_AD.InsertarUsuario(getApplicationContext(),TipoUsuario,NombreRegistro.getText().toString(),Contra1.getText().toString(),Correo.getText().toString());
            Toast.makeText(this, "Registro Usuario Completo su codigo es: "+ IdCliente, Toast.LENGTH_SHORT).show();

        }

    }
}