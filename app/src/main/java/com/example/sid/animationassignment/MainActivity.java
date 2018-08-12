package com.example.sid.animationassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    TextView tvS, tvI, tvD,tvTest;
    AnimationSet animationSet, animationSet2, animationSet3,animationSet4;
    Animation animTranslateForS, animTranslateForI, animTranslateForD,animTranslateForTest;
    Animation animationForS, animationForI, animationForD,animationForTest;
    int state = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvS = (TextView) findViewById(R.id.tvS);
        tvI = (TextView) findViewById(R.id.tvI);
        tvD = (TextView) findViewById(R.id.tvD);
        tvTest = (TextView) findViewById(R.id.tvTest);


        animationForS = AnimationUtils.loadAnimation(this, R.anim.rotate);
        animTranslateForS = AnimationUtils.loadAnimation(this, R.anim.translate);

        animationForI = AnimationUtils.loadAnimation(this, R.anim.rotate);
        animTranslateForI = AnimationUtils.loadAnimation(this, R.anim.translate);

        animationForD = AnimationUtils.loadAnimation(this, R.anim.rotate);
        animTranslateForD = AnimationUtils.loadAnimation(this, R.anim.translate);

        animationForTest = AnimationUtils.loadAnimation(this, R.anim.rotate);
        animTranslateForTest = AnimationUtils.loadAnimation(this, R.anim.translate);

        tvS.setAnimation(animationForS);
        tvS.setAnimation(animTranslateForS);


        animationSet = new AnimationSet(true);
        animationSet2 = new AnimationSet(true);
        animationSet3 = new AnimationSet(true);
        animationSet4 = new AnimationSet(true);

        animationSet.addAnimation(animationForS);
        animationSet.addAnimation(animTranslateForS);

        animationSet2.addAnimation(animationForI);
        animationSet2.addAnimation(animTranslateForI);

        animationSet3.addAnimation(animationForD);
        animationSet3.addAnimation(animTranslateForD);

        animationSet4.addAnimation(animationForTest);
        animationSet4.addAnimation(animTranslateForTest);


        //tvS.startAnimation(animationSet);
        startAnimationForS();
        state++;

        animTranslateForS.setAnimationListener(this);
        animationForS.setAnimationListener(this);

    }


    @Override
    public void onAnimationStart(Animation animation) {
        Toast.makeText(this, "animation started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Toast.makeText(this, "animation end", Toast.LENGTH_SHORT).show();
        //animationSet.cancel();
        animTranslateForS.setAnimationListener(null);
        animationForS.setAnimationListener(null);

        switch (state) {
            case 1:
                startAnimationForI();
                animTranslateForI.setAnimationListener(this);
                animationForI.setAnimationListener(this);
                state = 2;
                break;
            case 2:
                startAnimationForD();
                state = 3;
                break;
            case 3:
                startAnimationForTest();
                animationForTest.setAnimationListener(this);
                animTranslateForTest.setAnimationListener(this);
                break;
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    public void stopAnimation() {
        tvI.clearAnimation();
        animationSet2.cancel();
    }

    public void startAnimationForS() {
        tvS.setAnimation(animationForS);
        tvS.setAnimation(animTranslateForS);
        tvS.startAnimation(animationSet);
    }

    public void startAnimationForI() {
        tvI.setAnimation(animationForI);
        tvI.setAnimation(animTranslateForI);
        tvI.startAnimation(animationSet2);
    }

    public void startAnimationForD() {
        tvD.setAnimation(animationForD);
        tvD.setAnimation(animTranslateForD);
        tvD.startAnimation(animationSet3);
    }
    public void startAnimationForTest() {
        tvD.setAnimation(animationForD);
        tvD.setAnimation(animTranslateForD);
        tvD.startAnimation(animationSet3);
    }
}
