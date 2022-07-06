package com.example.whole_automation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Registro extends AppCompatActivity {
    ///var/www/html/WebCasa
    EditText etUsuario, edtPassword;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etUsuario = findViewById(R.id.etUsuario);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        edtPassword=findViewById(R.id.etContrasena);


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar("http://YourPathHere");
            }
        });
    }

    public void registrar(String URL) {
        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // En este apartado se programa lo que deseamos hacer en caso de no haber errores
                        if(!response.isEmpty()){
                            Toast.makeText(Registro.this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(Registro.this, "Registro Realizado Correctamente", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // En caso de tener algun error en la obtencion de los datos
                Toast.makeText(Registro.this, "ERROR CON LA CONEXION", Toast.LENGTH_LONG).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("usuario", etUsuario.getText().toString());
                parametros.put("password", edtPassword.getText().toString());
                return parametros;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


}