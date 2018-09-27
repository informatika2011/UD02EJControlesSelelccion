package com.example.amaia.ud02ejcontrolesselelccion;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.amaia.ud02ejcontrolesselelccion.R.id.lblTitulo;

public class EJ06ViewHolder extends AppCompatActivity {

    private EJ05Titular[] datosVH =
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

    private ListView lblOpcionesVH;
    private TextView lblOpcionSeleccionadaVH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej06_view_holder);

        lblOpcionesVH =(ListView) findViewById(R.id.lstListViewTitularesVH);
        lblOpcionSeleccionadaVH = (TextView) findViewById(R.id.lblTitularSeleccionadoVH);


        //Cabecera
        View cabecera = getLayoutInflater().inflate(R.layout.ej05_list_header, null);
        lblOpcionesVH.addHeaderView(cabecera);

        //Adaptador
        EJ06ViewHolder.EJ06AdaptadorTitularesOptimizado adaptadorTitulares = new EJ06ViewHolder.EJ06AdaptadorTitularesOptimizado(this, datosVH);

        lblOpcionesVH.setAdapter(adaptadorTitulares);

        lblOpcionesVH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tituloSeleccionado =((EJ05Titular) parent.getItemAtPosition(position)).getTitulo();
                lblOpcionSeleccionadaVH.setText("La opción seleccionada es: "+tituloSeleccionado);
            }
        });
    }

    class EJ06AdaptadorTitularesOptimizado extends ArrayAdapter<EJ05Titular> {

        public EJ06AdaptadorTitularesOptimizado(Context context, EJ05Titular[] datos) {
            super(context, R.layout.ej05_listitem_titular, datos);
            datosVH= datos;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView;
            ViewHolder holder;

            if (item==null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                item = inflater.inflate(R.layout.ej05_listitem_titular, null);

                holder = new ViewHolder();
                holder.titulo= (TextView)item.findViewById(lblTitulo);
                holder.subtitulo =(TextView)item.findViewById(R.id.lblSubTitulo);

                item.setTag(holder);
            }
            else
                    holder = (ViewHolder) item.getTag();

            holder.titulo.setText(datosVH[position].getTitulo());
            holder.subtitulo.setText(datosVH[position].getSubTitulo());

            return(item);
        }
    }
    static class ViewHolder {
        TextView titulo;
        TextView subtitulo;
    }
}
