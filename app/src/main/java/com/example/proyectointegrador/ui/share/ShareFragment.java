package com.example.proyectointegrador.ui.share;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectointegrador.ClasesModelo.AlquilerModelo;
import com.example.proyectointegrador.ClasesModelo.InmuebleModelo;
import com.example.proyectointegrador.ClasesModelo.InquilinoModelo;
import com.example.proyectointegrador.ClasesModelo.PropietarioModelo;
import com.example.proyectointegrador.R;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;

    List<AlquilerModelo> alquileres;

    public View onCreateView(@NonNull final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        shareViewModel = ViewModelProviders.of(this).get(ShareViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_share, container, false);

        final Spinner spiner = root.findViewById(R.id.spPropiedades);

        List<String> spTitulos = new ArrayList<>();

        alquileres = new ArrayList<>();

        PropietarioModelo propietario_01 = new PropietarioModelo(1,37723905,"rivrola","gustavo","2665102305","gusguz1994@gmail.com","12345");

        InquilinoModelo inquilino_01 = new InquilinoModelo(1,123456,"sosa","juan","potrero","123456");
        InquilinoModelo inquilino_02 = new InquilinoModelo(2,123456,"rodriguez","lucas","la punta","123456");
        InquilinoModelo inquilino_03 = new InquilinoModelo(3,4431234,"ramirez","jessica","juana koslay","123456");

        InmuebleModelo inmueble_01 = new InmuebleModelo(1,"las heras 561",3,"departamento","vivienda",5000,true,propietario_01);
        InmuebleModelo inmueble_02 = new InmuebleModelo(2,"chacabuco 822",3,"deposito","deposito",3500,true,propietario_01);
        InmuebleModelo inmueble_03 = new InmuebleModelo(3,"los lapachos",2,"comercio","comercial",3000,true,propietario_01);

        AlquilerModelo alquiler_01 = new AlquilerModelo(1,5000,new Date(2019,10,14),new Date(2019,11,14),inquilino_01,inmueble_01);
        alquileres.add(alquiler_01);
        AlquilerModelo alquiler_02 = new AlquilerModelo(2,3500,new Date(2019,10,14),new Date(2019,11,14),inquilino_02,inmueble_02);
        alquileres.add(alquiler_02);
        AlquilerModelo alquiler_03 = new AlquilerModelo(3,3000,new Date(2019,10,14),new Date(2019,11,14),inquilino_03,inmueble_03);
        alquileres.add(alquiler_03);

        for (AlquilerModelo a: alquileres) {
            spTitulos.add(a.getInmueble().getDireccion());
        }

        spiner.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,spTitulos));

        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                List<AlquilerModelo> alquileresCorrespondientes = new ArrayList<>();
                for (AlquilerModelo a: alquileres) {
                    if(a.getInmueble().getDireccion().equals(spiner.getSelectedItem())){
                        alquileresCorrespondientes.add(a);
                    }
                }
                ArrayAdapter<AlquilerModelo> adapter= new ListAdapterAlquiler(getActivity(),R.layout.alquiler_item,alquileresCorrespondientes,inflater);
                ListView lv= root.findViewById(R.id.listAlquiler);
                lv.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return root;
    }
    public class ListAdapterAlquiler extends ArrayAdapter<AlquilerModelo> {
        private Context context;
        private List<AlquilerModelo> lista;
        private LayoutInflater layoutInflater;

        public ListAdapterAlquiler(@NonNull Context context, int resource, @NonNull List<AlquilerModelo> objects, LayoutInflater layoutInflater) {
            super(context, resource, objects);
            this.context= context;
            this.lista=objects;
            this.layoutInflater=layoutInflater;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View itemView=convertView;
            if(itemView==null){
                itemView=layoutInflater.inflate(R.layout.alquiler_item,parent,false);
            }
            AlquilerModelo alquilerModelo=lista.get(position);

            TextView fechaIni= itemView.findViewById(R.id.tvFechaInicio);
            fechaIni.setText(DateFormat.getDateInstance().format(alquilerModelo.getFechaInicio()));
            TextView fechaFin= itemView.findViewById(R.id.tvFechaFinal);
            fechaFin.setText(DateFormat.getDateInstance().format(alquilerModelo.getFechaFin()));
            TextView precio= itemView.findViewById(R.id.tvPrecioAlqu);
            precio.setText(alquilerModelo.getPrecio()+"");
            return itemView;
        }
    }
}