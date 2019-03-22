package com.eisedo.eisedo.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UIThreadExecutor implements Executor {

    private final Executor executor;

    public UIThreadExecutor() {
        this.executor = Executors.newSingleThreadExecutor();
    }


    @Override
    public void execute(Runnable command) {
        executor.execute(command);
    }
}