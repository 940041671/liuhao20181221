package com.umeng.soexample.liuhao20181221;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText text;
    private Custom custom;
    private List<String> list = new ArrayList();
    private TextView click;
    private TextView tiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private void initView() {
        text = (EditText) findViewById(R.id.text);
        custom = (Custom) findViewById(R.id.custom);
        click = (TextView) findViewById(R.id.click);
        click.setOnClickListener(this);
        tiao = (TextView) findViewById(R.id.tiao);
        tiao.setOnClickListener(this);
    }

    private void submit() {
        // validate
        String textString = text.getText().toString().trim();
        if (TextUtils.isEmpty(textString)) {
            Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
            return;
        } else {
            list.add(textString);
            custom.setData(list);
        }

        // TODO validate success, do something


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tiao:
                Intent intent=new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.click:
                submit();
                break;
        }
    }
}
