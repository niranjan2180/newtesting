package com.eisedo.eisedo.home.lists.check_list;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.check_list.CheckListActivity;
import com.eisedo.eisedo.check_list.CheckListViewModel;
import com.eisedo.eisedo.data.local.entities.CheckListItem;
import com.eisedo.eisedo.databinding.FragmentCheckListBinding;
import com.eisedo.eisedo.util.OnItemClickListener;
import com.eisedo.eisedo.util.Util;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

public class CheckListFragment extends Fragment implements OnItemClickListener {

    public static CheckListFragment checkListFragment = null;

//    private OnFragmentInteractionListener mListener;

    private ArrayList<CheckListItem> checkListItems;

    public static CheckListFragment getInstance() {
        if (checkListFragment == null) {
            checkListFragment = new CheckListFragment();
        }
        return checkListFragment;
    }

    public CheckListFragment() {
    }

    private FragmentCheckListBinding fragmentCheckListBinding;

    private CheckListViewModel checkListViewModel;

    private boolean menuVisible = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRetainInstance(true);
        setHasOptionsMenu(true);
        checkListViewModel = CheckListActivity.obtainViewModel(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentCheckListBinding = FragmentCheckListBinding.inflate(inflater, container, false);

        checkListItems = new ArrayList<>();

//        Log.d("FragmentsLisr", getArguments().getString("Title") + " " );

        fragmentCheckListBinding.setCheckListItems(checkListItems);

        checkListViewModel.getCheckListItemMutableLiveData().observe(this, checkListItems1 -> {
            this.checkListItems.clear();
            this.checkListItems.addAll(checkListItems1);
            fragmentCheckListBinding.rvCheckItems.getAdapter().notifyDataSetChanged();
        });

        setCheckListItemAdapter();

        checkListViewModel.getCheckListItemItmes();


        //TODO -- AddText watcher in better way

        fragmentCheckListBinding.etCheckListName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    menuVisible = false;
                } else {
                    menuVisible = true;
                }
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        setUpActionbar();


        return fragmentCheckListBinding.getRoot();
    }

    void setCheckListItemAdapter() {
        CheckListAdapter checkListAdapter = new CheckListAdapter(checkListItems, this);
        fragmentCheckListBinding.rvCheckItems.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentCheckListBinding.rvCheckItems.setAdapter(checkListAdapter);
    }

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        inflater.inflate(R.menu.save_menu,menu);
//        super.onCreateOptionsMenu(menu, inflater);
//    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_save:
                checkListItems.add(new CheckListItem(1, Util.getEditTextValue(fragmentCheckListBinding.etCheckListName)));
                fragmentCheckListBinding.rvCheckItems.getAdapter().notifyDataSetChanged();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.save_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.item_save);
        menuItem.setVisible(menuVisible);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override
    public void onClick(Object o, int position) {

    }

    void setUpActionbar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentCheckListBinding.toolbar4);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setTitle(R.string.lists);
        ab.setDisplayHomeAsUpEnabled(true);
    }

}