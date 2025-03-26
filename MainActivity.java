package com.example.galeriamvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
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
    public MainActivity instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        instance = this;
        binding.lewo.setOnClickListener(view1 -> lewo());
        binding.prawo.setOnClickListener(view1 -> prawo());
        obrazy = new ArrayList<Integer>();
        imageviewModel = new ViewModelProvider(this).get(ImageviewModel.class);
        imageviewModel.indeks.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                wyswietl();
            }
        });
        dodajobrazy();

    }

    private void dodajobrazy() {
        obrazy.add(R.drawable.wb);
        obrazy.add(R.drawable.mire);
        obrazy.add(R.drawable.wh);
        wyswietl();
    }

    private void prawo()
    {
        imageviewModel.prawo();
        if (imageviewModel.pobierzindeks()>obrazy.size()-1)
        {
            imageviewModel.ustawIndeks(0);
        }
    }
    private void lewo()
    {
        imageviewModel.lewo();

        if (imageviewModel.pobierzindeks()<0)
        {
            imageviewModel.ustawIndeks(obrazy.size()-1);
        }
    }
    private void wyswietl() {
        binding.image.setImageResource(obrazy.get(imageviewModel.pobierzindeks()));
    }
}