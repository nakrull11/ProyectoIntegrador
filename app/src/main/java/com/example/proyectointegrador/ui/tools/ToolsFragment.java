package com.example.proyectointegrador.ui.tools;

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
import com.example.proyectointegrador.ClasesModelo.PagoModelo;
import com.example.proyectointegrador.ClasesModelo.PropietarioModelo;
import com.example.proyectointegrador.ListAdapter;
import com.example.proyectointegrador.R;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ToolsFragment extends Fragment {
    private List<AlquilerModelo> listaAlquileres ;
    private List<PagoModelo> listaPagos;

    private ToolsViewModel toolsViewModel;

    public View onCreateView(@NonNull final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel = ViewModelProviders.of(this).get(ToolsViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_tools, container, false);
        final Spinner spinner = root.findViewById(R.id.spPagos);
        PropietarioModelo gustavo = new PropietarioModelo(1,37723905,"rivarola","gustavo","2665102305","gusguz1994@gmail.com","12345");
        InmuebleModelo departamento = new InmuebleModelo(1,"las heras,255",3,"casa","residencial",5000,true,gustavo);
        InquilinoModelo juan = new InquilinoModelo(1,123456,"sosa","juan","potrero","123456");
        AlquilerModelo primerAlquiler = new AlquilerModelo(1,5000,new Date(2019,10,14),new Date(2019,11,14),juan,departamento);
        PagoModelo primerPago = new PagoModelo(1,1,new Date(2019,10,14),5000,primerAlquiler);
        listaAlquileres = new ArrayList<>();
        listaPagos= new ArrayList<>();
        listaAlquileres.add(primerAlquiler);
        listaPagos.add(primerPago);

        List<String> tituloSp = new ArrayList<>();
        for (AlquilerModelo alquiler: listaAlquileres){
            tituloSp.add(alquiler.getInmueble().getDireccion()+"");
        }
        spinner.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,tituloSp));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                List<PagoModelo> pagosCorrespondientes = new ArrayList<>();
                for (AlquilerModelo alquiler: listaAlquileres) {
                    if(alquiler.getInmueble().getDireccion().equals(spinner.getSelectedItem())){
                        for (PagoModelo pago: listaPagos) {
                        if(pago.getAlquiler().getIdAlquiler() == alquiler.getIdAlquiler()){
                            pagosCorrespondientes.add(pago);
                        }
                        }
                    }
                }

                ArrayAdapter<PagoModelo> adapter = new ListAdapterPago(getContext(),R.layout.pago_item,pagosCorrespondientes,inflater);

                ListView listView = root.findViewById(R.id.listPagos);

                listView.setAdapter(adapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return root;
    }
    public class ListAdapterPago extends ArrayAdapter<PagoModelo> {
        private Context context;
        private List<PagoModelo> lista;
        private LayoutInflater layoutInflater;

        public ListAdapterPago(@NonNull Context context, int resource, @NonNull List<PagoModelo> objects, LayoutInflater layoutInflater) {
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
                itemView=layoutInflater.inflate(R.layout.pago_item,parent,false);
            }
            PagoModelo pago=lista.get(position);

            TextView nroPago= itemView.findViewById(R.id.tvNroPago);

            nroPago.setText(pago.getNroPago()+"");

            TextView fecha = itemView.findViewById(R.id.tvFecha);

            fecha.setText(DateFormat.getDateInstance().format(pago.getFecha()) );

            TextView importe = itemView.findViewById(R.id.tvImporte);

            importe.setText(pago.getImporte()+"");


            return itemView;
        }
    }
}