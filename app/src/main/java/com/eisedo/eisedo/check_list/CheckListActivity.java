package com.eisedo.eisedo.check_list;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.util.ViewModelFactory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

public class CheckListActivity extends AppCompatActivity  {

    private CheckListViewModel checkListViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_check_list);
        checkListViewModel = obtainViewModel(this);
//            NavHostFragment finalHost = NavHostFragment.create(R.navigation.check_list_nav);
//            finalHost.getNavController().removeOnDestinationChangedListener((controller, destination, arguments) -> {
//                Log.d("Destinaiton", destination.getLabel()+"");
//            });
//            finalHost.getNavController().addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
//                @Override
//                public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
//                    Log.d("Destinaiton", destination.getLabel()+"");
//                }
//            });
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.nav_check_list_fragment, finalHost)
//                    .setPrimaryNavigationFragment(finalHost) // this is the equivalent to app:defaultNavHost="true"
//                    .commit();
    }
//


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Log.d("CAllled","HomeBack");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this,R.id.nav_check_list_fragment).navigateUp();
    }

    public static CheckListViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(CheckListViewModel.class);
    }

}
