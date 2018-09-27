package com.example.amaia.ud02ejcontrolesselelccion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EJ01Spinner extends AppCompatActivity {

    private Spinner cmbOpciones;
    private TextView lblOpcSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej01_spinner);



        //Opción 1
        cmbOpciones =(Spinner)findViewById(R.id.CmbOpciones);
        lblOpcSeleccionada = (TextView)findViewById(R.id.lblOpcSeleccionada);

        //OPCION 1: Utilizando un array
        final String[] datos = new String[]{"Elemento 1", "Elemento 2","Elemento 3","Elemento 4",
                "Elemento 5","Elemento 6","Elemento 7","Elemento 8","Elemento 9","Elemento 10"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,datos);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones.setAdapter(adaptador);


        cmbOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Seleccionada: "+ (parent.getItemIdAtPosition(position)+1) +"- "+parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
                lblOpcSeleccionada.setText("Seleccionada: "+
                        (parent.getItemIdAtPosition(position)+1)+" "+ parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                lblOpcSeleccionada.setText("No se ha realizado" +
                        " ninguna selección");
            }
        });


    }
}
