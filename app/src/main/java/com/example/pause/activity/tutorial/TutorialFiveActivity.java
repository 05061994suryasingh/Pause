package com.example.pause.activity.tutorial;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pause.R;
import com.example.pause.activity.BaseActivity.BaseActivity;
import com.example.pause.activity.home.HomeActivity;

public class TutorialFiveActivity extends BaseActivity {
private Button btnFinish ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_five);
        this.reference();
        this.setListenrs();
    }

    @Override
    public void reference() {
        btnFinish = (Button) findViewById(R.id.btnfinish);

    }

    @Override
    public void setListenrs() {
btnFinish.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(TutorialFiveActivity.this , HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
});
    }
}
