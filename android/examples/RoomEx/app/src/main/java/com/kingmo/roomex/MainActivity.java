package com.kingmo.roomex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.kingmo.roomex.database.AppDatabase;
import com.kingmo.roomex.databinding.ActivityMainBinding;
import com.kingmo.roomex.repository.TeamMateRepository;
import com.kingmo.roomex.viewmodel.RosterEntryViewModel;
import com.kingmo.roomex.viewmodel.TeamMateViewModel;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding binding;
    private TeamMateRepository teamMateRepository;
    private AppDatabase appDatabase;
    private TeamMateAdapter mateAdapter;
    private CompositeDisposable subscribers = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appDatabase = ((RoomExApplication) getApplicationContext())
                .getAppDatabase();
        teamMateRepository = new TeamMateRepository(appDatabase.teamDao());

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(new RosterEntryViewModel(teamMateRepository,
                new SchedulerProvider(), getResources()));

        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTeamMate(binding.playerName.getText().toString(),
                        binding.playerNumber.getText().toString());
            }
        });

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        binding.playerList.setLayoutManager(new LinearLayoutManager(this));
        binding.playerList.setAdapter(mateAdapter);
    }

    private void getTeamInfosFromDB() {
        subscribers.add(binding.getViewModel()
                .getFormattedTeamInfos()
                .subscribe(new Consumer<List<TeamMateViewModel>>() {
                    @Override
                    public void accept(List<TeamMateViewModel> teamMateViewModels) throws Exception {
                        showOrHideResults();
                        updateTeamMatesAdapter(teamMateViewModels);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "Error! Unable to show  TeamMateViewModels", throwable);
                    }
                }));
    }

    private void addTeamMate(String name, String jerseyNumber) {
        int jerseyNum = !StringUtils.isNumeric(jerseyNumber) ? 0 : Integer.valueOf(jerseyNumber);

        subscribers.add(binding.getViewModel().addTeamMate(name, jerseyNum)
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        clearPlayInputs();
                        notifyTeamMateAdapter();
                        Log.d(TAG, "Teammate Added!!");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "Error! Unable to add teammate", throwable);
                    }
                }));
    }

    private void showOrHideResults() {
        binding.playerList.setVisibility(binding.getViewModel()
                .isPlayerResultsVisible() ? View.VISIBLE : View.GONE);
        binding.noResultsText.setVisibility(binding.getViewModel()
                .isNoResultsVisible() ? View.VISIBLE : View.GONE);
    }

    private void updateTeamMatesAdapter(List<TeamMateViewModel> teamMateViewModels) {
        if (mateAdapter == null) {
            mateAdapter = new TeamMateAdapter(teamMateViewModels);
            binding.playerList.setAdapter(mateAdapter);
        }
        ((TeamMateAdapter) binding.playerList.getAdapter()).updateData(teamMateViewModels);
    }

    private void notifyTeamMateAdapter() {
        if (binding.playerList.getAdapter() != null) {
            binding.playerList.scrollToPosition(binding.playerList.getAdapter().getItemCount() - 1);
            binding.playerList.getAdapter().notifyDataSetChanged();
        }
    }

    private void clearPlayInputs() {
        binding.playerName.setText("");
        binding.playerNumber.setText("");
    }

    @Override
    protected void onStart() {
        super.onStart();

        getTeamInfosFromDB();
    }

    @Override
    protected void onStop() {
        super.onStop();
        subscribers.clear();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppDatabase.destroyInstance();
        if (!subscribers.isDisposed()) {
            subscribers.dispose();
        }
    }
}
