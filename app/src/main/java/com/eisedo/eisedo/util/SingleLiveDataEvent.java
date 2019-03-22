package com.eisedo.eisedo.util;

import android.util.Log;

import java.util.concurrent.atomic.AtomicBoolean;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class SingleLiveDataEvent<T> extends MutableLiveData<T> {

    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {

        if (hasActiveObservers()) {
            Log.d("ObserversMultiple", "Present");
        }

        super.observe(owner, t -> {
            if (atomicBoolean.compareAndSet(true, false)) {
                observer.onChanged(t);
            }
        });
    }

    @Override
    public void setValue(T value) {
        atomicBoolean.set(true);
        super.setValue(value);
    }

    @MainThread
    void call() {
        atomicBoolean = null;
    }

}