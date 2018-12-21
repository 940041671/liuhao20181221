package com.umeng.soexample.liuhao20181221;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView images;
    private TextView price1;
    private Button jian;
    private TextView price2;
    private Button jia;
    private TextView xiaoji;
    private TextView zongjia;
    private Button bbb;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int price = intent.getIntExtra("price",110);
        String image = intent.getStringExtra("image");

        Glide.with(this).load(image).into(images);
        title.setText(name);
        price1.setText(price+"");
        xiaoji.setText(price+"");
    }

    private void initView() {
        images = (ImageView) findViewById(R.id.images);
        price1 = (TextView) findViewById(R.id.price1);
        jian = (Button) findViewById(R.id.jian);
        price2 = (TextView) findViewById(R.id.price2);
        jia = (Button) findViewById(R.id.jia);
        xiaoji = (TextView) findViewById(R.id.xiaoji);
        zongjia = (TextView) findViewById(R.id.zongjia);
        bbb = (Button) findViewById(R.id.bbb);

        jian.setOnClickListener(this);
        jia.setOnClickListener(this);
        bbb.setOnClickListener(this);
        title = (TextView) findViewById(R.id.title);
        title.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jian:
                String s = price2.getText().toString();
                int i = Integer.parseInt(s);
                if (i>1){
                    price2.setText((i-1)+"");
                    xiaoji.setText((i-1)*Integer.parseInt(price1.getText().toString())+"");
                    i--;
                }else {
                    Toast.makeText(this,"最小数量为1",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.jia:
                String s1 = price2.getText().toString();
                int j = Integer.parseInt(s1);

                    price2.setText((j+1)+"");
                    xiaoji.setText((j+1)*Integer.parseInt(price1.getText().toString())+"");
                    j++;

                break;
            case R.id.bbb:

                break;
        }
    }
}
