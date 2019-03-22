package com.eisedo.eisedo.setting;

import android.app.Application;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.EiseDoRepository;
import com.eisedo.eisedo.data.SettingItem;
import com.eisedo.eisedo.data.local.entities.User;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class SettingViewModel extends AndroidViewModel {

    private EiseDoRepository eiseDoRepository;

    private MutableLiveData<User> userMutableLiveData;

    private MutableLiveData<ArrayList<SettingItem>> settingsListMutableLiveData;

    private MutableLiveData<Integer> integerMutableLiveData;

    public SettingViewModel(@NonNull Application application, EiseDoRepository eiseDoRepository) {
        super(application);
        this.eiseDoRepository = eiseDoRepository;
    }

    public MutableLiveData<User> getUserMutableLiveData() {
        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }

    public MutableLiveData<ArrayList<SettingItem>> getSettingsListMutableLiveData() {
        if (settingsListMutableLiveData == null) {
            settingsListMutableLiveData = new MutableLiveData<>();
        }
        return settingsListMutableLiveData;
    }

    public MutableLiveData<Integer> getIntegerMutableLiveData() {
        if (integerMutableLiveData == null){
            integerMutableLiveData = new MutableLiveData<>();
        }
        return integerMutableLiveData;
    }

    public void loadSettingItems() {
        ArrayList<SettingItem> settingItems = new ArrayList<>();
        settingItems.add(new SettingItem(getApplication().getString(R.string.my_details)));
        settingItems.add(new SettingItem(getApplication().getString(R.string.matrix)));
        settingItems.add(new SettingItem(getApplication().getString(R.string.notification)));
        settingItems.add(new SettingItem(getApplication().getString(R.string.subscription)));
        settingItems.add(new SettingItem(getApplication().getString(R.string.help)));
        settingItems.add(new SettingItem(getApplication().getString(R.string.terms_conditions)));
        settingItems.add(new SettingItem(getApplication().getString(R.string.sign_out)));
        settingsListMutableLiveData.setValue(settingItems);
    }

    public void openScreen(Integer integer){
        integerMutableLiveData.postValue(integer);
    }
}