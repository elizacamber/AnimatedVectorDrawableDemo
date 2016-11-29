package com.pixplicity.animatedvectordrawabledemo;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * With AnimatedVectorDrawable we can animate the properties of a VectorDrawable,
 * and to do that, we basically need three XML files
 * 1. A VectorDrawable <vector> in res/drawable/ folder
 * 2. One or more ObjectAnimator <objectAnimator> or AnimatorSet <set> in res/anim/ folder
 * 3. And a AnimatedVectorDrawable <animated-vector> in res/drawable/ folder
 *
 * Based on:
 * https://stories.uplabs.com/animated-icons-on-android-ee635307bd6#.eaifxto4n
 */

public class MainActivity extends AppCompatActivity {

    AnimatedVectorDrawable drawable, reverseDrawable;
    boolean isMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = (ImageView) findViewById(R.id.image);
        drawable = (AnimatedVectorDrawable) getDrawable(R.drawable.ic_menu_animated);
        reverseDrawable = (AnimatedVectorDrawable) getDrawable(R.drawable.ic_back_arrow_animated);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isMenu) {
                    imageView.setImageDrawable(drawable);
                    drawable.start();
                    isMenu = true;
                }else {
                    imageView.setImageDrawable(reverseDrawable);
                    reverseDrawable.start();
                    isMenu = false;
                }
            }
        });
    }


}
