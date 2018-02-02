package com.kingmo.roomex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.Toast;

import com.kingmo.roomex.databinding.ActivityMainBinding;
import com.kingmo.roomex.repository.TeamMateRepository;
import com.kingmo.roomex.viewmodel.RosterEntryViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private TeamMateRepository teamMateRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        teamMateRepository = new TeamMateRepository(((RoomExApplication) getApplicationContext())
                .getAppDatabase().teamDao());

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(new RosterEntryViewModel(teamMateRepository,
                new SchedulerProvider(), getResources()));

        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Hey There!!! " + binding.playerName.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
