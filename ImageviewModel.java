package com.example.galeriamvvm;

import androidx.lifecycle.ViewModel;

public class ImageviewModel extends ViewModel {
    private int indeks;

    public int getIndeks() {
        return indeks;
    }

    public void setIndeks(int indeks) {
        this.indeks = indeks;
    }
}
