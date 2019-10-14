package com.example.proyectointegrador.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.proyectointegrador.FragmentPropiedades;
import com.example.proyectointegrador.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    private ViewPager vp;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);


        vp = root.findViewById(R.id.viewPager);

        appBarLayout = root.findViewById(R.id.appBar);

        tabLayout = new TabLayout(getContext());


        appBarLayout.addView(tabLayout);
        ViewPageAdapter vpa = new ViewPageAdapter(getChildFragmentManager());

        vpa.addFragment(new FragmentPropiedades(),"Prop 1");
        vpa.addFragment(new FragmentPropiedades(),"Prop 2");

        vp.setAdapter(vpa);

        tabLayout.setupWithViewPager(vp);


        return root;
    }

    public class ViewPageAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> titulosFragment =  new ArrayList<>();

        public ViewPageAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titulosFragment.get(position);
        }

        public void addFragment(Fragment fragment,String titulo){
            fragmentList.add(fragment);
            titulosFragment.add(titulo);
        }


    }


}