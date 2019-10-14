package com.example.proyectointegrador.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectointegrador.ClasesModelo.InquilinoModelo;
import com.example.proyectointegrador.ListAdapter;
import com.example.proyectointegrador.R;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {
    private ArrayList<InquilinoModelo> listaInquilinos = new ArrayList<>();

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel = ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        InquilinoModelo gustavo = new InquilinoModelo(1,37723905,"rivarola","gustavo","122viv,san luis","2665102305");
        listaInquilinos.add(gustavo);
        InquilinoModelo juan = new InquilinoModelo(2,1614151,"sanchez","juan","544viv,san luis","2664123456");
        listaInquilinos.add(juan);
        ArrayAdapter<InquilinoModelo> adapter = new ListAdapter(getContext(),R.layout.inquilino_item,listaInquilinos,inflater);
        ListView listView = root.findViewById(R.id.listinquilinos);
        listView.setAdapter(adapter);

        return root;
    }
}