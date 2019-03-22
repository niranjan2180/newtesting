package com.eisedo.eisedo.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.check_list.CheckListActivity;
import com.eisedo.eisedo.data.HomeItem;
import com.eisedo.eisedo.databinding.ActivityHomeBinding;
import com.eisedo.eisedo.home.home_item.HomeItemsActivity;
import com.eisedo.eisedo.home.main.HomeFragment;
import com.eisedo.eisedo.home.task.NewTaskFragment;
import com.eisedo.eisedo.home.task.TaskActivity;
import com.eisedo.eisedo.setting.SettingActivity;
import com.eisedo.eisedo.util.OnItemClickListener;
import com.eisedo.eisedo.util.ViewModelFactory;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

public class HomeActivity extends AppCompatActivity implements OnItemClickListener {

    private Context context;

//    private ArrayList<HomeItem> homeItems;

//    private HomeAdapter homeAdapter;

//    private FragmentManager fragmentManager;

    private HomeViewModel homeViewModel;

    private ActivityHomeBinding activityHomeBinding;

    private FragmentManager fragmentManager;

    private HomeFragment homeFragment;

//    private AddEditTaskFragment addEditTaskFragment;

    private NewTaskFragment newTaskFragment;
//
//    @BindingAdapter("setImage")
//    public static void bindSrcCompat(ImageView imageView, Drawable drawable){ō
//        // Your setter code goes here, like setDrawable or similar
//        Log.d("ImageREsource", drawable + " ");
//        imageView.setImageDrawable(drawable);
//    }

//    @BindingAdapter("android:loadhomeItems")
//    public static void setText(RecyclerView view, ArrayList<HomeItem> homeItems) {
//        // Some checks removed for clarity
//        homeItems.addAll(homeItems);
//        HomeAdapter homeA dapter = new HomeAdapter(homeItems,HomeActivity.this,this);
//        view.setAdapter;
//    }

//    @BindingAdapter("onAddTask")
//    public static void onClickAddTask(View view){
//        Log.d("onAddTask","Clicked");
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.context = HomeActivity.this;

        activityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        homeViewModel = obtainViewModel(this);

        fragmentManager = getSupportFragmentManager();

        if (homeFragment == null) {
            homeFragment = HomeFragment.getInstance();
        } else {
            homeFragment = (HomeFragment) fragmentManager.findFragmentByTag("home");
        }

//        if (addEditTaskFragment == null) {
//            addEditTaskFragment = AddEditTaskFragment.getInstance();
//        } else {
//            addEditTaskFragment = (AddEditTaskFragment) fragmentManager.findFragmentByTag("addtask");
//        }

        if (newTaskFragment == null) {
            newTaskFragment = NewTaskFragment.getInstance();
        } else {
            newTaskFragment = (NewTaskFragment) fragmentManager.findFragmentByTag("addtask");
        }


        homeViewModel.getOpenScreen().observe(this, integer -> onClick(null, integer));

        setupToolbar();

        if (homeViewModel.getOpenScreen().getValue() == null) {
            callHomeFragment();
        } else {
            Log.d("OpenScreen", homeViewModel.getOpenScreen().getValue() + "");
            onClick(null, homeViewModel.getOpenScreen().getValue());
//            if (homeViewModel.getOpenScreen().getValue() ==9){
//                callAddTaskFragment();
//            }else {
//                callSettings();
//            }
        }


//        activityHomeBinding.setHomeVm(homeViewModel);

//        homeItems = new ArrayList<>();

//        fragmentManager = getSupportFragmentManager();

//        homeViewModel.getHomeListMutableLiveData().observe(this, homeItems -> {
//            this.homeItems.clear();
//            this.homeItems.addAll(homeItems);
//            homeAdapter.notifyDataSetChanged();
//        });

//        setHomeItems();

//        Calendar calendar1 = Calendar.getInstance();
//        calendar1.setTimeInMillis(System.currentTimeMillis());
//        calendar1.set(Calendar.HOUR_OF_DAY, 14);
//        calendar1.set(Calendar.MINUTE, 33);
//        setAlarm(calendar1.getTimeInMillis());

    }


    // TODO --> Settings Home Items
//    private void setHomeItems() {
//        Calendar calendar = Calendar.getInstance();
//        homeViewModel.getHomeItems(calendar.getTime());
//        homeAdapter = new HomeAdapter(homeItems, HomeActivity.this, this);
//        activityHomeBinding.rvHomeNavigation.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
//        activityHomeBinding.rvHomeNavigation.setAdapter(homeAdapter);
//    }


    // Todo --> To set the alarm
//    private void setAlarm(long alarm) {
//        Log.d("AlarmValue", alarm + "");
//        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), 1, intent, 0);
//        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, alarm, pendingIntent);
//    }

    private void setupToolbar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("User Name");
        actionBar.setHomeAsUpIndicator(R.drawable.ic_launcher);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:

                if (fragmentManager.getFragments().size() > 0) {
                    fragmentManager.popBackStack();
                }

                break;
            case R.id.item_search:

                Intent intent = new Intent(HomeActivity.this, HomeItemsActivity.class);
                intent.putExtra(getString(R.string.type), getString(R.string.search));
                startActivity(intent);

                break;
            case R.id.item_setting:

                callSettings();

                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(Object o, int i) {
        Intent intent = new Intent(HomeActivity.this, HomeItemsActivity.class);
        switch (i) {
            case 0:
                callTaskFragment();
                break;
            case 1:
                intent.putExtra(getString(R.string.type), getString(R.string.projects));
                startActivity(intent);
                break;
            case 2:
//                intent.putExtra(getString(R.string.type), getString(R.string.lists));
//                startActivity(intent);
                callCheckList();
                break;

            case 3:
                intent.putExtra(getString(R.string.type), getString(R.string.starred));
                startActivity(intent);
                break;

            case 4:
                intent.putExtra(getString(R.string.type), getString(R.string.repeat));
                startActivity(intent);
                break;

            case 5:
                intent.putExtra(getString(R.string.type), getString(R.string.overdue));
                startActivity(intent);
                break;
            case 6:
                intent.putExtra(getString(R.string.type), getString(R.string.delegated));
                startActivity(intent);
                break;
            case 7:
                intent.putExtra(getString(R.string.type), getString(R.string.completed));
                startActivity(intent);
                break;
            case 8:
                intent.putExtra(getString(R.string.type), getString(R.string.trash));
                startActivity(intent);
                break;
            case 9:
                callAddTaskFragment();
                break;
            case 10:
                callHomeFragment();
                break;
            default:
                break;
        }
    }

    void callCheckList(){
        startActivity(new Intent(HomeActivity.this, CheckListActivity.class));
    }

    void callSettings() {
        startActivity(new Intent(context, SettingActivity.class));
    }

    public static HomeViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(HomeViewModel.class);
    }

    void callHomeFragment() {
        fragmentManager.beginTransaction().add(R.id.cl_container, homeFragment, "home").commit();

    }

    void callTaskFragment() {
        startActivity(new Intent(HomeActivity.this, TaskActivity.class));
    }

    public void callAddTaskFragment() {
        fragmentManager.beginTransaction().replace(R.id.cl_container, newTaskFragment, "addtask").addToBackStack("addtask").commit();

        //TODO Replace this Logic
//        Intent intent = new Intent(HomeActivity.this,TaskActivity.class);
//        intent.putExtra("screen", 1);
//        startActivity(intent);
    }

}