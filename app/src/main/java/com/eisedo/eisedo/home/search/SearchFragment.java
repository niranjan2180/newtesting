package com.eisedo.eisedo.home.search;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.FragmentSearchBinding;
import com.eisedo.eisedo.util.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

public class SearchFragment extends Fragment implements OnItemClickListener {

    private static SearchFragment searchFragment = null;

    private FragmentSearchBinding fragmentSearchBinding;

    private ArrayList<Task> searchTasks;

    public SearchFragment getInstance(){
        if (searchFragment == null){
            searchFragment = new SearchFragment();
        }
        return searchFragment;
    }

    public SearchFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentSearchBinding  = FragmentSearchBinding.inflate(inflater,container,false);
        fragmentSearchBinding.setSearchTasks(searchTasks);

        searchTasks = new ArrayList<>();
//        fragmentSearchBinding.tbSearch.

        searchTasks.add(new Task());

        setSearchAdapter();

        fragmentSearchBinding.rvSearchTasks.getAdapter().notifyDataSetChanged();

        setUpActionBar();

        fragmentSearchBinding.etSearchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("TAsks", s.toString() + "");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        fragmentSearchBinding.etSearchText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE){
                Log.d("Search","Done");
            }
        return false;
        });

        return fragmentSearchBinding.getRoot();
    }

    private void setUpActionBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentSearchBinding.tbSearch);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
    }

    void setSearchAdapter() {
        SearchAdapter searchAdapter = new SearchAdapter(searchTasks, this);
        fragmentSearchBinding.rvSearchTasks.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentSearchBinding.rvSearchTasks.setAdapter(searchAdapter);
    }

    @Override
    public void onClick(Object o, int position) {

    }
}
