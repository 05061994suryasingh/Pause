package com.example.pause.activity.tutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pause.R;
import com.example.pause.activity.BaseActivity.BaseActivity;

public class TutorialFourActivity extends BaseActivity {
private Button btnNext ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_four);
        this.reference();
        this.setListenrs();

    }

    @Override
    public void reference() {
        btnNext = (Button) findViewById(R.id.btnnext);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void setListenrs() {
btnNext.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(TutorialFourActivity.this , TutorialFiveActivity.class));
    }
});
    }

}
