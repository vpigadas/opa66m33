package com.example.myapplication.smaple;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SampleViewModel extends ViewModel {

    private int counter = 0;
    private MutableLiveData<Integer> _streamCounter = new MutableLiveData<>(0);
    LiveData<Integer> streamCounter = _streamCounter;

    public void decreaseCounter() {
        int counter = _streamCounter.getValue() - 1;
//        return counter;
        _streamCounter.postValue(counter);
    }

    public void increaseCounter() {
        int counter = _streamCounter.getValue() + 1;

        _streamCounter.postValue(counter);
    }
}
