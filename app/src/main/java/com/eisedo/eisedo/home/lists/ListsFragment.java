package com.eisedo.eisedo.home.lists;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.check_list.CheckListActivity;
import com.eisedo.eisedo.check_list.CheckListViewModel;
import com.eisedo.eisedo.data.local.entities.CheckList;
import com.eisedo.eisedo.databinding.FragmentListsBinding;
import com.eisedo.eisedo.util.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

public class ListsFragment extends Fragment implements OnItemClickListener {

    private ArrayList<CheckList> checkLists;

    private FragmentListsBinding fragmentListsBinding;

//    private OnFragmentInteractionListener mListener;

    private CheckListViewModel checkListViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(false);
        checkListViewModel = CheckListActivity.obtainViewModel(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentListsBinding = FragmentListsBinding.inflate(inflater, container, false);

        if (savedInstanceState == null){

            fragmentListsBinding.setChecklist(checkLists);

            checkListViewModel.getCheckListMutableLiveData().observe(this, checkList -> {
                this.checkLists.clear();
                this.checkLists.addAll(checkLists);
                this.checkLists.add(new CheckList(1, "List One"));
                this.checkLists.add(new CheckList(2, "List Two"));
                this.checkLists.add(new CheckList(3, "List Three"));
                this.checkLists.add(new CheckList(4, "List Four"));
                this.checkLists.add(new CheckList(1, "List One"));
                this.checkLists.add(new CheckList(2, "List Two"));
                this.checkLists.add(new CheckList(3, "List Three"));
                this.checkLists.add(new CheckList(4, "List Four"));
                this.checkLists.add(new CheckList(1, "List One"));
                this.checkLists.add(new CheckList(2, "List Two"));
                this.checkLists.add(new CheckList(3, "List Three"));
                this.checkLists.add(new CheckList(4, "List Four"));
                this.checkLists.add(new CheckList(1, "List One"));
                this.checkLists.add(new CheckList(2, "List Two"));
                this.checkLists.add(new CheckList(3, "List Three"));
                this.checkLists.add(new CheckList(4, "List Four"));
                this.checkLists.add(new CheckList(1, "List One"));
                this.checkLists.add(new CheckList(2, "List Two"));
                this.checkLists.add(new CheckList(3, "List Three"));
                this.checkLists.add(new CheckList(4, "List Four"));
                this.checkLists.add(new CheckList(1, "List One"));
                this.checkLists.add(new CheckList(2, "List Two"));
                this.checkLists.add(new CheckList(3, "List Three"));
                this.checkLists.add(new CheckList(4, "List Four"));
                this.checkLists.add(new CheckList(1, "List One"));
                this.checkLists.add(new CheckList(2, "List Two"));
                this.checkLists.add(new CheckList(3, "List Three"));
                this.checkLists.add(new CheckList(4, "List Four"));
                this.checkLists.add(new CheckList(1, "List One"));
                this.checkLists.add(new CheckList(2, "List Two"));
                this.checkLists.add(new CheckList(3, "List Three"));
                this.checkLists.add(new CheckList(4, "List Four"));
                this.checkLists.add(new CheckList(1, "List One"));
                this.checkLists.add(new CheckList(2, "List Two"));
                this.checkLists.add(new CheckList(3, "List Three"));
                this.checkLists.add(new CheckList(4, "List Four"));
                this.checkLists.add(new CheckList(-1, getString(R.string.create_list)));
                fragmentListsBinding.rvLists.getAdapter().notifyDataSetChanged();
            });

            checkLists = new ArrayList<>();

            checkListViewModel.getCheckListItems();

            //TODO -- call the addEditList
            //      Navigation.findNavController(v).navigate(R.id.addEditList);

            //TODO -- call the CheckListFragment
            //      Navigation.findNavController(v).navigate(R.id.checkListFragment);

//        checkLists = new ArrayList<>();
//        CheckList checkList = new CheckList();
//        checkList.setId(1);
//        checkList.setTitle("Title");
//
//        CheckList checkList1 = new CheckList();
//        checkList1.setId(2);
//        checkList1.setTitle("Title 1");
//
//        checkLists.add(checkList);
//        checkLists.add(checkList1);

//        fragmentListsBinding.setChecklist(checkLists);


        }

        setCheckListAdapter();

        setUpActionbar();

        return fragmentListsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().finish();
                getActivity().onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    void setCheckListAdapter() {
        ListAdapter listAdapter = new ListAdapter(checkLists, this);
        fragmentListsBinding.rvLists.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentListsBinding.rvLists.setAdapter(listAdapter);
    }

    @Override
    public void onClick(Object o, int position) {
        Log.d("Clicked", position + "");
        CheckList checkList = (CheckList) o;
        if (checkList.getId() == -1) {
            Bundle bundle = new Bundle();
            bundle.putString("Title", checkList.title);
            bundle.putLong("Id", checkList.id);
            Navigation.findNavController(getView()).navigate(R.id.action_listsFragment_to_addEditList, bundle);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("Title", checkList.title);
            bundle.putLong("Id", checkList.id);
            Navigation.findNavController(getView()).navigate(R.id.action_listsFragment_to_checkListFragment, bundle);
        }
    }

    void setUpActionbar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentListsBinding.tbList);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setTitle(R.string.lists);
        ab.setDisplayHomeAsUpEnabled(false);
    }
}