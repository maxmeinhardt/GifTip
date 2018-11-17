package com.mycompany.giftiplinear;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat; //for locale (tells java what format to pu numbers in

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import pl.droidsonroids.gif.GifTextView;


public class MainActivity extends AppCompatActivity {

    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormat = NumberFormat.getPercentInstance();
    private double billAmount = 0.0;
    private double percent = 0.15;
    // private double percent = 0.15;
    private TextView amountTextView;
    private TextView percentTextView;
    private TextView tipTextView;
    private TextView totalTextView;
    private ImageView gifDisplay;
    private ImageView returnImage;

    private ImageButton smallBtn;
    private ImageButton mediumBtn;
    private ImageButton largeBtn;
    private ImageButton xLargeBtn;


    private GifTextView gifImageView;
    private GifImageView testView;
    private GifDrawable gifGrabs;
    private GifDrawable gifFromAssets;

    VideoView logoVid;
    VideoView bottomVid;
    MediaController m;

    ImageView aniImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        amountTextView = (TextView) findViewById(R.id.amountTextView);
        percentTextView = (TextView) findViewById(R.id.percentTextView);
        tipTextView = (TextView) findViewById(R.id.tipTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        tipTextView.setText(currencyFormat.format(0));
        totalTextView.setText(currencyFormat.format(0));

        EditText amountEditText = (EditText) findViewById(R.id.amountEditText);
        amountEditText.addTextChangedListener(amountEditTextWatcher);
        SeekBar percentSeekBar = (SeekBar) findViewById(R.id.percentSeekBar);
        percentSeekBar.setOnSeekBarChangeListener(seekBarListener);


        gifDisplay = (GifImageView) findViewById(R.id.laguna);


        /*gradient?
        Shader textShader=new LinearGradient(0, 0, 0, 20,
                new int[]{Color.GREEN,Color.BLUE},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        totalTextView.getPaint().setShader(textShader);
        */

        //Button Actions
        smallBtn = (ImageButton) findViewById(R.id.btn10);
        smallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                percent = 0.10;
                calculate();
            }
        });

        mediumBtn = (ImageButton) findViewById(R.id.btn15);
        mediumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                percent = 0.15;
                calculate();

            }
        });

        largeBtn = (ImageButton) findViewById(R.id.btn20);
        largeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                percent = 0.20;
                calculate();
            }
        });

        xLargeBtn = (ImageButton) findViewById(R.id.btn30);
        xLargeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                percent = 0.30;
                calculate();
            }
        });

        //top border video controls
        logoVid = (VideoView) findViewById(R.id.borderTop);
        //Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.header_border_big_logo_nowhite);
        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.header_biglogo_big);
        logoVid.setVideoURI(video);
        logoVid.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }

        });
        logoVid.start();





    }

    public ImageView findImage(double per) {
        //determines what gif to display based on the amount you are tipping

        if (per < 0.10) {
            //wtf
            returnImage = (GifImageView) findViewById(R.id.laguna);
            returnImage.setImageResource(R.drawable.tomwtf);
            return returnImage;

        } else if (per >= 0.10 && per <= 0.14) {
            //Oh come on
            returnImage = (GifImageView) findViewById(R.id.laguna);
            returnImage.setImageResource(R.drawable.lcsad);
            return returnImage;

        } else if (per == 0.15) {
            //LC Eye roll
            returnImage = (GifImageView) findViewById(R.id.laguna);
            returnImage.setImageResource(R.drawable.lceyeroll);
            return returnImage;

        } else if (per > 0.15 && per <= 0.20) {
            //Beyonce Eye Roll
            returnImage = (GifImageView) findViewById(R.id.laguna);
            returnImage.setImageResource(R.drawable.beyonceeyeroll);
            return returnImage;


        } else if (per >= 0.21 && per <= 0.25) {
            //TSwift L
            returnImage = (GifImageView) findViewById(R.id.laguna);
            returnImage.setImageResource(R.drawable.tswiftl);
            return returnImage;


        } else if (per >= 0.26 && per <= 0.30) {
            //Ryan Reynolds
            returnImage = (GifImageView) findViewById(R.id.laguna);
            returnImage.setImageResource(R.drawable.gif_reynolds);
            return returnImage;


        } else if (per >= 0.31 && per <= 0.35) {
            //Idris
            returnImage = (GifImageView) findViewById(R.id.laguna);
            returnImage.setImageResource(R.drawable.gif_idris);
            return returnImage;

        } else if (per >= 0.36 && per <= 0.40) {
            //Franco
            returnImage = (GifImageView) findViewById(R.id.laguna);
            returnImage.setImageResource(R.drawable.gif_franco);
            return returnImage;


        } else if (per >= 0.41 && per <= 0.45) {
            //Obama
            returnImage = (GifImageView) findViewById(R.id.laguna);
            returnImage.setImageResource(R.drawable.gif_obama);
            return returnImage;

        } else if (per >= 0.46 && per <= 0.50) {
            //23 Shake
            returnImage = (GifImageView) findViewById(R.id.laguna);
            returnImage.setImageResource(R.drawable.gif_mjshake);
            return returnImage;

        } else if (per >= 0.51 && per <= 0.55) {
            //dog glare
            returnImage = (GifImageView) findViewById(R.id.laguna);
            returnImage.setImageResource(R.drawable.gif_dog);
            return returnImage;

        } else if (per >= 0.56 && per <= 0.60) {
            //dog happy
            returnImage = (GifImageView) findViewById(R.id.laguna);
            returnImage.setImageResource(R.drawable.gif_doghappy);
            return returnImage;


        } else if (per >= 0.61 && per <= 0.70) {
            //elevator
            returnImage = (GifImageView) findViewById(R.id.laguna);
            returnImage.setImageResource(R.drawable.gif_elevatordab);
            return returnImage;

        } else if (per >= 0.71 && per <= 0.80) {
            //good burger
            returnImage = (GifImageView) findViewById(R.id.laguna);
            returnImage.setImageResource(R.drawable.gif_goodburger);
            return returnImage;

        } else if (per >= 0.81 && per <= 0.90) {
            //jackson popcorn
            returnImage = (GifImageView) findViewById(R.id.laguna);
            returnImage.setImageResource(R.drawable.gif_mjpopcorn);
            return returnImage;

        } else if (per >= 0.91 && per <= 0.95) {
            //ssj lebron
            returnImage = (GifImageView) findViewById(R.id.laguna);
            returnImage.setImageResource(R.drawable.gif_ssjsoccer);
            return returnImage;

        } else {
            //ssj soccer
            returnImage = (GifImageView) findViewById(R.id.laguna);
            returnImage.setImageResource(R.drawable.gif_ssjlebron);
            return returnImage;


        }

    }




    private void calculate() {
        findImage(percent);
        percentTextView.setText(percentFormat.format(percent));
        double tip = billAmount * percent;
        double total = billAmount + tip;
        tipTextView.setText(currencyFormat.format(tip));
        totalTextView.setText(currencyFormat.format(total));
    }

    private final OnSeekBarChangeListener seekBarListener =
            new OnSeekBarChangeListener() {

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    //change the gif when the progress changes
                    //findImage(percent);
                    percent = progress / 100.0;
                    calculate();

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            };

    private final TextWatcher amountEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {
            try {
                //billAmount = Double.parseDouble(s.toString())/100.0;  use when entering number NO decimal
                billAmount = Double.parseDouble(s.toString());
                amountTextView.setText(currencyFormat.format(billAmount));
            } catch (NumberFormatException e) {
                amountTextView.setText("");
                billAmount = 0.0;
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
    };

}





