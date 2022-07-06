package com.example.whole_automation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Script;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Salon extends AppCompatActivity {
    Button on_LuzSalon, off_LuzSalon, on_CalefaccionSalon, off_CalefaccionSalon, humedad_salon;
    TextView temperatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon);
        on_LuzSalon=findViewById(R.id.on_LuzSalon);
        off_LuzSalon=findViewById(R.id.off_LuzSalon);
        on_CalefaccionSalon=findViewById(R.id.on_CalefaccionSalon);
        off_CalefaccionSalon=findViewById(R.id.off_CalefaccionSalon);
        humedad_salon=findViewById(R.id.humedad_salon);
        temperatura = findViewById(R.id.temp);

        on_LuzSalon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                encederlampara("http://192.168.1.243/WebCasa/onLampara.php");
            }

        });

        off_LuzSalon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apagarlampara("http://192.168.1.243/WebCasa/offLampara.php");
            }
        });

        on_CalefaccionSalon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                encendercalefaccion("http://192.168.1.243/WebCasa/onCalefaccion.php");
            }
        });

        off_CalefaccionSalon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apagarcalefaccion("http://192.168.1.243/WebCasa/offCalefaccion.php");
            }
        });

        humedad_salon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp_hum("http://192.168.1.243/WebCasa/temp_hum.php");
            }
        });

    }
    public void encederlampara(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.isEmpty()){
                    Toast.makeText(Salon.this, "Encendida Correctamente", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Salon.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Salon.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String on = "on";
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("on", on);
                return parametros;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void apagarlampara(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.isEmpty()){
                    Toast.makeText(Salon.this, "Apagada Correctamente", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Salon.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Salon.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String off = "off";
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("off", off);
                return parametros;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void encendercalefaccion(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.isEmpty()){
                    Toast.makeText(Salon.this, "Encendida Correctamente", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Salon.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Salon.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String on = "on";
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("on", on);
                return parametros;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void apagarcalefaccion(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.isEmpty()){
                    Toast.makeText(Salon.this, "Apagada Correctamente", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Salon.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Salon.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String off = "off";
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("off", off);
                return parametros;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void temp_hum(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                temperatura.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Salon.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}