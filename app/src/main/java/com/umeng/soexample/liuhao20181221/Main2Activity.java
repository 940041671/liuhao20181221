package com.umeng.soexample.liuhao20181221;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.umeng.soexample.liuhao20181221.Bean.Product;
import com.umeng.soexample.liuhao20181221.Presenter.Main2Presenter;
import com.umeng.soexample.liuhao20181221.view.Main2View;

import java.util.List;

public class Main2Activity extends AppCompatActivity implements Main2View {

    private XRecyclerView xrecy;
    private Main2Presenter main2Presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        Intent intent = getIntent();
        String a = intent.getStringExtra("a");
        String url="http://www.zhaoapi.cn/product/searchProducts?keywords="+a+"&page=1&sort=0";
        main2Presenter.getData(url);
    }

    private void initView() {
        main2Presenter = new Main2Presenter(this);
        xrecy = (XRecyclerView) findViewById(R.id.xrecy);
    }

    @Override
    public void success(Product data) {
        List<Product.DataBean> lis = data.getData();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        xrecy.setLayoutManager(manager);
        xrecy.setRefreshProgressStyle(ProgressStyle.BallZigZag);
        xrecy.setLoadingMoreProgressStyle(ProgressStyle.BallZigZag);
        MyAdapter myAdapter = new MyAdapter(lis, Main2Activity.this);
        xrecy.setAdapter(myAdapter);

    }
}
