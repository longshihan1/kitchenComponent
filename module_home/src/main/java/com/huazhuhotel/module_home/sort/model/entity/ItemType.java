package com.huazhuhotel.module_home.sort.model.entity;

import android.support.annotation.IntDef;

/**
 * @author pengbo
 * @date 2019/1/8 0008
 */
@IntDef({ItemType.BIG_SORT, ItemType.SMALL_SORT})
public @interface ItemType {
    int BIG_SORT = 0;
    int SMALL_SORT = 1;
}
