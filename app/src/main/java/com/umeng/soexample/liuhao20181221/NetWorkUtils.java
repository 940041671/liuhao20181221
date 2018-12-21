package com.umeng.soexample.liuhao20181221;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public  class NetWorkUtils {
    /**
     * 单例模式
     */
    static NetWorkUtils netWorkUtils=new NetWorkUtils();

    private NetWorkUtils() {
    }
    public static NetWorkUtils getInstance(){
        return netWorkUtils;
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String data= (String) msg.obj;
            okhttpListener.success(data);
        }
    };
    public NetWorkUtils get(String url){
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                String method = request.method();
                Log.i("aaa",method);
                return chain.proceed(request);
            }
        }).build();
        final Request request=new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message=Message.obtain();
                message.obj=response.body().string();
                handler.sendMessage(message);
            }
        });
        return netWorkUtils;
    }
    private OkhttpListener okhttpListener;
    public interface OkhttpListener{
        void success(String data);
        void failure();
    }
    public void result(OkhttpListener okhttpListener){
        this.okhttpListener=okhttpListener;
    }
}
