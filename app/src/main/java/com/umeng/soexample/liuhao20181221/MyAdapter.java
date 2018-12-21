package com.umeng.soexample.liuhao20181221;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.umeng.soexample.liuhao20181221.Bean.Product;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Product.DataBean> list;
    private Context mcontext;

    public MyAdapter(List<Product.DataBean> list, Context mcontext) {
        this.list = list;
        this.mcontext = mcontext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,null);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String images = list.get(position).getImages();
        String[] split = images.split("!");
        Glide.with(mcontext).load(split[0]).into(holder.img);
        holder.text1.setText(list.get(position).getTitle());
        holder.price.setText("￥"+list.get(position).getPrice());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext,Main3Activity.class);
                intent.putExtra("name",list.get(position).getTitle());
                intent.putExtra("price",list.get(position).getPrice());
                intent.putExtra("image",list.get(position).getImages().split("!")[0]);
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView text1;
        private final Button button;
        private final ImageView img;
        private final TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.t1);
            button = itemView.findViewById(R.id.btn);
            img = itemView.findViewById(R.id.img);
            price = itemView.findViewById(R.id.price);
        }
    }
}
