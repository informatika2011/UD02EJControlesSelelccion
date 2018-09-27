package com.example.amaia.ud02ejcontrolesselelccion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class EJ03ListView extends AppCompatActivity {

    private ListView lstListView1;
    private TextView lblOpcionSeleccionadaLV1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej03_list_view);

        lstListView1 = (ListView) findViewById (R.id.LstOpciones1);
        lblOpcionSeleccionadaLV1 =(TextView)findViewById(R.id.lblOpcSeleccionadaLV1);

        //OPCION 1: Utilizando un array datosLV (Datos ListVeiw)
        final String[] datosLV = new String[]{"LV-Elemento 1", "LV-Elemento 2","LV-Elemento 3","LV-Elemento 4",
                "LV-Elemento 5","LV-Elemento 6","LV-Elemento 7","LV-Elemento 8","LV-Elemento 9","LV-Elemento 10"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datosLV);
        //adaptador.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line); // setDropDownViewResource se utiliza para definir el tipo de layout que se utilizará para mostrar la lista completa de opciones
        lstListView1.setAdapter(adaptador);

        lstListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Seleccionada: "+ (parent.getItemIdAtPosition(position)+1) +"- "+parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
                lblOpcionSeleccionadaLV1.setText("Seleccionada: "+
                        (parent.getItemIdAtPosition(position)+1)+" "+ parent.getItemAtPosition(position));
            }
        });
    }
}
