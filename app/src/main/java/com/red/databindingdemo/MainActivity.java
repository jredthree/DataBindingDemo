package com.red.databindingdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.red.databindingdemo.databinding.ActivityMainBinding;
import com.red.databindingdemo.viewmodel.MyViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        MyViewModel viewModel = new MyViewModel();
        binding.setViewModel(viewModel);
    }
}
