package com.example.sugondese;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomePageFragment extends Fragment {

    Button pizzaBtn,burgerBtn,chineseBtn,italianBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        pizzaBtn = view.findViewById(R.id.pizzaBtn);
        burgerBtn = view.findViewById(R.id.burgerBtn);
        chineseBtn = view.findViewById(R.id.chineseBtn);
        italianBtn = view.findViewById(R.id.italianBtn);



        pizzaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePageFragment.this.getContext(), Pizza_Category.class));

            }
        });

        burgerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePageFragment.this.getContext(), Burger_Category.class));
            }
        });

        chineseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePageFragment.this.getContext(),Chinese_Category.class));
            }
        });

        italianBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePageFragment.this.getContext(), Italian_Category.class));
            }
        });



        return view;

    }


}