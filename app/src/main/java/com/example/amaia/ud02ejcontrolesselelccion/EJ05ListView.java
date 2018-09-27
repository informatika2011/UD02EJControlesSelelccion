package com.example.amaia.ud02ejcontrolesselelccion;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class EJ05ListView extends AppCompatActivity {

    private EJ05Titular[] datos =
            new EJ05Titular[]{
                    new EJ05Titular("Título 1", "Subtítulo largo 1"),
                    new EJ05Titular("Título 2", "Subtítulo largo 2"),
                    new EJ05Titular("Título 3", "Subtítulo largo 3"),
                    new EJ05Titular("Título 4", "Subtítulo largo 4"),
                    new EJ05Titular("Título 5", "Subtítulo largo 5"),
                    new EJ05Titular("Título 6", "Subtítulo largo 6"),
                    new EJ05Titular("Título 7", "Subtítulo largo 7"),
                    new EJ05Titular("Título 8", "Subtítulo largo 8"),
                    new EJ05Titular("Título 9", "Subtítulo largo 9"),
                    new EJ05Titular("Título 10", "Subtítulo largo 10"),
                    new EJ05Titular("Título 11", "Subtítulo largo 11"),
                    new EJ05Titular("Título 12", "Subtítulo largo 12"),
                    new EJ05Titular("Título 13", "Subtítulo largo 13"),
                    new EJ05Titular("Título 14", "Subtítulo largo 14"),
                    new EJ05Titular("Título 15", "Subtítulo largo 15"),
                    new EJ05Titular("Título 16", "Subtítulo largo 16")};

    private ListView lblOpciones;
    private TextView lblOpcionSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej05_list_view);


        lblOpciones = (ListView)findViewById(R.id.LstListViewLibros);
        lblOpcionSeleccionada =(TextView)findViewById(R.id.LblTitularSeleccionado);

        //Cabecera
        View cabecera = getLayoutInflater().inflate(R.layout.ej05_list_header, null);
        lblOpciones.addHeaderView(cabecera);

        //Adaptador
        EJ05AdaptadorTitulares adaptadorTitulares = new EJ05AdaptadorTitulares(this, datos);

        lblOpciones.setAdapter(adaptadorTitulares);

        //Eventos
        lblOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seleccionada = ((EJ05Titular)parent.getItemAtPosition(position)).getTitulo();

                lblOpcionSeleccionada.setText("La opcion seleccionada es: "+ (position)+": "+seleccionada);

                Toast.makeText(getApplicationContext(),"Opcion selecciona: ("+(position)+": "+seleccionada+")",
                        Toast.LENGTH_SHORT).show();

            }
        });


    }

    class EJ05AdaptadorTitulares extends ArrayAdapter<EJ05Titular> {

        public EJ05AdaptadorTitulares(Context context, EJ05Titular[] datos) {
            super(context, R.layout.ej05_listitem_titular, datos);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.ej05_listitem_titular, null);
            TextView lblTitulo = (TextView)item.findViewById(R.id.lblTitulo);
            lblTitulo.setText(datos[position].getTitulo());

            TextView lblSubTitulo = (TextView)item.findViewById(R.id.lblSubTitulo);
            lblSubTitulo.setText(datos[position].getSubTitulo());

            return (item);
        }
    }
}
