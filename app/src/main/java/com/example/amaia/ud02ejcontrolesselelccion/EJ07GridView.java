package com.example.amaia.ud02ejcontrolesselelccion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class EJ07GridView extends AppCompatActivity {

    private String[] datosGV = new String[50];
    private GridView grdOpciones;
    private TextView lblOpcionSeleccionadaGV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej07_grid_view);

        for (int i=1; i<=50; i++)
            datosGV[i-1]="Dato "+i;

        ArrayAdapter<String> adaptadorGV =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datosGV);

        lblOpcionSeleccionadaGV=(TextView)findViewById(R.id.lblSeleccionadoGV);
        grdOpciones = (GridView)findViewById(R.id.GridOpciones);
        grdOpciones.setAdapter(adaptadorGV);

        grdOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                lblOpcionSeleccionadaGV.setText(parent.getItemAtPosition(position).toString());
            }
        });
    }
}
