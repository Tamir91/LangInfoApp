package com.example.android.languagechange;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Setting extends AppCompatActivity {
    int _langCode;
    Spinner _spinner;
    ImageView _ivLogo;
    //Menu _menu;
    String[] _languages = {"Java", "JavaScript", "Ruby", "PHP"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initViews();
        //addLanguages();
        initSpinner();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        menu.removeItem(R.id.action_setting);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, MainActivity.class);

        switch (item.getItemId()) {
            case R.id.action_exit:
                //Exit button work not correct
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Exit me", true);
                startActivity(intent);
                finish();
                break;
            case R.id.action_back:
                intent.putExtra("langCode", _langCode);
                setResult(RESULT_OK, intent);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void initViews() {
        _spinner = (Spinner) findViewById(R.id.spinner);
        _ivLogo = (ImageView) findViewById(R.id.ivLangPic);
    }

    //Intent intent = new Intent(context, MainActivity.class);
    //intent.putExtra("langCode", position);
    public void initSpinner() {
        final Context context = this;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, _languages);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _spinner.setAdapter(arrayAdapter);

        _spinner.setPrompt("" + R.string.titleSpinner);
        _spinner.setSelection(2);//??

        _spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                _langCode = position;
                setImage(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void setImage(int position) {
        switch (position + 1) {
            case 1:
                _ivLogo.setImageResource(R.drawable.java);
                break;
            case 2:
                _ivLogo.setImageResource(R.drawable.javas);
                break;
            case 3:
                _ivLogo.setImageResource(R.drawable.ruby);
                break;
            case 4:
                _ivLogo.setImageResource(R.drawable.php);
                break;
        }
    }
}
