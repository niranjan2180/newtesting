package com.eisedo.eisedo.home.main;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.eisedo.eisedo.data.HomeItem;
import com.eisedo.eisedo.databinding.FragmentHomeBinding;
import com.eisedo.eisedo.home.HomeActivity;
import com.eisedo.eisedo.home.HomeViewModel;
import com.eisedo.eisedo.util.OnItemClickListener;

import java.util.ArrayList;
import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment implements OnItemClickListener {

    public static HomeFragment homeFragment = null;

    public static HomeFragment getInstance(){
        if (homeFragment == null){
            homeFragment = new HomeFragment();
        }
        return homeFragment;
    }

    private FragmentHomeBinding fragmentHomeBinding;

    private HomeViewModel homeViewModel;

    private ArrayList<HomeItem> homeItems;

    @BindingAdapter("setHomeItems")
    public static void setHomeItems(RecyclerView recyclerView, ArrayList<HomeItem> homeItems) {
        if (homeItems != null) {
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    @BindingAdapter({"image"})
    public static void loadImage(ImageView view, Drawable image) {
        view.setImageDrawable(image);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false);

        HomeActivityPresenter presenter = new HomeActivityPresenter();

        fragmentHomeBinding.setHomePresenter(presenter);


        setRetainInstance(true);

        homeViewModel = HomeActivity.obtainViewModel(getActivity());
        homeViewModel.getHomeListMutableLiveData().observe(this, homeItems -> {
            this.homeItems.clear();
            this.homeItems.addAll(homeItems);
            fragmentHomeBinding.setHomeItems(this.homeItems);
        });

        homeItems = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        homeViewModel.getHomeItems(calendar.getTime());

        setHomeAdapter();

        return fragmentHomeBinding.getRoot();
    }

    void setHomeAdapter() {
        HomeAdapter homeAdapter = new HomeAdapter(homeItems, this);
        fragmentHomeBinding.rvHomeNavigation.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentHomeBinding.rvHomeNavigation.setAdapter(homeAdapter);
    }

    @Override
    public void onClick(Object o, int position) {
        homeViewModel.setScreen(position);
    }

    public class HomeActivityPresenter {
        public void onAddTask() {
            homeViewModel.setScreen(9);
        }
    }
}