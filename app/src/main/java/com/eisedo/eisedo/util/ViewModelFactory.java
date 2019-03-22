package com.eisedo.eisedo.util;

import android.annotation.SuppressLint;
import android.app.Application;


import com.eisedo.eisedo.Injection;
import com.eisedo.eisedo.check_list.CheckListViewModel;
import com.eisedo.eisedo.data.EiseDoRepository;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.home.HomeViewModel;
import com.eisedo.eisedo.home.home_item.HomeItemViewModel;
import com.eisedo.eisedo.home.task.TaskViewModel;
import com.eisedo.eisedo.login.LoginViewModel;
import com.eisedo.eisedo.setting.SettingViewModel;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    @SuppressLint("StaticFieldLeak")
    private static volatile ViewModelFactory INSTANCE;

    private final Application mApplication;

    private final EiseDoRepository eiseDoRepository;

    public static ViewModelFactory getInstance(Application application) {

        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(application,
                            Injection.eiseDoRepository(application.getApplicationContext()));
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }

    private ViewModelFactory(Application application, EiseDoRepository eiseDoRepository) {
        mApplication = application;
        this.eiseDoRepository = eiseDoRepository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) new HomeViewModel(mApplication,eiseDoRepository);
        }else if (modelClass.isAssignableFrom(HomeItemViewModel.class)){
            return (T) new HomeItemViewModel(mApplication,eiseDoRepository);
        }else if (modelClass.isAssignableFrom(SettingViewModel.class)){
            return (T) new SettingViewModel(mApplication,eiseDoRepository);
        }else if (modelClass.isAssignableFrom(LoginViewModel.class)){
            return (T) new LoginViewModel(mApplication,eiseDoRepository);
        }else if (modelClass.isAssignableFrom(TaskViewModel.class)){
            return (T) new TaskViewModel(mApplication,eiseDoRepository);
        }else if (modelClass.isAssignableFrom(CheckListViewModel.class)){
            return (T) new CheckListViewModel(mApplication,eiseDoRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
