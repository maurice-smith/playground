package com.kingmo.workmanagerexample;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kingmo.workmanagerexample.models.Message;
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

    private AppScheduler appScheduler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        appScheduler = new AppScheduler();

        scheduleText = findViewById(R.id.scheduleText);
        timeInput = findViewById(R.id.timeInput);
        scheduleButton = findViewById(R.id.scheduleButton);

        SchedulerViewModel viewModel = ViewModelProviders.of(this).get(SchedulerViewModel.class);
        viewModel.getSharedPrefMessage(new PrefManager(this), getResources())
                .observe(this, msg -> scheduleText.setText(msg));

        scheduleButton.setOnClickListener(view -> {
            Message newMsg = new Message(612, "My new message");
            Map<String, Object> inputData = new HashMap<>();
            inputData.put(WORK_EXTRA, newMsg.getMessage());

            String userInput = timeInput.getEditableText().toString();
            long timeDelay = Duration.ofMinutes(Long.valueOf(userInput)).toMinutes();
            WorkRequestBuilder workBuilder = new WorkRequestBuilder(SharedPrefWorker.class)
                    .setDelay(timeDelay)
                    .setWorkTag(SharedPrefWorker.TAG)
                    .setInputData(inputData);

            appScheduler.schedule(workBuilder);

            Toast.makeText(this, getString(R.string.schedToastMsg), Toast.LENGTH_SHORT).show();

            Handler finishHandler = new Handler();
            finishHandler.postDelayed(() -> finishAndRemoveTask(), Duration.ofSeconds(2).toMillis());
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
