package com.huazhuhotel.module_home.utils;

import android.content.Context;

/**
 * Created by LONGHE001.
 *
 * @time 2019/4/17 0017
 * @des
 * @function
 */

public class DimenUtil {
    /**
     * dp转px
     */
    public static int dp2px(Context context, float dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density + 0.5f);
    }

    /**
     * px转dp
     */
    public static float px2dp(Context context, int px) {
        return (px / context.getResources().getDisplayMetrics().density + 0.5f);
    }

    /**
     * 将sp值转换为px值
     */
    public static int sp2px(Context context, float sp) {
        return (int) (sp * context.getResources().getDisplayMetrics().scaledDensity + 0.5f);
    }
}
