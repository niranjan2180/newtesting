package com.eisedo.eisedo.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.databinding.ActivitySettingBinding;
import com.eisedo.eisedo.login.LoginActivity;
import com.eisedo.eisedo.setting.matrix.MatrixFragment;
import com.eisedo.eisedo.setting.mydetails.ChangePasswordFragment;
import com.eisedo.eisedo.setting.mydetails.MyDetailsFragment;
import com.eisedo.eisedo.setting.notification.NotificationsFragment;
import com.eisedo.eisedo.util.ViewModelFactory;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

public class SettingActivity extends AppCompatActivity {

    private ActivitySettingBinding activitySettingBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activitySettingBinding = DataBindingUtil.setContentView(this,R.layout.activity_setting);

        SettingViewModel settingViewModel = obtainViewModel(this);

        activitySettingBinding.setSettingsViewModel(settingViewModel);

        settingViewModel.getIntegerMutableLiveData().observe(this, integer -> openScreen(integer));

        openSettingFragment();
    }

    private void openSettingFragment() {
        getSupportFragmentManager().beginTransaction().add(R.id.cl_container, new SettingsFragment(), "setting").commit();
    }

    private void openScreen(int screenNo) {

        switch (screenNo) {
            case 0:
                getSupportFragmentManager().beginTransaction().add(R.id.cl_container, new MyDetailsFragment(), "details").addToBackStack("").commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().add(R.id.cl_container, new MatrixFragment(), "matrix").addToBackStack("").commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().add(R.id.cl_container, new NotificationsFragment(), "notification").addToBackStack("").commit();
                break;
            case 3:
//                getSupportFragmentManager().beginTransaction().add(R.id.cl_container,new NotificationsFragment(),"notification").addToBackStack("").commit();
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
                break;
            case 7:
                getSupportFragmentManager().beginTransaction().add(R.id.cl_container, new ChangePasswordFragment(), "changePassword").addToBackStack("").commit();
                break;
            default:
                break;
        }

    }

    public static SettingViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(SettingViewModel.class);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (getSupportFragmentManager().getFragments().size() > 1){
                    getSupportFragmentManager().popBackStack();
                }else {
                    finish();
                }

                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
