package com.example.galeriamvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ImageviewModel extends ViewModel {

    MutableLiveData<Integer> indeks;

    public MutableLiveData<Integer> getIndeks() {
        if (indeks==null)
        {
            indeks = new MutableLiveData<>();
        }
        return indeks;
    }

    public void setIndeks(MutableLiveData<Integer> indeks) {
        if (indeks==null)
        {
            indeks = new MutableLiveData<>();
        }
        this.indeks = indeks;
    }
    int pobierzindeks()
    {
        return indeks.getValue();
    }
    void ustawIndeks(int i)
    {
        indeks.setValue(i);
    }
    void prawo()
    {
        indeks.setValue(indeks.getValue()+1);
    }
    void lewo()
    {
        indeks.setValue(indeks.getValue()-1);
    }
}
