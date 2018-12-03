package com.mycompany.giftiplinear;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class SplashScreen extends AppCompatActivity {
    VideoView logoVid;
    MediaController m;

    ImageView aniImg;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        logoVid = (VideoView) findViewById(R.id.logoSplash);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.giftip_splash_twice);
        logoVid.setVideoURI(video);


        logoVid.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                startNextActivity();
            }
        });

        logoVid.start();
    }

    private void startNextActivity() {
        if (isFinishing())
            return;
        startActivity(new Intent(this, MainActivity.class));
        //startActivity(new Intent(this, StartScreen.class));
        finish();
    }
}















    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        logoVid = (VideoView)findViewById(R.id.logoSplash);

        String videoToPlay = "D:\\androidTesting\\Tetris-master\\gifTipLinear\\app\\src\\main\\res\\raw\\tipgifani.mp4";
        String vid2 = "android.resource://com.mycompany.giftiplinear/"+R.raw.tipgifani;


        Uri videoUri = Uri.parse(vid2);
        logoVid.setVideoURI(videoUri);


        logoVid.start();

        /*
        String videoToPlay = "D:\\androidTesting\\Tetris-master\\gifTipLinear\\app\\src\\main\\res\\raw\\tipgifani.mp4";
        String vid2 = "android.resource://com.mycompany.giftiplinear/"+R.raw.tipgifani;

        */
        /*

        aniImg = (ImageView)findViewById(R.id.logoimage);
        aniImg.setImageResource(R.drawable.tipgiflogo);


        <ImageView
        android:layout_width="match_parent"
        android:layout_height="569dp"
        android:src="@drawable/tipgiflogo"
        android:padding="5dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />



         <VideoView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/logoSplash2"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"/>





        //Thread used to make splash screen
        Thread myThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);


                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setDataAndType(videoUri, "video/mp4");


                    //startActivity(intent);
                   // finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
            myThread.start();
        }


        public void playVideo(View v){

            //m = new MediaController(this);
            String videoToPlay = "D:\\androidTesting\\Tetris-master\\gifTipLinear\\app\\src\\main\\res\\raw\\tipgifani.mp4";
            String vid2 = "android.resource://com.mycompany.giftiplinear/"+R.raw.tipgifani;


            Uri videoUri = Uri.parse(vid2);
            logoVid.setVideoURI(videoUri);
            logoVid.start();
        }


}
        */

