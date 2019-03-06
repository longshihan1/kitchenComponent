package com.huazhuhotel.module_home.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/6 0006
 * @des
 * @function
 */

public class LineFlowLayout extends ViewGroup {

    private int maxLineNumber = 0;  //默认0，表示不限制行数
    private int maxColumnNumber = 0;  //默认0，表示不限制列数

    public LineFlowLayout(Context context) {
        this(context, null);
    }
    public LineFlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LineFlowLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LineFlowLayoutStyle);
        maxLineNumber = typedArray.getInt(R.styleable.LineFlowLayoutStyle_flowlinenumber, 0);
    }

    public int getMaxLineNumber() {
        return maxLineNumber;
    }

    /**
     * 设置最大可显示行数
     * @param maxLineNumber 值>0时有效，小于等于0表示不限制行数
     */
    public void setMaxLineNumber(int maxLineNumber) {
        this.maxLineNumber = maxLineNumber;
    }
    /**
     * 负责设置子控件的测量模式和大小 根据所有子控件设置自己的宽和高
     */

    public int getMaxColumnNumber() {
        return maxColumnNumber;
    }
    /**
     * 设置单行最大可显示列数
     * @param maxColumnNumber 值>0时有效，小于等于0表示不限制列数
     */
    public void setMaxColumnNumber(int maxColumnNumber) {
        this.maxColumnNumber = maxColumnNumber;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 获得它的父容器为它设置的测量模式和大小
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        // 如果是warp_content情况下，记录宽和高
        int width = 0, height = 0;
        //记录每一行的宽度，width不断取最大宽度; 每一行的高度，累加至height
        int lineWidth = 0, lineHeight = 0;
        int childWidth, childHeight;
        int cCount = getChildCount();
        int lineCount = 1;
        int columnCount = 1;
        View child;
        // 遍历每个子元素
        for (int i = 0; i < cCount; i++)
        {
            child = getChildAt(i);
            if(child.getVisibility() != GONE){
                columnCount++;
                // 测量每一个child的宽和高
                measureChild(child, widthMeasureSpec, heightMeasureSpec);
                // 得到child的lp
                MarginLayoutParams lp = (MarginLayoutParams) child
                        .getLayoutParams();
                // 当前子空间实际占据的宽度
                childWidth = child.getMeasuredWidth() + lp.leftMargin
                        + lp.rightMargin;
                // 当前子空间实际占据的高度
                childHeight = child.getMeasuredHeight() + lp.topMargin
                        + lp.bottomMargin;
                //如果加入当前child，则超出最大宽度，则的到目前最大宽度给width，类加height 然后开启新行
                if (lineWidth + childWidth > sizeWidth
                        || (maxColumnNumber > 0 && columnCount > maxColumnNumber))
                {
                    columnCount = 0;
                    if(maxLineNumber > 0 && lineCount>= maxLineNumber) {
                        height += lineHeight;  //计算总的行高
                        break;
                    }
                    width = Math.max(lineWidth, childWidth);// 取最大的
                    lineWidth = childWidth; // 重新开启新行，开始记录
                    // 叠加当前高度，
                    height += lineHeight;
                    // 开启记录下一行的高度
                    lineHeight = childHeight;
                    lineCount++;
                } else
                // 否则累加值lineWidth,lineHeight取最大高度
                {
                    lineWidth += childWidth;
                    lineHeight = Math.max(lineHeight, childHeight);
                }
            }
            // 如果是最后一个，则将当前记录的最大宽度和当前lineWidth做比较
            if (i == cCount - 1)
            {
                width = Math.max(width, lineWidth);
                height += lineHeight;
            }
        }
        setMeasuredDimension((modeWidth == MeasureSpec.EXACTLY) ? sizeWidth
                : width, (modeHeight == MeasureSpec.EXACTLY) ? sizeHeight
                : height);

    }

    /**
     * 存储所有的View，按行记录
     */
    private List<List<View>> mAllViews = new ArrayList<List<View>>();
    /**
     * 记录每一行的最大高度
     */
    private List<Integer> mLineHeight = new ArrayList<Integer>();
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b)
    {
        mAllViews.clear();
        mLineHeight.clear();
        int width = getWidth();

        int lineWidth = 0, lineHeight = 0, columnCount = 0;
        // 存储每一行所有的childView
        List<View> lineViews = new ArrayList<View>();
        int cCount = getChildCount();
        View child;
        int childWidth, childHeight;
        boolean moreThanMaxLines = false;
        // 遍历所有的孩子
        for (int i = 0; i < cCount; i++)
        {
            child = getChildAt(i);
            if(child.getVisibility() == GONE){
                continue;
            }
            MarginLayoutParams lp = (MarginLayoutParams) child
                    .getLayoutParams();
            childWidth = child.getMeasuredWidth();
            childHeight = child.getMeasuredHeight();
            columnCount++;
            // 如果已经需要换行
            if (childWidth + lp.leftMargin + lp.rightMargin + lineWidth > width
                    || (maxColumnNumber > 0 && columnCount > maxColumnNumber))
            {
                columnCount = 0;
                // 记录这一行所有的View以及最大高度
                mLineHeight.add(lineHeight);
                // 将当前行的childView保存，然后开启新的ArrayList保存下一行的childView
                mAllViews.add(lineViews);
                if (maxLineNumber > 0 && mLineHeight.size() >= maxLineNumber){//超过限定行数，则跳出
                    moreThanMaxLines = true;
                    break;
                }
                //记录当前第几行
                lineWidth = 0;// 重置行宽
                lineViews = new ArrayList<View>();
            }
            //如果不需要换行，则累加
            lineWidth += childWidth + lp.leftMargin + lp.rightMargin;
            lineHeight = Math.max(lineHeight, childHeight + lp.topMargin
                    + lp.bottomMargin);
            lineViews.add(child);
        }
        // 记录最后一行
        if(!moreThanMaxLines){
            mLineHeight.add(lineHeight);
            mAllViews.add(lineViews);
        }


        int left = 0, top = 0;
        int lc, tc, rc, bc;
        // 得到总行数
        int lineNums = mAllViews.size();
        for (int i = 0; i < lineNums; i++)
        {
            // 每一行的所有的views
            lineViews = mAllViews.get(i);
            // 当前行的最大高度
            lineHeight = mLineHeight.get(i);
            // 遍历当前行所有的View
            for (int j = 0; j < lineViews.size(); j++)
            {
                child = lineViews.get(j);
                if (child.getVisibility() == View.GONE)
                {
                    continue;
                }
                MarginLayoutParams lp = (MarginLayoutParams) child
                        .getLayoutParams();
                //计算childView的left,top,right,bottom
                lc = left + lp.leftMargin;
                tc = top + lp.topMargin;
                rc =lc + child.getMeasuredWidth();
                bc = tc + child.getMeasuredHeight();

                child.layout(lc, tc, rc, bc);

                left += child.getMeasuredWidth() + lp.rightMargin + lp.leftMargin;
            }
            left = 0;
            top += lineHeight;
        }
    }

    public int getShowCount(){
        int count = 0;
        if(mAllViews.size() > 0){
            List<View> lineViews;
            for (int i = 0; i < mAllViews.size(); i++)
            {
                lineViews  = mAllViews.get(i);
                count += lineViews.size();
            }
        }
        return count;
    }

    /**
     * 与当前ViewGroup对应的LayoutParams
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        // TODO Auto-generated method stub

        return new MarginLayoutParams(getContext(), attrs);
    }
}
