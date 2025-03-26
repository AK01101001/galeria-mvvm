package com.example.galeriamvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ImageviewModel extends ViewModel {

    MutableLiveData<Integer> indeks;

    Integer pobierzindeks()
    {
        isset();
        return indeks.getValue();
    }
    void ustawIndeks(int i)
    {
        isset();
        indeks.setValue(i);
    }
    void prawo()
    {
        isset();
        indeks.setValue(pobierzindeks()+1);
    }
    void lewo()
    {
        isset();
        indeks.setValue(pobierzindeks()-1);
    }
    void isset()
    {
        if (indeks==null)
        {
            indeks = new MutableLiveData<>();
            indeks.setValue(0);
        }

    }
}
