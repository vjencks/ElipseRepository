package com.timer1.vincent_jencks.eclipsetimer;


import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView time;
    private Button start;
    private Button cancel;
    private CountDownTimer countDownTimer;
    private View.OnClickListener btnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.start_button :
                    start();
                    break;
                case R.id.cancel_button :
                    cancel();
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.start_button);
        start.setOnClickListener(btnClickListener);
        cancel = (Button) findViewById(R.id.cancel_button);
        cancel.setOnClickListener(btnClickListener);
        time = (TextView) findViewById(R.id.textViewTime);
    }

    private void start(){
        time.setText("15");
        countDownTimer : new CountDownTimer(15 * 1000, 1000){
            @Override
            public void onTick(long millisUntilFinished){
                time.setText("" + millisUntilFinished / 1000);
            }
            @Override
            public void onFinish(){
                time.setText("done");
            }

        };
    }

    private void cancel(){
        if(countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
    }

}
