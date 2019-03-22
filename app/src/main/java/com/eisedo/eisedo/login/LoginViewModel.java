package com.eisedo.eisedo.login;

import android.app.Application;

import com.eisedo.eisedo.data.EiseDoRepository;
import com.eisedo.eisedo.util.SingleLiveDataEvent;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;


public class LoginViewModel extends AndroidViewModel {

    private ObservableField<String> userName = new ObservableField<>();

    private ObservableField<String> password = new ObservableField<>();

    private MutableLiveData<Boolean> loginLiveData;

    private MutableLiveData<String> message;

    private EiseDoRepository eiseDoRepository;

    private SingleLiveDataEvent<String> stringSingleLiveDataEvent;

    private SingleLiveDataEvent<Integer> integerSingleLiveDataEvent;

    public LoginViewModel(@NonNull Application application, EiseDoRepository eiseDoRepository) {
        super(application);
        this.eiseDoRepository = eiseDoRepository;
    }

    public SingleLiveDataEvent<String> getStringSingleLiveDataEvent() {
        if (stringSingleLiveDataEvent == null){
            stringSingleLiveDataEvent = new SingleLiveDataEvent<>();
        }
        return stringSingleLiveDataEvent;
    }

    public SingleLiveDataEvent<Integer> getIntegerSingleLiveDataEvent() {
        if (integerSingleLiveDataEvent == null){
            integerSingleLiveDataEvent = new SingleLiveDataEvent<>();
        }
        return integerSingleLiveDataEvent;
    }

    public MutableLiveData<String> getMessage() {
        if (message == null) {
            message = new MutableLiveData<>();
        }
        return message;
    }

    public MutableLiveData<Boolean> getLoginLiveData() {
        if (loginLiveData == null) {
            loginLiveData = new MutableLiveData<>();
        }
        return loginLiveData;
    }

    public ObservableField<String> getUserName() {
        return userName;
    }

    public ObservableField<String> getPassword() {
        return password;
    }

    void loginClick() {
        loginLiveData.postValue(true);

//        if (userName.get() != null) {
//            if (userName.get().equals("1")) {
//        loginLiveData.postValue(true);
//            } else {
//                message.setValue(getApplication().getString(R.string.enter_credentials));
//            }
//        } else {
//            message.setValue(getApplication().getString(R.string.enter_user_name));
//        }
    }
}