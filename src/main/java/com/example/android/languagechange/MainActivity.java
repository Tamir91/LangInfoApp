package com.example.android.languagechange;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvLangDescrip;
    private final int REQUEST_CODE_SETTINGS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        menu.removeItem(R.id.action_back);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_setting:
                startSettingActivity();
                break;
            case R.id.action_exit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void initViews(){
        tvLangDescrip = (TextView) findViewById(R.id.tvLanguageDescription);
        tvLangDescrip.setMovementMethod(new ScrollingMovementMethod());
    }

    public void startSettingActivity(){
        Intent intent = new Intent(this, Setting.class);
        startActivityForResult(intent, REQUEST_CODE_SETTINGS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // super.onActivityResult(requestCode, resultCode, data);

        if( getIntent().getBooleanExtra("Exit me", false)){
            finish();
            return;
        }

        if(resultCode == RESULT_OK && requestCode == REQUEST_CODE_SETTINGS){
            Bundle extras = data.getExtras();
            int langCode = extras.getInt("langCode");

            switch (langCode + 1){
                case 1: tvLangDescrip.setText(R.string.java);

                    break;
                case 2: tvLangDescrip.setText(R.string.javaScript);
                    break;
                case 3: tvLangDescrip.setText(R.string.ruby);
                    break;
                case 4: tvLangDescrip.setText(R.string.PHP);
                    break;
            }
        }
    }


}


