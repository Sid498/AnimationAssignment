package com.example.sid.animationassignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SID on 8/12/2018.
 */

public class TestActivity extends AppCompatActivity implements Animation.AnimationListener {

    TextView tvS, tvI, tvD;
    AnimationSet animationSet,animationSet2,animationSet3;
    Animation animTranslateForS,animTranslateForI,animTranslateForD;
    Animation animationForS,animationForI,animationForD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvS = (TextView) findViewById(R.id.tvS);
        tvI = (TextView) findViewById(R.id.tvI);
        tvD = (TextView) findViewById(R.id.tvD);

        animationForS = AnimationUtils.loadAnimation(this,R.anim.rotate);
        animTranslateForS = AnimationUtils.loadAnimation(this,R.anim.translate);

        animationForI = AnimationUtils.loadAnimation(this,R.anim.rotate);
        animTranslateForI = AnimationUtils.loadAnimation(this,R.anim.translate);

        animationForD = AnimationUtils.loadAnimation(this,R.anim.rotate);
        animTranslateForD = AnimationUtils.loadAnimation(this,R.anim.translate);

        tvS.setAnimation(animationForS);
        tvS.setAnimation(animTranslateForS);



        animationSet = new AnimationSet(true);
        animationSet2 = new AnimationSet(true);
        animationSet3 = new AnimationSet(true);

        animationSet.addAnimation(animationForS);
        animationSet.addAnimation(animTranslateForS);

        animationSet2.addAnimation(animationForI);
        animationSet2.addAnimation(animTranslateForI);

        animationSet3.addAnimation(animationForD);
        animationSet3.addAnimation(animTranslateForD);


        tvS.startAnimation(animationSet);
        startAnimationForS();

        animTranslateForS.setAnimationListener(this);
        animationForS.setAnimationListener(this);
    }

    @Override
    public void onAnimationStart(Animation animation) {
        Toast.makeText(this, "animation started", Toast.LENGTH_SHORT).show();
        // tvS.startAnimation(animation);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Toast.makeText(this, "animation end", Toast.LENGTH_SHORT).show();
        animationSet.cancel();
        if ((animationSet.hasEnded())) {
            //tvI.setAnimation(animationForI);
            //tvI.setAnimation(animTranslateForI);
            //tvI.startAnimation(animationSet2);
            startAnimationForI();
            animationSet2.cancel();
        }
        if (animationForI.hasEnded()){
            animationSet2.cancel();
            startAnimationForD();
        }
        startAnimationForD();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    public void stopAnimation(){
        tvI.clearAnimation();
        animationSet2.cancel();
    }

    public void startAnimationForS(){
        tvS.setAnimation(animationForS);
        tvS.setAnimation(animTranslateForS);
        tvS.startAnimation(animationSet);
    }
    public void startAnimationForI(){
        tvI.setAnimation(animationForI);
        tvI.setAnimation(animTranslateForI);
        tvI.startAnimation(animationSet2);
    }
    public void startAnimationForD(){
        tvD.setAnimation(animationForD);
        tvD.setAnimation(animTranslateForD);
        tvD.startAnimation(animationSet3);
    }

}
