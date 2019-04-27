package com.example.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button play,stop,pause;
MediaPlayer mediaPlayer;
int pausecurrentpos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=(Button)findViewById(R.id.play);
        stop=(Button)findViewById(R.id.stop);
        pause=(Button)findViewById(R.id.pause);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
        }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.play:
            if(mediaPlayer==null){
            mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.music1);
            mediaPlayer.start();}
            else if(!mediaPlayer.isPlaying()){
                mediaPlayer.seekTo(pausecurrentpos);
                mediaPlayer.start();
            }
                break;
            case R.id.stop:
            if(mediaPlayer!=null) {
                mediaPlayer.stop();
                mediaPlayer = null;
            }
                break;
                case R.id.pause:
                if(mediaPlayer!=null){
                    mediaPlayer.pause();
                 pausecurrentpos=mediaPlayer.getCurrentPosition();

                }
                break;
        }
    }
}
