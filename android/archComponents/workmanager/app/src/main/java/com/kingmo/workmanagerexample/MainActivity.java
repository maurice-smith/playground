package com.kingmo.workmanagerexample;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kingmo.workmanagerexample.work.AppScheduler;
import com.kingmo.workmanagerexample.work.SharedPrefWorker;
import com.kingmo.workmanagerexample.work.WorkRequestBuilder;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.kingmo.workmanagerexample.work.SharedPrefWorker.WORK_EXTRA;

public class MainActivity extends AppCompatActivity {

    private TextView scheduleText;
    private TextInputEditText timeInput;
    private Button scheduleButton;
    private TextInputEditText msgInput;

    private AppScheduler appScheduler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        appScheduler = new AppScheduler();

        scheduleText = findViewById(R.id.scheduleText);
        timeInput = findViewById(R.id.timeInput);
        scheduleButton = findViewById(R.id.scheduleButton);
        msgInput = findViewById(R.id.msgInput);

        SchedulerViewModel viewModel = ViewModelProviders.of(this).get(SchedulerViewModel.class);
        viewModel.getSharedPrefMessage(new PrefManager(this), getResources())
                .observe(this, msg -> scheduleText.setText(msg));

        scheduleButton.setOnClickListener(view -> {
            long timeDelay = Duration.ofMinutes(Long.valueOf(timeInput.getEditableText().toString()))
                    .toMinutes();

            scheduleJob(timeDelay, msgInput.getEditableText().toString());
        });
    }

    public void scheduleJob(long timeDelay, String message) {
        Map<String, Object> inputData = new HashMap<>();
        inputData.put(WORK_EXTRA, message);

        WorkRequestBuilder workBuilder = new WorkRequestBuilder(SharedPrefWorker.class)
                .setDelay(timeDelay)
                .setWorkTag(SharedPrefWorker.TAG)
                .setInputData(inputData);

        appScheduler.schedule(workBuilder);

        Toast.makeText(this, getString(R.string.schedToastMsg), Toast.LENGTH_SHORT).show();

        Handler finishHandler = new Handler();
        finishHandler.postDelayed(() -> finishAndRemoveTask(), Duration.ofSeconds(2).toMillis());
    }
}
