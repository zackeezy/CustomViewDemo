package edu.harding.customviewdemo;

import android.os.Handler;
import android.os.Message;
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
                mThreadHandler.sendEmptyMessage(0);

                try{
                    Thread.sleep(10);
                }
                catch(Exception e){
                    //ignore
                }
            }
        }
    };

    //When instatiate Handler with no arguments, the Handler by default will handle messages from the UI thread
    //and will run on the UI thread
    private Handler mThreadHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //Update the UI
            mCustomView.update();
            mCustomView.draw();
        }
    };
}
