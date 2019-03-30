package com.huazhuhotel.module_home.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.web.WebActivity;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/8 0008
 * @des
 * @function
 */

public class GoodsDetailCookItemView extends LinearLayout {
    private Context context;
    private View view;
    TextView mCookitemName;
    TextView mCookitemNote;
    LinearLayout mCookitemLin;

    public GoodsDetailCookItemView(Context context) {
        super(context);
        init(context);
    }

    public GoodsDetailCookItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GoodsDetailCookItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        view = View.inflate(context, R.layout.item_goodsdetailcookitem, this);
        initView();
    }

    private void initView() {
        this.mCookitemName = (TextView) view.findViewById(R.id.cookitem_name);
        this.mCookitemNote = (TextView) view.findViewById(R.id.cookitem_note);
        this.mCookitemLin = (LinearLayout) view.findViewById(R.id.cookitem_lin);
    }
    public void setData(String name,String note,String url){
        mCookitemName.setText(name);
        mCookitemNote.setText(note);
    }

    public void setDelLine(boolean b) {
        if (b) {
            mCookitemName.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            mCookitemNote.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }else {
            mCookitemName.getPaint().setFlags(0);
            mCookitemNote.getPaint().setFlags(0);
        }
    }
}
