package com.example.whole_automation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button salon, cocina, lavabo, hab1, hab2, hab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        salon = findViewById(R.id.salon);
        cocina = findViewById(R.id.cocina);
        lavabo = findViewById(R.id.lavabo);
        hab1 = findViewById(R.id.hab1);
        hab2 = findViewById(R.id.hab2);
        hab3 = findViewById(R.id.hab3);

        salon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Salon.class);
                startActivity(intent);
            }
        });

        cocina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Cocina.class);
                startActivity(intent);
            }
        });

        lavabo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Lavabo.class);
                startActivity(intent);
            }
        });

        hab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Hab1.class);
                startActivity(intent);
            }
        });

        hab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Hab2.class);
                startActivity(intent);
            }
        });

        hab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Hab3.class);
                startActivity(intent);
            }
        });

    }
}