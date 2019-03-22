package com.eisedo.eisedo.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {

    private static final int THREAD_COUNT = 3;

    private final Executor uiExecutor;

    private final Executor mainExecutor;

    private final Executor networkExecuotr;

    AppExecutors(Executor uiExecutor, Executor mainExecutor, Executor networkExecuotr) {
        this.uiExecutor = uiExecutor;
        this.mainExecutor = mainExecutor;
        this.networkExecuotr = networkExecuotr;
    }

    public AppExecutors() {
        this(new UIThreadExecutor(),new MainThreadExecutor(), Executors.newFixedThreadPool(THREAD_COUNT));
    }

    public Executor getUiExecutor() {
        return uiExecutor;
    }

    public Executor getMainExecutor() {
        return mainExecutor;
    }

    public Executor getNetworkExecuotr() {
        return networkExecuotr;
    }
}
