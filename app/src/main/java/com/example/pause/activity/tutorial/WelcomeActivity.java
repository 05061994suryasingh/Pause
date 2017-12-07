package com.example.pause.activity.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.pause.R;
import com.example.pause.activity.BaseActivity.BaseActivity;
import com.example.pause.adapter.WelcomViewPagerAdapter;


public class WelcomeActivity extends BaseActivity {

    private ViewPager viewPager;
    private WelcomViewPagerAdapter welcomViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    private Button btnSkip, btnNext;
    private FrameLayout frameLayout ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);
        viewPager   = (ViewPager) findViewById(R.id.pager);
        dotsLayout  = (LinearLayout) findViewById(R.id.circles);
        btnNext     =  (Button ) findViewById(R.id.btnnext);
        frameLayout  = (FrameLayout) findViewById(R.id.frameLayout);

        // layouts of all welcome sliders
        // add few more layouts if you want
        layouts = new int[]{
                R.layout.activity_tutorial_one,
                R.layout.activity_tutorial_two,
                R.layout.activity_tutorial_three};

        // adding bottom dots
        addBottomDots(0);
        welcomViewPagerAdapter = new WelcomViewPagerAdapter(this, layouts);
        viewPager.setAdapter(welcomViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

//        btnSkip.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(layouts.length);
//            }
//        });
//
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking for last page
                // if last page home screen will be launched
                int current = getItem(+1);
                if (current < layouts.length) {
                    // move to next screen
                    viewPager.setCurrentItem(current);
                } else {
                    launchHomeScreen();
                }
            }
        });
    }

    private void launchHomeScreen() {
        startActivity(new Intent(WelcomeActivity.this , TutorialFourActivity.class));
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    //	viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
//                btnNext.setBackgroundColor(Color.TRANSPARENT);
               // btnNext.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.VISIBLE);
//                btnSkip.setVisibility(View.GONE);
            } else {
                frameLayout.setVisibility(View.GONE);
                // still pages are left
//                btnNext.setText("");
//              //  btnNext.setBackgroundResource(R.drawable.right_arrow);
//                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };


    @Override
    public void reference() {

    }

    @Override
    public void setListenrs() {

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
