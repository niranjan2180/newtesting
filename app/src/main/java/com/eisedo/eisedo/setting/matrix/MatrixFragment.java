package com.eisedo.eisedo.setting.matrix;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.databinding.FragmentMatrixBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class MatrixFragment extends Fragment {

    private Context context;

    private FragmentMatrixBinding fragmentMatrixBinding;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentMatrixBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_matrix,container,false);
        setUpActionBar();
        return fragmentMatrixBinding.getRoot();
    }

    private void setUpActionBar(){
        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentMatrixBinding.tbMatrix.tbTitle);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setTitle(R.string.matrix);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }
}
