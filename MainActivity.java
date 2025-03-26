package com.example.galeriamvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.example.galeriamvvm.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ImageviewModel imageviewModel;
    private ArrayList<Integer> obrazy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.lewo.setOnClickListener(view1 -> lewo());
        binding.prawo.setOnClickListener(view1 -> prawo());
        obrazy = new ArrayList<Integer>();
        dodajobrazy();
        imageviewModel = new ViewModelProvider(this).get(ImageviewModel.class);
    }

    private void dodajobrazy() {
        obrazy.add(R.drawable.wb);
        obrazy.add(R.drawable.mire);
        obrazy.add(R.drawable.wh);
    }

    private void prawo()
    {
        imageviewModel.setIndeks(imageviewModel.getIndeks()+1);
        if (imageviewModel.getIndeks()>obrazy.size()-1)
        {
            imageviewModel.setIndeks(0);
        }
        wyswietl();
    }
    private void lewo()
    {
        imageviewModel.setIndeks(imageviewModel.getIndeks()-1);

        if (imageviewModel.getIndeks()<0)
        {
            imageviewModel.setIndeks(obrazy.size()-1);
        }
        wyswietl();
    }
    private void wyswietl() {
        binding.image.setImageResource(obrazy.get(imageviewModel.getIndeks()));
    }
}