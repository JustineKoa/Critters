package com.example.austin.critters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void randomButtonClick(View view)
    {
        CritterView critterView = (CritterView)findViewById(R.id.CritterView);
        critterView.setCritter(2);
    }

    public void chaserButtonClick(View view)
    {
        CritterView critterView = (CritterView)findViewById(R.id.CritterView);
        critterView.setCritter(1);
    }

    public void runnerButtonClick(View view)
    {
        CritterView critterView = (CritterView)findViewById(R.id.CritterView);
        critterView.setCritter(0);
    }

    public void startStopButtonClick(View view) {
        CritterView critterView = (CritterView) findViewById(R.id.CritterView);
        Button startstop = (Button) findViewById(R.id.startStop);

        if (startstop.getText().equals("Start")) {
            startstop.setText("Stop");
            critterView.start();
        } else {
            startstop.setText("Start");
            critterView.stop();
        }
    }
    public void resetButtonClick(View view){
        CritterView critterView = (CritterView) findViewById(R.id.CritterView);
        Button startStopButton = (Button) findViewById(R.id.startStop);
        critterView.clearCritters();
        if (startStopButton.getText().equals("Stop")){
            startStopButton.setText("Start");
            critterView.stop();
        }
    }

}
