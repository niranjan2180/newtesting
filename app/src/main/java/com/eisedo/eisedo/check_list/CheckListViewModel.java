package com.eisedo.eisedo.check_list;

import android.app.Application;

import com.eisedo.eisedo.data.EiseDoRepository;
import com.eisedo.eisedo.data.local.entities.CheckList;
import com.eisedo.eisedo.data.local.entities.CheckListItem;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class CheckListViewModel extends AndroidViewModel {

    private EiseDoRepository eiseDoRepository;

    private MutableLiveData<ArrayList<CheckList>> checkListMutableLiveData;

    private MutableLiveData<ArrayList<CheckListItem>> checkListItemMutableLiveData;

    public MutableLiveData<ArrayList<CheckList>> getCheckListMutableLiveData() {
        if (checkListMutableLiveData == null){
            checkListMutableLiveData = new MutableLiveData<>();
        }
        return checkListMutableLiveData;
    }


    public MutableLiveData<ArrayList<CheckListItem>> getCheckListItemMutableLiveData() {
        if (checkListItemMutableLiveData == null){
            checkListItemMutableLiveData = new MutableLiveData<>();
        }
        return checkListItemMutableLiveData;
    }

    public CheckListViewModel(@NonNull Application application, EiseDoRepository eiseDoRepository) {
        super(application);
        this.eiseDoRepository = eiseDoRepository;
    }

    public void getCheckListItems(){
        ArrayList<CheckList> checkLists = new ArrayList<>();
        checkLists.add(new CheckList());
        checkListMutableLiveData.setValue(checkLists);
    }

    public void getCheckListItemItmes(){
        ArrayList<CheckListItem> checkListItems = new ArrayList<>();
        checkListItemMutableLiveData.setValue(checkListItems);
    }

}
