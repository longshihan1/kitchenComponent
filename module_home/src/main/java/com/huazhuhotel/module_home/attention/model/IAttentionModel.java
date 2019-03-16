package com.huazhuhotel.module_home.attention.model;

import com.huazhuhotel.module_home.mvp.model.AttentionInfo;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;

import io.reactivex.Observable;

public interface IAttentionModel {
    Observable<AttentionInfo> getAttentionInfo(String id);
}
