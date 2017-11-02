package edu.harding.customviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Thread mAnimationThread;

    private CustomView mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCustomView = (CustomView) findViewById(R.id.custom_view);

        mAnimationThread = new Thread(AnimateRunnable);
        mAnimationThread.start();
    }

    private Runnable AnimateRunnable = new Runnable(){
        @Override
        public void run() {
            //Code to run on this background thread

            while (true){
                mCustomView.update();
            }
        }
    };
}
