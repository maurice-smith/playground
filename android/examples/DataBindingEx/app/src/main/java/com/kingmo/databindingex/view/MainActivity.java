package com.kingmo.databindingex.view;

import android.databinding.DataBindingUtil;

import java.util.Observable;
import java.util.Observer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kingmo.databindingex.R;
import com.kingmo.databindingex.databinding.ActivityMainBinding;
import com.kingmo.databindingex.repo.PersonRepo;
import com.kingmo.databindingex.scheduler.SchedulerProvider;
import com.kingmo.databindingex.viewmodel.PersonViewModel;

public class MainActivity extends AppCompatActivity implements Observer {
    private PersonViewModel personViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personViewModel = new PersonViewModel(null, new PersonRepo(), new SchedulerProvider());

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(personViewModel);

        personViewModel.addObserver(this);

        binding.enterButton.setOnClickListener(view -> {
            personViewModel.updatePersonData(binding.name.getText().toString(),
                    binding.age.getText().toString());
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        personViewModel.cleanUp();
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof PersonViewModel) {
            PersonViewModel viewModel = (PersonViewModel) o;
            binding.infoText.setText(viewModel.getPersonInfo());
        }
    }
}
