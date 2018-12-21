package com.umeng.soexample.liuhao20181221;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.umeng.soexample.liuhao20181221.view.Main2View;

import java.util.ArrayList;
import java.util.List;

public class Custom extends LinearLayout {
    Context mcontext;
    public List<String> list=new ArrayList();
    public Custom(Context context) {
        this(context,null);
    }

    public Custom(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mcontext=context;
        setOrientation(VERTICAL);

    }
    public void setData(List<String> list){
        removeAllViews();
        this.list=list;
        int len=0;
        LinearLayout view = (LinearLayout) View.inflate(mcontext, R.layout.item_h, null);
        addView(view);
        for (final String s:list){
            len+=s.length();
            if (len>22){
                view = (LinearLayout) View.inflate(mcontext, R.layout.item_h, null);
                addView(view);
                len=s.length();
            }
            final View inflate = View.inflate(mcontext, R.layout.textlayout, null);
            TextView textview = inflate.findViewById(R.id.tt);
            textview.setText(s);
            textview.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mcontext,Main2Activity.class);
                    intent.putExtra("a",s);
                    mcontext.startActivity(intent);
                }
            });
            view.addView(inflate);
            LinearLayout.LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.weight=1;
            view.setLayoutParams(layoutParams);
        }

    }
}
