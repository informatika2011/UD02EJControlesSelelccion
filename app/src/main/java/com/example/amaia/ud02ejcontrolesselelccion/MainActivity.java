package com.example.amaia.ud02ejcontrolesselelccion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.amaia.ud02ejcontrolesselelccion.R.id.btnListView2;
import static com.example.amaia.ud02ejcontrolesselelccion.R.id.lblOpcSeleccionada2;

public class MainActivity extends AppCompatActivity {

    private Button btnSpinner1, btnSpinner2;
    private Button btnListView1,btnListView2, btnListView3;
    private Button btnViewHolder;
    private Button btnGridView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSpinner1 =(Button)findViewById(R.id.btnSpinner1);
        btnSpinner2 = (Button)findViewById(R.id.btnSpinner2);

        btnSpinner1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, EJ01Spinner.class);
                startActivity(intento);
            }
        });

        btnSpinner2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent (MainActivity.this, EJ02Spinner.class);
                startActivity(intento);
            }
        });

        btnListView1 = (Button)findViewById(R.id.btnListView1);
        btnListView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent (MainActivity.this, EJ03ListView.class);
                startActivity(intento);
            }
        });

        btnListView2 = (Button)findViewById(R.id.btnListView2);
        btnListView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent (MainActivity.this, EJ04ListView.class);
                startActivity(intento);
            }
        });

        btnListView3 = (Button)findViewById(R.id.btnListView3);
        btnListView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, EJ05ListView.class);
                startActivity(intento);
            }
        });

        btnViewHolder = (Button)findViewById(R.id.btnViewHolder);
        btnViewHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, EJ06ViewHolder.class);
                System.out.println("Llamando a EJ07");
                startActivity(intento);
            }
        });

        btnGridView = (Button)findViewById(R.id.btnGridView);
        btnGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, EJ07GridView.class);
                startActivity(intento);
            }
        });
    }
}
