package com.pay.sampleapp.utils;

import androidx.lifecycle.Observer;

import java.text.ParseException;

public abstract class MyObserver<T> implements Observer<T> {
    @Override
    public void onChanged(T t) {
        if (t != null) {
            try {
                valueChanged(t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract void valueChanged(T t) throws ParseException;
}
