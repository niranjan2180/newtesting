package com.eisedo.eisedo;

import android.content.Context;

import com.eisedo.eisedo.data.EiseDoRepository;
import com.eisedo.eisedo.data.local.EiseDoDatabase;
import com.eisedo.eisedo.data.local.EiseDoLocalDataRepository;
import com.eisedo.eisedo.executor.AppExecutors;

public class Injection {

    public static EiseDoRepository eiseDoRepository;

    public static EiseDoRepository eiseDoRepository(Context context){
        if (eiseDoRepository == null){
            //  creating room Database
            EiseDoDatabase eiseDoDatabase = EiseDoDatabase.getInstance(context);
            EiseDoLocalDataRepository eiseDoLocalDataRepository = EiseDoLocalDataRepository.getInstance(eiseDoDatabase.eiseDoDao(),new AppExecutors());

            eiseDoRepository = EiseDoRepository.getInstance(eiseDoLocalDataRepository,eiseDoLocalDataRepository);
        }
        return eiseDoRepository;
    }
}
