package com.huazhuhotel.module_home.widget.refresh.header;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

/**
 * Created by LONGHE001.
 *
 * @time 2019/2/19 0019
 * @des
 * @function
 */

public class RefreshEmptyHeaderView extends LinearLayout implements RefreshHeader {
    public RefreshEmptyHeaderView(Context context) {
        super(context);
        initView(context);
    }

    public RefreshEmptyHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.initView(context);
    }

    public RefreshEmptyHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initView(context);
    }

    private void initView(Context context) {}

    @NonNull
    public View getView() {
        return this;//真实的视图就是自己，不能返回null
    }

    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;//指定为平移，不能null
    }

    @Override
    public void onStartAnimator(RefreshLayout layout, int headHeight, int maxDragHeight) {

    }

    @Override
    public int onFinish(RefreshLayout layout, boolean success) {
        return 0;//延迟500毫秒之后再弹回
    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onInitialized(RefreshKernel kernel, int height, int maxDragHeight) {
    }

    /**
     *
//     * @param isDragging true 手指正在拖动 false 回弹动画
     * @param percent 下拉的百分比 值 = offset/footerHeight (0 - percent - (footerHeight+maxDragHeight) / footerHeight )
     * @param offset 下拉的像素偏移量  0 - offset - (footerHeight+maxDragHeight)
     * @param height 高度 HeaderHeight or FooterHeight
     * @param extendHeight 最大拖动高度
     */
    @Override
    public void onPulling(float percent, int offset, int height, int extendHeight) {
    }

    @Override
    public void onReleasing(float percent, int offset, int height, int extendHeight) {

    }

    @Override
    public void onReleased(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {

    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
    }

    @Override
    public void setPrimaryColors(@ColorInt int... colors) {
    }
}
