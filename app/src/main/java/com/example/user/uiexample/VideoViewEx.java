package com.example.user.uiexample;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoViewEx extends AppCompatActivity {
    private VideoView videoView;
    private int position = 0;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoview);
        videoView = (VideoView) findViewById(R.id.videoView);
        if (mediaController == null) {
            mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
        }

        try {
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sawing_a_baby_in_half);
            videoView.setVideoURI(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }

        videoView.setOnPreparedListener(onPreparedListener);
    }

    MediaPlayer.OnPreparedListener onPreparedListener = new MediaPlayer.OnPreparedListener() {
        public void onPrepared(MediaPlayer mediaPlayer) {
            System.out.println("onPrepared");
            if (position == 0) {
                videoView.start();
            }
            mediaPlayer.setOnVideoSizeChangedListener(
                    new MediaPlayer.OnVideoSizeChangedListener() {
                        @Override
                        public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                            System.out.println("onVideoSizeChanged");
                            mediaController.setAnchorView(videoView);
                        }
                    });
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        int position = videoView.getCurrentPosition();
        outState.putInt("position",position);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int position = savedInstanceState.getInt("position",10);
        videoView.seekTo(position);
    }
}
