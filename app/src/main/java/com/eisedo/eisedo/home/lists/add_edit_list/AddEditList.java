package com.eisedo.eisedo.home.lists.add_edit_list;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.databinding.FragmentAddEditListBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class AddEditList extends Fragment {

    private FragmentAddEditListBinding fragmentAddEditListBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentAddEditListBinding = FragmentAddEditListBinding.inflate(inflater, container, false);

        Log.d("FragmentsLisr", getArguments().getString("Title") + " " + getArguments().getLong("Id"));

        // TODO do it in proper data binding
        fragmentAddEditListBinding.tieCheckListName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0){
                    setHasOptionsMenu(false);
                }else {
                    setHasOptionsMenu(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        setUpActionbar();

        return fragmentAddEditListBinding.getRoot();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_save:
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.save_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    void setUpActionbar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentAddEditListBinding.toolbar3);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setTitle(R.string.create_lists);
        ab.setDisplayHomeAsUpEnabled(true);
    }
}