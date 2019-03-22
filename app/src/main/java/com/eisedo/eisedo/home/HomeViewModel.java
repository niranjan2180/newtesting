package com.eisedo.eisedo.home;

import android.app.Application;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.EiseDoRepository;
import com.eisedo.eisedo.data.HomeItem;
import com.eisedo.eisedo.data.local.entities.HomeTaskCount;
import com.eisedo.eisedo.executor.AppExecutors;
import com.eisedo.eisedo.util.ResultCallBackListener;
import com.eisedo.eisedo.util.SingleLiveDataEvent;

import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class HomeViewModel extends AndroidViewModel {

    private EiseDoRepository eiseDoRepository;

    private MutableLiveData<ArrayList<HomeItem>> homeListMutableLiveData;

    private SingleLiveDataEvent<Integer> openScreen;

    public HomeViewModel(@NonNull Application application, EiseDoRepository eiseDoRepository) {
        super(application);
        this.eiseDoRepository = eiseDoRepository;
    }

    public MutableLiveData<ArrayList<HomeItem>> getHomeListMutableLiveData() {
        if (homeListMutableLiveData == null) {
            homeListMutableLiveData = new MutableLiveData<>();
        }
        return homeListMutableLiveData;
    }

    public SingleLiveDataEvent<Integer> getOpenScreen() {
        if (openScreen == null) {
            openScreen = new SingleLiveDataEvent<>();
        }
        return openScreen;
    }

    public void setScreen(int screen) {
        openScreen.setValue(screen);
    }

    public void getHomeItems(Date date) {

        eiseDoRepository.getTasksCount(date, new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {
                HomeTaskCount homeTaskCount = (HomeTaskCount) o;
                ArrayList<HomeItem> homeItems = new ArrayList<>();

                homeItems.add(new HomeItem(getApplication().getResources().getDrawable(R.drawable.ic_inbox), (int) homeTaskCount.inboxCount, getApplication().getString(R.string.inbox)));
                homeItems.add(new HomeItem(getApplication().getResources().getDrawable(R.drawable.ic_projects), -1, getApplication().getString(R.string.projects)));
                homeItems.add(new HomeItem(getApplication().getResources().getDrawable(R.drawable.ic_check_list), -1, getApplication().getString(R.string.lists)));
                homeItems.add(new HomeItem(getApplication().getResources().getDrawable(R.drawable.ic_launcher), (int) homeTaskCount.getStarredCount(), getApplication().getString(R.string.starred)));
                homeItems.add(new HomeItem(getApplication().getResources().getDrawable(R.drawable.ic_replay), (int) homeTaskCount.getStarredCount(), getApplication().getString(R.string.repeat)));
                homeItems.add(new HomeItem(getApplication().getResources().getDrawable(R.drawable.ic_launcher), (int) homeTaskCount.getOverDueCount(), getApplication().getString(R.string.overdue)));
                homeItems.add(new HomeItem(getApplication().getResources().getDrawable(R.drawable.ic_delegate), (int) homeTaskCount.getDelegateCount(), getApplication().getString(R.string.delegated)));
                homeItems.add(new HomeItem(getApplication().getResources().getDrawable(R.drawable.ic_completed), (int) homeTaskCount.getCompletedCount(), getApplication().getString(R.string.completed)));
                homeItems.add(new HomeItem(getApplication().getResources().getDrawable(R.drawable.ic_delegate), (int) homeTaskCount.getTrashedCount(), getApplication().getString(R.string.trash)));

                Runnable runnable = () -> homeListMutableLiveData.setValue(homeItems);
                AppExecutors appExecutors = new AppExecutors();
                appExecutors.getMainExecutor().execute(runnable);
            }

            @Override
            public void onFailure(Object o) {
            }
        });
    }
}