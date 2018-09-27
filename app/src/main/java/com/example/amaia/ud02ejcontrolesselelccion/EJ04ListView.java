package com.example.amaia.ud02ejcontrolesselelccion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class EJ04ListView extends AppCompatActivity {

    private ListView lstListView2;
    private TextView lblOpcionSeleccionadaLV2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej04_list_view);

        lstListView2 = (ListView)findViewById(R.id.LstOpciones2);
        lblOpcionSeleccionadaLV2 = (TextView)findViewById(R.id.lblOpcSeleccionadaLV2);

        ArrayAdapter adaptador2 = ArrayAdapter.createFromResource(this,
                R.array.valores_array_LV, android.R.layout.simple_list_item_1);
        lstListView2.setAdapter(adaptador2);

        lstListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Seleccionada: "+ (parent.getItemIdAtPosition(position)+1) +"- "+parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
                lblOpcionSeleccionadaLV2.setText("Seleccionada: "+
                        (parent.getItemIdAtPosition(position)+1)+" "+ parent.getItemAtPosition(position));
            }
        });
    }
}
