package com.umeng.soexample.liuhao20181221.Presenter;

import com.google.gson.Gson;
import com.umeng.soexample.liuhao20181221.Bean.Product;
import com.umeng.soexample.liuhao20181221.NetWorkUtils;
import com.umeng.soexample.liuhao20181221.view.Main2View;

public class Main2Presenter {
    private Main2View main2View;

    public Main2Presenter(Main2View main2View) {
        this.main2View = main2View;
    }
    public void getData(String url){
        NetWorkUtils.getInstance().get(url).result(new NetWorkUtils.OkhttpListener() {
            @Override
            public void success(String data) {
                Gson gson=new Gson();
                Product product = gson.fromJson(data, Product.class);
                main2View.success(product);
            }

            @Override
            public void failure() {

            }
        });

    }
}
