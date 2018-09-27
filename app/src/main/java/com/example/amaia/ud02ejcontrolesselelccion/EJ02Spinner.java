package com.example.amaia.ud02ejcontrolesselelccion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class EJ02Spinner extends AppCompatActivity {
    private Spinner cmbOpciones2;
    private TextView lblOpcSeleccionada2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej02_spinner);

        cmbOpciones2 =(Spinner)findViewById(R.id.CmbOpciones2);
        lblOpcSeleccionada2 = (TextView) findViewById(R.id.lblOpcSeleccionada2);

        //OPCION 2: con archivo values_array.xml
        //Adaptador de tipo ArrayAdapter, pero utilizando el array definindo en el archivo valores_array.xml
        ArrayAdapter adaptador2 = ArrayAdapter.createFromResource(this,
                R.array.valores_array, android.R.layout.simple_spinner_item);

        adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones2.setAdapter(adaptador2);

        cmbOpciones2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lblOpcSeleccionada2.setText ("Seleccionada: "+
                        (parent.getItemIdAtPosition(position)+1)+" "+ parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                lblOpcSeleccionada2.setText("No se ha realizado" +
                        " ninguna selección");
            }
        });



    }
}
