package com.example.imageview250220201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView mImg;
    Button mBtnPrevious, mBtnNext, mBtnRandom, mBtnAutoPrevious, mBtnAutoNext, mBtnPause, mBtnAutoRandom;
    int mCount = 0, mValue;
    ArrayList<Integer> mArrayImageView, getmArrayImageViewRandom;
    Random mRandom;
    CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImg = findViewById(R.id.imageview);
        mBtnPrevious = findViewById(R.id.buttonPrevious);
        mBtnNext = findViewById(R.id.buttonNext);
        mBtnRandom = findViewById(R.id.buttonRandom);
        mBtnAutoPrevious = findViewById(R.id.buttonAutoPrevious);
        mBtnAutoNext = findViewById(R.id.buttonAutoNext);
        mBtnPause = findViewById(R.id.buttonPause);


        mArrayImageView = new ArrayList<>();
        mArrayImageView.add(R.drawable.hinh1);
        mArrayImageView.add(R.drawable.hinh2);
        mArrayImageView.add(R.drawable.hinh3);
        mArrayImageView.add(R.drawable.hinh4);
        mArrayImageView.add(R.drawable.hinh5);

        getmArrayImageViewRandom = new ArrayList<>();
        getmArrayImageViewRandom.add(R.drawable.hinh1);
        getmArrayImageViewRandom.add(R.drawable.hinh2);
        getmArrayImageViewRandom.add(R.drawable.hinh3);
        getmArrayImageViewRandom.add(R.drawable.hinh4);
        getmArrayImageViewRandom.add(R.drawable.hinh5);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mCount = mCount == mArrayImageView.size() - 1 ? 0 : ++mCount;
            mImg.setImageResource(mArrayImageView.get(mCount));

            }
        });
        mBtnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mCount = mCount == 0 ? mArrayImageView.size() - 1 : --mCount;
            mImg.setImageResource(mArrayImageView.get(mCount));

            }
        });
        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCountDownTimer = new CountDownTimer(1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mRandom = new Random();
                        if (getmArrayImageViewRandom.size() != 0) {
                            mValue = mRandom.nextInt(getmArrayImageViewRandom.size());
                            mCount = mValue;
                            mImg.setImageResource(getmArrayImageViewRandom.get(mValue));
                            getmArrayImageViewRandom.remove(mValue);
                        } else {
                            getmArrayImageViewRandom.add(R.drawable.hinh1);
                            getmArrayImageViewRandom.add(R.drawable.hinh2);
                            getmArrayImageViewRandom.add(R.drawable.hinh3);
                            getmArrayImageViewRandom.add(R.drawable.hinh4);
                            getmArrayImageViewRandom.add(R.drawable.hinh5);
                            mValue = mRandom.nextInt(getmArrayImageViewRandom.size());
                            mCount = mValue;
                            mImg.setImageResource(getmArrayImageViewRandom.get(mValue));
                            getmArrayImageViewRandom.remove(mValue);
                        }
                    }

                    @Override
                    public void onFinish() {
                        mCountDownTimer.start();
                    }
                };
                mCountDownTimer.start();
            }
        });
        mBtnAutoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCountDownTimer = new CountDownTimer(1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mCount = mCount >= mArrayImageView.size() - 1 ? 0 : ++mCount;
                        mImg.setImageResource(mArrayImageView.get(mCount));
                    }

                    @Override
                    public void onFinish() {
                        mCountDownTimer.start();
                    }
                };
                mCountDownTimer.start();
            }
        });
        mBtnAutoPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCountDownTimer = new CountDownTimer(1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mCount = mCount <= 0 ? mArrayImageView.size() - 1 : --mCount;
                        mImg.setImageResource(mArrayImageView.get(mCount));
                    }

                    @Override
                    public void onFinish() {
                        mCountDownTimer.start();
                    }
                };
                mCountDownTimer.start();
            }
        });
        mBtnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCountDownTimer.cancel();
            }
        });


    }
}
