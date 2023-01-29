package com.google.sample.cloudvision;

import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.media.SoundPool;

import android.support.v7.app.AppCompatActivity;

public class SplashActivity  extends AppCompatActivity {
    //Sound
    SoundPool soundPool;	//작성
    int soundID;		//작성

    @Override
    protected void onCreate(Bundle savedInstanceStare) {
        super.onCreate(savedInstanceStare);
        setContentView(R.layout.activity_splash);

        //Sound

        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);	//작성
        soundID = soundPool.load(this,R.raw.pling_sound,1);	//작성, (mp3 파일 이름이 click_sound이다.)

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                //스플래시 실행시 효과음 울림
                soundPool.play(soundID,1,1,0,0,1);
                finish();
            }
            //스플래시 0.5초 실행
        },500);
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
