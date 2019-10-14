package com.example.proyectointegrador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.proyectointegrador.ClasesModelo.InquilinoModelo;

import java.util.List;

public class ListAdapter extends ArrayAdapter<InquilinoModelo>{
    private Context context;
    private List<InquilinoModelo> listaInquilinos;
    private LayoutInflater layoutInflater;

    public ListAdapter(@NonNull Context context, int resource, @NonNull List<InquilinoModelo> objects, LayoutInflater layoutInflater) {
        super(context, resource, objects);
        this.context= context;
        this.listaInquilinos=objects;
        this.layoutInflater=layoutInflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView= convertView;
        if(itemView==null){
            itemView=layoutInflater.inflate(R.layout.inquilino_item,parent,false);
        }
        InquilinoModelo inquilino=listaInquilinos.get(position);

        TextView dni= itemView.findViewById(R.id.tvDni);
        dni.setText(inquilino.getDni()+"");

        TextView nombre= itemView.findViewById(R.id.tvNombre);
        nombre.setText(inquilino.getNombre()+"");

        TextView apellido= itemView.findViewById(R.id.tvApellido);
        apellido.setText(inquilino.getApellido()+"");

        TextView direccion= itemView.findViewById(R.id.tvDireccion);
        direccion.setText(inquilino.getDireccion()+"");

        TextView telefono= itemView.findViewById(R.id.tvTelefono);
        telefono.setText(inquilino.getTelefono()+"");

        return itemView;
    }
}
